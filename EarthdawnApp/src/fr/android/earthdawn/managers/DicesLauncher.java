/**
 *
 */
package fr.android.earthdawn.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import fr.android.earthdawn.R;
import fr.android.earthdawn.dices.Rollable;
import fr.android.earthdawn.dices.impl.Dice;
import fr.android.earthdawn.dices.impl.FixedValueDice;

/**
 * @author DrMabulle
 *
 * Not thread safe at all, but the way the program uses this it doesn't matter
 */
public class DicesLauncher
{

    private final String REGEX = "([0-9]+D[0-9]+[ ]*)+(-[0-9]+)*";

    private static final DicesLauncher INSTANCE = new DicesLauncher();
    private final StringBuilder logs = new StringBuilder(256);
    private int result = 0;
    private int rank = 0;
    private String dicesInfos = null;

    private DicesLauncher() {}

    public static DicesLauncher get()
    {
        return INSTANCE;
    }

    public int getRank()
    {
        return rank;
    }

    public String getDicesInfos()
    {
        return dicesInfos;
    }

    public boolean testInputDicesInfos(final String dicesInfos)
    {
        return dicesInfos != null && dicesInfos.length() > 0 && dicesInfos.matches(REGEX);
    }

    public int rollDices(final int aRank)
    {
        return rollDices(aRank, true);
    }

    public int rollDices(final int aRank, final boolean withRerollOnExtremities)
    {
        rank = aRank;
        dicesInfos = null;
        return rollDices(parseDicesInfos(RankManager.getDicesFromRank(rank)), withRerollOnExtremities);
    }

    public int rollDices(final String aDicesInfos)
    {
        return rollDices(aDicesInfos, true);
    }

    public int rollDices(final String aDicesInfos, final boolean withRerollOnExtremities)
    {
        rank = 0;
        dicesInfos = aDicesInfos;
        return rollDices(parseDicesInfos(dicesInfos), withRerollOnExtremities);
    }

    private List<Rollable> parseDicesInfos(final String dicesInfos)
    {
        // Full exemple of infos : 2D20 1D12 -2
        final List<Rollable> dices = new ArrayList<Rollable>(6);

        final String[] dicesAndMod = dicesInfos.split("-");
        final String[] dicesDescription = dicesAndMod[0].split(" ");

        for (final String infos : dicesDescription)
        {
            instanciateDices(infos, dices);
        }
        if (dicesAndMod.length == 2)
        {
            dices.add(new FixedValueDice(-Integer.parseInt(dicesAndMod[1])));
        }

        return dices;
    }

    private void instanciateDices(final String infos, final List<Rollable> dices)
    {
        final String[] split = infos.split("D");
        if (split.length == 2)
        {
            final int nb = Integer.parseInt(split[0]);
            final int maxValue = Integer.parseInt(split[1]);

            for (int i = 0; i < nb; i++)
            {
                dices.add(new Dice(maxValue));
            }
        }
    }

    public int rollDices(final List<Rollable> dices, final boolean withRerollOnExtremities)
    {
        logs.setLength(0);
        // lancer une première fois les dés et additionner les résultats.
        result = simpleRoll(dices);

        // Gérer les relances spécifiques au système EarthDawn
        if (withRerollOnExtremities)
        {
            result += manageRerolls(dices);
        }

        // Somme des dés après relances
        return result;
    }

    private int simpleRoll(final List<Rollable> dices)
    {
        // Lancer les dés et additionner les résultats
        int sum = 0;
        for (final Rollable dice : dices)
        {
            sum += dice.roll();

            logs.append(dice.toString());
            logs.append(" donne ");
            logs.append(dice.getPreviousResult());
            logs.append('\n');
        }
        return sum;
    }

    private int manageRerolls(final List<Rollable> dices)
    {
        final List<Rollable> maxDices = new ArrayList<Rollable>(6);
        final List<Rollable> minDices = new ArrayList<Rollable>(6);
        int result = 0;

        // Récupérer les Max et Min
        for (final Rollable dice : dices)
        {
            if (dice.isMaxValue())
            {
                maxDices.add(dice);
            }
            else if (dice.isMinValue())
            {
                minDices.add(dice);
            }
        }

        // Virer les Max et Min qui s'annullent
        if (!maxDices.isEmpty() && !minDices.isEmpty())
        {
            removeCancelledDices(maxDices, minDices);
        }

        logs.append("------\n");

        // Relancer les Max tant qu'ils sont Max
        if (!maxDices.isEmpty())
        {
            result = rerollMaxs(maxDices);
        }
        // Ou relancer les Min tant qu'ils sont Min
        else if (!minDices.isEmpty())
        {
            result = rerollMins(minDices);
        }

        return result;
    }

    private void removeCancelledDices(final List<Rollable> maxDices, final List<Rollable> minDices)
    {
        // Trier les listes par ordre décroissant
        Collections.sort(maxDices);
        Collections.reverse(maxDices);
        Collections.sort(minDices);
        Collections.reverse(minDices);

        while (!maxDices.isEmpty() && !minDices.isEmpty())
        {
            logs.append(maxDices.remove(0));
            logs.append(" et ");
            logs.append(minDices.remove(0));
            logs.append(" s'annulent\n");
        }

    }

    private int rerollMaxs(final List<Rollable> maxDices)
    {
        int sum = 0;
        while (!maxDices.isEmpty())
        {
            // relancer les dés et ajouter les résultats
            sum += simpleRoll(maxDices);

            logs.append("------\n");

            // Ne garder que les dés qui ont fait un maximum (pour relance)
            for (int i = maxDices.size() - 1; i >= 0; i--)
            {
                if (!maxDices.get(i).isMaxValue())
                {
                    maxDices.remove(i);
                }
            }
        }
        return sum;
    }

    private int rerollMins(final List<Rollable> minDices)
    {
        int sum = 0;
        while (!minDices.isEmpty())
        {
            // relancer les dés et soustraire les résultats
            sum -= simpleRoll(minDices);

            logs.append("------\n");

            // Ne garder que les dés qui ont fait un maximum (pour relance)
            for (int i = minDices.size() - 1; i >= 0; i--)
            {
                if (!minDices.get(i).isMinValue())
                {
                    minDices.remove(i);
                }
            }
        }
        return sum;
    }

    public String getRollLogs()
    {
        return logs.toString();
    }

    public int getRollResult()
    {
        return result;
    }

    public String getDetailedMessage(final Context ctx)
    {
        String msg = null;
        if (DicesLauncher.get().getDicesInfos() != null)
        {
            msg = DicesLauncher.get().getDicesInfos();
        }
        else
        {
            final int rank = DicesLauncher.get().getRank();
            msg = ctx.getString(R.string.roller_rank_msg, rank, RankManager.getDicesFromRank(rank));
        }
        return ctx.getString(R.string.roller_message, msg, DicesLauncher.get().getRollResult(), DicesLauncher.get().getRollLogs());
    }
}
