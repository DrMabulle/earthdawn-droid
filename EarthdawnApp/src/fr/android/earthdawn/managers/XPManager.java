/**
 *
 */
package fr.android.earthdawn.managers;

import java.util.List;

import fr.android.earthdawn.character.Character;
import fr.android.earthdawn.character.enums.Attributs;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.equipement.impl.MagicalEquipment;

/**
 * @author DrMabulle
 *
 */
public class XPManager
{
    private final int[] FIRST_COL = new int[] {0, 100, 300, 600, 1100, 1900, 3200, 5300, 8700, 14200, 23100, 37500, 60800, 98500, 159500, 258200};
    private final int[] SECOND_COL = new int[] {0, 200, 500, 1000, 1800, 3100, 5200, 8600, 14100, 23000, 37400, 60700, 98400, 159400, 258100, 417800};
    private final int[] THIRD_COL = new int[] {0, 300, 800, 1600, 2900, 5000, 8400, 13900, 22800, 37200, 60500, 98200, 159200, 257900, 417600, 676000};
    private final int[] FORTH_COL = new int[] {0, 500, 1300, 2600, 4700, 8100, 13600, 22500, 36900, 60200, 97900, 158900, 257600, 417300, 675700, 1093800};
    private final int[][] talentCost = new int[][] {FIRST_COL, SECOND_COL, THIRD_COL, FORTH_COL};

    private final int[] attributsCost = new int[] {0, 800, 2100, 4200, 7600, 13100};


    private static final XPManager INSTANCE = new XPManager();
    private XPManager() {}
    public static final XPManager get()
    {
        return INSTANCE;
    }

    public int evaluateCharacter(final Character character)
    {
        int total = 0;
        // Talents
        total += evaluateDiscipline(character.getMainDiscipline());
        total += evaluateDiscipline(character.getSecondDiscipline());
        total += evaluateDiscipline(character.getThirdDiscipline());

        // Attributs
        total += evaluateAttributs(character.getAttributEvols(Attributs.CHA));
        total += evaluateAttributs(character.getAttributEvols(Attributs.DEX));
        total += evaluateAttributs(character.getAttributEvols(Attributs.END));
        total += evaluateAttributs(character.getAttributEvols(Attributs.PER));
        total += evaluateAttributs(character.getAttributEvols(Attributs.STR));
        total += evaluateAttributs(character.getAttributEvols(Attributs.VOL));

        // Karma
        // TODO

        // Equipement magique
        // TODO

        return total;
    }

    public int evaluateDiscipline(final Discipline discipline)
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
    public int evaluateTalent(final Talent talent, final int rank)
    {
        int col = 0;
        if (talent.getCircle() < 5) col = 0;
        else if (talent.getCircle() < 9) col = 1;
        else if (talent.getCircle() < 13) col = 2;
        else col = 3;
        return talentCost[col][rank];
    }

    public int evaluateAttributs(final int nbEvols)
    {
        return attributsCost[nbEvols];
    }

    public int evaluateEquipment(final MagicalEquipment equipment, final int rank)
    {
        return 0;
    }

    public int evaluateKarma(final Races race, final int karmaBought)
    {
        return karmaBought * race.getKarmaCost();
    }
}
