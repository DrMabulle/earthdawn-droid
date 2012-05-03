/**
 *
 */
package fr.android.earthdawn.dices.impl;

import java.util.Random;

import fr.android.earthdawn.dices.Rollable;

/**
 * @author Administrateur
 *
 */
public class Dice implements Rollable
{
    private static final Random RAND = new Random();

    private final int maxValue;
    private int result;

    public Dice(final int aMaxValue)
    {
        maxValue = aMaxValue;
    }

    @Override
    public int roll()
    {
        result = RAND.nextInt(maxValue) + 1;
        return result;
    }

    @Override
    public int getPreviousResult()
    {
        return result;
    }

    @Override
    public boolean isMaxValue()
    {
        return result == maxValue;
    }

    @Override
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
        return builder.toString();
    }

    @Override
    public int compareTo(final Rollable dice)
    {
        if (dice.getClass() == this.getClass())
        {
            return this.maxValue - ((Dice) dice).maxValue;
        }
        return 1;
    }
}
