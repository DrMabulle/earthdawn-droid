/**
 *
 */
package fr.android.earthdawn.utils;

/**
 * @author Bubulle
 *
 */
public final class NumberUtils
{
    private NumberUtils() {};

    public static final String format(final double aDouble)
    {
        String builder = Double.toString(aDouble);
        if (builder.endsWith(".0"))
        {
            builder = builder.substring(0, builder.length() - 2);
        }
        return builder;
    }

    public static final int ensureMinimum(final int value, final int min)
    {
        return Math.max(value, min);
    }
}
