package fr.android.earthdawn.character;

import junit.framework.TestCase;

import org.junit.Test;

import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.managers.EquipmentManager;

public class CharacterTest extends TestCase
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

        assertEquals(7, obsidien.getTalentRank(armesMelee, discipline));
        assertEquals(13, obsidien.getTalentLevel(armesMelee, discipline));
        assertEquals(5, obsidien.getTalentRank(longevite, discipline));
        assertEquals(5, obsidien.getTalentLevel(longevite, discipline));

        // increment
        obsidien.incrementTalentRank(armesMelee, discipline);

        assertEquals(8, obsidien.getTalentRank(armesMelee, discipline));
        assertEquals(14, obsidien.getTalentLevel(armesMelee, discipline));
        assertEquals(5, obsidien.getTalentRank(longevite, discipline));
        assertEquals(5, obsidien.getTalentLevel(longevite, discipline));
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

        assertEquals(10, elfe.getPhysicalDefense());
        assertEquals(9, humain.getPhysicalDefense());
        assertEquals(9, nain.getPhysicalDefense());
        assertEquals(8, obsidien.getPhysicalDefense());
        assertEquals(9, ork.getPhysicalDefense());
        assertEquals(13, sylphe.getPhysicalDefense());
        assertEquals(9, troll.getPhysicalDefense());
        assertEquals(10, tskrang.getPhysicalDefense());
    }
    @Test
    public void testGetMagicalDefense()
    {
        initDisciplines();

        assertEquals(8, elfe.getMagicalDefense());
        assertEquals(7, humain.getMagicalDefense());
        assertEquals(7, nain.getMagicalDefense());
        assertEquals(7, obsidien.getMagicalDefense());
        assertEquals(6, ork.getMagicalDefense());
        assertEquals(8, sylphe.getMagicalDefense());
        assertEquals(6, troll.getMagicalDefense());
        assertEquals(6, tskrang.getMagicalDefense());
    }
    @Test
    public void testGetSocialDefense()
    {
        initDisciplines();

        assertEquals(6, elfe.getSocialDefense());
        assertEquals(5, humain.getSocialDefense());
        assertEquals(4, nain.getSocialDefense());
        assertEquals(5, obsidien.getSocialDefense());
        assertEquals(5, ork.getSocialDefense());
        assertEquals(8, sylphe.getSocialDefense());
        assertEquals(5, troll.getSocialDefense());
        assertEquals(6, tskrang.getSocialDefense());
    }
    @Test
    public void testGetMysticArmor()
    {
        initDisciplines();

        assertEquals(1, elfe.getMysticArmor());
        assertEquals(1, humain.getMysticArmor());
        assertEquals(1, nain.getMysticArmor());
        assertEquals(1, obsidien.getMysticArmor());
        assertEquals(0, ork.getMysticArmor());
        assertEquals(1, sylphe.getMysticArmor());
        assertEquals(1, troll.getMysticArmor());
        assertEquals(1, tskrang.getMysticArmor());
    }
    @Test
    public void testGetPhysicalArmor()
    {
        initDisciplines();

        assertEquals(0, nain.getPhysicalArmor());
        assertEquals(3, obsidien.getPhysicalArmor());

        nain.addEquipment(EquipmentManager.getArmorList().get(0));
        obsidien.addEquipment(EquipmentManager.getArmorList().get(0));
        assertEquals(6, nain.getPhysicalArmor());
        assertEquals(9, obsidien.getPhysicalArmor());
    }

    @Test
    public void testGetWoundThreshold()
    {
        initDisciplines();

        assertEquals(8, elfe.getWoundThreshold());
        assertEquals(9, humain.getWoundThreshold());
        assertEquals(11, nain.getWoundThreshold());
        assertEquals(14, obsidien.getWoundThreshold());
        assertEquals(10, ork.getWoundThreshold());
        assertEquals(8, sylphe.getWoundThreshold());
        assertEquals(10, troll.getWoundThreshold());
        assertEquals(10, tskrang.getWoundThreshold());
    }

    @Test
    public void testGetMouvement()
    {
        assertEquals(40, elfe.getCombatMouvement());
        assertEquals(80, elfe.getRunningMouvement());
        assertEquals(34, humain.getCombatMouvement());
        assertEquals(68, humain.getRunningMouvement());
        assertEquals(30, nain.getCombatMouvement());
        assertEquals(60, nain.getRunningMouvement());
        assertEquals(24, obsidien.getCombatMouvement());
        assertEquals(48, obsidien.getRunningMouvement());
        assertEquals(36, ork.getCombatMouvement());
        assertEquals(72, ork.getRunningMouvement());
        assertEquals(40, sylphe.getCombatMouvement());
        assertEquals(80, sylphe.getRunningMouvement());
        assertEquals(34, troll.getCombatMouvement());
        assertEquals(68, troll.getRunningMouvement());
        assertEquals(36, tskrang.getCombatMouvement());
        assertEquals(72, tskrang.getRunningMouvement());
    }

    @Test
    public void testGetTransportCapacity()
    {
        assertEquals(140, elfe.getLiftingCapacity());
        assertEquals(70, elfe.getCarryingCapacity());
        assertEquals(140, humain.getLiftingCapacity());
        assertEquals(70, humain.getCarryingCapacity());
        assertEquals(180, nain.getLiftingCapacity());
        assertEquals(90, nain.getCarryingCapacity());
        assertEquals(290, obsidien.getLiftingCapacity());
        assertEquals(145, obsidien.getCarryingCapacity());
        assertEquals(200, ork.getLiftingCapacity());
        assertEquals(100, ork.getCarryingCapacity());
        assertEquals(40, sylphe.getLiftingCapacity());
        assertEquals(20, sylphe.getCarryingCapacity());
        assertEquals(230, troll.getLiftingCapacity());
        assertEquals(115, troll.getCarryingCapacity());
        assertEquals(140, tskrang.getLiftingCapacity());
        assertEquals(70, tskrang.getCarryingCapacity());
    }

    @Test
    public void testCheckCircle()
    {
        // Valeurs accept�es
        assertTrue(EDCharacter.checkCircle(1));
        assertTrue(EDCharacter.checkCircle(5));
        assertTrue(EDCharacter.checkCircle(9));
        assertTrue(EDCharacter.checkCircle(13));
        assertTrue(EDCharacter.checkCircle(15));
        // Valeurs n�gatives
        assertFalse(EDCharacter.checkCircle(-1));
        assertFalse(EDCharacter.checkCircle(-5));
        assertFalse(EDCharacter.checkCircle(-9));
        assertFalse(EDCharacter.checkCircle(-13));
        assertFalse(EDCharacter.checkCircle(-15));
        // Valeurs trop grandes ou trop petites
        assertFalse(EDCharacter.checkCircle(0));
        assertFalse(EDCharacter.checkCircle(16));
        assertFalse(EDCharacter.checkCircle(22));
    }

    @Test
    public void testCheckCircles()
    {
        // Valeurs accept�es
        assertTrue(EDCharacter.checkCircles(6, 3));
        assertTrue(EDCharacter.checkCircles(9, 6));
        assertTrue(EDCharacter.checkCircles(10, 10));
        assertTrue(EDCharacter.checkCircles(15, 1));
        assertTrue(EDCharacter.checkCircles(2, 1));
        // Valeurs n�gatives
        assertFalse(EDCharacter.checkCircles(-1, 3));
        assertFalse(EDCharacter.checkCircles(5, -2));
        assertFalse(EDCharacter.checkCircles(-9, 4));
        assertFalse(EDCharacter.checkCircles(6, -13));
        assertFalse(EDCharacter.checkCircles(-15, 10));
        // Valeurs trop grandes ou trop petites
        assertFalse(EDCharacter.checkCircles(0, 2));
        assertFalse(EDCharacter.checkCircles(2, 0));
        assertFalse(EDCharacter.checkCircles(15, 16));
        assertFalse(EDCharacter.checkCircles(16, 15));
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
        assertEquals(32, elfe.getDeathThreshold());
        assertEquals(35, humain.getDeathThreshold());
        assertEquals(39, nain.getDeathThreshold());
        assertEquals(40, obsidien.getDeathThreshold());
        assertEquals(36, ork.getDeathThreshold());
        assertEquals(31, sylphe.getDeathThreshold());
        assertEquals(38, troll.getDeathThreshold());
        assertEquals(36, tskrang.getDeathThreshold());

        // Health points
        assertEquals(32+6*6, elfe.getHealthPoints());
        assertEquals(35+6*6, humain.getHealthPoints());
        assertEquals(39+6*6, nain.getHealthPoints());
        assertEquals(40+6*9, obsidien.getHealthPoints());
        assertEquals(36+6*7, ork.getHealthPoints());
        assertEquals(31+6*7, sylphe.getHealthPoints());
        assertEquals(38+6*8, troll.getHealthPoints());
        assertEquals(36+6*4, tskrang.getHealthPoints());

        // Unconsciousness Threshold
        assertEquals(24, elfe.getUnconsciousnessThreshold());
        assertEquals(27, humain.getUnconsciousnessThreshold());
        assertEquals(31, nain.getUnconsciousnessThreshold());
        assertEquals(32, obsidien.getUnconsciousnessThreshold());
        assertEquals(28, ork.getUnconsciousnessThreshold());
        assertEquals(22, sylphe.getUnconsciousnessThreshold());
        assertEquals(30, troll.getUnconsciousnessThreshold());
        assertEquals(28, tskrang.getUnconsciousnessThreshold());

        // Unconsicousness Points
        assertEquals(24+6*5, elfe.getUnconsciousnessPoints());
        assertEquals(27+6*5, humain.getUnconsciousnessPoints());
        assertEquals(31+6*5, nain.getUnconsciousnessPoints());
        assertEquals(32+6*7, obsidien.getUnconsciousnessPoints());
        assertEquals(28+6*6, ork.getUnconsciousnessPoints());
        assertEquals(22+6*6, sylphe.getUnconsciousnessPoints());
        assertEquals(30+6*6, troll.getUnconsciousnessPoints());
        assertEquals(28+6*3, tskrang.getUnconsciousnessPoints());

        // RecoveryDices
        assertEquals("1D8", elfe.getRecoveryDices());
        assertEquals("1D10", humain.getRecoveryDices());
        assertEquals("1D12", nain.getRecoveryDices());
        assertEquals("1D12", obsidien.getRecoveryDices());
        assertEquals("1D10", ork.getRecoveryDices());
        assertEquals("1D8", sylphe.getRecoveryDices());
        assertEquals("1D10", troll.getRecoveryDices());
        assertEquals("1D10", tskrang.getRecoveryDices());

        // NbRecoveryTests
        assertEquals(2.0, elfe.getNbRecoveryTests(), 0.0001);
        assertEquals(2.0, humain.getNbRecoveryTests(), 0.0001);
        assertEquals(3.0, nain.getNbRecoveryTests(), 0.0001);
        assertEquals(3.0, obsidien.getNbRecoveryTests(), 0.0001);
        assertEquals(3.0, ork.getNbRecoveryTests(), 0.0001);
        assertEquals(2.0, sylphe.getNbRecoveryTests(), 0.0001);
        assertEquals(3.0, troll.getNbRecoveryTests(), 0.0001);
        assertEquals(3.0, tskrang.getNbRecoveryTests(), 0.0001);

        // Other tests
        final EDCharacter character = new EDCharacter("tskrang", "Mâle", 120, 225, 421, Races.Tskrang, 17, 0, 15, 0, 13, 0, 10, 0, 11, 0, 8, 0);
        character.setMainDiscipline(Disciplines.Necromancien, 1);
        assertEquals(28, character.getUnconsciousnessPoints());
    }
}
