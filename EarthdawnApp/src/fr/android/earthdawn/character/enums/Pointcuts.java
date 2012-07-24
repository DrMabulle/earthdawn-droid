/**
 *
 */
package fr.android.earthdawn.character.enums;


/**
 * @author DrMabulle
 *
 */
public enum Pointcuts
{
    DEF_PHY("Défense physique"),
    DEF_MAG("Défense magique"),
    DEF_SOC("Défense sociale"),
    ARM_PHY("Armure physique"),
    ARM_MYS("Armure mysitque"),
    INIT("Rang d'Initiative"),
    INIT_MOD("Modificateur d'Initiative"),
    ATTRIBUT("Attributs"),
    KARMA_POINTS("Points de karma"),
    KARMA_RANK("Niveau du karma"),
    KARMA_USE("Utilisation Karma"),
    HEALTH_POINTS("Points de vie"),
    BLOOD_MAGIC("Magie du sang"),
    UNCOUNSCIOUSNESS_THRESHOLD("Seuil d'inconscience"),
    RECOVERY_TESTS("Jets de récupération"),
    RECOVERY_LVL("Dé de récupération"),
    WOUND_THRESHOLD("Seuil de blessure grave"),
    //WOUND("Blessure grave"),
    //DAMAGES("Dommages subis"),
    TALENT("Talent"),
    WEAPON_DAMAGE("Dommages de l'arme"),
    WEIGHT("Poids"),

    POWER("Pouvoir");

    private final String label;

    private Pointcuts(final String aLabel)
    {
        this.label = aLabel;
    }

    @Override
    public String toString()
    {
        return label;
    }

}
