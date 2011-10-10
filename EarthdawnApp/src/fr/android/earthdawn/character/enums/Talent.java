/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;

/**
 * @author DrMabulle
 *
 */
public class Talent implements Serializable
{
    private static final long serialVersionUID = 155881862161569900L;

    private final Talents talent;
    private final int circle;
    private final boolean isDiscipline;

    public Talent(final Talents aTalent, final int aCircle, final boolean isDiscipline)
    {
        talent = aTalent;
        circle = aCircle;
        this.isDiscipline = isDiscipline;
    }

    public int getCircle()
    {
        return circle;
    }
    public boolean isDiscipline()
    {
        return isDiscipline;
    }

    /**
     * @return the label
     */
    public String getName()
    {
        return talent.getLabel();
    }
    /**
     * @return the attribut
     */
    public Attributs getAttribut()
    {
        return talent.getAttribut();
    }
    /**
     * @return the isAction
     */
    public boolean isAction()
    {
        return talent.isAction();
    }
    /**
     * @return the isKarmaMandatory
     */
    public boolean isKarmaMandatory()
    {
        return talent.isKarmaMandatory();
    }
    /**
     * @return the isRollable
     */
    public boolean isRollable()
    {
        return talent.isRollable();
    }
    /**
     * @return the page
     */
    public int getPage()
    {
        return talent.getPage();
    }
    /**
     * @return the effort
     */
    public int getEffort()
    {
        return talent.getEffort();
    }

    public boolean isSameTalentAs(final Talents talent)
    {
        return this.talent.equals(talent);
    }
}
