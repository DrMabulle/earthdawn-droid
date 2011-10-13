/**
 *
 */
package fr.android.earthdawn.character.enums;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author DrMabulle
 *
 */
public enum Disciplines implements Serializable
{
    Archer("Archer", Arrays.asList(new Talent(Talents.RituelKarma, 1, false), new Talent(Talents.Endurance, 2, false, 6, 5))),

    Cavalier("Cavalier",
        Arrays.asList(new Talent(Talents.ArmesMelee, 1, false), new Talent(Talents.RituelKarma, 1, false),
            new Talent(Talents.Endurance, 2, false, 7, 6))),

    Eclaireur("Eclaireur", Arrays.asList(new Talent(Talents.ArmesMelee, 1, false), new Talent(Talents.RituelKarma, 1, false),
            new Talent(Talents.Endurance, 2, false, 6, 5))),

    EcumeurDuCiel("Ecumeur du Ciel", Arrays.asList(new Talent(Talents.ArmesMelee, 1, false), new Talent(Talents.RituelKarma, 1, false),
            new Talent(Talents.Endurance, 2, false, 8, 6))),

    Elementaliste("Elémentaliste",
        Arrays.asList(new Talent(Talents.Incantation, 1, true),  new Talent(Talents.RituelKarma, 1, false),
                new Talent(Talents.LectureEcriture, 1, false), new Talent(Talents.LectureEcritureMagie, 1, false),
                new Talent(Talents.MatriceSort, 1, false), new Talent(Talents.MatriceSort, 1, false),
                new Talent(Talents.TissageElementaliste, 1, true),
                new Talent(Talents.Endurance, 2, false, 4, 3))),

    Forgeron("Forgeron", Arrays.asList(new Talent(Talents.RituelKarma, 1, false), new Talent(Talents.Endurance, 2, false, 6, 5))),

    Guerrier("Guerrier",
        Arrays.asList(new Talent(Talents.ArmesMelee, 1, true), new Talent(Talents.AttaqueAcrobatique, 1, false),
                new Talent(Talents.CombatMainsNues, 1, true), new Talent(Talents.DanseAirs, 1, false),
                new Talent(Talents.PeauBois, 1, true), new Talent(Talents.RituelKarma, 1, false),
                new Talent(Talents.Endurance, 2, false, 9, 7), new Talent(Talents.ArmesJet, 2, false), new Talent(Talents.Anticipation, 2, true),
                new Talent(Talents.Esquive, 3, true), new Talent(Talents.VivaciteTigre, 3, false),
                new Talent(Talents.AttaquePlongeante, 4, true), new Talent(Talents.TissageGuerrier, 4, true),
                new Talent(Talents.CoupPiedRapide, 5, true), new Talent(Talents.MarcheVents, 5, true),
                new Talent(Talents.ArmesTir, 6, false), new Talent(Talents.UltimeSursaut, 6, true))),

    Illusionniste("Illusionniste", Arrays.asList(new Talent(Talents.RituelKarma, 1, false), new Talent(Talents.Endurance, 2, false, 4, 3))),

    MaitreArmes("Maitre d'Armes", Arrays.asList(new Talent(Talents.ArmesMelee, 1, false), new Talent(Talents.RituelKarma, 1, false),
            new Talent(Talents.Endurance, 2, false, 7, 6))),

    MaitreAnimaux("Maitre des Animaux", Arrays.asList(new Talent(Talents.RituelKarma, 1, false), new Talent(Talents.Endurance, 2, false, 7, 6))),

    NavigateurCiel("Navigateur du Ciel", Arrays.asList(new Talent(Talents.ArmesMelee, 1, false), new Talent(Talents.RituelKarma, 1, false),
            new Talent(Talents.Endurance, 2, false, 6, 5))),

    Necromancien("Nécromancien", Arrays.asList(new Talent(Talents.RituelKarma, 1, false), new Talent(Talents.Endurance, 2, false, 4, 3))),

    Sorcieur("Sorcier", Arrays.asList(new Talent(Talents.RituelKarma, 1, false), new Talent(Talents.Endurance, 2, false, 4, 3))),

    Troubadour("Troubadour", Arrays.asList(new Talent(Talents.ArmesMelee, 1, false), new Talent(Talents.RituelKarma, 1, false),
            new Talent(Talents.Endurance, 2, false, 6, 5))),

    Voleur("Voleur", Arrays.asList(new Talent(Talents.ArmesMelee, 1, false), new Talent(Talents.RituelKarma, 1, false),
            new Talent(Talents.Endurance, 2, false, 5, 4)));

    private String label;
    private List<Talent> talents;

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
