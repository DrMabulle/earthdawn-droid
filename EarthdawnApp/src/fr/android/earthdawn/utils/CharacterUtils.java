/**
 *
 */
package fr.android.earthdawn.utils;

import java.util.ArrayList;
import java.util.List;

import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.character.equipement.IEquipment;
import fr.android.earthdawn.managers.RankManager;


/**
 * @author DrMabulle
 *
 */
public final class CharacterUtils
{
    private CharacterUtils() {}

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
    protected static double incrementIfEqual(final Pointcuts pointcut, final double aResult, final Mod mod, final Enum... additionnalInfos)
    {
        double result = aResult;
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

    /**
     * Returns the maximum rank for a given talent. Searches all disciplines
     * @param aCharacter a character
     * @param aTalent a talent to search
     * @return max level over all disciplines
     */
    public static int getTalentRank(final EDCharacter aCharacter, final Talents aTalent)
    {
        Discipline disc = aCharacter.getMainDiscipline();
        int rank1 = 0;
        if (disc != null)
        {
            rank1 = disc.getTalentRank(disc.findTalent(aTalent));
        }
        disc = aCharacter.getSecondDiscipline();
        int rank2 = 0;
        if (disc != null)
        {
            rank2 = disc.getTalentRank(disc.findTalent(aTalent));
        }
        disc = aCharacter.getThirdDiscipline();
        int rank3 = 0;
        if (disc != null)
        {
            rank3 = disc.getTalentRank(disc.findTalent(aTalent));
        }
        return Math.max(rank1, Math.max(rank2, rank3));
    }
    public static Talent getTalent(final EDCharacter aCharacter, final Talents aTalent)
    {
        Talent talent = null;
        Discipline disc = aCharacter.getMainDiscipline();
        if (disc != null)
        {
            talent = disc.findTalent(aTalent);
        }
        if (talent == null)
        {
            disc = aCharacter.getSecondDiscipline();
            if (disc != null)
            {
                talent = disc.findTalent(aTalent);
            }
            if (talent == null)
            disc = aCharacter.getThirdDiscipline();
            if (disc != null)
            {
                talent = disc.findTalent(aTalent);
            }
        }
        return talent;
    }

    public static boolean canBuyKarma(final EDCharacter aCharacter)
    {
        // Check Legend points, max karma allowed
        return CharacterUtils.maxKarmaBuyable(aCharacter) > 0;
    }

    public static int maxKarmaBuyable(final EDCharacter aCharacter)
    {
        // Level of talent Rituel de Karma
        final int maxKarmaBuyable = CharacterUtils.getTalentRank(aCharacter, Talents.RituelKarma);
        // Difference between max karma allowed and karma available
        final int maxKarma = CharacterUtils.getMaxKarma(aCharacter);
        final int availableKarma = aCharacter.getAvailableKarma();
        // Legend points (10 legend points per karma point)
        final int legend = aCharacter.getLegendPoints() / 10;

        return Math.min(maxKarmaBuyable, Math.min(legend, maxKarma - availableKarma));
    }

    public static boolean knowsTalent(final EDCharacter aCharacter, final Talents aTalent)
    {
        return CharacterUtils.getTalentRank(aCharacter, aTalent) > 0;
    }

    public static String computeInitiativeTest(final EDCharacter character)
    {
        final int initiativeRank = character.getInitiativeLevel();
        final int initiativeMod = character.computeBonusesInt(Pointcuts.INIT_MOD);
        final StringBuilder result = new StringBuilder(24);
        String sign = "";
        if (initiativeRank > 0 || initiativeRank == 0 && initiativeMod == 0)
        {
            result.append(RankManager.getDicesFromRank(initiativeRank));
            sign = " + ";
        }

        if (initiativeMod > 0)
        {
            result.append(sign);
            result.append(initiativeMod);
        }
        else if (initiativeMod < 0)
        {
            result.append(initiativeMod);
        }
        return result.toString();
    }
}
