/**
 *
 */
package fr.android.earthdawn.utils;

import java.util.List;

import fr.android.earthdawn.character.enums.Attributs;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.character.equipement.IEquipment;

/**
 * @author DrMabulle
 *
 */
public final class EquipmentUtils
{
    private EquipmentUtils() {}

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


    @SuppressWarnings("rawtypes")
    public static double computeMods(final List<IEquipment> equipment, final List<Mod> permMod, final List<Mod> tmpMod,
            final Pointcuts pointcut, final Enum... additionnalInfos)
    {
        double result = 0.0;

        for (final IEquipment equip : equipment)
        {
            for (final Mod mod : equip.getBonuses())
            {
                result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
            }
        }
        for (final Mod mod : permMod)
        {
            result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
        }
        for (final Mod mod : tmpMod)
        {
            result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
        }

        return result;
    }

    @SuppressWarnings("rawtypes")
    protected static double incrementIfEqual(final Pointcuts pointcut, double result, final Mod mod, final Enum... additionnalInfos)
    {
        if (pointcut.equals(mod.getPointcut()))
        {
            // Attributs
            if (Pointcuts.ATTRIBUT.equals(pointcut))
            {
                if(((Attributs) additionnalInfos[0]).equals(mod.getOtherInfos()[0]))
                {
                    result += mod.getModificator();
                }
            }

            // Talents
            else if (Pointcuts.TALENT.equals(pointcut))
            {
                if (((Talents) additionnalInfos[0]).equals(mod.getOtherInfos()[0]))
                {
                    result += mod.getModificator();
                }
            }

            // Others
            else
            {
                result += mod.getModificator();
            }
        }
        return result;
    }


    @SuppressWarnings("rawtypes")
    public static double computeMods(final List<IEquipment> equipment, final List<Mod> permMod, final List<Mod> tmpMod,
            final Pointcuts pointcut, final Enum... additionnalInfos)
    {
        double result = 0.0;

        for (final IEquipment equip : equipment)
        {
            for (final Mod mod : equip.getBonuses())
            {
                result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
            }
        }
        for (final Mod mod : permMod)
        {
            result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
        }
        for (final Mod mod : tmpMod)
        {
            result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
        }

        return result;
    }

    @SuppressWarnings("rawtypes")
    protected static double incrementIfEqual(final Pointcuts pointcut, double result, final Mod mod, final Enum... additionnalInfos)
    {
        if (pointcut.equals(mod.getPointcut()))
        {
            // Attributs || talents
            if (Pointcuts.ATTRIBUT.equals(pointcut) || Pointcuts.TALENT.equals(pointcut))
            {
                if(additionnalInfos[0].equals(mod.getOtherInfos()[0]))
                {
                    result += mod.getModificator();
                }
            }

            // Others
            else
            {
                result += mod.getModificator();
            }
        }
        return result;
    }
}
