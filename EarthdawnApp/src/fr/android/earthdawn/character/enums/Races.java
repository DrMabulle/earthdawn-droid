/**
 *
 */
package fr.android.earthdawn.character.enums;

import fr.android.earthdawn.R;

/**
 * @author DrMabulle
 *
 */
public enum Races
{
    Elfe("Elfe", 2, 0, -2, 1, 1, 1, 4, 6, 25, 0, 0, 0, 1, R.string.apt1),
    Humain("Humain", 0, 0, 0, 0, 0, 0, 5, 10, 40, 0, 0, 0, 0, R.string.apt3),
    Nain("Nain", 0, 2, 3, 0, 0, -2, 4, 6, 25, 0, 0, 0, -2, R.string.apt2),
    Obsidien("Obsidien", -2, 6, 4, -1, 0, -1, 3, 5, 20, 0, 3, 3, -3, R.string.apt4, R.string.apt5, R.string.apt6),
    Ork("Ork", 0, 3, 1, 0, -2, -1, 5, 10, 40, 0, 0, 0, 1, R.string.apt7, R.string.apt1),
    Sylphelin("Sylphelin", 1, -4, -3, 1, 0, 2, 6, 15, 60, 3, 0, 0, 2, R.string.apt8, R.string.apt9, R.string.apt10, R.string.apt11),
    Troll("Troll", 0, 4, 2, -1, 1, 0, 3, 5, 20, 0, 0, 0, 0, R.string.apt12, R.string.apt13, R.string.apt2),
    Tskrang("T'skrang", 1, 0, 1, 0, 0, 1, 4, 6, 25, 0, 0, 0, 0, R.string.apt14);

    private String name;
    private int bonusDex;
    private int bonusStr;
    private int bonusEnd;
    private int bonusPer;
    private int bonusVol;
    private int bonusCha;
    private int karmaRank;
    private int karmaInit;
    private int karmaMax;
    private int bonusPhyDef;
    private int bonusPhyArm;
    private int bonusWound;
    private int bonusMvt;
    private int[] aptitudes;


    /**
     * @param aName
     * @param aBonusDex
     * @param aBonusStr
     * @param aBonusEnd
     * @param aBonusPer
     * @param aBonusVol
     * @param aBonusCha
     * @param aKarmaRank
     */
    private Races(final String aName, final int aBonusDex, final int aBonusStr, final int aBonusEnd, final int aBonusPer,
            final int aBonusVol, final int aBonusCha, final int aKarmaRank, final int aKarmaInit, final int aKarmaMax,
            final int aBonusPhyDef, final int aBonusPhyArm, final int aBonusWound,
            final int aBonusMvt, final int... aAptitudes)
    {
        this.name = aName;
        this.bonusDex = aBonusDex;
        this.bonusStr = aBonusStr;
        this.bonusEnd = aBonusEnd;
        this.bonusPer = aBonusPer;
        this.bonusVol = aBonusVol;
        this.bonusCha = aBonusCha;
        this.karmaRank = aKarmaRank;
        this.karmaInit = aKarmaInit;
        this.karmaMax = aKarmaMax;
        this.bonusPhyDef = aBonusPhyDef;
        this.bonusPhyArm = aBonusPhyArm;
        this.bonusWound = aBonusWound;
        this.bonusMvt = aBonusMvt;
        this.aptitudes = aAptitudes;
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
     * @return the karmaMax
     */
    public int getKarmaMax()
    {
        return karmaMax;
    }

    /**
     * @return the karmaInit
     */
    public int getKarmaInit()
    {
        return karmaInit;
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
