/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;

import fr.android.earthdawn.R;

/**
 * @author DrMabulle
 *
 */
public enum Races implements Serializable
{
    Elfe("Elfe", 2, 0, -2, 1, 1, 1, 4, 10, 0, 0, 0, 1, R.string.apt1),
    Humain("Humain", 0, 0, 0, 0, 0, 0, 5, 6, 0, 0, 0, 0, R.string.apt3),
    Nain("Nain", 0, 2, 3, 0, 0, -2, 4, 10, 0, 0, 0, -2, R.string.apt2),
    Obsidien("Obsidien", -2, 6, 4, -1, 0, -1, 3, 10, 0, 3, 3, -3, R.string.apt4, R.string.apt5, R.string.apt6),
    Ork("Ork", 0, 3, 1, 0, -2, -1, 5, 7, 0, 0, 0, 1, R.string.apt7, R.string.apt1),
    Sylphelin("Sylphelin", 1, -4, -3, 1, 0, 2, 6, 5, 3, 0, 0, 2, R.string.apt8, R.string.apt9, R.string.apt10, R.string.apt11),
    Troll("Troll", 0, 4, 2, -1, 1, 0, 3, 10, 0, 0, 0, 0, R.string.apt12, R.string.apt13, R.string.apt2),
    Tskrang("T'skrang", 1, 0, 1, 0, 0, 1, 4, 8, 0, 0, 0, 0, R.string.apt14);

    private String name;
    private int bonusDex;
    private int bonusStr;
    private int bonusEnd;
    private int bonusPer;
    private int bonusVol;
    private int bonusCha;
    private int karmaRank;
    private int karmaCost;
    private int bonusPhyDef;
    private int bonusPhyArm;
    private int bonusWound;
    private int bonusMvt;
    private int[] aptitudes;


    /**
     * @param name
     * @param bonusDex
     * @param bonusStr
     * @param bonusEnd
     * @param bonusPer
     * @param bonusVol
     * @param bonusCha
     * @param karmaRank
     */
    private Races(final String name, final int bonusDex, final int bonusStr, final int bonusEnd, final int bonusPer,
            final int bonusVol, final int bonusCha, final int karmaRank, final int karmaCost,
            final int bonusPhyDef, final int bonusPhyArm, final int bonusWound,
            final int bonusMvt, final int... aptitudes)
    {
        this.name = name;
        this.bonusDex = bonusDex;
        this.bonusStr = bonusStr;
        this.bonusEnd = bonusEnd;
        this.bonusPer = bonusPer;
        this.bonusVol = bonusVol;
        this.bonusCha = bonusCha;
        this.karmaRank = karmaRank;
        this.karmaCost = karmaCost;
        this.bonusPhyDef = bonusPhyDef;
        this.bonusPhyArm = bonusPhyArm;
        this.bonusWound = bonusWound;
        this.bonusMvt = bonusMvt;
        this.aptitudes = aptitudes;
    }

    /**
     * @return the name
     */
    public final String getName()
    {
        return name;
    }

    /**
     * @return the bonusDex
     */
    public final int getBonusDex()
    {
        return bonusDex;
    }

    /**
     * @return the bonusStr
     */
    public final int getBonusStr()
    {
        return bonusStr;
    }

    /**
     * @return the bonusEnd
     */
    public final int getBonusEnd()
    {
        return bonusEnd;
    }

    /**
     * @return the bonusPer
     */
    public final int getBonusPer()
    {
        return bonusPer;
    }

    /**
     * @return the bonusVol
     */
    public final int getBonusVol()
    {
        return bonusVol;
    }

    /**
     * @return the bonusCha
     */
    public final int getBonusCha()
    {
        return bonusCha;
    }

    /**
     * @return the karmaRank
     */
    public final int getKarmaRank()
    {
        return karmaRank;
    }

    /**
     * @return the karmaCost
     */
    public int getKarmaCost()
    {
        return karmaCost;
    }

    /**
     * @return the bonusPhyDef
     */
    public final int getBonusPhyDef()
    {
        return bonusPhyDef;
    }

    /**
     * @return the bonusPhyArm
     */
    public final int getBonusPhyArm()
    {
        return bonusPhyArm;
    }

    /**
     * @return the bonusWound
     */
    public final int getBonusWound()
    {
        return bonusWound;
    }


    /**
     * @return the aptitudes
     */
    public int[] getAptitudes()
    {
        return aptitudes;
    }

    /**
     * @return the bonusMvt
     */
    public int getBonusMvt()
    {
        return bonusMvt;
    }

}
