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

    private String label;
    private Attributs attribut;
    private boolean isAction;
    private int strain = 0;
    private int rank = 1;


    /**
     * @param label
     * @param attribut
     * @param isAction
     * @param strain
     */
    public Skill(final String label, final Attributs attribut, final boolean isAction, final int strain)
    {
        super();
        this.label = label;
        this.attribut = attribut;
        this.isAction = isAction;
        this.strain = strain;
    }


    /**
     * @return the attribut
     */
    public Attributs getAttribut()
    {
        return attribut;
    }

    /**
     * @param attribut the attribut to set
     */
    public void setAttribut(final Attributs attribut)
    {
        this.attribut = attribut;
    }

    /**
     * @return the label
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(final String label)
    {
        this.label = label;
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
        return isAction;
    }

    /**
     * @param isAction the isAction to set
     */
    public void setAction(final boolean isAction)
    {
        this.isAction = isAction;
    }

    /**
     * @return the strain
     */
    public int getStrain()
    {
        return strain;
    }

    /**
     * @param strain the strain to set
     */
    public void setStrain(final int strain)
    {
        this.strain = strain;
    }
}
