/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author DrMabulle
 *
 */
public class Perks implements Serializable
{
    private static final long serialVersionUID = -1845938624915361903L;

    private final Mod mod;
    private final int rank;

    private Perks(final Mod aMod, final int aRank)
    {
        super();
        this.mod = aMod;
        this.rank = aRank;
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

    /*
     * Optimize number of instanciations.
     * Indeed, a lot of mods are strickly the same and can not be modified
     */
    private static final Map<String, Perks> factory = new WeakHashMap<String, Perks>();
    public static final Perks get(final Mod mod, final int rank)
    {
        final String key = getKey(mod, rank);
        Perks result = factory.get(key);
        if (result == null)
        {
            result = new Perks(mod, rank);
            factory.put(key, result);
        }
        return result;
    }

    private static String getKey(final Mod aMod, final int aRank)
    {
        final StringBuilder builder = new StringBuilder(aMod.toString());
        builder.append(" at rank ");
        builder.append(aRank);
        return builder.toString();
    }
}
