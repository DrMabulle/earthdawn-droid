package fr.android.earthdawn.character.enums;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class DisciplineTest extends TestCase
{
    @Test
    public void testGetTalentsUpTo()
    {
        final Discipline discipline = new Discipline(Disciplines.Guerrier, 6);

        final List<Talent> talent10 = discipline.getTalentsUpTo(6);

        assertTrue(talent10 != null && talent10.size() > 0);
        assertTrue(talent10.size() == 18);
        for (final Talent talent : talent10)
        {
            assertTrue(talent.getCircle() < 7);
        }
    }

    @Test
    public void testGetTalentRank()
    {
        final Discipline discipline = new Discipline(Disciplines.Guerrier, 10);
        final Talent armesMelee = discipline.findTalent(Talents.ArmesMelee);
        final Talent longevite = discipline.findTalent(Talents.Endurance);

        // Initial state
        assertEquals(0, discipline.getTalentRank(armesMelee));
        assertEquals(0, discipline.getTalentRank(longevite));

        // Set talent rank
        discipline.setTalentRank(armesMelee, 8);
        discipline.setTalentRank(longevite, 6);

        assertEquals(8, discipline.getTalentRank(armesMelee));
        assertEquals(6, discipline.getTalentRank(longevite));

        // Increment rank
        discipline.incrementTalentRank(armesMelee);
        assertEquals(9, discipline.getTalentRank(armesMelee));
        discipline.incrementTalentRank(armesMelee);
        assertEquals(10, discipline.getTalentRank(armesMelee));
    }
}
