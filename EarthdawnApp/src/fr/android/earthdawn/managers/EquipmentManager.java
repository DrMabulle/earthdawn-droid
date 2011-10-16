/**
 *
 */
package fr.android.earthdawn.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.android.earthdawn.character.enums.Attributs;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.character.equipement.Equipment;

/**
 * @author DrMabulle
 *
 */
public class EquipmentManager
{
    private static List<Equipment> weapons = null;
    private static List<Equipment> armors = null;

    public static List<Equipment> getWeaponList()
    {
        if (weapons == null)
        {
            weapons = initWeapons();
        }
        return weapons;
    }
    public static List<Equipment> getArmorList()
    {
        if (armors == null)
        {
            armors = initArmors();
        }
        return armors;
    }

    private static List<Equipment> initWeapons()
    {
        final List<Equipment> weap = new ArrayList<Equipment>();
        weap.add(new Equipment("Arme d'Hast", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 7), new Mod(Pointcuts.WEIGHT, 4))));
        weap.add(new Equipment("Bâton", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 2), new Mod(Pointcuts.WEIGHT, 2))));
        weap.add(new Equipment("Couteau", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 1), new Mod(Pointcuts.WEIGHT, 0.25))));
        weap.add(new Equipment("Dague", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 2), new Mod(Pointcuts.WEIGHT, 0.5))));
        weap.add(new Equipment("Epée à deux mains", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 7), new Mod(Pointcuts.WEIGHT, 3))));
        weap.add(new Equipment("Epée courte", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 4), new Mod(Pointcuts.WEIGHT, 1.5))));
        weap.add(new Equipment("Epée large", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 5), new Mod(Pointcuts.WEIGHT, 1.5))));
        weap.add(new Equipment("Epée naine", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 3), new Mod(Pointcuts.WEIGHT, 1))));
        weap.add(new Equipment("Epée trolle", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 6), new Mod(Pointcuts.WEIGHT, 2.5))));
        weap.add(new Equipment("Fléau", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 5), new Mod(Pointcuts.WEIGHT, 2))));
        weap.add(new Equipment("Fouet", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 3), new Mod(Pointcuts.WEIGHT, 0.5))));
        weap.add(new Equipment("Grande hache d'armes", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 8), new Mod(Pointcuts.WEIGHT, 4.5))));
        weap.add(new Equipment("Hache d'armes", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 6), new Mod(Pointcuts.WEIGHT, 2.5))));
        weap.add(new Equipment("Hache des cavernes", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 7), new Mod(Pointcuts.WEIGHT, 4.5))));
        weap.add(new Equipment("Hachette", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 4), new Mod(Pointcuts.WEIGHT, 1.5))));
        weap.add(new Equipment("Lance", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 4), new Mod(Pointcuts.WEIGHT, 1.5))));
        weap.add(new Equipment("Lance de cavalerie", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 6), new Mod(Pointcuts.WEIGHT, 4.5))));
        weap.add(new Equipment("Lance longue", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 5), new Mod(Pointcuts.WEIGHT, 3))));
        weap.add(new Equipment("Marteau de guerre", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 7), new Mod(Pointcuts.WEIGHT, 3.5))));
        weap.add(new Equipment("Masse", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 4), new Mod(Pointcuts.WEIGHT, 2))));
        weap.add(new Equipment("Masse d'armes", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 6), new Mod(Pointcuts.WEIGHT, 3))));
        weap.add(new Equipment("Massue", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 3), new Mod(Pointcuts.WEIGHT, 1.5))));
        weap.add(new Equipment("Matraque", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 1), new Mod(Pointcuts.WEIGHT, 0.25))));
        weap.add(new Equipment("Trident", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 5), new Mod(Pointcuts.WEIGHT, 1.5))));
        return weap;
    }
    private static List<Equipment> initArmors()
    {
        final List<Equipment> arm = new ArrayList<Equipment>();
        arm.add(new Equipment("Armure de cristal vivant", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 6), new Mod(Pointcuts.ARM_MYS, 3), new Mod(Pointcuts.INIT, -2), new Mod(Pointcuts.WEIGHT, 0), new Mod(Pointcuts.BLOOD_MAGIC, 5))));
        arm.add(new Equipment("Armure de cuir", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 3), new Mod(Pointcuts.ARM_MYS, 0), new Mod(Pointcuts.INIT, 0), new Mod(Pointcuts.WEIGHT, 6))));
        arm.add(new Equipment("Armure de cuir bouilli", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 5), new Mod(Pointcuts.ARM_MYS, 0), new Mod(Pointcuts.INIT, -1), new Mod(Pointcuts.WEIGHT, 10))));
        arm.add(new Equipment("Armure de cuir rembouré", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 4), new Mod(Pointcuts.ARM_MYS, 0), new Mod(Pointcuts.INIT, 0), new Mod(Pointcuts.WEIGHT, 10))));
        arm.add(new Equipment("Armure de peau", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 5), new Mod(Pointcuts.ARM_MYS, 1), new Mod(Pointcuts.INIT, -1), new Mod(Pointcuts.WEIGHT, 11))));
        arm.add(new Equipment("Armure de peau vivante", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 4), new Mod(Pointcuts.ARM_MYS, 4), new Mod(Pointcuts.INIT, -1), new Mod(Pointcuts.WEIGHT, 0), new Mod(Pointcuts.BLOOD_MAGIC, 4))));
        arm.add(new Equipment("Armure de plaques", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 9), new Mod(Pointcuts.ARM_MYS, 0), new Mod(Pointcuts.INIT, -4), new Mod(Pointcuts.WEIGHT, 30))));
        arm.add(new Equipment("Armure de plaques en cristal", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 7), new Mod(Pointcuts.ARM_MYS, 7), new Mod(Pointcuts.INIT, -5), new Mod(Pointcuts.WEIGHT, 40))));
        arm.add(new Equipment("Cape en écailles d'Espagra", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 3), new Mod(Pointcuts.ARM_MYS, 1), new Mod(Pointcuts.INIT, -1), new Mod(Pointcuts.WEIGHT, 5))));
        arm.add(new Equipment("Cotte de mailles", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 7), new Mod(Pointcuts.ARM_MYS, 0), new Mod(Pointcuts.INIT, -3), new Mod(Pointcuts.WEIGHT, 18))));
        arm.add(new Equipment("Ecorce", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 3), new Mod(Pointcuts.ARM_MYS, 3), new Mod(Pointcuts.INIT, -2), new Mod(Pointcuts.WEIGHT, 10))));
        arm.add(new Equipment("Galets de sang", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 5), new Mod(Pointcuts.ARM_MYS, 3), new Mod(Pointcuts.INIT, -1), new Mod(Pointcuts.WEIGHT, 0), new Mod(Pointcuts.BLOOD_MAGIC, 4))));
        arm.add(new Equipment("Haubert d'anneaux", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 6), new Mod(Pointcuts.ARM_MYS, 0), new Mod(Pointcuts.INIT, -2), new Mod(Pointcuts.WEIGHT, 14))));
        arm.add(new Equipment("Jaseran de cristal", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 4), new Mod(Pointcuts.ARM_MYS, 4), new Mod(Pointcuts.INIT, -2), new Mod(Pointcuts.WEIGHT, 16))));
        arm.add(new Equipment("Peau de Wyvern", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 8), new Mod(Pointcuts.ARM_MYS, 1), new Mod(Pointcuts.INIT, -3), new Mod(Pointcuts.WEIGHT, 22))));
        arm.add(new Equipment("Peau d'Obsidien", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 3), new Mod(Pointcuts.ARM_MYS, 1), new Mod(Pointcuts.INIT, 0), new Mod(Pointcuts.WEIGHT, 10))));
        arm.add(new Equipment("Tresselière", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 2), new Mod(Pointcuts.ARM_MYS, 3), new Mod(Pointcuts.INIT, 0), new Mod(Pointcuts.WEIGHT, 7))));
        arm.add(new Equipment("Vêtement rembourré", Arrays.asList(new Mod(Pointcuts.ARM_PHY, 2), new Mod(Pointcuts.ARM_MYS, 0), new Mod(Pointcuts.INIT, 0), new Mod(Pointcuts.WEIGHT, 2))));
        return arm;
    }

    @SuppressWarnings("rawtypes")
    public static double computeMods(final List<Equipment> equipment, final List<Mod> permMod, final List<Mod> tmpMod,
            final Pointcuts pointcut, final Enum... additionnalInfos)
    {
        double result = 0.0;

        for (final Equipment equip : equipment)
        {
            for (final Mod mod : equip.getBonuses())
            {
                result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
            }
        }
        for (final Mod mod : permMod)
        {
            result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
        }
        for (final Mod mod : tmpMod)
        {
            result = incrementIfEqual(pointcut, result, mod, additionnalInfos);
        }

        return result;
    }

    @SuppressWarnings("rawtypes")
    protected static double incrementIfEqual(final Pointcuts pointcut, double result, final Mod mod, final Enum... additionnalInfos)
    {
        if (pointcut.equals(mod.getPointcut()))
        {
            // Attributs
            if (Pointcuts.ATTRIBUT.equals(pointcut))
            {
                if(((Attributs) additionnalInfos[0]).equals(mod.getOtherInfos()[0]))
                {
                    result += mod.getModificator();
                }
            }

            // Talents
            else if (Pointcuts.TALENT.equals(pointcut))
            {
                if (((Talents) additionnalInfos[0]).equals(mod.getOtherInfos()[0]))
                {
                    result += mod.getModificator();
                }
            }

            // Others
            else
            {
                result += mod.getModificator();
            }
        }
        return result;
    }
}
