/**
 * 
 */
package fr.android.earthdawn.dices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.util.Log;

/**
 * @author DrMabulle
 *
 */
public class DicesLauncher
{
    private static final String TAG = "DicesLauncher";
    private static final String REGEX = "([0-9]+D[0-9]+[ ]*)+";

    private final StringBuilder logs = new StringBuilder(256);

    public boolean testInputDicesInfos(final String dicesInfos)
    {
        return dicesInfos != null && dicesInfos.length() > 0 && dicesInfos.matches(REGEX);
    }

    public List<Dice> parseDicesInfos(final String dicesInfos)
    {
        Log.d(TAG, "parsing dices infos");
        final List<Dice> dices = new ArrayList<Dice>(6);

        final String[] split = dicesInfos.split(" ");

        for (final String infos : split)
        {
            instanciateDices(infos, dices);
        }

        return dices;
    }

    private void instanciateDices(final String infos, final List<Dice> dices)
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

    public int rollDices(final List<Dice> dices)
    {
        Log.d(TAG, "rollDices");
        logs.setLength(0);
        // lancer une première fois les dés et additionner les résultats.
        int result = simpleRoll(dices);

        // Gérer les relances spécifiques au système EarthDawn
        result += manageRerolls(dices);

        // Somme des dés après relances
        return result;
    }

    private int simpleRoll(final List<Dice> dices)
    {
        Log.d(TAG, "simpleRoll");
        // Lancer les dés et additionner les résultats
        int sum = 0;
        for (final Dice dice : dices)
        {
            sum += dice.roll();

            logs.append(dice.toString());
            logs.append(" donne ");
            logs.append(dice.getPreviousResult());
            logs.append('\n');
        }
        return sum;
    }

    private int manageRerolls(final List<Dice> dices)
    {
        Log.d(TAG, "manageRerolls");
        final List<Dice> maxDices = new ArrayList<Dice>(6);
        final List<Dice> minDices = new ArrayList<Dice>(6);
        int result = 0;

        // Récupérer les Max et Min
        for (final Dice dice : dices)
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

    private void removeCancelledDices(final List<Dice> maxDices,
            final List<Dice> minDices)
    {
        Log.d(TAG, "removeCancelledDices");
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

    private int rerollMaxs(final List<Dice> maxDices)
    {
        Log.d(TAG, "rerollMaxs");
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

    private int rerollMins(final List<Dice> minDices)
    {
        Log.d(TAG, "rerollMins");
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

    public String getLogs()
    {
        return logs.toString();
    }
}
