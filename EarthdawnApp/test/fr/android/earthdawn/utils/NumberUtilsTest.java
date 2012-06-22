package fr.android.earthdawn.utils;

import junit.framework.Assert;

import org.junit.Test;

public class NumberUtilsTest
{
    @Test
    public void testFormatNumber()
    {
        Assert.assertEquals("0.25", NumberUtils.format(0.25));
        Assert.assertEquals("0.333", NumberUtils.format(0.333));
        Assert.assertEquals("1", NumberUtils.format(1.0));
        Assert.assertEquals("40", NumberUtils.format(40.0));
        Assert.assertEquals("32", NumberUtils.format(32));
    }

    @Test
    public void testEnsureMinimum()
    {
        Assert.assertEquals(5, NumberUtils.ensureMinimum(5, 1));
        Assert.assertEquals(1, NumberUtils.ensureMinimum(-5, 1));
        Assert.assertEquals(2, NumberUtils.ensureMinimum(2, 1));
        Assert.assertEquals(1, NumberUtils.ensureMinimum(0, 1));
        Assert.assertEquals(32, NumberUtils.ensureMinimum(32, 1));
    }
}
