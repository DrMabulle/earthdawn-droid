/**
 *
 */
package fr.android.earthdawn.character.equipement;

import java.util.List;

import fr.android.earthdawn.character.enums.Mod;

/**
 * @author DrMabulle
 *
 */
public class Equipment
{
    private final String name;
    private final List<Mod> bonuses;
    /**
     * @param name
     * @param bonuses
     */
    public Equipment(final String name, final List<Mod> bonuses)
    {
        super();
        this.name = name;
        this.bonuses = bonuses;
    }
    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * @return the bonuses
     */
    public List<Mod> getBonuses()
    {
        return bonuses;
    }



}
