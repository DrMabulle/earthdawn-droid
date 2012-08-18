package fr.android.earthdawn.managers;

import junit.framework.TestCase;

import org.junit.Test;

import fr.android.earthdawn.dices.DicesLauncher;

public class RankManagerTest extends TestCase
{
    @Test
    public void testGetRank()
    {
        assertEquals(0, RankManager.getRank(-1));
        assertEquals(0, RankManager.getRank(0));
        assertEquals(2, RankManager.getRank(1));
        assertEquals(2, RankManager.getRank(2));
        assertEquals(2, RankManager.getRank(3));
        assertEquals(3, RankManager.getRank(4));
        assertEquals(5, RankManager.getRank(12));
        assertEquals(6, RankManager.getRank(13));
        assertEquals(8, RankManager.getRank(21));
        assertEquals(9, RankManager.getRank(22));
        assertEquals(12, RankManager.getRank(33));
        assertEquals(13, RankManager.getRank(34));
    }

    @Test
    public void testGetDicesFromRank()
    {
        assertEquals("1D4 -2", RankManager.getDicesFromRank(1));
        assertEquals("1D8", RankManager.getDicesFromRank(5));
        assertEquals("1D10 + 1D6", RankManager.getDicesFromRank(10));
        assertEquals("1D20 + 1D6", RankManager.getDicesFromRank(15));
        assertEquals("1D20 + 1D8 + 1D6", RankManager.getDicesFromRank(20));
    }


    @Test
    public void testRanks()
    {
        for (int i = 0; i < 101; i++)
        {
            DicesLauncher.rollDices(RankManager.getDicesFromRank(i), false, false);
        }
    }

    @Test
    public void testGetDicesFromRankWithBonus()
    {
        assertEquals("1D4 -2 + 1", RankManager.getDicesFromRank(1, 1));
        assertEquals("1D8", RankManager.getDicesFromRank(5, 0));
        assertEquals("1D10 + 1D6 + 10", RankManager.getDicesFromRank(10, 10));
        assertEquals("1D20 + 1D6 -12", RankManager.getDicesFromRank(15, -12));
        assertEquals("1D20 + 1D8 + 1D6 + 5", RankManager.getDicesFromRank(20, 5));
    }
}
