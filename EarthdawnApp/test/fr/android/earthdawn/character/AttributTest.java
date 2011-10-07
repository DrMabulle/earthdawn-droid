/**
 *
 */
package fr.android.earthdawn.character;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author PBKR03831
 *
 */
public class AttributTest
{

    /**
     * Test method for {@link fr.android.earthdawn.character.Attribut#getResultingIndice()}.
     */
    @Test
    public void testGetResultingIndice()
    {
        final Attribut attribut = new Attribut(15, 1);
        Assert.assertEquals(16, attribut.getResultingIndice());
    }

    /**
     * Test method for {@link fr.android.earthdawn.character.Attribut#getRank()}.
     */
    @Test
    public void testGetRank()
    {
        // Indice 1 - rank 2
        Attribut attribut = new Attribut(1, 0);
        Assert.assertEquals(2, attribut.getRank());
        // Indice 2 - rank 2
        attribut.incrementIndice();
        Assert.assertEquals(2, attribut.getRank());
        // Indice 3 - rank 2
        attribut.incrementIndice();
        Assert.assertEquals(2, attribut.getRank());
        // Indice 4 - rank 3
        attribut.incrementIndice();
        Assert.assertEquals(3, attribut.getRank());

        // Indice 12 - rank 5
        attribut = new Attribut(12, 0);
        Assert.assertEquals(5, attribut.getRank());
        // Indice 13 - rank 6
        attribut.incrementIndice();
        Assert.assertEquals(6, attribut.getRank());
        // Indice 14 - rank 6
        attribut.incrementEvol();
        Assert.assertEquals(6, attribut.getRank());
        // Indice 15 - rank 6
        attribut.incrementIndice();
        Assert.assertEquals(6, attribut.getRank());
        // Indice 16 - rank 7
        attribut.incrementIndice();
        Assert.assertEquals(7, attribut.getRank());

        // Indice 27 - rank 10
        attribut = new Attribut(27, 0);
        Assert.assertEquals(10, attribut.getRank());
        // Indice 28 - rank 11
        attribut.incrementIndice();
        Assert.assertEquals(11, attribut.getRank());
        // Indice 29 - rank 11
        attribut.incrementEvol();
        Assert.assertEquals(11, attribut.getRank());
        // Indice 30 - rank 11
        attribut.incrementIndice();
        Assert.assertEquals(11, attribut.getRank());
    }

}
