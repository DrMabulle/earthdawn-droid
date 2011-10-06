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
    private final int indice;
    private final int evol;

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

    public int getRank()
    {
        return (int) (Math.ceil((indice + evol) / 3) + 1);
    }
}
