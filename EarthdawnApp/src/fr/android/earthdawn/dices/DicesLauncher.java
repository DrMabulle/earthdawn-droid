/**
 *
 */
package fr.android.earthdawn.dices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.android.earthdawn.dices.impl.Dice;
import fr.android.earthdawn.dices.impl.FixedValueDice;
import fr.android.earthdawn.managers.RankManager;

/**
 * @author DrMabulle
 *
 * Not thread safe at all, but the way the program uses this it doesn't matter
 */
public class DicesLauncher
{

    private static final String REGEX = "([0-9]+D[0-9]+[ ]*)+(-[0-9]+)*";

    private static final StringBuilder logs = new StringBuilder(256);
    private static int result = 0;
    private static int rank = 0;
    private static String dicesInfos = null;

    private DicesLauncher() {}

    public static boolean testInputDicesInfos(final String dicesInfos)
    {
        return dicesInfos != null && dicesInfos.length() > 0 && dicesInfos.matches(REGEX);
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

    private static List<Rollable> parseDicesInfos(final String dicesInfos)
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

    private static void instanciateDices(final String infos, final List<Rollable> dices)
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

    private static int rollDices(final List<Rollable> dices, final boolean rerollMax, final boolean rerollMins)
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

    private static int simpleRoll(final List<Rollable> dices)
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

    private static int manageRerolls(final List<Rollable> dices, final boolean rerollMax, final boolean rerollMins)
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

    private static void removeCancelledDices(final List<Rollable> maxDices, final List<Rollable> minDices)
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

    private static int rerollMaxs(final List<Rollable> maxDices)
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

    private static int rerollMins(final List<Rollable> minDices)
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

    public static int getRollResult()
    {
        return result;
    }

    public static String getRollLogs()
    {
        return logs.toString();
    }
}
