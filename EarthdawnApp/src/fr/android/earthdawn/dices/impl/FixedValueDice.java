/**
 *
 */
package fr.android.earthdawn.dices.impl;

import fr.android.earthdawn.dices.Rollable;

/**
 * @author SOFTEAM
 *
 */
public class FixedValueDice implements Rollable
{
    private final int value;

    public FixedValueDice(final int value)
    {
        super();
        this.value = value;
    }

    @Override
    public int roll()
    {
        return value;
    }

    @Override
    public boolean isMaxValue()
    {
        return false;
    }

    @Override
    public boolean isMinValue()
    {
        return false;
    }

    @Override
    public int getPreviousResult()
    {
        return value;
    }

    @Override
    public int compareTo(final Rollable dice)
    {
        if (dice.getClass().equals(this.getClass()))
        {
            return this.value - ((FixedValueDice) dice).value;
        }
        return -1;
    }

    /*
     * (non-Javadoc)
     *
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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

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
