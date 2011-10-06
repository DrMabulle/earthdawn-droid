package fr.android.earthdawn.character;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class CharacterTest
{

    Character character;
    @Before
    public void setUp() throws Exception
    {
        character = new Character("Malack", "Mâle", 120, 225, 421, Races.obsidien, 17, 1, 15, 1, 13, 1, 13, 1, 11, 0, 8, 0);
    }

    @Test
    public void testGetPhysicalDefense()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testGetDeathCeil()
    {
        Assert.assertEquals(42, character.getDeathCeil());
    }

    @Test
    public void testComputeDeathCeil()
    {
        Assert.assertEquals(19, character.computeDeathCeil(1));
        Assert.assertEquals(20, character.computeDeathCeil(2));
        Assert.assertEquals(22, character.computeDeathCeil(3));
        Assert.assertEquals(23, character.computeDeathCeil(4));
        Assert.assertEquals(34, character.computeDeathCeil(12));
        Assert.assertEquals(35, character.computeDeathCeil(13));
        Assert.assertEquals(36, character.computeDeathCeil(14));
        Assert.assertEquals(42, character.computeDeathCeil(18));
        Assert.assertEquals(43, character.computeDeathCeil(19));
        Assert.assertEquals(44, character.computeDeathCeil(20));
        Assert.assertEquals(55, character.computeDeathCeil(28));
        Assert.assertEquals(56, character.computeDeathCeil(29));
        Assert.assertEquals(58, character.computeDeathCeil(30));
    }

    @Test
    public void testComputeUncounciousnessCeil()
    {
        Assert.assertEquals(10, character.computeUncounciousnessCeil(1));
        Assert.assertEquals(11, character.computeUncounciousnessCeil(2));
        Assert.assertEquals(13, character.computeUncounciousnessCeil(3));
        Assert.assertEquals(14, character.computeUncounciousnessCeil(4));
        Assert.assertEquals(21, character.computeUncounciousnessCeil(9));
        Assert.assertEquals(22, character.computeUncounciousnessCeil(10));
        Assert.assertEquals(24, character.computeUncounciousnessCeil(11));
        Assert.assertEquals(26, character.computeUncounciousnessCeil(12));
        Assert.assertEquals(27, character.computeUncounciousnessCeil(13));
        Assert.assertEquals(28, character.computeUncounciousnessCeil(14));
        Assert.assertEquals(34, character.computeUncounciousnessCeil(18));
        Assert.assertEquals(35, character.computeUncounciousnessCeil(19));
        Assert.assertEquals(36, character.computeUncounciousnessCeil(20));
        Assert.assertEquals(39, character.computeUncounciousnessCeil(21));
        Assert.assertEquals(40, character.computeUncounciousnessCeil(22));
        Assert.assertEquals(48, character.computeUncounciousnessCeil(28));
        Assert.assertEquals(49, character.computeUncounciousnessCeil(29));
        Assert.assertEquals(51, character.computeUncounciousnessCeil(30));
    }


    @Test
    public void testComputeWoundCeil()
    {
        Assert.assertEquals(3, character.computeWoundCeil(1));
        Assert.assertEquals(4, character.computeWoundCeil(2));
        Assert.assertEquals(4, character.computeWoundCeil(3));
        Assert.assertEquals(5, character.computeWoundCeil(4));
        Assert.assertEquals(7, character.computeWoundCeil(9));
        Assert.assertEquals(8, character.computeWoundCeil(10));
        Assert.assertEquals(8, character.computeWoundCeil(11));
        Assert.assertEquals(9, character.computeWoundCeil(12));
        Assert.assertEquals(12, character.computeWoundCeil(18));
        Assert.assertEquals(12, character.computeWoundCeil(19));
        Assert.assertEquals(13, character.computeWoundCeil(20));
        Assert.assertEquals(13, character.computeWoundCeil(21));
        Assert.assertEquals(13, character.computeWoundCeil(22));
        Assert.assertEquals(15, character.computeWoundCeil(25));
        Assert.assertEquals(15, character.computeWoundCeil(27));
        Assert.assertEquals(16, character.computeWoundCeil(28));
        Assert.assertEquals(16, character.computeWoundCeil(29));
        Assert.assertEquals(17, character.computeWoundCeil(30));
    }

}
