/**
 *
 */
package fr.android.earthdawn.dices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import fr.android.earthdawn.R;
import fr.android.earthdawn.dices.impl.Dice;
import fr.android.earthdawn.dices.impl.FixedValueDice;
import fr.android.earthdawn.managers.RankManager;

/**
 * @author DrMabulle
 *
 * Not thread safe at all, but the way the program uses this it doesn't matter
 */
public final class DicesLauncher
{
    protected static final StringBuilder logs = new StringBuilder(512);
    private static int result = 0;
    private static int rank = 0;
    private static String dicesInfos = null;

    private DicesLauncher() {}

    /**
     * Checks whether the given dices informations respect the expected syntax
     * @param aDicesInfos some dices informations
     * @return true if the given dices informations respect the expected syntax
     */
    public static boolean testInputDicesInfos(final String aDicesInfos)
    {
        List<Rollable> dices = null;
        try
        {
            dices = parseDicesInfos(aDicesInfos.toUpperCase());
        }
        catch (final Exception e)
        {
            // do nothing
        }
        return dices != null && dices.size() > 0;
    }

    /**
     * Roll dices according to EarthDawn rules
     * @param aRank rank (step) to be rolled
     * @param rerollMax indicates whether max values should be rerolled
     * @param rerollMins  indicates whether min values should be rerolled
     * @return result of the roll
     */
    public static int rollDices(final int aRank, final boolean rerollMax, final boolean rerollMins)
    {
        rank = aRank;
        dicesInfos = null;
        return rollDices(parseDicesInfos(RankManager.getDicesFromRank(rank)), rerollMax, rerollMins);
    }

    /**
     * Roll dices according to EarthDawn rules
     * @param aDicesInfos dices to be rolled
     * @param rerollMax indicates whether max values should be rerolled
     * @param rerollMins  indicates whether min values should be rerolled
     * @return result of the roll
     */
    public static int rollDices(final String aDicesInfos, final boolean rerollMax, final boolean rerollMins)
    {
        rank = 0;
        dicesInfos = aDicesInfos;
        return rollDices(parseDicesInfos(dicesInfos), rerollMax, rerollMins);
    }

    protected static List<Rollable> parseDicesInfos(final String aDicesInfos)
    {
        // Full exemple of infos : 2D20 + 5 + 1D12 -2
        final List<Rollable> dices = new ArrayList<Rollable>(6);

        final String[] dicesDescription = aDicesInfos.split("\\+");

        for (final String infos : dicesDescription)
        {
            instanciateDices(infos, dices, false);
        }

        return dices;
    }

    protected static void instanciateDices(final String infos, final List<Rollable> dices, final boolean isNegative)
    {
        // Exemples : "5", "1D20", "1D4 -2"

        // Split "-"
        if (infos.contains("-"))
        {
            final String[] dicesDescription = infos.split("-");

            for (final String split : dicesDescription)
            {
                instanciateDices(split, dices, true);
            }
            return;
        }

        // Deal with dices...
        if (infos.contains("D"))
        {
            final String[] split = infos.split("D");
            if (split.length == 2)
            {
                final int nb = Integer.parseInt(split[0].trim());
                final int maxValue = Integer.parseInt(split[1].trim());

                for (int i = 0; i < nb; i++)
                {
                    dices.add(new Dice(maxValue));
                }
            }
        }
        // ... and fixed values
        else
        {
            int value = Integer.parseInt(infos.trim());
            if (isNegative)
            {
                value *= -1;
            }
            dices.add(new FixedValueDice(value));
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
        int mResult = 0;

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
            mResult = rerollMaxs(maxDices);
        }
        // Ou relancer les Min tant qu'ils sont Min
        else if (rerollMins && !minDices.isEmpty())
        {
            mResult = rerollMins(minDices);
        }

        return mResult;
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

    /**
     * @return result of the roll
     */
    public static int getRollResult()
    {
        return result;
    }

    /**
     * @return Logs of the roll
     */
    public static String getRollLogs()
    {
        return logs.toString();
    }

    /**
     * Prepares a detailed message for display
     * @param ctx Android Context
     * @return a detailed message for display
     */
    public static String getDetailedMessage(final Context ctx)
    {
        String msg = null;
        if (dicesInfos != null)
        {
            msg = dicesInfos;
        }
        else
        {
            msg = ctx.getString(R.string.roller_rank_msg, Integer.toString(rank), RankManager.getDicesFromRank(rank));
        }
        return ctx.getString(R.string.roller_message, msg, Integer.toString(result), logs.toString());
    }
}
