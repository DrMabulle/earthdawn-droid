/**
 *
 */
package fr.android.earthdawn.character.equipement.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.equipement.IEquipment;

/**
 * @author DrMabulle
 *
 */
public class MagicalEquipment implements IEquipment, Serializable
{
    private static final long serialVersionUID = 6525264693377432928L;

    private final String name;
    private int rank = 0;
    private final List<List<Mod>> bonuses;
    private final int[] costs;
    /**
     * @param aName
     * @param someBonuses
     */
    public MagicalEquipment(final String aName, final List<List<Mod>> someBonuses, final int[] someCosts)
    {
        super();
        this.name = aName;
        this.bonuses = someBonuses;
        this.costs = someCosts;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public List<Mod> getBonuses()
    {
        final List<Mod> result = new ArrayList<Mod>();
        for (int i = 0; i < rank+1; i++)
        {
            result.addAll(bonuses.get(i));
        }
        return result;
    }
    public List<Mod> getBonuses(final int aRank)
    {
        return bonuses.get(aRank);
    }

    public int getRank()
    {
        return rank;
    }
    public void incrementRank()
    {
        rank++;
    }

    public int[] getCosts()
    {
        return costs;
    }

    @Override
    public boolean isMagical()
    {
        return true;
    }
}
