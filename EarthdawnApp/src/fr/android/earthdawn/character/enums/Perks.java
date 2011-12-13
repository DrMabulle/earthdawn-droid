/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;

/**
 * @author DrMabulle
 *
 */
public class Perks implements Serializable
{
    private static final long serialVersionUID = -1845938624915361903L;

    private final Mod mod;
    private final int rank;

    public Perks(final Mod mod, final int rank)
    {
        super();
        this.mod = mod;
        this.rank = rank;
    }

    /**
     * @return the mod
     */
    public Mod getMod()
    {
        return mod;
    }

    /**
     * @return the rank
     */
    public int getRank()
    {
        return rank;
    }

}
