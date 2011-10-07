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
    DEX(0, "Dextérité"),
    STR(1, "Force"),
    END(2, "Endurance"),
    PER(3, "Perception"),
    VOL(4, "Volonté"),
    CHA(5, "Charisme"),
    NUL(6, "Aucun");


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
}
