package fr.android.earthdawn.utils;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Attributs;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.equipement.IEquipment;
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

        elfe.setMainDiscipline(Disciplines.Forgeron, 1);
        Assert.assertEquals(25, CharacterUtils.getMaxKarma(elfe));

        elfe.setMainDiscipline(Disciplines.Forgeron, 15);
        Assert.assertEquals(50, CharacterUtils.getMaxKarma(elfe));
    }

    @Test
    public void testComputePerks()
    {
        final EDCharacter elfe = new EDCharacter("elfe", "Mâle", 120, 225, 421, Races.Elfe, 17, 0, 15, 0, 13, 0, 13, 0, 11, 0, 8, 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 4);
        Assert.assertTrue(CharacterUtils.computePerks(elfe, Pointcuts.KARMA_USE, Attributs.DEX) == 0);

        elfe.setMainDiscipline(Disciplines.Forgeron, 5);
        Assert.assertTrue(CharacterUtils.computePerks(elfe, Pointcuts.KARMA_USE, Attributs.DEX) > 0);
    }

}
