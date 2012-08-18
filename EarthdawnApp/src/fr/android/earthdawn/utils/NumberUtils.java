/**
 *
 */
package fr.android.earthdawn.utils;


/**
 * @author DrMabulle
 *
 */
public final class NumberUtils
{
    private NumberUtils() {};

    /**
     * Formats numbers for better display.
     * For example, it removes ".0" if present.
     * @param aDouble a double to be formatted
     * @return representation of the double as String, ready for display
     */
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
