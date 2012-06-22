/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;

import fr.android.earthdawn.character.actions.IAction;
import fr.android.earthdawn.utils.ArrayUtils;

/**
 * @author DrMabulle
 *
 */
public class Talent implements Serializable
{
    private static final long serialVersionUID = 155881862161569900L;

    private final Talents talent;
    private final int circle;
    private final boolean discipline;
    private final Object[] additionnalInfos;

    private final IAction preAction;
    private final IAction postAction;

    public Talent(final Talents aTalent, final int aCircle, final boolean isDiscipline, final IAction aPreAction, final IAction aPostAction, final Object... objects )
    {
        talent = aTalent;
        circle = aCircle;
        this.discipline = isDiscipline;
        this.preAction = aPreAction;
        this.postAction = aPostAction;
        additionnalInfos = (ArrayUtils.isNullOrEmpty(objects)) ? null : objects;
    }

    public int getCircle()
    {
        return circle;
    }
    public boolean isDiscipline()
    {
        return discipline;
    }

    /**
     * @return the label
     */
    public int getName()
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
     * @return the strain
     */
    public int getStrain()
    {
        return talent.getStrain();
    }

    public boolean isSameTalentAs(final Talents aTalent)
    {
        return this.talent.equals(aTalent);
    }

    /**
     * @return the additionnalInfos
     */
    public Object[] getAdditionnalInfos()
    {
        return additionnalInfos;
    }

    public Talents getEnum()
    {
        return talent;
    }

    public void executePreAction(final Object...params)
    {
        if (preAction != null)
        {
            preAction.execute(talent.getLabel(), params);
        }
    }

    public void executePostAction(final Object...params)
    {
        if (postAction != null)
        {
            postAction.execute(talent.getLabel(), params);
        }
    }
}
