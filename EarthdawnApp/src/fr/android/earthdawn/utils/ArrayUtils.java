package fr.android.earthdawn.utils;

/**
 * @author DrMabulle
 *
 */
public final class ArrayUtils
{
    /**
     * Checks whether the given array of Objects is null or empty.
     * @param objects the array of Objects to test
     * @return true if the given array of Objects is null or empty.
     */
    public static final boolean isNullOrEmpty(final Object[] objects)
    {
        return objects == null || objects.length == 0;
    }
}
