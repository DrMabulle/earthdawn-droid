package fr.android.earthdawn.character;

import junit.framework.Assert;

import org.junit.Test;

import fr.android.earthdawn.character.enums.Races;

public class CharacterTest
{

    Character elfe =             new Character("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);
    Character humain =       new Character("humain", "Mâle", 120, 225, 421, Races.Humain, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);
    Character nain =             new Character("nain", "Mâle", 120, 225, 421, Races.Nain, 17, 0, 15, 0, 13, 0, 12, 0, 11, 0, 8, 0);
    Character obsidien = new Character("obsidien", "Mâle", 120, 225, 421, Races.Obsidien, 17, 0, 15, 0, 13, 0, 12, 0, 11, 0, 8, 0);
    Character ork =                new Character("ork", "Mâle", 120, 225, 421, Races.Ork, 17, 0, 15, 0, 13, 0, 10, 0, 11, 0, 8, 0);
    Character sylphe = new Character("sylphelin", "Mâle", 120, 225, 421, Races.Sylphelin, 17, 0, 11, 0, 13, 0, 14, 0, 11, 0, 12, 0);
    Character troll =          new Character("troll", "Mâle", 120, 225, 421, Races.Troll, 17, 0, 15, 0, 13, 0, 10, 0, 11, 0, 8, 0);
    Character tskrang =    new Character("tskrang", "Mâle", 120, 225, 421, Races.Tskrang, 17, 0, 15, 0, 13, 0, 10, 0, 11, 0, 8, 0);

    @Test
    public void testGetPhysicalDefense()
    {
        Assert.assertEquals(10, elfe.getPhysicalDefense());
        Assert.assertEquals(9, humain.getPhysicalDefense());
        Assert.assertEquals(9, nain.getPhysicalDefense());
        Assert.assertEquals(8, obsidien.getPhysicalDefense());
        Assert.assertEquals(9, ork.getPhysicalDefense());
        Assert.assertEquals(13, sylphe.getPhysicalDefense());
        Assert.assertEquals(9, troll.getPhysicalDefense());
        Assert.assertEquals(10, tskrang.getPhysicalDefense());
    }
    @Test
    public void testGetMagicalDefense()
    {
        Assert.assertEquals(8, elfe.getMagicalDefense());
        Assert.assertEquals(7, humain.getMagicalDefense());
        Assert.assertEquals(7, nain.getMagicalDefense());
        Assert.assertEquals(7, obsidien.getMagicalDefense());
        Assert.assertEquals(6, ork.getMagicalDefense());
        Assert.assertEquals(8, sylphe.getMagicalDefense());
        Assert.assertEquals(6, troll.getMagicalDefense());
        Assert.assertEquals(6, tskrang.getMagicalDefense());
    }
    @Test
    public void testGetSocialDefense()
    {
        Assert.assertEquals(6, elfe.getSocialDefense());
        Assert.assertEquals(5, humain.getSocialDefense());
        Assert.assertEquals(4, nain.getSocialDefense());
        Assert.assertEquals(5, obsidien.getSocialDefense());
        Assert.assertEquals(5, ork.getSocialDefense());
        Assert.assertEquals(8, sylphe.getSocialDefense());
        Assert.assertEquals(5, troll.getSocialDefense());
        Assert.assertEquals(6, tskrang.getSocialDefense());
    }
    @Test
    public void testGetMysticArmor()
    {
        Assert.assertEquals(1, elfe.getMysticArmor());
        Assert.assertEquals(1, humain.getMysticArmor());
        Assert.assertEquals(1, nain.getMysticArmor());
        Assert.assertEquals(1, obsidien.getMysticArmor());
        Assert.assertEquals(0, ork.getMysticArmor());
        Assert.assertEquals(1, sylphe.getMysticArmor());
        Assert.assertEquals(1, troll.getMysticArmor());
        Assert.assertEquals(1, tskrang.getMysticArmor());
    }

    @Test
    public void testGetDeathThreshold()
    {
        Assert.assertEquals(32, elfe.getDeathThreshold());
        Assert.assertEquals(35, humain.getDeathThreshold());
        Assert.assertEquals(39, nain.getDeathThreshold());
        Assert.assertEquals(40, obsidien.getDeathThreshold());
        Assert.assertEquals(36, ork.getDeathThreshold());
        Assert.assertEquals(31, sylphe.getDeathThreshold());
        Assert.assertEquals(38, troll.getDeathThreshold());
        Assert.assertEquals(36, tskrang.getDeathThreshold());
    }

    @Test
    public void testGetUnconsciousnessThreshold()
    {
        Assert.assertEquals(24, elfe.getUnconsciousnessThreshold());
        Assert.assertEquals(27, humain.getUnconsciousnessThreshold());
        Assert.assertEquals(31, nain.getUnconsciousnessThreshold());
        Assert.assertEquals(32, obsidien.getUnconsciousnessThreshold());
        Assert.assertEquals(28, ork.getUnconsciousnessThreshold());
        Assert.assertEquals(22, sylphe.getUnconsciousnessThreshold());
        Assert.assertEquals(30, troll.getUnconsciousnessThreshold());
        Assert.assertEquals(28, tskrang.getUnconsciousnessThreshold());
    }

    @Test
    public void testGetWoundThreshold()
    {
        Assert.assertEquals(8, elfe.getWoundThreshold());
        Assert.assertEquals(9, humain.getWoundThreshold());
        Assert.assertEquals(11, nain.getWoundThreshold());
        Assert.assertEquals(14, obsidien.getWoundThreshold());
        Assert.assertEquals(10, ork.getWoundThreshold());
        Assert.assertEquals(8, sylphe.getWoundThreshold());
        Assert.assertEquals(10, troll.getWoundThreshold());
        Assert.assertEquals(10, tskrang.getWoundThreshold());
    }

    @Test
    public void testComputeDeathThreshold()
    {
        Assert.assertEquals(19, Character.computeDeathThreshold(1));
        Assert.assertEquals(20, Character.computeDeathThreshold(2));
        Assert.assertEquals(22, Character.computeDeathThreshold(3));
        Assert.assertEquals(23, Character.computeDeathThreshold(4));
        Assert.assertEquals(34, Character.computeDeathThreshold(12));
        Assert.assertEquals(35, Character.computeDeathThreshold(13));
        Assert.assertEquals(36, Character.computeDeathThreshold(14));
        Assert.assertEquals(42, Character.computeDeathThreshold(18));
        Assert.assertEquals(43, Character.computeDeathThreshold(19));
        Assert.assertEquals(44, Character.computeDeathThreshold(20));
        Assert.assertEquals(55, Character.computeDeathThreshold(28));
        Assert.assertEquals(56, Character.computeDeathThreshold(29));
        Assert.assertEquals(58, Character.computeDeathThreshold(30));
    }

    @Test
    public void testComputeUncounciousnessThreshold()
    {
        Assert.assertEquals(10, Character.computeUnconsciousnessThreshold(1));
        Assert.assertEquals(11, Character.computeUnconsciousnessThreshold(2));
        Assert.assertEquals(13, Character.computeUnconsciousnessThreshold(3));
        Assert.assertEquals(14, Character.computeUnconsciousnessThreshold(4));
        Assert.assertEquals(21, Character.computeUnconsciousnessThreshold(9));
        Assert.assertEquals(22, Character.computeUnconsciousnessThreshold(10));
        Assert.assertEquals(24, Character.computeUnconsciousnessThreshold(11));
        Assert.assertEquals(26, Character.computeUnconsciousnessThreshold(12));
        Assert.assertEquals(27, Character.computeUnconsciousnessThreshold(13));
        Assert.assertEquals(28, Character.computeUnconsciousnessThreshold(14));
        Assert.assertEquals(34, Character.computeUnconsciousnessThreshold(18));
        Assert.assertEquals(35, Character.computeUnconsciousnessThreshold(19));
        Assert.assertEquals(36, Character.computeUnconsciousnessThreshold(20));
        Assert.assertEquals(39, Character.computeUnconsciousnessThreshold(21));
        Assert.assertEquals(40, Character.computeUnconsciousnessThreshold(22));
        Assert.assertEquals(48, Character.computeUnconsciousnessThreshold(28));
        Assert.assertEquals(49, Character.computeUnconsciousnessThreshold(29));
        Assert.assertEquals(51, Character.computeUnconsciousnessThreshold(30));
    }


    @Test
    public void testComputeWoundThreshold()
    {
        Assert.assertEquals(3, Character.computeWoundThreshold(1));
        Assert.assertEquals(4, Character.computeWoundThreshold(2));
        Assert.assertEquals(4, Character.computeWoundThreshold(3));
        Assert.assertEquals(5, Character.computeWoundThreshold(4));
        Assert.assertEquals(5, Character.computeWoundThreshold(5));
        Assert.assertEquals(6, Character.computeWoundThreshold(6));
        Assert.assertEquals(6, Character.computeWoundThreshold(7));
        Assert.assertEquals(7, Character.computeWoundThreshold(9));
        Assert.assertEquals(8, Character.computeWoundThreshold(10));
        Assert.assertEquals(8, Character.computeWoundThreshold(11));
        Assert.assertEquals(9, Character.computeWoundThreshold(12));
        Assert.assertEquals(12, Character.computeWoundThreshold(18));
        Assert.assertEquals(12, Character.computeWoundThreshold(19));
        Assert.assertEquals(13, Character.computeWoundThreshold(20));
        Assert.assertEquals(13, Character.computeWoundThreshold(21));
        Assert.assertEquals(13, Character.computeWoundThreshold(22));
        Assert.assertEquals(14, Character.computeWoundThreshold(23));
        Assert.assertEquals(14, Character.computeWoundThreshold(24));
        Assert.assertEquals(15, Character.computeWoundThreshold(25));
        Assert.assertEquals(15, Character.computeWoundThreshold(26));
        Assert.assertEquals(15, Character.computeWoundThreshold(27));
        Assert.assertEquals(16, Character.computeWoundThreshold(28));
        Assert.assertEquals(16, Character.computeWoundThreshold(29));
        Assert.assertEquals(17, Character.computeWoundThreshold(30));
    }

    @Test
    public void testComputeIndiceDefense()
    {
        Assert.assertEquals(2, Character.computeIndiceDefense(1));
        Assert.assertEquals(3, Character.computeIndiceDefense(2));
        Assert.assertEquals(3, Character.computeIndiceDefense(3));
        Assert.assertEquals(4, Character.computeIndiceDefense(4));
        Assert.assertEquals(4, Character.computeIndiceDefense(5));
        Assert.assertEquals(4, Character.computeIndiceDefense(6));
        Assert.assertEquals(5, Character.computeIndiceDefense(7));
        Assert.assertEquals(5, Character.computeIndiceDefense(8));
        Assert.assertEquals(6, Character.computeIndiceDefense(9));
        Assert.assertEquals(6, Character.computeIndiceDefense(10));
        Assert.assertEquals(7, Character.computeIndiceDefense(11));
        Assert.assertEquals(7, Character.computeIndiceDefense(12));
        Assert.assertEquals(7, Character.computeIndiceDefense(13));
        Assert.assertEquals(9, Character.computeIndiceDefense(17));
        Assert.assertEquals(10, Character.computeIndiceDefense(18));
        Assert.assertEquals(10, Character.computeIndiceDefense(19));
        Assert.assertEquals(10, Character.computeIndiceDefense(20));
        Assert.assertEquals(11, Character.computeIndiceDefense(21));
        Assert.assertEquals(12, Character.computeIndiceDefense(23));
        Assert.assertEquals(13, Character.computeIndiceDefense(27));
        Assert.assertEquals(14, Character.computeIndiceDefense(28));
        Assert.assertEquals(14, Character.computeIndiceDefense(29));
        Assert.assertEquals(15, Character.computeIndiceDefense(30));
    }

    @Test
    public void testComputeMysticArmor()
    {
        Assert.assertEquals(0, Character.computeMysticArmor(1));
        Assert.assertEquals(0, Character.computeMysticArmor(5));
        Assert.assertEquals(0, Character.computeMysticArmor(10));
        Assert.assertEquals(1, Character.computeMysticArmor(11));
        Assert.assertEquals(1, Character.computeMysticArmor(12));
        Assert.assertEquals(1, Character.computeMysticArmor(13));
        Assert.assertEquals(2, Character.computeMysticArmor(14));
        Assert.assertEquals(2, Character.computeMysticArmor(15));
        Assert.assertEquals(2, Character.computeMysticArmor(16));
        Assert.assertEquals(6, Character.computeMysticArmor(27));
        Assert.assertEquals(6, Character.computeMysticArmor(28));
        Assert.assertEquals(7, Character.computeMysticArmor(29));
        Assert.assertEquals(7, Character.computeMysticArmor(30));
    }

}
