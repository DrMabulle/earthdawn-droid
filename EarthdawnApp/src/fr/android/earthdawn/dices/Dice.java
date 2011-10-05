/**
 * 
 */
package fr.android.earthdawn.dices;

import java.util.Random;

/**
 * @author DrMabulle
 *
 */
public class Dice implements Comparable<Dice>
{
    // Compteur pour ID
    private static int cpt = 0;

    private static final Random RAND = new Random();

    private final int maxValue;
    private int result;
    private final int id;

    public Dice(final int aMaxValue)
    {
        maxValue = aMaxValue;
        id = cpt++;
    }

    public int roll()
    {
        result = RAND.nextInt(maxValue) + 1;
        return result;
    }

    public int getPreviousResult()
    {
        return result;
    }

    public boolean isMaxValue()
    {
        return result == maxValue;
    }

    public boolean isMinValue()
    {
        return result == 1;
    }

    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append("D");
        builder.append(maxValue);
        builder.append("(");
        builder.append(id);
        builder.append(")");
        return builder.toString();
    }

    @Override
    public int compareTo(final Dice dice)
    {
        return this.maxValue - dice.maxValue;
    }
}
