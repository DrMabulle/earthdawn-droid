package fr.android.earthdawn.managers;

import junit.framework.TestCase;

import org.junit.Test;

import fr.android.earthdawn.managers.EDDicesLauncher.Roll;

public class EDDicesLauncherTest extends TestCase
{
    @Test
    public void testRollDices()
    {
        // Roll 1
        final int result1 = EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_TALENT, 0, 16, 3);
        assertEquals(result1, EDDicesLauncher.getRollResult());
        final int rollType1 = EDDicesLauncher.getRollType();
        assertEquals(0, rollType1);
        assertEquals(1, EDDicesLauncher.rollsHistory.size());

        // Roll 2
        final int result2 = EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_OTHER, 2, "1D10", 4);
        assertEquals(result2, EDDicesLauncher.getRollResult());
        final int rollType2 = EDDicesLauncher.getRollType();
        assertEquals(2, rollType2);
        assertEquals(2, EDDicesLauncher.rollsHistory.size());

        // History 1
        final Roll firstRoll = EDDicesLauncher.rollsHistory.get(1);
        assertEquals(EDDicesLauncher.ROLL_TALENT, firstRoll.rollKind);
        assertEquals(0, firstRoll.rollNameId);
        assertEquals(16, firstRoll.rollRank);
        assertEquals(result1, firstRoll.rollResult);
        assertEquals(2, firstRoll.rollWounds);

        // History 2
        final Roll secondRoll = EDDicesLauncher.rollsHistory.get(0);
        assertEquals(EDDicesLauncher.ROLL_OTHER, secondRoll.rollKind);
        assertEquals(2, secondRoll.rollNameId);
        assertEquals("1D10", secondRoll.rollDicesInfos);
        assertEquals(result2, secondRoll.rollResult);
        assertEquals(3, secondRoll.rollWounds);

        // Max History
        for (int i = 0; i < 10; i++)
        {
            EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_TALENT, 0, 16, 3);
        }
        assertEquals(10, EDDicesLauncher.rollsHistory.size());
    }
}
