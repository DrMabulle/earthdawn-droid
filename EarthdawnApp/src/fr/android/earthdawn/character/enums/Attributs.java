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
    dex(0, "Dextérité"),
    str(1, "Force"),
    end(2, "Endurance"),
    per(3, "Perception"),
    vol(4, "Volonté"),
    cha(5, "Charisme");


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
