package fr.android.earthdawn.dices;

public interface Rollable extends Comparable<Rollable>
{
    public int roll();

    public boolean isMaxValue();

    public boolean isMinValue();

    public int getPreviousResult();

}
