package fr.android.earthdawn.character;

import junit.framework.Assert;

import org.junit.Test;

import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.managers.EquipmentManager;

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
        Assert.assertEquals(13, obsidien.getTalentLevel(armesMelee, discipline));
        Assert.assertEquals(5, obsidien.getTalentRank(longevite, discipline));
        Assert.assertEquals(5, obsidien.getTalentLevel(longevite, discipline));

        // increment
        obsidien.incrementTalentRank(armesMelee, discipline);

        Assert.assertEquals(8, obsidien.getTalentRank(armesMelee, discipline));
        Assert.assertEquals(14, obsidien.getTalentLevel(armesMelee, discipline));
        Assert.assertEquals(5, obsidien.getTalentRank(longevite, discipline));
        Assert.assertEquals(5, obsidien.getTalentLevel(longevite, discipline));
    }

    private void initDisciplines()
    {
        elfe.setMainDiscipline(Disciplines.Guerrier, 1);
        humain.setMainDiscipline(Disciplines.Guerrier, 1);
        nain.setMainDiscipline(Disciplines.Guerrier, 1);
        obsidien.setMainDiscipline(Disciplines.Guerrier, 1);
        ork.setMainDiscipline(Disciplines.Guerrier, 1);
        sylphe.setMainDiscipline(Disciplines.Guerrier, 1);
        troll.setMainDiscipline(Disciplines.Guerrier, 1);
        tskrang.setMainDiscipline(Disciplines.Guerrier, 1);
    }

    @Test
    public void testGetPhysicalDefense()
    {
        initDisciplines();

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
        initDisciplines();

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
        initDisciplines();

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
        initDisciplines();

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
    public void testGetPhysicalArmor()
    {
        initDisciplines();

        Assert.assertEquals(0, nain.getPhysicalArmor());
        Assert.assertEquals(3, obsidien.getPhysicalArmor());

        nain.addEquipment(EquipmentManager.getArmorList().get(0));
        obsidien.addEquipment(EquipmentManager.getArmorList().get(0));
        Assert.assertEquals(6, nain.getPhysicalArmor());
        Assert.assertEquals(9, obsidien.getPhysicalArmor());
    }

    @Test
    public void testGetWoundThreshold()
    {
        initDisciplines();

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

        // RecoveryDices
        Assert.assertEquals("1D8", elfe.getRecoveryDices());
        Assert.assertEquals("1D10", humain.getRecoveryDices());
        Assert.assertEquals("1D12", nain.getRecoveryDices());
        Assert.assertEquals("1D12", obsidien.getRecoveryDices());
        Assert.assertEquals("1D10", ork.getRecoveryDices());
        Assert.assertEquals("1D8", sylphe.getRecoveryDices());
        Assert.assertEquals("1D10", troll.getRecoveryDices());
        Assert.assertEquals("1D10", tskrang.getRecoveryDices());

        // NbRecoveryTests
        Assert.assertEquals(2.0, elfe.getNbRecoveryTests(), 0.0001);
        Assert.assertEquals(2.0, humain.getNbRecoveryTests(), 0.0001);
        Assert.assertEquals(3.0, nain.getNbRecoveryTests(), 0.0001);
        Assert.assertEquals(3.0, obsidien.getNbRecoveryTests(), 0.0001);
        Assert.assertEquals(3.0, ork.getNbRecoveryTests(), 0.0001);
        Assert.assertEquals(2.0, sylphe.getNbRecoveryTests(), 0.0001);
        Assert.assertEquals(3.0, troll.getNbRecoveryTests(), 0.0001);
        Assert.assertEquals(3.0, tskrang.getNbRecoveryTests(), 0.0001);

        // Other tests
        final EDCharacter character = new EDCharacter("tskrang", "Mâle", 120, 225, 421, Races.Tskrang, 17, 0, 15, 0, 13, 0, 10, 0, 11, 0, 8, 0);
        character.setMainDiscipline(Disciplines.Necromancien, 1);
        Assert.assertEquals(28, character.getUnconsciousnessPoints());
    }
}
