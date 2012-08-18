/**
 *
 */
package fr.android.earthdawn.managers;

import java.util.List;

import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Attributes;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Skill;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.equipement.IEquipment;
import fr.android.earthdawn.character.equipement.impl.MagicalEquipment;

/**
 * @author DrMabulle
 *
 */
public final class XPManager
{
    private static final int[] FIRST_COL = new int[] {0, 100, 300, 600, 1100, 1900, 3200, 5300, 8700, 14200, 23100, 37500, 60800, 98500, 159500, 258200};
    private static final int[] SECOND_COL = new int[] {0, 200, 500, 1000, 1800, 3100, 5200, 8600, 14100, 23000, 37400, 60700, 98400, 159400, 258100, 417800};
    private static final int[] THIRD_COL = new int[] {0, 300, 800, 1600, 2900, 5000, 8400, 13900, 22800, 37200, 60500, 98200, 159200, 257900, 417600, 676000};
    private static final int[] FORTH_COL = new int[] {0, 500, 1300, 2600, 4700, 8100, 13600, 22500, 36900, 60200, 97900, 158900, 257600, 417300, 675700, 1093800};
    private static final int[][] talentCost = new int[][] {FIRST_COL, SECOND_COL, THIRD_COL, FORTH_COL};

    private static final int[] attributesCost = new int[] {0, 800, 2100, 4200, 7600, 13100};

    private static final int KARMA_COST = 10;

    private XPManager() {}

    /**
     * Computes the total number of Legend Points spent buy a given character
     * @param character a character to analyze
     * @return the total number of Legend Points spent buy the given character
     */
    public static int evaluateCharacter(final EDCharacter character)
    {
        int total = 0;
        // Talents
        total += evaluateDiscipline(character.getMainDiscipline());
        total += evaluateDiscipline(character.getSecondDiscipline());
        total += evaluateDiscipline(character.getThirdDiscipline());

        // Attributes
        total += evaluateAttributes(character.getAttributEvols(Attributes.CHA));
        total += evaluateAttributes(character.getAttributEvols(Attributes.DEX));
        total += evaluateAttributes(character.getAttributEvols(Attributes.END));
        total += evaluateAttributes(character.getAttributEvols(Attributes.PER));
        total += evaluateAttributes(character.getAttributEvols(Attributes.STR));
        total += evaluateAttributes(character.getAttributEvols(Attributes.VOL));

        // Skills
        total += evaluateSkills(character.getSkills());

        // Karma
        total += evaluateKarma(character.getKarmaBought());

        // Magical Equipment
        total += evaluateEquipment(character);

        return total;
    }

    protected static int evaluateDiscipline(final Discipline discipline)
    {
        int total = 0;

        if (discipline != null)
        {
            final List<Talent> talents = discipline.getKnownTalents();
            for (final Talent talent : talents)
            {
                total += evaluateTalent(talent, discipline.getTalentRank(talent));
            }
        }

        return total;
    }
    protected static int evaluateTalent(final Talent talent, final int rank)
    {
        int col = 0;
        if (talent.getCircle() < 5)
        {
            col = 0;
        }
        else if (talent.getCircle() < 9)
        {
            col = 1;
        }
        else if (talent.getCircle() < 13)
        {
            col = 2;
        }
        else
        {
            col = 3;
        }
        return talentCost[col][rank];
    }

    protected static int evaluateAttributes(final int nbEvols)
    {
        return attributesCost[nbEvols];
    }

    protected static int evaluateEquipment(final EDCharacter character)
    {
        int sum = 0;

        final List<IEquipment> loot = character.getEquipment();
        for (final IEquipment equipment : loot)
        {
            if (equipment.isMagical())
            {
                sum += evaluateEquipment((MagicalEquipment) equipment);
            }
        }

        return sum;
    }

    protected static int evaluateEquipment(final MagicalEquipment equipment)
    {
        final int[] costs = equipment.getCosts();
        final int rank = equipment.getRank();
        int sum = 0;

        for(int i = 0; i < rank; i++)
        {
            sum += costs[i];
        }
        return sum;
    }

    /**
     * Computes the number of Legend Points spent buy a given character on Karma Points
     * @param karmaBought number of karma points bought
     * @return the total number of Legend Points spent buy the given character on Karma Points
     */
    public static int evaluateKarma(final int karmaBought)
    {
        return karmaBought * KARMA_COST;
    }

    protected static int evaluateSkills(final List<Skill> skills)
    {
        // Skills are equivalent to talents 5-8
        int sum = 0;
        if (skills != null)
        {
            for (final Skill skill : skills)
            {
                sum += SECOND_COL[skill.getRank()];
            }
        }
        return sum;
    }
}
