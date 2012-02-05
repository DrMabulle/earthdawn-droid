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
    DEX(0, "DEX", "Dextérité"),
    STR(1, "FOR", "Force"),
    END(2, "END", "Endurance"),
    PER(3, "PER", "Perception"),
    VOL(4, "VOL", "Volonté"),
    CHA(5, "CHA", "Charisme"),
    NUL(6, "", "Aucun attribut");


    private int id;
    private String label;
    private String fullName;

    Attributs(final int aId, final String aLabel, final String aFullName)
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

    public String getFullName()
    {
        return fullName;
    }

    @Override
    public String toString()
    {
        return label;
    }
}
