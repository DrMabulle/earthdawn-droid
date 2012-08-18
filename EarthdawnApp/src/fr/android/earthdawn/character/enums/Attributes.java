/**
 *
 */
package fr.android.earthdawn.character.enums;

import fr.android.earthdawn.R;

/**
 * @author DrMabulle
 *
 */
public enum Attributes
{
    DEX(0, "DEX", R.string.dex),
    STR(1, "FOR", R.string.str),
    END(2, "END", R.string.end),
    PER(3, "PER", R.string.per),
    VOL(4, "VOL", R.string.vol),
    CHA(5, "CHA", R.string.cha),
    NUL(6, "", R.string.no_att);

    private int id;
    private String label;
    private int fullName;

    Attributes(final int aId, final String aLabel, final int aFullName)
    {
        id = aId;
        label = aLabel;
        fullName = aFullName;
    }

    public int getId()
    {
        return id;
    }

    public String getLabel()
    {
        return label;
    }

    public int getFullName()
    {
        return fullName;
    }

    @Override
    public String toString()
    {
        return label;
    }
}
