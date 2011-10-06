/**
 * 
 */
package fr.android.earthdawn.character;

/**
 * @author DrMabulle
 *
 */
public enum Races
{
    elf("Elfe", 2, 0, -2, 1, 1, 1, 4, 0, 0, 0),
    humain("Humain", 0, 0, 0, 0, 0, 0, 5, 0, 0, 0),
    nain("Nain", 0, 2, 3, 0, 0, -2, 4, 0, 0, 0),
    obsidien("Obsidien", -2, 6, 4, -1, 0, -1, 3, 0, 3, 3),
    ork("Ork", 0, 3, 1, 0, -2, -1, 5, 0, 0, 0),
    sylphelin("Sylphelin", 1, -4, -3, 1, 0, 2, 6, 3, 0, 0),
    troll("Troll", 0, 4, 2, -1, 1, 0, 3, 0, 0, 0),
    tskrang("T'skrang", 1, 0, 1, 0, 0, 1, 4, 0, 0, 0);

    private String name;
    private int bonusDex;
    private int bonusStr;
    private int bonusEnd;
    private int bonusPer;
    private int bonusVol;
    private int bonusCha;
    private int karmaRank;
    private int bonusPhyDef;
    private int bonusPhyArm;
    private int bonusWound;


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
            final int bonusVol, final int bonusCha, final int karmaRank,
            final int bonusPhyDef, final int bonusPhyArm, final int bonusWound)
    {
        this.name = name;
        this.bonusDex = bonusDex;
        this.bonusStr = bonusStr;
        this.bonusEnd = bonusEnd;
        this.bonusPer = bonusPer;
        this.bonusVol = bonusVol;
        this.bonusCha = bonusCha;
        this.karmaRank = karmaRank;
        this.bonusPhyDef = bonusPhyDef;
        this.bonusPhyArm = bonusPhyArm;
        this.bonusWound = bonusWound;

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

}
