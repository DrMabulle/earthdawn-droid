/**
 *
 */
package fr.android.earthdawn.character.enums;

/**
 * @author DrMabulle
 *
 */
public enum Talents
{
    AbriVegetal("Abri Végétal", Attributs.CHA, true, false, 167),
    AcrobatiesEnSelle("Acrobaties en selle", Attributs.DEX, false, false, 168),
    AffolementTroupeaux("Affolement des troupeaux", Attributs.VOL, true, false, 168),

    ArmeMelee("Arme de Mélée", Attributs.DEX, true, false, 168),

    RituelKarmique("Rituel Karmique", Attributs.NUL, true, false, 168),
    Longevite("Longévité", Attributs.NUL, false, false, 168);


    private String label;
    private Attributs attribut;
    private boolean isAction;
    private boolean isKarmaMandatory;
    /**
     * @param label
     * @param attribut
     * @param isAction
     * @param isKarmaMandatory
     * @param page
     */
    private Talents(final String label, final Attributs attribut, final boolean isAction, final boolean isKarmaMandatory, final int page)
    {
        this.label = label;
        this.attribut = attribut;
        this.isAction = isAction;
        this.isKarmaMandatory = isKarmaMandatory;
        this.page = page;
    }
    private int page;
    /**
     * @return the label
     */
    public String getLabel()
    {
        return label;
    }
    /**
     * @return the attribut
     */
    public Attributs getAttribut()
    {
        return attribut;
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
     * @return the page
     */
    public int getPage()
    {
        return page;
    }



}
