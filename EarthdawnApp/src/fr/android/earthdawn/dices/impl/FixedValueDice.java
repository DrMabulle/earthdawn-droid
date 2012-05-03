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
        if (dice.getClass() == this.getClass())
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

}
