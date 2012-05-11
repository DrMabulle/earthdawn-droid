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
public final class DicesLauncher
{
    private static final String REGEX = "([0-9]+D[0-9]+[ ]*)+(-[0-9]+)*";

    protected static final StringBuilder logs = new StringBuilder(256);
    private static int result = 0;
    private static int rank = 0;
    private static String dicesInfos = null;

    private DicesLauncher() {}

    public static boolean testInputDicesInfos(final String dicesInfos)
    {
        return dicesInfos != null && dicesInfos.length() > 0 && dicesInfos.toUpperCase().matches(REGEX);
    }

    public static int rollDices(final int aRank, final boolean rerollMax, final boolean rerollMins)
    {
        rank = aRank;
        dicesInfos = null;
        return rollDices(parseDicesInfos(RankManager.getDicesFromRank(rank)), rerollMax, rerollMins);
    }

    public static int rollDices(final String aDicesInfos, final boolean rerollMax, final boolean rerollMins)
    {
        rank = 0;
        dicesInfos = aDicesInfos;
        return rollDices(parseDicesInfos(dicesInfos), rerollMax, rerollMins);
    }

    protected static List<Rollable> parseDicesInfos(final String dicesInfos)
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

    protected static void instanciateDices(final String infos, final List<Rollable> dices)
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

    protected static int rollDices(final List<Rollable> dices, final boolean rerollMax, final boolean rerollMins)
    {
        logs.setLength(0);
        // lancer une première fois les dés et additionner les résultats.
        result = simpleRoll(dices);

        // Gérer les relances spécifiques au système EarthDawn
        if (rerollMax || rerollMins)
        {
            result += manageRerolls(dices, rerollMax, rerollMins);
        }

        // Somme des dés après relances
        return result;
    }

    protected static int simpleRoll(final List<Rollable> dices)
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

    protected static int manageRerolls(final List<Rollable> dices, final boolean rerollMax, final boolean rerollMins)
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
        if (rerollMax && !maxDices.isEmpty())
        {
            result = rerollMaxs(maxDices);
        }
        // Ou relancer les Min tant qu'ils sont Min
        else if (rerollMins && !minDices.isEmpty())
        {
            result = rerollMins(minDices);
        }

        return result;
    }

    protected static void removeCancelledDices(final List<Rollable> maxDices, final List<Rollable> minDices)
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

    protected static int rerollMaxs(final List<Rollable> maxDices)
    {
        // relancer les dés et ajouter les résultats
        int sum = simpleRoll(maxDices);

        // Relancer seulement les max (après éliminations des min-max qui s'annulent)
        sum += manageRerolls(maxDices, true, false);

        return sum;
    }

    protected static int rerollMins(final List<Rollable> minDices)
    {
        int sum = 0;
        // relancer les dés et soustraire les résultats
        sum -= simpleRoll(minDices);

        // Relancer seulement les min (après éliminations des min-max qui s'annulent)
        sum -= manageRerolls(minDices, false, true);

        return sum;
    }

    public static int getRollResult()
    {
        return result;
    }

    public static String getRollLogs()
    {
        return logs.toString();
    }

    public static String getDetailedMessage(final Context ctx)
    {
        String msg = null;
        if (dicesInfos != null)
        {
            msg = dicesInfos;
        }
        else
        {
            msg = ctx.getString(R.string.roller_rank_msg, rank, RankManager.getDicesFromRank(rank));
        }
        return ctx.getString(R.string.roller_message, msg, result, logs.toString());
    }
}
