/**
 *
 */
package fr.android.earthdawn.character.enums;

/**
 * @author DrMabulle
 *
 */
public enum Attributs
{
    DEX(0, "DEX"),
    STR(1, "FOR"),
    END(2, "END"),
    PER(3, "PER"),
    VOL(4, "VOL"),
    CHA(5, "CHA"),
    NUL(6, "");


    private int id;
    private String label;

    Attributs(final int aId, final String aLabel)
    {
        id = aId;
        label = aLabel;
    }

    public int getId()
    {
        return id;
    }

    public String getLabel()
    {
        return label;
    }

    @Override
    public String toString()
    {
        return label;
    }
}
