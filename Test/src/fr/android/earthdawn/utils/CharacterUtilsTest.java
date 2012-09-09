package fr.android.earthdawn.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;
import fr.android.earthdawn.R;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Attributes;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.character.equipement.IEquipment;
import fr.android.earthdawn.character.equipement.impl.MagicalEquipment;
import fr.android.earthdawn.managers.EquipmentManager;

public class CharacterUtilsTest extends TestCase
{
    public void testComputeDeathThreshold()
    {
        assertEquals(19, CharacterUtils.computeDeathThreshold(1));
        assertEquals(20, CharacterUtils.computeDeathThreshold(2));
        assertEquals(22, CharacterUtils.computeDeathThreshold(3));
        assertEquals(23, CharacterUtils.computeDeathThreshold(4));
        assertEquals(34, CharacterUtils.computeDeathThreshold(12));
        assertEquals(35, CharacterUtils.computeDeathThreshold(13));
        assertEquals(36, CharacterUtils.computeDeathThreshold(14));
        assertEquals(42, CharacterUtils.computeDeathThreshold(18));
        assertEquals(43, CharacterUtils.computeDeathThreshold(19));
        assertEquals(44, CharacterUtils.computeDeathThreshold(20));
        assertEquals(55, CharacterUtils.computeDeathThreshold(28));
        assertEquals(56, CharacterUtils.computeDeathThreshold(29));
        assertEquals(58, CharacterUtils.computeDeathThreshold(30));
    }

    public void testComputeUnconsciousnessThreshold()
    {
        assertEquals(10, CharacterUtils.computeUnconsciousnessThreshold(1));
        assertEquals(11, CharacterUtils.computeUnconsciousnessThreshold(2));
        assertEquals(13, CharacterUtils.computeUnconsciousnessThreshold(3));
        assertEquals(14, CharacterUtils.computeUnconsciousnessThreshold(4));
        assertEquals(21, CharacterUtils.computeUnconsciousnessThreshold(9));
        assertEquals(22, CharacterUtils.computeUnconsciousnessThreshold(10));
        assertEquals(24, CharacterUtils.computeUnconsciousnessThreshold(11));
        assertEquals(26, CharacterUtils.computeUnconsciousnessThreshold(12));
        assertEquals(27, CharacterUtils.computeUnconsciousnessThreshold(13));
        assertEquals(28, CharacterUtils.computeUnconsciousnessThreshold(14));
        assertEquals(34, CharacterUtils.computeUnconsciousnessThreshold(18));
        assertEquals(35, CharacterUtils.computeUnconsciousnessThreshold(19));
        assertEquals(36, CharacterUtils.computeUnconsciousnessThreshold(20));
        assertEquals(39, CharacterUtils.computeUnconsciousnessThreshold(21));
        assertEquals(40, CharacterUtils.computeUnconsciousnessThreshold(22));
        assertEquals(48, CharacterUtils.computeUnconsciousnessThreshold(28));
        assertEquals(49, CharacterUtils.computeUnconsciousnessThreshold(29));
        assertEquals(51, CharacterUtils.computeUnconsciousnessThreshold(30));
    }


    public void testComputeWoundThreshold()
    {
        assertEquals(3, CharacterUtils.computeWoundThreshold(1));
        assertEquals(4, CharacterUtils.computeWoundThreshold(2));
        assertEquals(4, CharacterUtils.computeWoundThreshold(3));
        assertEquals(5, CharacterUtils.computeWoundThreshold(4));
        assertEquals(5, CharacterUtils.computeWoundThreshold(5));
        assertEquals(6, CharacterUtils.computeWoundThreshold(6));
        assertEquals(6, CharacterUtils.computeWoundThreshold(7));
        assertEquals(7, CharacterUtils.computeWoundThreshold(9));
        assertEquals(8, CharacterUtils.computeWoundThreshold(10));
        assertEquals(8, CharacterUtils.computeWoundThreshold(11));
        assertEquals(9, CharacterUtils.computeWoundThreshold(12));
        assertEquals(12, CharacterUtils.computeWoundThreshold(18));
        assertEquals(12, CharacterUtils.computeWoundThreshold(19));
        assertEquals(13, CharacterUtils.computeWoundThreshold(20));
        assertEquals(13, CharacterUtils.computeWoundThreshold(21));
        assertEquals(13, CharacterUtils.computeWoundThreshold(22));
        assertEquals(14, CharacterUtils.computeWoundThreshold(23));
        assertEquals(14, CharacterUtils.computeWoundThreshold(24));
        assertEquals(15, CharacterUtils.computeWoundThreshold(25));
        assertEquals(15, CharacterUtils.computeWoundThreshold(26));
        assertEquals(15, CharacterUtils.computeWoundThreshold(27));
        assertEquals(16, CharacterUtils.computeWoundThreshold(28));
        assertEquals(16, CharacterUtils.computeWoundThreshold(29));
        assertEquals(17, CharacterUtils.computeWoundThreshold(30));
    }

    public void testComputeIndiceDefense()
    {
        assertEquals(2, CharacterUtils.computeIndiceDefense(1));
        assertEquals(3, CharacterUtils.computeIndiceDefense(2));
        assertEquals(3, CharacterUtils.computeIndiceDefense(3));
        assertEquals(4, CharacterUtils.computeIndiceDefense(4));
        assertEquals(4, CharacterUtils.computeIndiceDefense(5));
        assertEquals(4, CharacterUtils.computeIndiceDefense(6));
        assertEquals(5, CharacterUtils.computeIndiceDefense(7));
        assertEquals(5, CharacterUtils.computeIndiceDefense(8));
        assertEquals(6, CharacterUtils.computeIndiceDefense(9));
        assertEquals(6, CharacterUtils.computeIndiceDefense(10));
        assertEquals(7, CharacterUtils.computeIndiceDefense(11));
        assertEquals(7, CharacterUtils.computeIndiceDefense(12));
        assertEquals(7, CharacterUtils.computeIndiceDefense(13));
        assertEquals(9, CharacterUtils.computeIndiceDefense(17));
        assertEquals(10, CharacterUtils.computeIndiceDefense(18));
        assertEquals(10, CharacterUtils.computeIndiceDefense(19));
        assertEquals(10, CharacterUtils.computeIndiceDefense(20));
        assertEquals(11, CharacterUtils.computeIndiceDefense(21));
        assertEquals(12, CharacterUtils.computeIndiceDefense(23));
        assertEquals(13, CharacterUtils.computeIndiceDefense(27));
        assertEquals(14, CharacterUtils.computeIndiceDefense(28));
        assertEquals(14, CharacterUtils.computeIndiceDefense(29));
        assertEquals(15, CharacterUtils.computeIndiceDefense(30));
    }

    public void testComputeMysticArmor()
    {
        assertEquals(0, CharacterUtils.computeMysticArmor(1));
        assertEquals(0, CharacterUtils.computeMysticArmor(5));
        assertEquals(0, CharacterUtils.computeMysticArmor(10));
        assertEquals(1, CharacterUtils.computeMysticArmor(11));
        assertEquals(1, CharacterUtils.computeMysticArmor(12));
        assertEquals(1, CharacterUtils.computeMysticArmor(13));
        assertEquals(2, CharacterUtils.computeMysticArmor(14));
        assertEquals(2, CharacterUtils.computeMysticArmor(15));
        assertEquals(2, CharacterUtils.computeMysticArmor(16));
        assertEquals(6, CharacterUtils.computeMysticArmor(27));
        assertEquals(6, CharacterUtils.computeMysticArmor(28));
        assertEquals(7, CharacterUtils.computeMysticArmor(29));
        assertEquals(7, CharacterUtils.computeMysticArmor(30));
    }

    public void testComputeCombatMouvement()
    {
        assertEquals(6, CharacterUtils.computeCombatMovement(1));
        assertEquals(7, CharacterUtils.computeCombatMovement(2));
        assertEquals(8, CharacterUtils.computeCombatMovement(3));
        assertEquals(9, CharacterUtils.computeCombatMovement(4));
        assertEquals(10, CharacterUtils.computeCombatMovement(5));
        assertEquals(12, CharacterUtils.computeCombatMovement(6));
        assertEquals(14, CharacterUtils.computeCombatMovement(7));
        assertEquals(24, CharacterUtils.computeCombatMovement(12));
        assertEquals(34, CharacterUtils.computeCombatMovement(17));
        assertEquals(38, CharacterUtils.computeCombatMovement(19));
        assertEquals(40, CharacterUtils.computeCombatMovement(20));
        assertEquals(43, CharacterUtils.computeCombatMovement(21));
        assertEquals(46, CharacterUtils.computeCombatMovement(22));
        assertEquals(61, CharacterUtils.computeCombatMovement(27));
        assertEquals(64, CharacterUtils.computeCombatMovement(28));
        assertEquals(67, CharacterUtils.computeCombatMovement(29));
        assertEquals(70, CharacterUtils.computeCombatMovement(30));
    }

    public void testComputeRunningMouvement()
    {
        assertEquals(12, CharacterUtils.computeRunningMovement(1));
        assertEquals(14, CharacterUtils.computeRunningMovement(2));
        assertEquals(16, CharacterUtils.computeRunningMovement(3));
        assertEquals(18, CharacterUtils.computeRunningMovement(4));
        assertEquals(20, CharacterUtils.computeRunningMovement(5));
        assertEquals(24, CharacterUtils.computeRunningMovement(6));
        assertEquals(28, CharacterUtils.computeRunningMovement(7));
        assertEquals(48, CharacterUtils.computeRunningMovement(12));
        assertEquals(68, CharacterUtils.computeRunningMovement(17));
        assertEquals(76, CharacterUtils.computeRunningMovement(19));
        assertEquals(80, CharacterUtils.computeRunningMovement(20));
        assertEquals(86, CharacterUtils.computeRunningMovement(21));
        assertEquals(92, CharacterUtils.computeRunningMovement(22));
        assertEquals(122, CharacterUtils.computeRunningMovement(27));
        assertEquals(128, CharacterUtils.computeRunningMovement(28));
        assertEquals(134, CharacterUtils.computeRunningMovement(29));
        assertEquals(140, CharacterUtils.computeRunningMovement(30));
    }

    public void testComputeLiftingCapacity()
    {
        assertEquals(5, CharacterUtils.computeLiftingCapacity(1));
        assertEquals(15, CharacterUtils.computeLiftingCapacity(3));
        assertEquals(30, CharacterUtils.computeLiftingCapacity(6));
        assertEquals(40, CharacterUtils.computeLiftingCapacity(7));
        assertEquals(80, CharacterUtils.computeLiftingCapacity(11));
        assertEquals(95, CharacterUtils.computeLiftingCapacity(12));
        assertEquals(140, CharacterUtils.computeLiftingCapacity(15));
        assertEquals(160, CharacterUtils.computeLiftingCapacity(16));
        assertEquals(200, CharacterUtils.computeLiftingCapacity(18));
        assertEquals(230, CharacterUtils.computeLiftingCapacity(19));
        assertEquals(290, CharacterUtils.computeLiftingCapacity(21));
        assertEquals(330, CharacterUtils.computeLiftingCapacity(22));
        assertEquals(410, CharacterUtils.computeLiftingCapacity(24));
        assertEquals(460, CharacterUtils.computeLiftingCapacity(25));
        assertEquals(560, CharacterUtils.computeLiftingCapacity(27));
        assertEquals(620, CharacterUtils.computeLiftingCapacity(28));
        assertEquals(740, CharacterUtils.computeLiftingCapacity(30));
    }

    public void testComputeCarryingCapacity()
    {
        assertEquals(3, CharacterUtils.computeCarryingCapacity(1));
        assertEquals(8, CharacterUtils.computeCarryingCapacity(3));
        assertEquals(15, CharacterUtils.computeCarryingCapacity(6));
        assertEquals(20, CharacterUtils.computeCarryingCapacity(7));
        assertEquals(40, CharacterUtils.computeCarryingCapacity(11));
        assertEquals(48, CharacterUtils.computeCarryingCapacity(12));
        assertEquals(70, CharacterUtils.computeCarryingCapacity(15));
        assertEquals(80, CharacterUtils.computeCarryingCapacity(16));
        assertEquals(100, CharacterUtils.computeCarryingCapacity(18));
        assertEquals(115, CharacterUtils.computeCarryingCapacity(19));
        assertEquals(145, CharacterUtils.computeCarryingCapacity(21));
        assertEquals(165, CharacterUtils.computeCarryingCapacity(22));
        assertEquals(205, CharacterUtils.computeCarryingCapacity(24));
        assertEquals(230, CharacterUtils.computeCarryingCapacity(25));
        assertEquals(280, CharacterUtils.computeCarryingCapacity(27));
        assertEquals(310, CharacterUtils.computeCarryingCapacity(28));
        assertEquals(370, CharacterUtils.computeCarryingCapacity(30));
    }

    public void testGetWeapons()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);
        elfe.setMainDiscipline(Disciplines.Forgeron, 1);
        elfe.addEquipment(EquipmentManager.getWeaponList().get(0));
        elfe.addEquipment(EquipmentManager.getArmorList().get(0));
        elfe.addEquipment(EquipmentManager.getDefensesList().get(0));

        // Test
        final List<IEquipment> weapons = CharacterUtils.getWeapons(elfe);

        // Assert
        assertTrue(weapons != null && weapons.size() == 1);
        assertEquals(EquipmentManager.getWeaponList().get(0), weapons.get(0));
    }

    public void testGetMaxKarma()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        // Test 1
        elfe.setMainDiscipline(Disciplines.Forgeron, 1);
        assertEquals(25, CharacterUtils.getMaxKarma(elfe));

        // Test 2
        elfe.setMainDiscipline(Disciplines.Forgeron, 15);
        assertEquals(50, CharacterUtils.getMaxKarma(elfe));

        // Test 3
        elfe.addPermanentMod(Mod.get(Pointcuts.KARMA_POINTS, 5));
        assertEquals(55, CharacterUtils.getMaxKarma(elfe));

        // Test 4
        final List<List<Mod>> bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.KARMA_POINTS, 10)));
        final MagicalEquipment ring = new MagicalEquipment("Kelnone", bonuses, new int[] {200});
        ring.incrementRank();
        elfe.addEquipment(ring);
        assertEquals(65, CharacterUtils.getMaxKarma(elfe));
    }

    public void testComputePerks()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 4);
        assertTrue(CharacterUtils.computePerks(elfe, Pointcuts.KARMA_USE, Attributes.DEX) == 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 5);
        assertTrue(CharacterUtils.computePerks(elfe, Pointcuts.KARMA_USE, Attributes.DEX) == 1);

        elfe.setMainDiscipline(Disciplines.Forgeron, 10);
        elfe.setSecondDiscipline(Disciplines.Elementaliste, 9);
        elfe.setThirdDiscipline(Disciplines.MaitreAnimaux, 8);
        assertTrue(CharacterUtils.computePerks(elfe, Pointcuts.KARMA_USE, Attributes.VOL) == 3);
    }

    public void testMaxKarmaBuyable()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 6);
        Discipline discipline = elfe.getMainDiscipline();
        List<Talent> talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(5), 3); // RituelKarma

        assertTrue(elfe.getAvailableKarma() < 10);
        assertTrue(CharacterUtils.getMaxKarma(elfe) == 25);


        // Test 1 : restriction on legend points
        assertEquals(0, elfe.getLegendPoints());
        assertEquals(0, CharacterUtils.maxKarmaBuyable(elfe));
        assertFalse(CharacterUtils.canBuyKarma(elfe));

        elfe.incrementLegendPoints(10);
        assertEquals(1, CharacterUtils.maxKarmaBuyable(elfe));
        assertTrue(CharacterUtils.canBuyKarma(elfe));

        // Test 2 : restriction on talent Rituel Karma
        elfe.incrementLegendPoints(5000);
        assertEquals(3, CharacterUtils.maxKarmaBuyable(elfe));
        assertTrue(CharacterUtils.canBuyKarma(elfe));

        discipline.setTalentRank(talents.get(5), 10); // RituelKarma
        assertEquals(10, CharacterUtils.maxKarmaBuyable(elfe));
        assertTrue(CharacterUtils.canBuyKarma(elfe));

        // Test 3 : restriction on max karma allowed
        elfe.incrementKarmaBought(CharacterUtils.getMaxKarma(elfe) - elfe.getAvailableKarma() - 3);
        assertEquals(3, CharacterUtils.maxKarmaBuyable(elfe));
        assertTrue(CharacterUtils.canBuyKarma(elfe));

        elfe.incrementKarmaBought(1);
        assertEquals(2, CharacterUtils.maxKarmaBuyable(elfe));
        assertTrue(CharacterUtils.canBuyKarma(elfe));

        // Test 4 : Second and third disciplines
        elfe.incrementKarmaSpent(10);

        elfe.setSecondDiscipline(Disciplines.Elementaliste, 6);
        discipline = elfe.getSecondDiscipline();
        talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(1), 11); // RituelKarma

        elfe.setThirdDiscipline(Disciplines.MaitreAnimaux, 6);
        discipline = elfe.getThirdDiscipline();
        talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 12); // RituelKarma

        assertEquals(12, CharacterUtils.maxKarmaBuyable(elfe));
        assertTrue(CharacterUtils.canBuyKarma(elfe));
    }

    public void testComputeInitiativeTest()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);
        elfe.setMainDiscipline(Disciplines.Forgeron, 6);

        // Test 1
        assertEquals("2D6", CharacterUtils.computeInitiativeTest(elfe));

        // Test 2
        elfe.addTempMod(Mod.get(Pointcuts.INIT, 1));
        assertEquals("1D8 + 1D6", CharacterUtils.computeInitiativeTest(elfe));

        // Test 3
        elfe.addTempMod(Mod.get(Pointcuts.INIT_MOD, 2));
        assertEquals("1D8 + 1D6 + 2", CharacterUtils.computeInitiativeTest(elfe));

        // Test 4
        elfe.addOrReplaceTempMod(Mod.get(Pointcuts.INIT_MOD, -2));
        assertEquals("1D8 + 1D6 -2", CharacterUtils.computeInitiativeTest(elfe));
    }

    public void testGetTalent()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 10);
        elfe.setSecondDiscipline(Disciplines.Elementaliste, 9);
        elfe.setThirdDiscipline(Disciplines.MaitreAnimaux, 8);

        assertNull(CharacterUtils.getTalent(elfe, Talents.ArcVent));

        assertNotNull(CharacterUtils.getTalent(elfe, Talents.DetectionDefautsArmure));
        assertNotNull(CharacterUtils.getTalent(elfe, Talents.MatriceAmelioree));
        assertNotNull(CharacterUtils.getTalent(elfe, Talents.DechainementGriffes));


        final Talent talent = CharacterUtils.getTalent(elfe, Talents.DetectionDefautsArmure);
        assertNull(talent.getAdditionnalInfos());
        assertEquals(Attributes.PER, talent.getAttribut());
        assertEquals(R.string.per, talent.getAttribut().getFullName());
        assertEquals("PER", talent.getAttribut().getLabel());
        assertEquals(6, talent.getCircle());
        assertEquals(Talents.DetectionDefautsArmure, talent.getEnum());
        assertEquals(R.string.DetectionDefautsArmure, talent.getName());
        assertEquals(181, talent.getPage());
        assertEquals(0, talent.getStrain());
        assertFalse(talent.isAction());
        assertTrue(talent.isDiscipline());
        assertFalse(talent.isKarmaMandatory());
        assertTrue(talent.isRollable());
    }

    public void testGetTalentRank()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 10);
        final Discipline discipline = elfe.getMainDiscipline();
        final List<Talent> talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 10); // Arme de Melee
        final Talent talent = talents.get(0);

        // Test 1
        assertEquals(10, CharacterUtils.getTalentRank(elfe, Talents.ArmesMelee));
        assertEquals(10, elfe.getTalentRank(talent, discipline));

        // Test 2
        elfe.addPermanentMod(Mod.get(Pointcuts.TALENT, 1, Talents.ArmesMelee));
        assertEquals(10, CharacterUtils.getTalentRank(elfe, Talents.ArmesMelee));
        assertEquals(11, elfe.getTalentRank(talent, discipline));

        // Test 3
        final List<List<Mod>> bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.TALENT, 1, Talents.ArmesMelee)));
        final MagicalEquipment ring = new MagicalEquipment("Kelnone", bonuses, new int[] {200});
        ring.incrementRank();
        elfe.addEquipment(ring);
        assertEquals(10, CharacterUtils.getTalentRank(elfe, Talents.ArmesMelee));
        assertEquals(12, elfe.getTalentRank(talent, discipline));
    }

    public void testKnowsTalent()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 10);

        final Discipline discipline = elfe.getMainDiscipline();
        final List<Talent> talents = discipline.getKnownTalents();
        for (int i = 0; i < 28; i++)
        {
            discipline.setTalentRank(talents.get(i), 10);
        }

        assertFalse(CharacterUtils.knowsTalent(elfe, Talents.ArcVent));
        assertTrue(CharacterUtils.knowsTalent(elfe, Talents.DetectionDefautsArmure));
    }
}
