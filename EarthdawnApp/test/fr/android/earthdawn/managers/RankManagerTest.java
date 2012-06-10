package fr.android.earthdawn.managers;

import junit.framework.Assert;

import org.junit.Test;

public class RankManagerTest
{
    @Test
    public void testGetRank()
    {
        Assert.assertEquals(0, RankManager.getRank(-1));
        Assert.assertEquals(0, RankManager.getRank(0));
        Assert.assertEquals(2, RankManager.getRank(1));
        Assert.assertEquals(2, RankManager.getRank(2));
        Assert.assertEquals(2, RankManager.getRank(3));
        Assert.assertEquals(3, RankManager.getRank(4));
        Assert.assertEquals(5, RankManager.getRank(12));
        Assert.assertEquals(6, RankManager.getRank(13));
        Assert.assertEquals(8, RankManager.getRank(21));
        Assert.assertEquals(9, RankManager.getRank(22));
        Assert.assertEquals(12, RankManager.getRank(33));
        Assert.assertEquals(13, RankManager.getRank(34));
    }

    @Test
    public void testGetDicesFromRank()
    {
        Assert.assertEquals("1D4 -2", RankManager.getDicesFromRank(1));
        Assert.assertEquals("1D8", RankManager.getDicesFromRank(5));
        Assert.assertEquals("1D10 + 1D6", RankManager.getDicesFromRank(10));
        Assert.assertEquals("1D20 + 1D6", RankManager.getDicesFromRank(15));
        Assert.assertEquals("1D20 + 1D8 + 1D6", RankManager.getDicesFromRank(20));
    }
}
