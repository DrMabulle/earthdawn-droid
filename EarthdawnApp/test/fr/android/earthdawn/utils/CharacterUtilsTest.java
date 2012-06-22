package fr.android.earthdawn.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import fr.android.earthdawn.R;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Attributs;
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

public class CharacterUtilsTest
{
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
    public void testComputeUnconsciousnessThreshold()
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
        Assert.assertTrue(weapons != null && weapons.size() == 1);
        Assert.assertEquals(EquipmentManager.getWeaponList().get(0), weapons.get(0));
    }

    @Test
    public void testGetMaxKarma()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        // Test 1
        elfe.setMainDiscipline(Disciplines.Forgeron, 1);
        Assert.assertEquals(25, CharacterUtils.getMaxKarma(elfe));

        // Test 2
        elfe.setMainDiscipline(Disciplines.Forgeron, 15);
        Assert.assertEquals(50, CharacterUtils.getMaxKarma(elfe));

        // Test 3
        elfe.addPermanentMod(Mod.get(Pointcuts.KARMA_POINTS, 5));
        Assert.assertEquals(55, CharacterUtils.getMaxKarma(elfe));

        // Test 4
        final List<List<Mod>> bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.KARMA_POINTS, 10)));
        final MagicalEquipment ring = new MagicalEquipment("Kelnone", bonuses, new int[] {200});
        ring.incrementRank();
        elfe.addEquipment(ring);
        Assert.assertEquals(65, CharacterUtils.getMaxKarma(elfe));
    }

    @Test
    public void testComputePerks()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 4);
        Assert.assertTrue(CharacterUtils.computePerks(elfe, Pointcuts.KARMA_USE, Attributs.DEX) == 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 5);
        Assert.assertTrue(CharacterUtils.computePerks(elfe, Pointcuts.KARMA_USE, Attributs.DEX) == 1);

        elfe.setMainDiscipline(Disciplines.Forgeron, 10);
        elfe.setSecondDiscipline(Disciplines.Elementaliste, 9);
        elfe.setThirdDiscipline(Disciplines.MaitreAnimaux, 8);
        Assert.assertTrue(CharacterUtils.computePerks(elfe, Pointcuts.KARMA_USE, Attributs.VOL) == 3);
    }

    @Test
    public void testMaxKarmaBuyable()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 6);
        Discipline discipline = elfe.getMainDiscipline();
        List<Talent> talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(5), 3); // RituelKarma

        Assert.assertTrue(elfe.getAvailableKarma() < 10);
        Assert.assertTrue(CharacterUtils.getMaxKarma(elfe) == 25);


        // Test 1 : restriction on legend points
        Assert.assertEquals(0, elfe.getLegendPoints());
        Assert.assertEquals(0, CharacterUtils.maxKarmaBuyable(elfe));
        Assert.assertFalse(CharacterUtils.canBuyKarma(elfe));

        elfe.incrementLegendPoints(10);
        Assert.assertEquals(1, CharacterUtils.maxKarmaBuyable(elfe));
        Assert.assertTrue(CharacterUtils.canBuyKarma(elfe));

        // Test 2 : restriction on talent Rituel Karma
        elfe.incrementLegendPoints(5000);
        Assert.assertEquals(3, CharacterUtils.maxKarmaBuyable(elfe));
        Assert.assertTrue(CharacterUtils.canBuyKarma(elfe));

        discipline.setTalentRank(talents.get(5), 10); // RituelKarma
        Assert.assertEquals(10, CharacterUtils.maxKarmaBuyable(elfe));
        Assert.assertTrue(CharacterUtils.canBuyKarma(elfe));

        // Test 3 : restriction on max karma allowed
        elfe.incrementKarmaBought(CharacterUtils.getMaxKarma(elfe) - elfe.getAvailableKarma() - 3);
        Assert.assertEquals(3, CharacterUtils.maxKarmaBuyable(elfe));
        Assert.assertTrue(CharacterUtils.canBuyKarma(elfe));

        elfe.incrementKarmaBought(1);
        Assert.assertEquals(2, CharacterUtils.maxKarmaBuyable(elfe));
        Assert.assertTrue(CharacterUtils.canBuyKarma(elfe));

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

        Assert.assertEquals(12, CharacterUtils.maxKarmaBuyable(elfe));
        Assert.assertTrue(CharacterUtils.canBuyKarma(elfe));
    }

    @Test
    public void testComputeInitiativeTest()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);
        elfe.setMainDiscipline(Disciplines.Forgeron, 6);

        // Test 1
        Assert.assertEquals("2D6", CharacterUtils.computeInitiativeTest(elfe));

        // Test 2
        elfe.addTempMod(Mod.get(Pointcuts.INIT, 1));
        Assert.assertEquals("1D8 + 1D6", CharacterUtils.computeInitiativeTest(elfe));

        // Test 3
        elfe.addTempMod(Mod.get(Pointcuts.INIT_MOD, 2));
        Assert.assertEquals("1D8 + 1D6 + 2", CharacterUtils.computeInitiativeTest(elfe));

        // Test 4
        elfe.addOrReplaceTempMod(Mod.get(Pointcuts.INIT_MOD, -2));
        Assert.assertEquals("1D8 + 1D6 -2", CharacterUtils.computeInitiativeTest(elfe));
    }

    @Test
    public void testGetTalent()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 10);
        elfe.setSecondDiscipline(Disciplines.Elementaliste, 9);
        elfe.setThirdDiscipline(Disciplines.MaitreAnimaux, 8);

        Assert.assertNull(CharacterUtils.getTalent(elfe, Talents.ArcVent));

        Assert.assertNotNull(CharacterUtils.getTalent(elfe, Talents.DetectionDefautsArmure));
        Assert.assertNotNull(CharacterUtils.getTalent(elfe, Talents.MatriceAmelioree));
        Assert.assertNotNull(CharacterUtils.getTalent(elfe, Talents.DechainementGriffes));


        final Talent talent = CharacterUtils.getTalent(elfe, Talents.DetectionDefautsArmure);
        Assert.assertNull(talent.getAdditionnalInfos());
        Assert.assertEquals(Attributs.PER, talent.getAttribut());
        Assert.assertEquals(R.string.per, talent.getAttribut().getFullName());
        Assert.assertEquals("PER", talent.getAttribut().getLabel());
        Assert.assertEquals(6, talent.getCircle());
        Assert.assertEquals(Talents.DetectionDefautsArmure, talent.getEnum());
        Assert.assertEquals(R.string.DetectionDefautsArmure, talent.getName());
        Assert.assertEquals(181, talent.getPage());
        Assert.assertEquals(0, talent.getStrain());
        Assert.assertFalse(talent.isAction());
        Assert.assertTrue(talent.isDiscipline());
        Assert.assertFalse(talent.isKarmaMandatory());
        Assert.assertTrue(talent.isRollable());
    }

    @Test
    public void testGetTalentRank()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 10);
        final Discipline discipline = elfe.getMainDiscipline();
        final List<Talent> talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 10); // Arme de Melee
        final Talent talent = talents.get(0);

        // Test 1
        Assert.assertEquals(10, CharacterUtils.getTalentRank(elfe, Talents.ArmesMelee));
        Assert.assertEquals(10, elfe.getTalentRank(talent, discipline));

        // Test 2
        elfe.addPermanentMod(Mod.get(Pointcuts.TALENT, 1, Talents.ArmesMelee));
        Assert.assertEquals(10, CharacterUtils.getTalentRank(elfe, Talents.ArmesMelee));
        Assert.assertEquals(11, elfe.getTalentRank(talent, discipline));

        // Test 3
        final List<List<Mod>> bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.TALENT, 1, Talents.ArmesMelee)));
        final MagicalEquipment ring = new MagicalEquipment("Kelnone", bonuses, new int[] {200});
        ring.incrementRank();
        elfe.addEquipment(ring);
        Assert.assertEquals(10, CharacterUtils.getTalentRank(elfe, Talents.ArmesMelee));
        Assert.assertEquals(12, elfe.getTalentRank(talent, discipline));
    }

    @Test
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

        Assert.assertFalse(CharacterUtils.knowsTalent(elfe, Talents.ArcVent));
        Assert.assertTrue(CharacterUtils.knowsTalent(elfe, Talents.DetectionDefautsArmure));
    }
}
