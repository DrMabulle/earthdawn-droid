/**
 *
 */
package fr.android.earthdawn.utils;

import java.util.List;

import fr.android.earthdawn.character.enums.Attributes;
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

    /**
     * Computes and returns the damage rank of a given piece of equipment (weapon)
     * @param weapon a piece of equipment to evaluate
     * @return the damage rank of the given piece of equipment (weapon)
     */
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


    /**
     * Computes the modificator for a given Pointcut, considering the equipment and modificators affecting the character.
     * @param equipment a list of pieces of equipment carried by the character
     * @param permMod a list of permanent modificators affecting the character
     * @param tmpMod a list of temporary modificators affecting the character
     * @param pointcut the Pointcut to evaluate.
     * @param additionnalInfos additionnal informations linked to the Pointcut (talent name, attribute, etc.)
     * @return
     */
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
    protected static double incrementIfEqual(final Pointcuts pointcut, final double aResult, final Mod mod, final Enum... additionnalInfos)
    {
        double result = aResult;
        if (pointcut.equals(mod.getPointcut()))
        {
            // Attributes
            if (Pointcuts.ATTRIBUT.equals(pointcut))
            {
                if(((Attributes) additionnalInfos[0]).equals(mod.getOtherInfos()[0]))
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
}
