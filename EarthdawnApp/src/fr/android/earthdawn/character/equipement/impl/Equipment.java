/**
 *
 */
package fr.android.earthdawn.character.equipement.impl;

import java.io.Serializable;
import java.util.List;

import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.equipement.IEquipment;

/**
 * @author DrMabulle
 *
 */
public class Equipment implements IEquipment, Serializable
{
    private static final long serialVersionUID = 4947121231383859309L;

    private final String name;
    private final List<Mod> bonuses;
    /**
     * @param aName
     * @param someBonuses
     */
    public Equipment(final String aName, final List<Mod> someBonuses)
    {
        super();
        this.name = aName;
        this.bonuses = someBonuses;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public List<Mod> getBonuses()
    {
        return bonuses;
    }

    @Override
    public boolean isMagical()
    {
        return false;
    }
}
