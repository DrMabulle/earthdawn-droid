/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;

/**
 * @author DrMabulle
 *
 */
public enum Talents implements Serializable
{
    AbriVegetal("Abri Végétal", Attributs.CHA, true, false, 0, 167),
    AcrobatiesEnSelle("Acrobaties en selle", Attributs.DEX, false, false, 0, 168),
    AffolementTroupeaux("Affolement des troupeaux", Attributs.VOL, true, false, 0, 168),

    Anticipation("Anticipation", Attributs.PER, false, false, 1, 168),
    ArmesJet("Armes de jet", Attributs.DEX, true, false, 0, 168),
    ArmesMelee("Armes de Mélée", Attributs.DEX, true, false, 0, 168),
    ArmesTrait("Armes de Trait", Attributs.DEX, true, false, 0, 168),
    AttaqueAccro("Attaque Accrobatique", Attributs.DEX, true, true, 0, 168),
    AttaquePlongeante("Attaque Plongeante", Attributs.STR, true, false, 1, 168),
    CombatMainsNues("Combat à mains nues", Attributs.DEX, true, false, 0, 168),
    CoupDouble("Coup Double", Attributs.DEX, false, false, 1, 168),
    DanseAir("Danse des airs", Attributs.DEX, false, false, false, 1, 168),
    Envol("Envol", Attributs.DEX, false, false, 1, 168),
    Esquive("Esquive", Attributs.DEX, false, false, 1, 168),
    Incantation("Incantation", Attributs.PER, true, false, 0, 168),
    LectureEcriture("Lecture et Ecriture", Attributs.PER, true, false, 0, 168),
    LectureEcritureMagie("Lecture et Ecriture de la Magie", Attributs.PER, true, false, 0, 168),
    Longevite("Longévité", Attributs.NUL, false, false, false, 0, 168),

    Matrice("Matrice de sort", Attributs.NUL, false, false, false, 0, 168),
    PeauBois("Peau de Bois", Attributs.END, true, false, 0, 168),
    RituelKarmique("Rituel Karmique", Attributs.NUL, true, false, false, 0, 168),
    Tissage("Tissage", Attributs.PER, true, false, 0, 168),



    UltimeSursaut("Ultime sursaut", Attributs.END, false, false, 0, 168),
    VivaciteTigre("Vivacité du Tigre", Attributs.NUL, false, false, false, 1, 168);


    private final Attributs attribut;
    private final int effort;
    private final boolean isAction;
    private final boolean isKarmaMandatory;
    private final boolean isRollable;
    private final String label;
    private final int page;
    /**
     * @param label
     * @param attribut
     * @param isAction
     * @param isKarmaMandatory
     * @param page
     */
    private Talents(final String label, final Attributs attribut,
            final boolean isAction, final boolean isKarmaMandatory, final boolean isRollable,
            final int effort, final int page)
    {
        this.label = label;
        this.attribut = attribut;
        this.isAction = isAction;
        this.isKarmaMandatory = isKarmaMandatory;
        this.isRollable = isRollable;
        this.effort = effort;
        this.page = page;
    }
    /**
     * @param label
     * @param attribut
     * @param isAction
     * @param isKarmaMandatory
     * @param page
     */
    private Talents(final String label, final Attributs attribut,
            final boolean isAction, final boolean isKarmaMandatory,
            final int effort, final int page)
    {
        this.label = label;
        this.attribut = attribut;
        this.isAction = isAction;
        this.isKarmaMandatory = isKarmaMandatory;
        this.isRollable = true;
        this.effort = effort;
        this.page = page;
    }
    /**
     * @return the attribut
     */
    public Attributs getAttribut()
    {
        return attribut;
    }
    /**
     * @return the effort
     */
    public int getEffort()
    {
        return effort;
    }
    /**
     * @return the label
     */
    public String getLabel()
    {
        return label;
    }
    /**
     * @return the page
     */
    public int getPage()
    {
        return page;
    }
    /**
     * @return the isAction
     */
    public boolean isAction()
    {
        return isAction;
    }
    /**
     * @return the isKarmaMandatory
     */
    public boolean isKarmaMandatory()
    {
        return isKarmaMandatory;
    }
    /**
     * @return the isRollable
     */
    public boolean isRollable()
    {
        return isRollable;
    }



}
