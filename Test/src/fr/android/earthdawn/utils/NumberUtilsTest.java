package fr.android.earthdawn.utils;

import junit.framework.TestCase;

public class NumberUtilsTest extends TestCase
{
    public void testFormatNumber()
    {
        assertEquals("0.25", NumberUtils.format(0.25));
        assertEquals("0.333", NumberUtils.format(0.333));
        assertEquals("1", NumberUtils.format(1.0));
        assertEquals("40", NumberUtils.format(40.0));
        assertEquals("32", NumberUtils.format(32));
    }

    public void testEnsureMinimum()
    {
        assertEquals(5, NumberUtils.ensureMinimum(5, 1));
        assertEquals(1, NumberUtils.ensureMinimum(-5, 1));
        assertEquals(2, NumberUtils.ensureMinimum(2, 1));
        assertEquals(1, NumberUtils.ensureMinimum(0, 1));
        assertEquals(32, NumberUtils.ensureMinimum(32, 1));
    }
}
