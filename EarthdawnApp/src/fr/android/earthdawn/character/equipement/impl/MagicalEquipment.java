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
     * @param name
     * @param bonuses
     */
    public MagicalEquipment(final String name, final List<List<Mod>> bonuses, final int[] costs)
    {
        super();
        this.name = name;
        this.bonuses = bonuses;
        this.costs = costs;
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
    public List<Mod> getBonuses(final int rank)
    {
        return bonuses.get(rank);
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
