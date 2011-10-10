package fr.android.earthdawn.character.enums;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class DisciplineTest
{

    @Test
    public void testGetTalentsUpTo()
    {
        final Discipline discipline = new Discipline(Disciplines.Guerrier, 6);

        final List<Talent> talent10 = discipline.getTalentsUpTo(6);

        Assert.assertTrue(talent10 != null && talent10.size() > 0);
        Assert.assertTrue(talent10.size() == 17);
        for (final Talent talent : talent10)
        {
            Assert.assertTrue(talent.getCircle() < 7);
        }
    }

    @Test
    public void testGetTalentRank()
    {
        final Discipline discipline = new Discipline(Disciplines.Guerrier, 10);
        final Talent armesMelee = discipline.findTalent(Talents.ArmesMelee);
        final Talent longevite = discipline.findTalent(Talents.Longevite);

        // Initial state
        Assert.assertEquals(0, discipline.getTalentRank(armesMelee));
        Assert.assertEquals(0, discipline.getTalentRank(longevite));

        // Set talent rank
        discipline.setTalentRank(armesMelee, 8);
        discipline.setTalentRank(longevite, 6);

        Assert.assertEquals(8, discipline.getTalentRank(armesMelee));
        Assert.assertEquals(6, discipline.getTalentRank(longevite));

        // Increment rank
        discipline.incrementTalentRank(armesMelee);
        Assert.assertEquals(9, discipline.getTalentRank(armesMelee));
        discipline.incrementTalentRank(armesMelee);
        Assert.assertEquals(10, discipline.getTalentRank(armesMelee));

    }

}
