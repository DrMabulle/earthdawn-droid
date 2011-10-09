/**
 *
 */
package fr.android.earthdawn.character;

import java.io.Serializable;

import fr.android.earthdawn.character.enums.Attributs;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Talents;

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

    /**
     * @return the attribut
     */
    public Attribut getAttribut(final Attributs attribut)
    {
        return attributs[attribut.getId()];
    }

    public int getPhysicalDefense()
    {
        return race.getBonusPhyDef() + computeIndiceDefense(attributs[Attributs.DEX.getId()].getResultingIndice());
    }
    public int getMagicalDefense()
    {
        return computeIndiceDefense(attributs[Attributs.PER.getId()].getResultingIndice());
    }
    public int getSocialDefense()
    {
        return computeIndiceDefense(attributs[Attributs.CHA.getId()].getResultingIndice());
    }
    public int getMysticArmor()
    {
        return computeMysticArmor(attributs[Attributs.VOL.getId()].getResultingIndice());
    }

    public int getDeathThreshold()
    {
        return computeDeathThreshold(attributs[Attributs.END.getId()].getResultingIndice());
    }

    public int getUnconsciousnessThreshold()
    {
        return computeUnconsciousnessThreshold(attributs[Attributs.END.getId()].getResultingIndice());
    }

    public int getWoundThreshold()
    {
        return computeWoundThreshold(attributs[Attributs.END.getId()].getResultingIndice()) + race.getBonusWound();
    }

    public int getLiftingCapacity()
    {
        return computeLiftingCapacity(attributs[Attributs.STR.getId()].getResultingIndice());
    }

    public int getCarryingCapacity()
    {
        return computeCarryingCapacity(attributs[Attributs.STR.getId()].getResultingIndice());
    }

    public int getRunningMouvement()
    {
        return computeRunningMouvement(attributs[Attributs.DEX.getId()].getResultingIndice() + race.getBonusMvt());
    }

    public int getCombatMouvement()
    {
        return computeCombatMouvement(attributs[Attributs.DEX.getId()].getResultingIndice() + race.getBonusMvt());
    }

    public int getInitiativeLevel()
    {
        // TODO manage penalities
        return attributs[Attributs.DEX.getId()].getRank();
    }

    public int getTalentRank(final Talents talent)
    {
        return attributs[talent.getAttribut().getId()].getRank(); // XXX + rang du talent
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
        if (indice <= 6) return 5 * indice;
        else if (indice <= 11) return 10 * indice - 30;
        else if (indice <= 15) return 15 * indice - 85;
        else if (indice <= 18) return 20 * indice - 160;
        else if (indice <= 21) return 30 * indice - 340;
        else if (indice <= 24) return 40 * indice - 550;
        else if (indice <= 27) return 50 * indice - 790;
        else return 60 * indice - 1060;
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
}
