package fr.android.earthdawn.dices;


/**
 * Representation of Objects that can be rolled (dices) in the EarthDawn rules universe
 * @author DrMabulle
 */
public interface Rollable extends Comparable<Rollable>
{
    /**
     * Simulates the dice roll
     * @return the result of the roll
     */
    public int roll();

    /**
     * Compares the value obtained by the roll to the max value of the Rollable.
     * @return true if the obtained value is equal to the maximum value of the Rollable
     */
    public boolean isMaxValue();

    /**
     * Compares the value obtained by the roll to the min value of the Rollable.
     * @return true if the obtained value is equal to the minimum value of the Rollable
     */
    public boolean isMinValue();

    /**
     * Retrieves the result of the previous roll
     * @return the result of the previous roll
     */
    public int getPreviousResult();

}
