package fr.android.earthdawn.managers;

import junit.framework.TestCase;
import fr.android.earthdawn.R;
import fr.android.earthdawn.managers.EDDicesLauncher.Roll;

public class EDDicesLauncherTest extends TestCase
{
    public void testRollDices()
    {
        // Roll 1
        final int result1 = EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_SKILL, R.string.skill, 16, 3);
        assertEquals(result1, EDDicesLauncher.getRollResult());
        final int rollType1 = EDDicesLauncher.getRollType();
        assertEquals(R.string.skill, rollType1);
        assertEquals(1, EDDicesLauncher.rollsHistory.size());

        // Roll 2
        final int result2 = EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_OTHER, R.string.free_roll, "1D10", 4);
        assertEquals(result2, EDDicesLauncher.getRollResult());
        final int rollType2 = EDDicesLauncher.getRollType();
        assertEquals(R.string.free_roll, rollType2);
        assertEquals(2, EDDicesLauncher.rollsHistory.size());

        // History 1
        final Roll firstRoll = EDDicesLauncher.rollsHistory.get(1);
        assertEquals(EDDicesLauncher.ROLL_SKILL, firstRoll.rollKind);
        assertEquals(R.string.skill, firstRoll.rollNameId);
        assertEquals(16, firstRoll.rollRank);
        assertEquals(result1, firstRoll.rollResult);
        assertEquals(2, firstRoll.rollWounds);

        // History 2
        final Roll secondRoll = EDDicesLauncher.rollsHistory.get(0);
        assertEquals(EDDicesLauncher.ROLL_OTHER, secondRoll.rollKind);
        assertEquals(R.string.free_roll, secondRoll.rollNameId);
        assertEquals("1D10", secondRoll.rollDicesInfos);
        assertEquals(result2, secondRoll.rollResult);
        assertEquals(3, secondRoll.rollWounds);

        // Max History
        for (int i = 0; i < 10; i++)
        {
            EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_SKILL, R.string.skill, 16, 3);
        }
        assertEquals(10, EDDicesLauncher.rollsHistory.size());
    }
}
