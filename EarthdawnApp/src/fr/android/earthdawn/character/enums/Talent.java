/**
 * 
 */
package fr.android.earthdawn.character.enums;

/**
 * @author DrMabulle
 *
 */
public class Talent
{
    private final Talents talent;
    private final int circle;

    public Talent(final Talents aTalent, final int aCircle)
    {
        talent = aTalent;
        circle = aCircle;
    }

    public Talents getTalent()
    {
        return talent;
    }
    public int getCircle()
    {
        return circle;
    }
}
