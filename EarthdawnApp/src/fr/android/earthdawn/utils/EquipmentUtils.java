/**
 *
 */
package fr.android.earthdawn.utils;

import java.util.List;

import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.equipement.IEquipment;

/**
 * @author DrMabulle
 *
 */
public final class EquipmentUtils
{
    public static final int getDamageRank(final IEquipment weapon)
    {
        final List<Mod> mods = weapon.getBonuses();
        int damages = 0;
        for (final Mod mod : mods)
        {
            if (Pointcuts.WEAPON_DAMAGE.equals(mod.getPointcut()))
            {
                damages += mod.getModificator();
            }
        }
        return damages;
    }
}
