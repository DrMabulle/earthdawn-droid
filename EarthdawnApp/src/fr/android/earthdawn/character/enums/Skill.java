/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;

/**
 * @author DrMabulle
 *
 */
public class Skill implements Serializable
{
    private static final long serialVersionUID = 5893341632241346616L;

    private final String label;
    private final Attributes attribut;
    private final boolean action;
    private int strain = 0;
    private int rank = 1;


    /**
     * @param aLabel
     * @param aAttribut
     * @param isAction
     * @param aStrain
     */
    public Skill(final String aLabel, final Attributes aAttribut, final boolean isAction, final int aStrain)
    {
        super();
        this.label = aLabel;
        this.attribut = aAttribut;
        this.action = isAction;
        this.strain = aStrain;
    }


    /**
     * @return the attribut
     */
    public Attributes getAttribut()
    {
        return attribut;
    }

    /**
     * @return the label
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * @return the rank
     */
    public int getRank()
    {
        return rank;
    }

    /**
     * @return the rank
     */
    public Skill incrementRank()
    {
        rank++;
        return this;
    }

    /**
     * @return the isAction
     */
    public boolean isAction()
    {
        return action;
    }

    /**
     * @return the strain
     */
    public int getStrain()
    {
        return strain;
    }
}
