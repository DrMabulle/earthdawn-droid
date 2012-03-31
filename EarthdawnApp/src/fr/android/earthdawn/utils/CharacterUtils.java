/**
 *
 */
package fr.android.earthdawn.utils;

import java.util.ArrayList;
import java.util.List;

import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.equipement.IEquipment;


/**
 * @author DrMabulle
 *
 */
public final class CharacterUtils
{

    public static int computeDeathThreshold(final int indice)
    {
        return (int) (indice + 18 + Math.ceil(indice / 3));
    }

    public static int computeUnconsciousnessThreshold(final int indice)
    {
        return (int) (indice + 9 + Math.ceil(indice / 3) + Math.ceil((indice - 1) / 10));
    }

    public static int computeWoundThreshold(final int indice)
    {
        return (int) Math.ceil(indice / 2.0 + 2.5 - Math.ceil((indice + 1) / 22) / 2.0 - Math.ceil(indice / 27) / 2.0);
    }

    public static int computeIndiceDefense(final int indice)
    {
        return (int) Math.ceil(indice / 2.0 + 1.5 - Math.ceil((indice + 1) / 7) / 2.0);
    }

    public static int computeMysticArmor(final int indice)
    {
        return (int) Math.ceil(Math.max(indice - 10, 0)  / 3.0);
    }

    public static int computeCarryingCapacity(final int indice)
    {
        return (int) Math.ceil(computeLiftingCapacity(indice) / 2.0);
    }

    public static int computeLiftingCapacity(final int indice)
    {
        if (indice <= 6)
        {
            return 5 * indice;
        }
        else if (indice <= 11)
        {
            return 10 * indice - 30;
        }
        else if (indice <= 15)
        {
            return 15 * indice - 85;
        }
        else if (indice <= 18)
        {
            return 20 * indice - 160;
        }
        else if (indice <= 21)
        {
            return 30 * indice - 340;
        }
        else if (indice <= 24)
        {
            return 40 * indice - 550;
        }
        else if (indice <= 27)
        {
            return 50 * indice - 790;
        }
        else
        {
            return 60 * indice - 1060;
        }
    }

    public static int computeRunningMouvement(final int indice)
    {
        return computeCombatMouvement(indice) * 2;
    }
    public static int computeCombatMouvement(final int indice)
    {
        if (indice < 6)
        {
            return indice + 5;
        }
        else if (indice < 21)
        {
            return indice * 2;
        }
        else
        {
            return indice * 3 - 20;
        }
    }

    public static List<IEquipment> getWeapons(final EDCharacter character)
    {
        final List<IEquipment> weapons = new ArrayList<IEquipment>();

        final List<IEquipment> tmp = character.getEquipment();
        for (final IEquipment iEquipment : tmp)
        {
            if (isWeapon(iEquipment))
            {
                weapons.add(iEquipment);
            }
        }

        return weapons;
    }

    private static boolean isWeapon(final IEquipment iEquipment)
    {
        final List<Mod> mods = iEquipment.getBonuses();
        for (final Mod mod : mods)
        {
            if (Pointcuts.WEAPON_DAMAGE.equals(mod.getPointcut()))
            {
                return true;
            }
        }
        return false;
    }

    public static final int getMaxKarma(final EDCharacter character)
    {
        int max = character.getRace().getKarmaMax();
        max += character.computeBonusesInt(Pointcuts.KARMA_POINTS);
        return max;
    }

    @SuppressWarnings("rawtypes")
    public static final double computePerks(final EDCharacter character, final Pointcuts pointcut, final Enum... additionnalInfos)
    {
        double result = 0.0;
        // Bonuses from main discipline
        List<Mod> mods = character.getMainDiscipline().getPerks();
        for (final Mod mod : mods)
        {
            result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
        }
        // bonuses from second discipline
        if (character.getSecondDiscipline() != null)
        {
            mods = character.getSecondDiscipline().getPerks();
            for (final Mod mod : mods)
            {
                result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
            }
            // bonuses from third discipline
            if (character.getThirdDiscipline() != null)
            {
                mods = character.getSecondDiscipline().getPerks();
                for (final Mod mod : mods)
                {
                    result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
                }
            }
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
    protected static double incrementIfEqual(final Pointcuts pointcut, double result, final Mod mod, final Enum... additionnalInfos)
    {
        if (pointcut.equals(mod.getPointcut()))
        {
            // Attributs || talents || karma use
            if (Pointcuts.ATTRIBUT.equals(pointcut) || Pointcuts.TALENT.equals(pointcut) || Pointcuts.KARMA_USE.equals(pointcut))
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
