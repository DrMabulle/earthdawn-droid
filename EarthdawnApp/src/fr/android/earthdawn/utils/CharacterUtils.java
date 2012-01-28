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

    public static int incrementWounds(final EDCharacter character, final int nbWounds)
    {
        final Mod wound = character.getTempMod(Pointcuts.WOUND);
        int totalWounds = nbWounds;
        if (wound != null)
        {
            totalWounds += wound.getModificator();
            character.removeTempMod(wound);
        }
        character.addTempMod(new Mod(Pointcuts.WOUND, totalWounds));
        return totalWounds;
    }
    public static int healWounds(final EDCharacter character, final int nbWounds)
    {
        return incrementWounds(character, nbWounds * -1);
    }

    public static int incrementDamages(final EDCharacter character, final int nbDamages)
    {
        final Mod damages = character.getTempMod(Pointcuts.DAMAGES);
        int totalDamages = nbDamages;
        if (damages != null)
        {
            totalDamages += damages.getModificator();
            character.removeTempMod(damages);
        }
        character.addTempMod(new Mod(Pointcuts.DAMAGES, totalDamages));
        return totalDamages;
    }
    public static int healDamages(final EDCharacter character, final int nbDamages)
    {
        return incrementDamages(character, nbDamages * -1);
    }
}
