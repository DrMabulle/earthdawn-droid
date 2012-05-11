/**
 *
 */
package fr.android.earthdawn.character;

import java.io.Serializable;

/**
 * @author DrMabulle
 *
 */
public class Attribut implements Serializable
{
    private static final long serialVersionUID = 3752637140824061324L;

    private int indice;
    private int evol;

    /**
     * @param indice indice de base
     * @param evol nombre d'évolutions
     */
    public Attribut(final int indice, final int evol)
    {
        super();
        this.indice = indice;
        this.evol = evol;
    }

    public int getResultingIndice()
    {
        return indice + evol;
    }

    public void incrementIndice()
    {
        indice++;
    }
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
