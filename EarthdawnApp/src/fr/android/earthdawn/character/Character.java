/**
 *
 */
package fr.android.earthdawn.character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.android.earthdawn.character.enums.Attributs;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.character.equipement.Equipment;
import fr.android.earthdawn.dices.utils.DiceMapping;
import fr.android.earthdawn.managers.EquipmentManager;
import fr.android.earthdawn.managers.RankManager;

/**
 * @author DrMabulle
 *
 */
public class Character implements Serializable
{
    private static final long serialVersionUID = -2501068072861443147L;

    private final String name;
    private final String sex;
    private final int age;
    private final int height;
    private final int weight;

    private final Races race;

    private final Attribut[] attributs = new Attribut[7];

    private Discipline discipline1;
    private Discipline discipline2;
    private Discipline discipline3;

    private final List<Equipment> equipment = new ArrayList<Equipment>(16);
    private final List<Mod> modPerm = new ArrayList<Mod>();
    private final List<Mod> modTmp = new ArrayList<Mod>();

    public Character(final String name, final String sex, final int age, final int height, final int weight,
            final Races race, final int dexInd, final int dexEvol, final int strInd, final int strEvol,
            final int endInd, final int endEvol, final int perInd, final int perEvol, final int volInd,
            final int volEvol, final int chaInd, final int chaEvol)
    {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.race = race;

        // Dextérité
        attributs[Attributs.DEX.getId()] = new Attribut(dexInd + race.getBonusDex(), dexEvol);
        // Force
        attributs[Attributs.STR.getId()] = new Attribut(strInd + race.getBonusStr(), strEvol);
        // Endurance
        attributs[Attributs.END.getId()] = new Attribut(endInd + race.getBonusEnd(), endEvol);
        // Perception
        attributs[Attributs.PER.getId()] = new Attribut(perInd + race.getBonusPer(), perEvol);
        // Velonté
        attributs[Attributs.VOL.getId()] = new Attribut(volInd + race.getBonusVol(), volEvol);
        // Charisme
        attributs[Attributs.CHA.getId()] = new Attribut(chaInd + race.getBonusCha(), chaEvol);
        // Null
        attributs[Attributs.NUL.getId()] = new Attribut(0, 0);
    }

    public Discipline getMainDiscipline()
    {
        return discipline1;
    }
    public Discipline getSecondDiscipline()
    {
        return discipline2;
    }
    public Discipline getThirdDiscipline()
    {
        return discipline3;
    }
    public String getMainDisciplineDisplay()
    {
        return discipline1 != null ? discipline1.getName() : "";
    }
    public String getSecondDisciplineDisplay()
    {
        return discipline2 != null ? discipline2.getName() : "";
    }
    public String getThirdDisciplineDisplay()
    {
        return discipline3 != null ? discipline3.getName() : "";
    }

    public String getMainCircleDisplay()
    {
        return discipline1 != null ? Integer.toString(discipline1.getCircle()) : "";
    }
    public String getSecondCircleDisplay()
    {
        return discipline2 != null ? Integer.toString(discipline2.getCircle()) : "";
    }
    public String getThirdCircleDisplay()
    {
        return discipline3 != null ? Integer.toString(discipline3.getCircle()) : "";
    }

    public boolean setMainDiscipline(final Disciplines discicpline, final int circle)
    {
        if(checkCircle(circle))
        {
            discipline1 = new Discipline(discicpline, circle);
            return true;
        }
        return false;
    }
    public boolean setSecondDiscipline(final Disciplines discicpline, final int circle)
    {
        if(checkCircle(circle) && checkCircles(discipline1.getCircle(), circle))
        {
            discipline2 = new Discipline(discicpline, circle);
            return true;
        }
        return false;
    }
    public boolean setThirdDiscipline(final Disciplines discicpline, final int circle)
    {
        if(checkCircle(circle) && checkCircles(discipline2.getCircle(), circle))
        {
            discipline3 = new Discipline(discicpline, circle);
            return true;
        }
        return false;
    }

    public void addEquipment(final Equipment equip)
    {
        equipment.add(equip);
    }
    public void removeEquipment(final Equipment equip)
    {
        equipment.remove(equip);
    }

    public void addPermanentMod(final Mod modif)
    {
        modPerm.add(modif);
    }
    public void removePermanentMod(final Mod modif)
    {
        modPerm.remove(modif);
    }

    public void addTempMod(final Mod modif)
    {
        modTmp.add(modif);
    }
    public void removeTempMod(final Mod modif)
    {
        modTmp.remove(modif);
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the sex
     */
    public String getSex()
    {
        return sex;
    }

    /**
     * @return the age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * @return the height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * @return the weight
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * @return the race
     */
    public Races getRace()
    {
        return race;
    }

    public int getAttributIndice(final Attributs attribut)
    {
        return attributs[attribut.getId()].getResultingIndice() + computeBonusesInt(attribut);
    }
    public int getAttributEvols(final Attributs attribut)
    {
        return attributs[attribut.getId()].getEvol();
    }
    public int getAttributRank(final Attributs attribut)
    {
        return RankManager.getRank(getAttributIndice(attribut));
    }



    public int getPhysicalDefense()
    {
        return computeIndiceDefense(getAttributIndice(Attributs.DEX)) + race.getBonusPhyDef() + computeBonusesInt(Pointcuts.DEF_PHY);
    }
    public int getMagicalDefense()
    {
        return computeIndiceDefense(getAttributIndice(Attributs.PER)) + computeBonusesInt(Pointcuts.DEF_MAG);
    }
    public int getSocialDefense()
    {
        return computeIndiceDefense(getAttributIndice(Attributs.CHA)) + computeBonusesInt(Pointcuts.DEF_SOC);
    }
    public int getMysticArmor()
    {
        return computeMysticArmor(getAttributIndice(Attributs.VOL)) + computeBonusesInt(Pointcuts.ARM_MYS);
    }
    public int getPhysicalArmor()
    {
        return computeBonusesInt(Pointcuts.ARM_PHY);
    }

    protected int getDeathThreshold()
    {
        return computeDeathThreshold(getAttributIndice(Attributs.END));
    }

    protected int getUnconsciousnessThreshold()
    {
        return computeUnconsciousnessThreshold(getAttributIndice(Attributs.END));
    }

    public int getWoundThreshold()
    {
        return computeWoundThreshold(getAttributIndice(Attributs.END)) + race.getBonusWound() + computeBonusesInt(Pointcuts.WOUND_THRESHOLD);
    }

    public int getLiftingCapacity()
    {
        return computeLiftingCapacity(getAttributIndice(Attributs.STR));
    }

    public int getCarryingCapacity()
    {
        return computeCarryingCapacity(getAttributIndice(Attributs.STR));
    }

    public int getRunningMouvement()
    {
        return computeRunningMouvement(getAttributIndice(Attributs.DEX) + race.getBonusMvt());
    }

    public int getCombatMouvement()
    {
        return computeCombatMouvement(getAttributIndice(Attributs.DEX) + race.getBonusMvt());
    }

    public int getInitiativeLevel()
    {
        return getAttributRank(Attributs.DEX) + computeBonusesInt(Pointcuts.INIT);
    }

    public int getTalentLevel(final Talent talent, final Discipline discipline)
    {
        return getAttributRank(talent.getAttribut()) + getTalentRank(talent, discipline);
    }
    public int getTalentRank(final Talent talent, final Discipline discipline)
    {
        return discipline.getTalentRank(talent) + computeBonusesInt(talent.getEnum());
    }
    public void incrementTalentRank(final Talent talent, final Discipline discipline)
    {
        discipline.incrementTalentRank(talent);
    }


    protected static int computeDeathThreshold(final int indice)
    {
        return (int) (indice + 18 + Math.ceil(indice / 3));
    }

    protected static int computeUnconsciousnessThreshold(final int indice)
    {
        return (int) (indice + 9 + Math.ceil(indice / 3) + Math.ceil((indice - 1) / 10));
    }

    protected static int computeWoundThreshold(final int indice)
    {
        return (int) Math.ceil(indice / 2.0 + 2.5 - Math.ceil((indice + 1) / 22) / 2.0 - Math.ceil(indice / 27) / 2.0);
    }

    protected static int computeIndiceDefense(final int indice)
    {
        return (int) Math.ceil(indice / 2.0 + 1.5 - Math.ceil((indice + 1) / 7) / 2.0);
    }

    protected static int computeMysticArmor(final int indice)
    {
        return (int) Math.ceil(Math.max(indice - 10, 0)  / 3.0);
    }

    protected static int computeCarryingCapacity(final int indice)
    {
        return (int) Math.ceil(computeLiftingCapacity(indice) / 2.0);
    }

    protected static int computeLiftingCapacity(final int indice)
    {
        if (indice <= 6)
        {
            return 5 * indice;
        }
        else if (indice <= 11)
        {
            return 10 * indice - 30;
        }
        else if (indice <= 15)
        {
            return 15 * indice - 85;
        }
        else if (indice <= 18)
        {
            return 20 * indice - 160;
        }
        else if (indice <= 21)
        {
            return 30 * indice - 340;
        }
        else if (indice <= 24)
        {
            return 40 * indice - 550;
        }
        else if (indice <= 27)
        {
            return 50 * indice - 790;
        }
        else
        {
            return 60 * indice - 1060;
        }
    }

    protected static int computeRunningMouvement(final int indice)
    {
        return computeCombatMouvement(indice) * 2;
    }
    protected static int computeCombatMouvement(final int indice)
    {
        if (indice < 6)
        {
            return indice + 5;
        }
        else if (indice < 21)
        {
            return indice * 2;
        }
        else
        {
            return indice * 3 - 20;
        }
    }

    public int computeBonusesInt(final Attributs attribut)
    {
        return (int) EquipmentManager.computeMods(equipment, modPerm, modTmp, Pointcuts.ATTRIBUT, attribut);
    }
    public int computeBonusesInt(final Talents talent)
    {
        return (int) EquipmentManager.computeMods(equipment, modPerm, modTmp, Pointcuts.TALENT, talent);
    }
    public int computeBonusesInt(final Pointcuts pointcut)
    {
        return (int) EquipmentManager.computeMods(equipment, modPerm, modTmp, pointcut);
    }

    protected static boolean checkCircle(final int circle)
    {
        // Circle must be between 1 and 15
        return circle > 0 && circle < 16;
    }

    protected static boolean checkCircles(final int circle1, final int circle2)
    {
        // Both circles must be correct and circle1 must be greater than or equal to circle 2
        return checkCircle(circle1)&& checkCircle(circle2) && circle2<=circle1;
    }

    public int getHealthPoints()
    {
        final Talent endurance = discipline1.findTalent(Talents.Endurance);
        return getDeathThreshold() + (Integer) endurance.getAdditionnalInfos()[0] * getTalentRank(endurance, discipline1) + computeBonusesInt(Pointcuts.HEALTH_POINTS);
    }

    public int getUnconsciousnessPoints()
    {
        final Talent endurance = discipline1.findTalent(Talents.Endurance);
        return getUnconsciousnessThreshold() + (Integer) endurance.getAdditionnalInfos()[1] * getTalentRank(endurance, discipline1) + computeBonusesInt(Pointcuts.UNCOUNSCIOUSNESS_THRESHOLD);
    }

    public String getRecoveryDices()
    {
        return DiceMapping.getDicesToThrow(getAttributRank(Attributs.END) + computeBonusesInt(Pointcuts.RECOVERY_LVL));
    }

    public double getNbRecoveryTests()
    {
        // 1 et 2 : 0.5
        // 3 - 7 : 1
        // 8 - 13 : 2
        // 14 - 19 : 3
        // 20+ : 4
        // + bonus
        final int results = computeBonusesInt(Pointcuts.RECOVERY_TESTS);
        final int endIndice = getAttributIndice(Attributs.END);
        if (endIndice < 3)
        {
            return results + 0.5;
        }
        else if (endIndice < 8)
        {
            return results + 1;
        }
        else if (endIndice < 14)
        {
            return results + 2;
        }
        else if (endIndice < 20)
        {
            return results + 3;
        }
        return results + 4;
    }
}
