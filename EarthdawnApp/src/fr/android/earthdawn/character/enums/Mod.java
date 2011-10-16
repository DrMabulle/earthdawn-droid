/**
 *
 */
package fr.android.earthdawn.character.enums;

/**
 * @author DrMabulle
 *
 */
public class Mod
{
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



}
