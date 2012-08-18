/**
 *
 */
package fr.android.earthdawn.dices.impl;

import java.util.Random;

import fr.android.earthdawn.dices.Rollable;

/**
 * @author DrMabulle
 *
 */
public class Dice implements Rollable
{
    private static final Random RAND = new Random();

    private final int maxValue;
    private int result;

    /**
     * Default constructor
     * @param aMaxValue Maximum value of the Dice (min is 1)
     */
    public Dice(final int aMaxValue)
    {
        maxValue = aMaxValue;
    }

    /**
     * {@inheritDoc}
     * @see fr.android.earthdawn.dices.Rollable#roll()
     */
    @Override
    public int roll()
    {
        result = RAND.nextInt(maxValue) + 1;
        return result;
    }

    /**
     * {@inheritDoc}
     * @see fr.android.earthdawn.dices.Rollable#getPreviousResult()
     */
    @Override
    public int getPreviousResult()
    {
        return result;
    }

    /**
     * {@inheritDoc}
     * @see fr.android.earthdawn.dices.Rollable#isMaxValue()
     */
    @Override
    public boolean isMaxValue()
    {
        return result == maxValue;
    }

    /**
     * {@inheritDoc}
     * @see fr.android.earthdawn.dices.Rollable#isMinValue()
     */
    @Override
    public boolean isMinValue()
    {
        return result == 1;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder(5);
        builder.append("D");
        builder.append(maxValue);
        return builder.toString();
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Rollable dice)
    {
        if (dice.getClass().equals(this.getClass()))
        {
            return this.maxValue - ((Dice) dice).maxValue;
        }
        return 1;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + maxValue;
        return hash;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Dice other = (Dice) obj;
        if (maxValue != other.maxValue)
        {
            return false;
        }
        return true;
    }
}
