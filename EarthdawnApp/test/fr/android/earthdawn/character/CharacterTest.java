package fr.android.earthdawn.character;

import junit.framework.Assert;

import org.junit.Test;

import fr.android.earthdawn.R;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.utils.CharacterUtils;

public class CharacterTest
{

    EDCharacter elfe =             new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);
    EDCharacter humain =       new EDCharacter("humain", "Mâle", 120, 225, 421, Races.Humain, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);
    EDCharacter nain =             new EDCharacter("nain", "Mâle", 120, 225, 421, Races.Nain, 17, 0, 15, 0, 13, 0, 12, 0, 11, 0, 8, 0);
    EDCharacter obsidien = new EDCharacter("obsidien", "Mâle", 120, 225, 421, Races.Obsidien, 17, 0, 15, 0, 13, 0, 12, 0, 11, 0, 8, 0);
    EDCharacter ork =                new EDCharacter("ork", "Mâle", 120, 225, 421, Races.Ork, 17, 0, 15, 0, 13, 0, 10, 0, 11, 0, 8, 0);
    EDCharacter sylphe = new EDCharacter("sylphelin", "Mâle", 120, 225, 421, Races.Sylphelin, 17, 0, 11, 0, 13, 0, 14, 0, 11, 0, 12, 0);
    EDCharacter troll =          new EDCharacter("troll", "Mâle", 120, 225, 421, Races.Troll, 17, 0, 15, 0, 13, 0, 10, 0, 11, 0, 8, 0);
    EDCharacter tskrang =    new EDCharacter("tskrang", "Mâle", 120, 225, 421, Races.Tskrang, 17, 0, 15, 0, 13, 0, 10, 0, 11, 0, 8, 0);

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
        Assert.assertEquals(19, CharacterUtils.computeDeathThreshold(1));
        Assert.assertEquals(20, CharacterUtils.computeDeathThreshold(2));
        Assert.assertEquals(22, CharacterUtils.computeDeathThreshold(3));
        Assert.assertEquals(23, CharacterUtils.computeDeathThreshold(4));
        Assert.assertEquals(34, CharacterUtils.computeDeathThreshold(12));
        Assert.assertEquals(35, CharacterUtils.computeDeathThreshold(13));
        Assert.assertEquals(36, CharacterUtils.computeDeathThreshold(14));
        Assert.assertEquals(42, CharacterUtils.computeDeathThreshold(18));
        Assert.assertEquals(43, CharacterUtils.computeDeathThreshold(19));
        Assert.assertEquals(44, CharacterUtils.computeDeathThreshold(20));
        Assert.assertEquals(55, CharacterUtils.computeDeathThreshold(28));
        Assert.assertEquals(56, CharacterUtils.computeDeathThreshold(29));
        Assert.assertEquals(58, CharacterUtils.computeDeathThreshold(30));
    }

    @Test
    public void testComputeUncounciousnessThreshold()
    {
        Assert.assertEquals(10, CharacterUtils.computeUnconsciousnessThreshold(1));
        Assert.assertEquals(11, CharacterUtils.computeUnconsciousnessThreshold(2));
        Assert.assertEquals(13, CharacterUtils.computeUnconsciousnessThreshold(3));
        Assert.assertEquals(14, CharacterUtils.computeUnconsciousnessThreshold(4));
        Assert.assertEquals(21, CharacterUtils.computeUnconsciousnessThreshold(9));
        Assert.assertEquals(22, CharacterUtils.computeUnconsciousnessThreshold(10));
        Assert.assertEquals(24, CharacterUtils.computeUnconsciousnessThreshold(11));
        Assert.assertEquals(26, CharacterUtils.computeUnconsciousnessThreshold(12));
        Assert.assertEquals(27, CharacterUtils.computeUnconsciousnessThreshold(13));
        Assert.assertEquals(28, CharacterUtils.computeUnconsciousnessThreshold(14));
        Assert.assertEquals(34, CharacterUtils.computeUnconsciousnessThreshold(18));
        Assert.assertEquals(35, CharacterUtils.computeUnconsciousnessThreshold(19));
        Assert.assertEquals(36, CharacterUtils.computeUnconsciousnessThreshold(20));
        Assert.assertEquals(39, CharacterUtils.computeUnconsciousnessThreshold(21));
        Assert.assertEquals(40, CharacterUtils.computeUnconsciousnessThreshold(22));
        Assert.assertEquals(48, CharacterUtils.computeUnconsciousnessThreshold(28));
        Assert.assertEquals(49, CharacterUtils.computeUnconsciousnessThreshold(29));
        Assert.assertEquals(51, CharacterUtils.computeUnconsciousnessThreshold(30));
    }


    @Test
    public void testComputeWoundThreshold()
    {
        Assert.assertEquals(3, CharacterUtils.computeWoundThreshold(1));
        Assert.assertEquals(4, CharacterUtils.computeWoundThreshold(2));
        Assert.assertEquals(4, CharacterUtils.computeWoundThreshold(3));
        Assert.assertEquals(5, CharacterUtils.computeWoundThreshold(4));
        Assert.assertEquals(5, CharacterUtils.computeWoundThreshold(5));
        Assert.assertEquals(6, CharacterUtils.computeWoundThreshold(6));
        Assert.assertEquals(6, CharacterUtils.computeWoundThreshold(7));
        Assert.assertEquals(7, CharacterUtils.computeWoundThreshold(9));
        Assert.assertEquals(8, CharacterUtils.computeWoundThreshold(10));
        Assert.assertEquals(8, CharacterUtils.computeWoundThreshold(11));
        Assert.assertEquals(9, CharacterUtils.computeWoundThreshold(12));
        Assert.assertEquals(12, CharacterUtils.computeWoundThreshold(18));
        Assert.assertEquals(12, CharacterUtils.computeWoundThreshold(19));
        Assert.assertEquals(13, CharacterUtils.computeWoundThreshold(20));
        Assert.assertEquals(13, CharacterUtils.computeWoundThreshold(21));
        Assert.assertEquals(13, CharacterUtils.computeWoundThreshold(22));
        Assert.assertEquals(14, CharacterUtils.computeWoundThreshold(23));
        Assert.assertEquals(14, CharacterUtils.computeWoundThreshold(24));
        Assert.assertEquals(15, CharacterUtils.computeWoundThreshold(25));
        Assert.assertEquals(15, CharacterUtils.computeWoundThreshold(26));
        Assert.assertEquals(15, CharacterUtils.computeWoundThreshold(27));
        Assert.assertEquals(16, CharacterUtils.computeWoundThreshold(28));
        Assert.assertEquals(16, CharacterUtils.computeWoundThreshold(29));
        Assert.assertEquals(17, CharacterUtils.computeWoundThreshold(30));
    }

    @Test
    public void testComputeIndiceDefense()
    {
        Assert.assertEquals(2, CharacterUtils.computeIndiceDefense(1));
        Assert.assertEquals(3, CharacterUtils.computeIndiceDefense(2));
        Assert.assertEquals(3, CharacterUtils.computeIndiceDefense(3));
        Assert.assertEquals(4, CharacterUtils.computeIndiceDefense(4));
        Assert.assertEquals(4, CharacterUtils.computeIndiceDefense(5));
        Assert.assertEquals(4, CharacterUtils.computeIndiceDefense(6));
        Assert.assertEquals(5, CharacterUtils.computeIndiceDefense(7));
        Assert.assertEquals(5, CharacterUtils.computeIndiceDefense(8));
        Assert.assertEquals(6, CharacterUtils.computeIndiceDefense(9));
        Assert.assertEquals(6, CharacterUtils.computeIndiceDefense(10));
        Assert.assertEquals(7, CharacterUtils.computeIndiceDefense(11));
        Assert.assertEquals(7, CharacterUtils.computeIndiceDefense(12));
        Assert.assertEquals(7, CharacterUtils.computeIndiceDefense(13));
        Assert.assertEquals(9, CharacterUtils.computeIndiceDefense(17));
        Assert.assertEquals(10, CharacterUtils.computeIndiceDefense(18));
        Assert.assertEquals(10, CharacterUtils.computeIndiceDefense(19));
        Assert.assertEquals(10, CharacterUtils.computeIndiceDefense(20));
        Assert.assertEquals(11, CharacterUtils.computeIndiceDefense(21));
        Assert.assertEquals(12, CharacterUtils.computeIndiceDefense(23));
        Assert.assertEquals(13, CharacterUtils.computeIndiceDefense(27));
        Assert.assertEquals(14, CharacterUtils.computeIndiceDefense(28));
        Assert.assertEquals(14, CharacterUtils.computeIndiceDefense(29));
        Assert.assertEquals(15, CharacterUtils.computeIndiceDefense(30));
    }

    @Test
    public void testComputeMysticArmor()
    {
        Assert.assertEquals(0, CharacterUtils.computeMysticArmor(1));
        Assert.assertEquals(0, CharacterUtils.computeMysticArmor(5));
        Assert.assertEquals(0, CharacterUtils.computeMysticArmor(10));
        Assert.assertEquals(1, CharacterUtils.computeMysticArmor(11));
        Assert.assertEquals(1, CharacterUtils.computeMysticArmor(12));
        Assert.assertEquals(1, CharacterUtils.computeMysticArmor(13));
        Assert.assertEquals(2, CharacterUtils.computeMysticArmor(14));
        Assert.assertEquals(2, CharacterUtils.computeMysticArmor(15));
        Assert.assertEquals(2, CharacterUtils.computeMysticArmor(16));
        Assert.assertEquals(6, CharacterUtils.computeMysticArmor(27));
        Assert.assertEquals(6, CharacterUtils.computeMysticArmor(28));
        Assert.assertEquals(7, CharacterUtils.computeMysticArmor(29));
        Assert.assertEquals(7, CharacterUtils.computeMysticArmor(30));
    }

    @Test
    public void testComputeCombatMouvement()
    {
        Assert.assertEquals(6, CharacterUtils.computeCombatMouvement(1));
        Assert.assertEquals(7, CharacterUtils.computeCombatMouvement(2));
        Assert.assertEquals(8, CharacterUtils.computeCombatMouvement(3));
        Assert.assertEquals(9, CharacterUtils.computeCombatMouvement(4));
        Assert.assertEquals(10, CharacterUtils.computeCombatMouvement(5));
        Assert.assertEquals(12, CharacterUtils.computeCombatMouvement(6));
        Assert.assertEquals(14, CharacterUtils.computeCombatMouvement(7));
        Assert.assertEquals(24, CharacterUtils.computeCombatMouvement(12));
        Assert.assertEquals(34, CharacterUtils.computeCombatMouvement(17));
        Assert.assertEquals(38, CharacterUtils.computeCombatMouvement(19));
        Assert.assertEquals(40, CharacterUtils.computeCombatMouvement(20));
        Assert.assertEquals(43, CharacterUtils.computeCombatMouvement(21));
        Assert.assertEquals(46, CharacterUtils.computeCombatMouvement(22));
        Assert.assertEquals(61, CharacterUtils.computeCombatMouvement(27));
        Assert.assertEquals(64, CharacterUtils.computeCombatMouvement(28));
        Assert.assertEquals(67, CharacterUtils.computeCombatMouvement(29));
        Assert.assertEquals(70, CharacterUtils.computeCombatMouvement(30));
    }

    @Test
    public void testComputeRunningMouvement()
    {
        Assert.assertEquals(12, CharacterUtils.computeRunningMouvement(1));
        Assert.assertEquals(14, CharacterUtils.computeRunningMouvement(2));
        Assert.assertEquals(16, CharacterUtils.computeRunningMouvement(3));
        Assert.assertEquals(18, CharacterUtils.computeRunningMouvement(4));
        Assert.assertEquals(20, CharacterUtils.computeRunningMouvement(5));
        Assert.assertEquals(24, CharacterUtils.computeRunningMouvement(6));
        Assert.assertEquals(28, CharacterUtils.computeRunningMouvement(7));
        Assert.assertEquals(48, CharacterUtils.computeRunningMouvement(12));
        Assert.assertEquals(68, CharacterUtils.computeRunningMouvement(17));
        Assert.assertEquals(76, CharacterUtils.computeRunningMouvement(19));
        Assert.assertEquals(80, CharacterUtils.computeRunningMouvement(20));
        Assert.assertEquals(86, CharacterUtils.computeRunningMouvement(21));
        Assert.assertEquals(92, CharacterUtils.computeRunningMouvement(22));
        Assert.assertEquals(122, CharacterUtils.computeRunningMouvement(27));
        Assert.assertEquals(128, CharacterUtils.computeRunningMouvement(28));
        Assert.assertEquals(134, CharacterUtils.computeRunningMouvement(29));
        Assert.assertEquals(140, CharacterUtils.computeRunningMouvement(30));
    }

    @Test
    public void testComputeLiftingCapacity()
    {
        Assert.assertEquals(5, CharacterUtils.computeLiftingCapacity(1));
        Assert.assertEquals(15, CharacterUtils.computeLiftingCapacity(3));
        Assert.assertEquals(30, CharacterUtils.computeLiftingCapacity(6));
        Assert.assertEquals(40, CharacterUtils.computeLiftingCapacity(7));
        Assert.assertEquals(80, CharacterUtils.computeLiftingCapacity(11));
        Assert.assertEquals(95, CharacterUtils.computeLiftingCapacity(12));
        Assert.assertEquals(140, CharacterUtils.computeLiftingCapacity(15));
        Assert.assertEquals(160, CharacterUtils.computeLiftingCapacity(16));
        Assert.assertEquals(200, CharacterUtils.computeLiftingCapacity(18));
        Assert.assertEquals(230, CharacterUtils.computeLiftingCapacity(19));
        Assert.assertEquals(290, CharacterUtils.computeLiftingCapacity(21));
        Assert.assertEquals(330, CharacterUtils.computeLiftingCapacity(22));
        Assert.assertEquals(410, CharacterUtils.computeLiftingCapacity(24));
        Assert.assertEquals(460, CharacterUtils.computeLiftingCapacity(25));
        Assert.assertEquals(560, CharacterUtils.computeLiftingCapacity(27));
        Assert.assertEquals(620, CharacterUtils.computeLiftingCapacity(28));
        Assert.assertEquals(740, CharacterUtils.computeLiftingCapacity(30));
    }

    @Test
    public void testComputeCarryingCapacity()
    {
        Assert.assertEquals(3, CharacterUtils.computeCarryingCapacity(1));
        Assert.assertEquals(8, CharacterUtils.computeCarryingCapacity(3));
        Assert.assertEquals(15, CharacterUtils.computeCarryingCapacity(6));
        Assert.assertEquals(20, CharacterUtils.computeCarryingCapacity(7));
        Assert.assertEquals(40, CharacterUtils.computeCarryingCapacity(11));
        Assert.assertEquals(48, CharacterUtils.computeCarryingCapacity(12));
        Assert.assertEquals(70, CharacterUtils.computeCarryingCapacity(15));
        Assert.assertEquals(80, CharacterUtils.computeCarryingCapacity(16));
        Assert.assertEquals(100, CharacterUtils.computeCarryingCapacity(18));
        Assert.assertEquals(115, CharacterUtils.computeCarryingCapacity(19));
        Assert.assertEquals(145, CharacterUtils.computeCarryingCapacity(21));
        Assert.assertEquals(165, CharacterUtils.computeCarryingCapacity(22));
        Assert.assertEquals(205, CharacterUtils.computeCarryingCapacity(24));
        Assert.assertEquals(230, CharacterUtils.computeCarryingCapacity(25));
        Assert.assertEquals(280, CharacterUtils.computeCarryingCapacity(27));
        Assert.assertEquals(310, CharacterUtils.computeCarryingCapacity(28));
        Assert.assertEquals(370, CharacterUtils.computeCarryingCapacity(30));
    }

    @Test
    public void testCheckCircle()
    {
        // Valeurs accept�es
        Assert.assertTrue(EDCharacter.checkCircle(1));
        Assert.assertTrue(EDCharacter.checkCircle(5));
        Assert.assertTrue(EDCharacter.checkCircle(9));
        Assert.assertTrue(EDCharacter.checkCircle(13));
        Assert.assertTrue(EDCharacter.checkCircle(15));
        // Valeurs n�gatives
        Assert.assertFalse(EDCharacter.checkCircle(-1));
        Assert.assertFalse(EDCharacter.checkCircle(-5));
        Assert.assertFalse(EDCharacter.checkCircle(-9));
        Assert.assertFalse(EDCharacter.checkCircle(-13));
        Assert.assertFalse(EDCharacter.checkCircle(-15));
        // Valeurs trop grandes ou trop petites
        Assert.assertFalse(EDCharacter.checkCircle(0));
        Assert.assertFalse(EDCharacter.checkCircle(16));
        Assert.assertFalse(EDCharacter.checkCircle(22));
    }

    @Test
    public void testCheckCircles()
    {
        // Valeurs accept�es
        Assert.assertTrue(EDCharacter.checkCircles(6, 3));
        Assert.assertTrue(EDCharacter.checkCircles(9, 6));
        Assert.assertTrue(EDCharacter.checkCircles(10, 10));
        Assert.assertTrue(EDCharacter.checkCircles(15, 1));
        Assert.assertTrue(EDCharacter.checkCircles(2, 1));
        // Valeurs n�gatives
        Assert.assertFalse(EDCharacter.checkCircles(-1, 3));
        Assert.assertFalse(EDCharacter.checkCircles(5, -2));
        Assert.assertFalse(EDCharacter.checkCircles(-9, 4));
        Assert.assertFalse(EDCharacter.checkCircles(6, -13));
        Assert.assertFalse(EDCharacter.checkCircles(-15, 10));
        // Valeurs trop grandes ou trop petites
        Assert.assertFalse(EDCharacter.checkCircles(0, 2));
        Assert.assertFalse(EDCharacter.checkCircles(2, 0));
        Assert.assertFalse(EDCharacter.checkCircles(15, 16));
        Assert.assertFalse(EDCharacter.checkCircles(16, 15));
    }

    @Test
    public void testGetHealth()
    {
        elfe.setMainDiscipline(Disciplines.Archer, 6);
        Discipline disc = elfe.getMainDiscipline();
        Talent endurance = disc.findTalent(Talents.Endurance);
        disc.setTalentRank(endurance, 6);
        humain.setMainDiscipline(Disciplines.Eclaireur, 6);
        disc = humain.getMainDiscipline();
        endurance = disc.findTalent(Talents.Endurance);
        disc.setTalentRank(endurance, 6);
        nain.setMainDiscipline(Disciplines.Forgeron, 6);
        disc = nain.getMainDiscipline();
        endurance = disc.findTalent(Talents.Endurance);
        disc.setTalentRank(endurance, 6);
        obsidien.setMainDiscipline(Disciplines.Guerrier, 6);
        disc = obsidien.getMainDiscipline();
        endurance = disc.findTalent(Talents.Endurance);
        disc.setTalentRank(endurance, 6);
        ork.setMainDiscipline(Disciplines.Cavalier, 6);
        disc = ork.getMainDiscipline();
        endurance = disc.findTalent(Talents.Endurance);
        disc.setTalentRank(endurance, 6);
        sylphe.setMainDiscipline(Disciplines.MaitreAnimaux, 6);
        disc = sylphe.getMainDiscipline();
        endurance = disc.findTalent(Talents.Endurance);
        disc.setTalentRank(endurance, 6);
        troll.setMainDiscipline(Disciplines.EcumeurCiel, 6);
        disc = troll.getMainDiscipline();
        endurance = disc.findTalent(Talents.Endurance);
        disc.setTalentRank(endurance, 6);
        tskrang.setMainDiscipline(Disciplines.Necromancien, 6);
        disc = tskrang.getMainDiscipline();
        endurance = disc.findTalent(Talents.Endurance);
        disc.setTalentRank(endurance, 6);

        // Death threshold
        Assert.assertEquals(32, elfe.getDeathThreshold());
        Assert.assertEquals(35, humain.getDeathThreshold());
        Assert.assertEquals(39, nain.getDeathThreshold());
        Assert.assertEquals(40, obsidien.getDeathThreshold());
        Assert.assertEquals(36, ork.getDeathThreshold());
        Assert.assertEquals(31, sylphe.getDeathThreshold());
        Assert.assertEquals(38, troll.getDeathThreshold());
        Assert.assertEquals(36, tskrang.getDeathThreshold());

        // Health points
        Assert.assertEquals(32+6*6, elfe.getHealthPoints());
        Assert.assertEquals(35+6*6, humain.getHealthPoints());
        Assert.assertEquals(39+6*6, nain.getHealthPoints());
        Assert.assertEquals(40+6*9, obsidien.getHealthPoints());
        Assert.assertEquals(36+6*7, ork.getHealthPoints());
        Assert.assertEquals(31+6*7, sylphe.getHealthPoints());
        Assert.assertEquals(38+6*8, troll.getHealthPoints());
        Assert.assertEquals(36+6*4, tskrang.getHealthPoints());

        // Unconsciousness Threshold
        Assert.assertEquals(24, elfe.getUnconsciousnessThreshold());
        Assert.assertEquals(27, humain.getUnconsciousnessThreshold());
        Assert.assertEquals(31, nain.getUnconsciousnessThreshold());
        Assert.assertEquals(32, obsidien.getUnconsciousnessThreshold());
        Assert.assertEquals(28, ork.getUnconsciousnessThreshold());
        Assert.assertEquals(22, sylphe.getUnconsciousnessThreshold());
        Assert.assertEquals(30, troll.getUnconsciousnessThreshold());
        Assert.assertEquals(28, tskrang.getUnconsciousnessThreshold());

        // Unconsicousness Points
        Assert.assertEquals(24+6*5, elfe.getUnconsciousnessPoints());
        Assert.assertEquals(27+6*5, humain.getUnconsciousnessPoints());
        Assert.assertEquals(31+6*5, nain.getUnconsciousnessPoints());
        Assert.assertEquals(32+6*7, obsidien.getUnconsciousnessPoints());
        Assert.assertEquals(28+6*6, ork.getUnconsciousnessPoints());
        Assert.assertEquals(22+6*6, sylphe.getUnconsciousnessPoints());
        Assert.assertEquals(30+6*6, troll.getUnconsciousnessPoints());
        Assert.assertEquals(28+6*3, tskrang.getUnconsciousnessPoints());
    }
}
