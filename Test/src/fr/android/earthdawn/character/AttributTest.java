/**
 *
 */
package fr.android.earthdawn.character;

import junit.framework.TestCase;
import fr.android.earthdawn.managers.RankManager;

/**
 * @author DrMabulle
 *
 */
public class AttributTest extends TestCase
{
    public void testGetResultingIndice()
    {
        final Attribute attribut = new Attribute(15, 1);
        assertEquals(16, attribut.getResultingIndice());
    }

    public void testGetRank()
    {
        // Indice 1 - rank 2
        Attribute attribut = new Attribute(1, 0);
        assertEquals(2, RankManager.getRank(attribut.getResultingIndice()));
        // Indice 2 - rank 2
        attribut.incrementIndice();
        assertEquals(2, RankManager.getRank(attribut.getResultingIndice()));
        // Indice 3 - rank 2
        attribut.incrementIndice();
        assertEquals(2, RankManager.getRank(attribut.getResultingIndice()));
        // Indice 4 - rank 3
        attribut.incrementIndice();
        assertEquals(3, RankManager.getRank(attribut.getResultingIndice()));

        // Indice 12 - rank 5
        attribut = new Attribute(12, 0);
        assertEquals(5, RankManager.getRank(attribut.getResultingIndice()));
        // Indice 13 - rank 6
        attribut.incrementIndice();
        assertEquals(6, RankManager.getRank(attribut.getResultingIndice()));
        // Indice 14 - rank 6
        attribut.incrementEvol();
        assertEquals(6, RankManager.getRank(attribut.getResultingIndice()));
        // Indice 15 - rank 6
        attribut.incrementIndice();
        assertEquals(6, RankManager.getRank(attribut.getResultingIndice()));
        // Indice 16 - rank 7
        attribut.incrementIndice();
        assertEquals(7, RankManager.getRank(attribut.getResultingIndice()));

        // Indice 27 - rank 10
        attribut = new Attribute(27, 0);
        assertEquals(10, RankManager.getRank(attribut.getResultingIndice()));
        // Indice 28 - rank 11
        attribut.incrementIndice();
        assertEquals(11, RankManager.getRank(attribut.getResultingIndice()));
        // Indice 29 - rank 11
        attribut.incrementEvol();
        assertEquals(11, RankManager.getRank(attribut.getResultingIndice()));
        // Indice 30 - rank 11
        attribut.incrementIndice();
        assertEquals(11, RankManager.getRank(attribut.getResultingIndice()));
    }
}
