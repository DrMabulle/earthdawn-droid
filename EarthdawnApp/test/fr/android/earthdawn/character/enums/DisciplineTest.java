package fr.android.earthdawn.character.enums;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class DisciplineTest
{

    @Test
    public void testGetTalentsUpTo()
    {
        final Discipline discipline = new Discipline(Disciplines.Guerrier, 10);

        final List<Talent> talent10 = discipline.getTalentsUpTo(10);

        Assert.assertTrue(talent10 != null && talent10.size() > 0);
        Assert.assertTrue(talent10.size() == 11);
        for (final Talent talent : talent10)
        {
            Assert.assertTrue(talent.getCircle() < 11);
        }
    }

}
