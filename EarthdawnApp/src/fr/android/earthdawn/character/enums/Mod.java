/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;

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
     * @param pointcut
     * @param modificator
     * @param otherInfos
     */
    public Mod(final Pointcuts pointcut, final double modificator, final Object... additionnalInfos)
    {
        super();
        this.pointcut = pointcut;
        this.modificator = modificator;
        this.otherInfos = additionnalInfos;
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
        final StringBuilder builder = new StringBuilder();
        builder.append(pointcut);
        if (Pointcuts.TALENT.equals(pointcut) || Pointcuts.ATTRIBUT.equals(pointcut))
        {
            builder.append('(').append(otherInfos[0]).append(')');
        }
        builder.append(" : ");
        if (modificator > 0)
        {
            builder.append('+');
        }
        builder.append(NumberUtils.format(modificator));
        return builder.toString();
    }



}
