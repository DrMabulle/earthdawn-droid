/**
 *
 */
package fr.android.earthdawn.character;

import java.io.Serializable;

/**
 * @author DrMabulle
 *
 */
public class Attribute implements Serializable
{
    private static final long serialVersionUID = 3752637140824061324L;

    private int indice;
    private int evol;

    /**
     * Constructor
     * @param aIndice base level (indice)
     * @param evol number of bought evolutions
     */
    public Attribute(final int aIndice, final int aEvol)
    {
        super();
        this.indice = aIndice;
        this.evol = aEvol;
    }

    /**
     * Computes resulting level (indice) of the attribute
     * @return  resulting level (indice) of the attribute
     */
    public int getResultingIndice()
    {
        return indice + evol;
    }

    /**
     * Increments base level (indice)
     */
    public void incrementIndice()
    {
        indice++;
    }
    /**
     * Increments number of evolutions bought
     */
    public void incrementEvol()
    {
        evol++;
    }
    /**
     * @return the evol
     */
    public int getEvol()
    {
        return evol;
    }
}
