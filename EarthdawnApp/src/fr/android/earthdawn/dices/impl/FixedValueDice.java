/**
 *
 */
package fr.android.earthdawn.dices.impl;

import fr.android.earthdawn.dices.Rollable;

/**
 * @author DrMabulle
 *
 */
public class FixedValueDice implements Rollable
{
    private final int value;

    /**
     * Default constructor
     * @param aValue value of the fixed value dice
     */
    public FixedValueDice(final int aValue)
    {
        super();
        this.value = aValue;
    }

    /**
     * {@inheritDoc}
     * @see fr.android.earthdawn.dices.Rollable#roll()
     */
    @Override
    public int roll()
    {
        return value;
    }

    /**
     * {@inheritDoc}
     * @see fr.android.earthdawn.dices.Rollable#isMaxValue()
     */
    @Override
    public boolean isMaxValue()
    {
        return false;
    }

    /**
     * {@inheritDoc}
     * @see fr.android.earthdawn.dices.Rollable#isMinValue()
     */
    @Override
    public boolean isMinValue()
    {
        return false;
    }

    /**
     * {@inheritDoc}
     * @see fr.android.earthdawn.dices.Rollable#getPreviousResult()
     */
    @Override
    public int getPreviousResult()
    {
        return value;
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
            return this.value - ((FixedValueDice) dice).value;
        }
        return -1;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append("Modificateur ");
        builder.append(value);
        return builder.toString();
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
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
        final FixedValueDice other = (FixedValueDice) obj;
        if (value != other.value)
        {
            return false;
        }
        return true;
    }

}
