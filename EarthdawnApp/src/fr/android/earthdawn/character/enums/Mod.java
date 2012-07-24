/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;
import java.util.Map;
import java.util.WeakHashMap;

import fr.android.earthdawn.utils.ArrayUtils;
import fr.android.earthdawn.utils.NumberUtils;

/**
 * @author DrMabulle
 *
 */
public class Mod implements Serializable
{
    private static final long serialVersionUID = -5238367796958138270L;

    private final Pointcuts pointcut;
    private final double modificator;
    private final Object[] otherInfos;
    /**
     * @param aPointcut
     * @param aModificator
     * @param otherInfos
     */
    private Mod(final Pointcuts aPointcut, final double aModificator, final Object... additionnalInfos)
    {
        super();
        this.pointcut = aPointcut;
        this.modificator = aModificator;
        this.otherInfos = ArrayUtils.isNullOrEmpty(additionnalInfos) ? null : additionnalInfos;
    }
    /**
     * @return the pointcut
     */
    public Pointcuts getPointcut()
    {
        return pointcut;
    }
    /**
     * @return the modificator
     */
    public double getModificator()
    {
        return modificator;
    }
    /**
     * @return the otherInfos
     */
    public Object[] getOtherInfos()
    {
        return otherInfos;
    }

    @Override
    public String toString()
    {
        return getKey(pointcut, modificator, otherInfos);
    }
    private static String getKey(final Pointcuts aPointcut, final double modificator, final Object[] additionnalInfos)
    {
        final StringBuilder builder = new StringBuilder(32);

        if (Pointcuts.POWER.equals(aPointcut))
        {
            builder.append(aPointcut);
            builder.append(" : ");
            builder.append(additionnalInfos[0]);
        }
        else if (Pointcuts.KARMA_USE.equals(aPointcut))
        {
            builder.append(aPointcut);
            builder.append('(').append(additionnalInfos[0]).append(')');
        }
        else
        {
            builder.append(aPointcut);
            if (Pointcuts.TALENT.equals(aPointcut) || Pointcuts.ATTRIBUT.equals(aPointcut))
            {
                builder.append('(').append(additionnalInfos[0]).append(')');
            }
            builder.append(" : ");
            if (modificator > 0)
            {
                builder.append('+');
            }
            builder.append(NumberUtils.format(modificator));
        }
        return builder.toString();
    }

    /*
     * Optimize number of instanciations.
     * Indeed, a lot of mods are strickly the same and can not be modified
     */
    private static final Map<String, Mod> factory = new WeakHashMap<String, Mod>();
    public static final Mod get(final Pointcuts pointcut, final double modificator, final Object... additionnalInfos)
    {
        final String key = getKey(pointcut, modificator, additionnalInfos);
        Mod result = factory.get(key);
        if (result == null)
        {
            result = new Mod(pointcut, modificator, additionnalInfos);
            factory.put(key, result);
        }
        return result;
    }
}
