/**
 *
 */
package fr.android.earthdawn.character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import fr.android.earthdawn.character.enums.Attributs;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Skill;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.character.equipement.IEquipment;
import fr.android.earthdawn.dices.utils.DiceMapping;
import fr.android.earthdawn.managers.EquipmentManager;
import fr.android.earthdawn.managers.RankManager;
import fr.android.earthdawn.utils.CharacterUtils;
import fr.android.earthdawn.utils.NumberUtils;

/**
 * @author DrMabulle
 *
 */
public class EDCharacter implements Serializable
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

    private final List<Skill> skills = new ArrayList<Skill>(6);

    private final List<IEquipment> equipment = new ArrayList<IEquipment>(16);
    private final List<Mod> modPerm = new ArrayList<Mod>();
    private final List<Mod> modTmp = new ArrayList<Mod>();

    private int wounds = 0;
    private int damages = 0;
    private int strain = 0;

    public EDCharacter(final String name, final String sex, final int age, final int height, final int weight,
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

    public List<Skill> getSkills()
    {
        return Collections.unmodifiableList(skills);
    }
    public void addSkill(final Skill skill)
    {
        skills.add(skill);
    }

    /**
     * Get the list of possessions
     * @return a read-only list of Equipment
     */
    public List<IEquipment> getEquipment()
    {
        return Collections.unmodifiableList(equipment);
    }
    public void addEquipment(final IEquipment equip)
    {
        equipment.add(equip);
    }
    public void removeEquipment(final IEquipment equip)
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
    public List<Mod> getPermanentMods()
    {
        return Collections.unmodifiableList(modPerm);
    }

    public void addTempMod(final Mod modif)
    {
        modTmp.add(modif);
    }
    public void addOrReplaceTempMod(final Mod modif)
    {
        final Iterator<Mod> iter = modTmp.iterator();
        while (iter.hasNext())
        {
            final Mod mod = iter.next();
            if (mod.getPointcut().equals(modif.getPointcut()) && Arrays.deepEquals(mod.getOtherInfos(), modif.getOtherInfos()))
            {
                modTmp.remove(mod);
                break;
            }
        }
        modTmp.add(modif);
    }
    public void removeTempMod(final Mod modif)
    {
        modTmp.remove(modif);
    }
    public List<Mod> getTempMods()
    {
        return Collections.unmodifiableList(modTmp);
    }
    public Mod getTempMod(final Pointcuts pointcut)
    {
        for (final Mod mod : modTmp)
        {
            if (mod.getPointcut().equals(pointcut))
            {
                return mod;
            }
        }
        return null;
    }

    public int getWounds()
    {
        return wounds;
    }
    public int incrementWounds(final int nbWounds)
    {
        wounds += nbWounds;
        // ensure minimum of 0
        wounds = NumberUtils.ensureMinimum(wounds, 0);
        return wounds;
    }

    public int getDamages()
    {
        return damages;
    }
    public int incrementDamages(final int nbDamages)
    {
        damages += nbDamages;
        // ensure minimum of 0
        damages = NumberUtils.ensureMinimum(damages, 0);
        return damages;
    }

    public int getStrain()
    {
        return strain;
    }
    public int incrementStrain(final int nbStrain)
    {
        strain += nbStrain;
        // ensure minimum of 0
        strain = NumberUtils.ensureMinimum(strain, 0);
        return strain;
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
        return CharacterUtils.computeIndiceDefense(getAttributIndice(Attributs.DEX)) + race.getBonusPhyDef() + computeBonusesInt(Pointcuts.DEF_PHY);
    }
    public int getMagicalDefense()
    {
        return CharacterUtils.computeIndiceDefense(getAttributIndice(Attributs.PER)) + computeBonusesInt(Pointcuts.DEF_MAG);
    }
    public int getSocialDefense()
    {
        return CharacterUtils.computeIndiceDefense(getAttributIndice(Attributs.CHA)) + computeBonusesInt(Pointcuts.DEF_SOC);
    }
    public int getMysticArmor()
    {
        return CharacterUtils.computeMysticArmor(getAttributIndice(Attributs.VOL)) + computeBonusesInt(Pointcuts.ARM_MYS);
    }
    public int getPhysicalArmor()
    {
        return computeBonusesInt(Pointcuts.ARM_PHY) + race.getBonusPhyArm();
    }

    protected int getDeathThreshold()
    {
        return CharacterUtils.computeDeathThreshold(getAttributIndice(Attributs.END));
    }

    protected int getUnconsciousnessThreshold()
    {
        return CharacterUtils.computeUnconsciousnessThreshold(getAttributIndice(Attributs.END));
    }

    public int getWoundThreshold()
    {
        return CharacterUtils.computeWoundThreshold(getAttributIndice(Attributs.END)) + race.getBonusWound() + computeBonusesInt(Pointcuts.WOUND_THRESHOLD);
    }

    public int getLiftingCapacity()
    {
        return CharacterUtils.computeLiftingCapacity(getAttributIndice(Attributs.STR));
    }

    public int getCarryingCapacity()
    {
        return CharacterUtils.computeCarryingCapacity(getAttributIndice(Attributs.STR));
    }

    public int getRunningMouvement()
    {
        return CharacterUtils.computeRunningMouvement(getAttributIndice(Attributs.DEX) + race.getBonusMvt());
    }

    public int getCombatMouvement()
    {
        return CharacterUtils.computeCombatMouvement(getAttributIndice(Attributs.DEX) + race.getBonusMvt());
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
        return getTalentRankNoWounds(talent, discipline) - wounds;
    }
    private int getTalentRankNoWounds(final Talent talent, final Discipline discipline)
    {
        return discipline.getTalentRank(talent) + computeBonusesInt(talent.getEnum());
    }
    public void incrementTalentRank(final Talent talent, final Discipline discipline)
    {
        discipline.incrementTalentRank(talent);
    }

    public int getSkillLevel(final Skill skill)
    {
        return getAttributRank(skill.getAttribut()) + skill.getRank();
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
        return getDeathThreshold() + (Integer) endurance.getAdditionnalInfos()[0] * getTalentRankNoWounds(endurance, discipline1) + computeBonusesInt(Pointcuts.HEALTH_POINTS);
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
