/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.util.Arrays;
import java.util.List;

/**
 * @author DrMabulle
 *
 */
public enum Disciplines
{
    Archer("Archer", Arrays.asList(new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    Cavalier("Cavalier",
        Arrays.asList(new Talent(Talents.ArmeMelee, 1), new Talent(Talents.RituelKarmique, 2),
            new Talent(Talents.Longevite, 2))),

    Eclaireur("Eclaireur", Arrays.asList(new Talent(Talents.ArmeMelee, 1), new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    EcumeurDuCiel("Ecumeur du Ciel", Arrays.asList(new Talent(Talents.ArmeMelee, 1), new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    Elementaliste("Elémentaliste", Arrays.asList(new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    Forgeron("Forgeron", Arrays.asList(new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    Guerrier("Guerrier",
        Arrays.asList(new Talent(Talents.ArmeMelee, 1), new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2),
                new Talent(Talents.ArmeMelee, 3), new Talent(Talents.ArmeMelee, 4), new Talent(Talents.ArmeMelee, 5),
                new Talent(Talents.ArmeMelee, 6), new Talent(Talents.ArmeMelee, 7), new Talent(Talents.ArmeMelee, 8),
                new Talent(Talents.ArmeMelee, 9), new Talent(Talents.ArmeMelee, 10), new Talent(Talents.ArmeMelee, 11),
                new Talent(Talents.ArmeMelee, 12), new Talent(Talents.ArmeMelee, 13), new Talent(Talents.ArmeMelee, 14),
                new Talent(Talents.ArmeMelee, 15))),

    Illusionniste("Illusionniste", Arrays.asList(new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    MaitreArmes("Maitre d'Armes", Arrays.asList(new Talent(Talents.ArmeMelee, 1), new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    MaitreAnimaux("Maitre des Animaux", Arrays.asList(new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    NavigateurCiel("Navigateur du Ciel", Arrays.asList(new Talent(Talents.ArmeMelee, 1), new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    Necromancien("Nécromancien", Arrays.asList(new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    Sorcieur("Sorcier", Arrays.asList(new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    Troubadour("Troubadour", Arrays.asList(new Talent(Talents.ArmeMelee, 1), new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2))),

    Voleur("Voleur", Arrays.asList(new Talent(Talents.ArmeMelee, 1), new Talent(Talents.RituelKarmique, 2), new Talent(Talents.Longevite, 2)));

    public String label;
    public List<Talent> talents;

    private Disciplines(final String label, final List<Talent> talents)
    {
        this.label = label;
        this.talents = talents;
    }

    /**
     * @return the label
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * @return the talents
     */
    public List<Talent> getTalents()
    {
        return talents;
    }
}
