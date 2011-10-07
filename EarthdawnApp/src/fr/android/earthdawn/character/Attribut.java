/**
 *
 */
package fr.android.earthdawn.character;

/**
 * @author DrMabulle
 *
 */
public class Attribut
{
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

    public int getRank()
    {
        return (int) (Math.ceil((indice + evol) / 3.0) + 1);
    }
}
