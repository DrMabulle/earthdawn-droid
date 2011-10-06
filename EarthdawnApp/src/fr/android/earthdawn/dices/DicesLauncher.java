/**
 * 
 */
package fr.android.earthdawn.dices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.android.earthdawn.dices.impl.Dice;
import fr.android.earthdawn.dices.impl.FixedValueDice;

import android.util.Log;

/**
 * @author Administrateur
 *
 */
public class DicesLauncher
{
    private static final String TAG = "DicesLauncher";
    private static final String REGEX = "([0-9]+D[0-9]+[ ]*)+(-[0-9]+)*";

    private final StringBuilder logs = new StringBuilder(256);

    public boolean testInputDicesInfos(final String dicesInfos)
    {
        return dicesInfos != null && dicesInfos.length() > 0 && dicesInfos.matches(REGEX);
    }

    public int rollDices(final int rank)
    {
        return rollDices(parseDicesInfos(RankManager.getDicesFromRank(rank)));
    }

    public int rollDices(final String dicesInfos)
    {
        return rollDices(parseDicesInfos(dicesInfos));
    }

    private List<Rollable> parseDicesInfos(final String dicesInfos)
    {
        Log.d(TAG, "parsing dices infos");
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

    public int rollDices(final List<Rollable> dices)
    {
        Log.d(TAG, "rollDices");
        logs.setLength(0);
        // lancer une premi�re fois les d�s et additionner les r�sultats.
        int result = simpleRoll(dices);

        // G�rer les relances sp�cifiques au syst�me EarthDawn
        result += manageRerolls(dices);

        // Somme des d�s apr�s relances
        return result;
    }

    private int simpleRoll(final List<Rollable> dices)
    {
        Log.d(TAG, "simpleRoll");
        // Lancer les d�s et additionner les r�sultats
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
        Log.d(TAG, "manageRerolls");
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
        Log.d(TAG, "removeCancelledDices");
        // Trier les listes par ordre d�croissant
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
        Log.d(TAG, "rerollMaxs");
        int sum = 0;
        while (!maxDices.isEmpty())
        {
            // relancer les d�s et ajouter les r�sultats
            sum += simpleRoll(maxDices);

            logs.append("------\n");

            // Ne garder que les d�s qui ont fait un maximum (pour relance)
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
        Log.d(TAG, "rerollMins");
        int sum = 0;
        while (!minDices.isEmpty())
        {
            // relancer les d�s et soustraire les r�sultats
            sum -= simpleRoll(minDices);

            logs.append("------\n");

            // Ne garder que les d�s qui ont fait un maximum (pour relance)
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

    public String getLogs()
    {
        return logs.toString();
    }
}
