package fr.android.earthdawn.managers;

import junit.framework.Assert;

import org.junit.Test;

import fr.android.earthdawn.managers.EDDicesLauncher.Roll;

public class EDDicesLauncherTest
{
    @Test
    public void testRollDices()
    {
        // Roll 1
        final int result1 = EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_TALENT, 0, 16, 3);
        Assert.assertEquals(result1, EDDicesLauncher.getRollResult());
        final int rollType1 = EDDicesLauncher.getRollType();
        Assert.assertEquals(0, rollType1);
        Assert.assertEquals(1, EDDicesLauncher.rollsHistory.size());

        // Roll 2
        final int result2 = EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_OTHER, 2, "1D10", 4);
        Assert.assertEquals(result2, EDDicesLauncher.getRollResult());
        final int rollType2 = EDDicesLauncher.getRollType();
        Assert.assertEquals(2, rollType2);
        Assert.assertEquals(2, EDDicesLauncher.rollsHistory.size());

        // History 1
        final Roll firstRoll = EDDicesLauncher.rollsHistory.get(1);
        Assert.assertEquals(EDDicesLauncher.ROLL_TALENT, firstRoll.rollKind);
        Assert.assertEquals(0, firstRoll.rollNameId);
        Assert.assertEquals(16, firstRoll.rollRank);
        Assert.assertEquals(result1, firstRoll.rollResult);
        Assert.assertEquals(3, firstRoll.rollWounds);

        // History 2
        final Roll secondRoll = EDDicesLauncher.rollsHistory.get(0);
        Assert.assertEquals(EDDicesLauncher.ROLL_OTHER, secondRoll.rollKind);
        Assert.assertEquals(2, secondRoll.rollNameId);
        Assert.assertEquals("1D10", secondRoll.rollDicesInfos);
        Assert.assertEquals(result2, secondRoll.rollResult);
        Assert.assertEquals(4, secondRoll.rollWounds);

        // Max History
        for (int i = 0; i < 10; i++)
        {
            EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_TALENT, 0, 16, 3);
        }
        Assert.assertEquals(10, EDDicesLauncher.rollsHistory.size());
    }
}
