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

}
