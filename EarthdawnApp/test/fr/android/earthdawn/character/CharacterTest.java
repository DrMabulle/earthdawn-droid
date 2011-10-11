package fr.android.earthdawn.character;

import junit.framework.Assert;

import org.junit.Test;

import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;

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
    public void testGetTalentRank()
    {
        obsidien.setMainDiscipline(Disciplines.Guerrier, 6);
        final Discipline discipline = obsidien.getMainDiscipline();
        final Talent armesMelee = discipline.findTalent(Talents.ArmesMelee);
        final Talent longevite = discipline.findTalent(Talents.Endurance);

        discipline.setTalentRank(armesMelee, 7);
        discipline.setTalentRank(longevite, 5);

        Assert.assertEquals(7, obsidien.getTalentRank(armesMelee, discipline));
        Assert.assertEquals(5, obsidien.getTalentRank(longevite, discipline));

        // increment
        obsidien.incrementTalentRank(armesMelee, discipline);

        Assert.assertEquals(8, obsidien.getTalentRank(armesMelee, discipline));
        Assert.assertEquals(5, obsidien.getTalentRank(longevite, discipline));
    }

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
    public void testGetMouvement()
    {
        Assert.assertEquals(40, elfe.getCombatMouvement());
        Assert.assertEquals(80, elfe.getRunningMouvement());
        Assert.assertEquals(34, humain.getCombatMouvement());
        Assert.assertEquals(68, humain.getRunningMouvement());
        Assert.assertEquals(30, nain.getCombatMouvement());
        Assert.assertEquals(60, nain.getRunningMouvement());
        Assert.assertEquals(24, obsidien.getCombatMouvement());
        Assert.assertEquals(48, obsidien.getRunningMouvement());
        Assert.assertEquals(36, ork.getCombatMouvement());
        Assert.assertEquals(72, ork.getRunningMouvement());
        Assert.assertEquals(40, sylphe.getCombatMouvement());
        Assert.assertEquals(80, sylphe.getRunningMouvement());
        Assert.assertEquals(34, troll.getCombatMouvement());
        Assert.assertEquals(68, troll.getRunningMouvement());
        Assert.assertEquals(36, tskrang.getCombatMouvement());
        Assert.assertEquals(72, tskrang.getRunningMouvement());
    }

    @Test
    public void testGetTransportCapacity()
    {
        Assert.assertEquals(140, elfe.getLiftingCapacity());
        Assert.assertEquals(70, elfe.getCarryingCapacity());
        Assert.assertEquals(140, humain.getLiftingCapacity());
        Assert.assertEquals(70, humain.getCarryingCapacity());
        Assert.assertEquals(180, nain.getLiftingCapacity());
        Assert.assertEquals(90, nain.getCarryingCapacity());
        Assert.assertEquals(290, obsidien.getLiftingCapacity());
        Assert.assertEquals(145, obsidien.getCarryingCapacity());
        Assert.assertEquals(200, ork.getLiftingCapacity());
        Assert.assertEquals(100, ork.getCarryingCapacity());
        Assert.assertEquals(40, sylphe.getLiftingCapacity());
        Assert.assertEquals(20, sylphe.getCarryingCapacity());
        Assert.assertEquals(230, troll.getLiftingCapacity());
        Assert.assertEquals(115, troll.getCarryingCapacity());
        Assert.assertEquals(140, tskrang.getLiftingCapacity());
        Assert.assertEquals(70, tskrang.getCarryingCapacity());
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

    @Test
    public void testComputeCombatMouvement()
    {
        Assert.assertEquals(6, Character.computeCombatMouvement(1));
        Assert.assertEquals(7, Character.computeCombatMouvement(2));
        Assert.assertEquals(8, Character.computeCombatMouvement(3));
        Assert.assertEquals(9, Character.computeCombatMouvement(4));
        Assert.assertEquals(10, Character.computeCombatMouvement(5));
        Assert.assertEquals(12, Character.computeCombatMouvement(6));
        Assert.assertEquals(14, Character.computeCombatMouvement(7));
        Assert.assertEquals(24, Character.computeCombatMouvement(12));
        Assert.assertEquals(34, Character.computeCombatMouvement(17));
        Assert.assertEquals(38, Character.computeCombatMouvement(19));
        Assert.assertEquals(40, Character.computeCombatMouvement(20));
        Assert.assertEquals(43, Character.computeCombatMouvement(21));
        Assert.assertEquals(46, Character.computeCombatMouvement(22));
        Assert.assertEquals(61, Character.computeCombatMouvement(27));
        Assert.assertEquals(64, Character.computeCombatMouvement(28));
        Assert.assertEquals(67, Character.computeCombatMouvement(29));
        Assert.assertEquals(70, Character.computeCombatMouvement(30));
    }

    @Test
    public void testComputeRunningMouvement()
    {
        Assert.assertEquals(12, Character.computeRunningMouvement(1));
        Assert.assertEquals(14, Character.computeRunningMouvement(2));
        Assert.assertEquals(16, Character.computeRunningMouvement(3));
        Assert.assertEquals(18, Character.computeRunningMouvement(4));
        Assert.assertEquals(20, Character.computeRunningMouvement(5));
        Assert.assertEquals(24, Character.computeRunningMouvement(6));
        Assert.assertEquals(28, Character.computeRunningMouvement(7));
        Assert.assertEquals(48, Character.computeRunningMouvement(12));
        Assert.assertEquals(68, Character.computeRunningMouvement(17));
        Assert.assertEquals(76, Character.computeRunningMouvement(19));
        Assert.assertEquals(80, Character.computeRunningMouvement(20));
        Assert.assertEquals(86, Character.computeRunningMouvement(21));
        Assert.assertEquals(92, Character.computeRunningMouvement(22));
        Assert.assertEquals(122, Character.computeRunningMouvement(27));
        Assert.assertEquals(128, Character.computeRunningMouvement(28));
        Assert.assertEquals(134, Character.computeRunningMouvement(29));
        Assert.assertEquals(140, Character.computeRunningMouvement(30));
    }

    @Test
    public void testComputeLiftingCapacity()
    {
        Assert.assertEquals(5, Character.computeLiftingCapacity(1));
        Assert.assertEquals(15, Character.computeLiftingCapacity(3));
        Assert.assertEquals(30, Character.computeLiftingCapacity(6));
        Assert.assertEquals(40, Character.computeLiftingCapacity(7));
        Assert.assertEquals(80, Character.computeLiftingCapacity(11));
        Assert.assertEquals(95, Character.computeLiftingCapacity(12));
        Assert.assertEquals(140, Character.computeLiftingCapacity(15));
        Assert.assertEquals(160, Character.computeLiftingCapacity(16));
        Assert.assertEquals(200, Character.computeLiftingCapacity(18));
        Assert.assertEquals(230, Character.computeLiftingCapacity(19));
        Assert.assertEquals(290, Character.computeLiftingCapacity(21));
        Assert.assertEquals(330, Character.computeLiftingCapacity(22));
        Assert.assertEquals(410, Character.computeLiftingCapacity(24));
        Assert.assertEquals(460, Character.computeLiftingCapacity(25));
        Assert.assertEquals(560, Character.computeLiftingCapacity(27));
        Assert.assertEquals(620, Character.computeLiftingCapacity(28));
        Assert.assertEquals(740, Character.computeLiftingCapacity(30));
    }

    @Test
    public void testComputeCarryingCapacity()
    {
        Assert.assertEquals(3, Character.computeCarryingCapacity(1));
        Assert.assertEquals(8, Character.computeCarryingCapacity(3));
        Assert.assertEquals(15, Character.computeCarryingCapacity(6));
        Assert.assertEquals(20, Character.computeCarryingCapacity(7));
        Assert.assertEquals(40, Character.computeCarryingCapacity(11));
        Assert.assertEquals(48, Character.computeCarryingCapacity(12));
        Assert.assertEquals(70, Character.computeCarryingCapacity(15));
        Assert.assertEquals(80, Character.computeCarryingCapacity(16));
        Assert.assertEquals(100, Character.computeCarryingCapacity(18));
        Assert.assertEquals(115, Character.computeCarryingCapacity(19));
        Assert.assertEquals(145, Character.computeCarryingCapacity(21));
        Assert.assertEquals(165, Character.computeCarryingCapacity(22));
        Assert.assertEquals(205, Character.computeCarryingCapacity(24));
        Assert.assertEquals(230, Character.computeCarryingCapacity(25));
        Assert.assertEquals(280, Character.computeCarryingCapacity(27));
        Assert.assertEquals(310, Character.computeCarryingCapacity(28));
        Assert.assertEquals(370, Character.computeCarryingCapacity(30));
    }

    @Test
    public void testCheckCircle()
    {
        // Valeurs accept�es
        Assert.assertTrue(Character.checkCircle(1));
        Assert.assertTrue(Character.checkCircle(5));
        Assert.assertTrue(Character.checkCircle(9));
        Assert.assertTrue(Character.checkCircle(13));
        Assert.assertTrue(Character.checkCircle(15));
        // Valeurs n�gatives
        Assert.assertFalse(Character.checkCircle(-1));
        Assert.assertFalse(Character.checkCircle(-5));
        Assert.assertFalse(Character.checkCircle(-9));
        Assert.assertFalse(Character.checkCircle(-13));
        Assert.assertFalse(Character.checkCircle(-15));
        // Valeurs trop grandes ou trop petites
        Assert.assertFalse(Character.checkCircle(0));
        Assert.assertFalse(Character.checkCircle(16));
        Assert.assertFalse(Character.checkCircle(22));
    }

    @Test
    public void testCheckCircles()
    {
        // Valeurs accept�es
        Assert.assertTrue(Character.checkCircles(6, 3));
        Assert.assertTrue(Character.checkCircles(9, 6));
        Assert.assertTrue(Character.checkCircles(10, 10));
        Assert.assertTrue(Character.checkCircles(15, 1));
        Assert.assertTrue(Character.checkCircles(2, 1));
        // Valeurs n�gatives
        Assert.assertFalse(Character.checkCircles(-1, 3));
        Assert.assertFalse(Character.checkCircles(5, -2));
        Assert.assertFalse(Character.checkCircles(-9, 4));
        Assert.assertFalse(Character.checkCircles(6, -13));
        Assert.assertFalse(Character.checkCircles(-15, 10));
        // Valeurs trop grandes ou trop petites
        Assert.assertFalse(Character.checkCircles(0, 2));
        Assert.assertFalse(Character.checkCircles(2, 0));
        Assert.assertFalse(Character.checkCircles(15, 16));
        Assert.assertFalse(Character.checkCircles(16, 15));
    }


}
