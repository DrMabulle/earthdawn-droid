/**
 *
 */
package fr.android.earthdawn.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.android.earthdawn.character.Character;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.character.equipement.impl.Equipment;
import fr.android.earthdawn.character.equipement.impl.MagicalEquipment;
/**
 * @author DrMabulle
 *
 */
public class CharacterManager
{
    private static Character CHAR = null;

    private static final String MALACK = "Malack";
    private static final String ARDAMIR = "Ardamir";
    private static final String PURIFICATEUR = "Ajmar Coeur-Tendre";
    private static final String MENESTREL = "Ménestrel";
    private static final String FORGERON = "Nimriel";

    public static Character getLoadedCharacter()
    {
        return CHAR;
    }
    public static Character getCharacter(final String id)
    {
        CHAR = loadCharacter(id);
        return CHAR;
    }

    private static Character loadCharacter(final String id)
    {
        // TODO à changer
        if (MALACK.equalsIgnoreCase(id))
        {
            return loadMalack();
        }
        else if (PURIFICATEUR.equals(id))
        {
            return loadPurifier();
        }
        else if (FORGERON.equals(id))
        {
            return loadForgeron();
        }
        return loadForgeron();
    }

    private static Character loadPurifier()
    {
        final Character purifier = new Character("Ajmar", "N/A", 121, 245, 421, Races.Obsidien, 17, 1, 15, 1, 13, 3, 12, 0, 10, 0, 11, 0);
        purifier.setMainDiscipline(Disciplines.Purificateur, 6);

        final Discipline discipline = purifier.getMainDiscipline();
        final List<Talent> talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 8); // CombatMainsNues
        discipline.setTalentRank(talents.get(1), 8); // ControleCorporel
        discipline.setTalentRank(talents.get(2), 5); // CriGuerre
        discipline.setTalentRank(talents.get(3), 5); // Enracinement
        discipline.setTalentRank(talents.get(4), 7); // Esquive
        discipline.setTalentRank(talents.get(5), 2); // RituelKarma

        discipline.setTalentRank(talents.get(6), 5); // AnalyseCreature
        discipline.setTalentRank(talents.get(7), 6); // DetectionVie
        discipline.setTalentRank(talents.get(8), 7); // Endurance

        discipline.setTalentRank(talents.get(9), 7); // LienTellurique
        discipline.setTalentRank(talents.get(10), 6); // PeauArgile

        discipline.setTalentRank(talents.get(11), 4); // LanguesElementaires
        discipline.setTalentRank(talents.get(12), 6); // TissagePurificateur

        discipline.setTalentRank(talents.get(13), 6); // CoupPiedRapide
        discipline.setTalentRank(talents.get(14), 0); // RituelMaitreFantome
        discipline.setTalentRank(talents.get(15), 7); // VolonteFer

        discipline.setTalentRank(talents.get(16), 5); // UltimeSursaut
        discipline.setTalentRank(talents.get(17), 6); // VivaciteTigre
        return purifier;
    }

    private static Character loadMalack()
    {
        final Character malack = new Character("Malack", "N/A", 121, 245, 421, Races.Obsidien, 17, 1, 15, 1, 13, 1, 13, 1, 11, 0, 8, 0);
        malack.setMainDiscipline(Disciplines.Guerrier, 6);
        malack.setSecondDiscipline(Disciplines.Elementaliste, 2);

        Discipline discipline = malack.getMainDiscipline();
        List<Talent> talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 8); // Arme de mêlée
        discipline.setTalentRank(talents.get(1), 6); // Attaque accrobatique
        discipline.setTalentRank(talents.get(2), 5); // CombatMainsNues
        discipline.setTalentRank(talents.get(3), 6); // DanseAir
        discipline.setTalentRank(talents.get(4), 6); // PeauBois
        discipline.setTalentRank(talents.get(5), 2); // RituelKarmique
        discipline.setTalentRank(talents.get(6), 7); // Longevite
        discipline.setTalentRank(talents.get(7), 4); // ArmesJet
        discipline.setTalentRank(talents.get(8), 5); // Anticipation
        discipline.setTalentRank(talents.get(9), 6); // Esquive
        discipline.setTalentRank(talents.get(10), 6); // VivaciteTigre
        discipline.setTalentRank(talents.get(11), 4); // AttaquePlongeante
        discipline.setTalentRank(talents.get(12), 7); // Tissage
        discipline.setTalentRank(talents.get(13), 4); // CoupDouble
        discipline.setTalentRank(talents.get(14), 6); // Envol
        discipline.setTalentRank(talents.get(15), 1); // Rituel Maitre Fantome
        discipline.setTalentRank(talents.get(16), 1); // ArmesTrait
        discipline.setTalentRank(talents.get(17), 3); // UltimeSursaut

        discipline = malack.getSecondDiscipline();
        talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 4); // Incantation
        discipline.setTalentRank(talents.get(1), 0); // RituelKarmique
        discipline.setTalentRank(talents.get(2), 3); // LectureEcriture
        discipline.setTalentRank(talents.get(3), 4); // LectureEcritureMagie
        discipline.setTalentRank(talents.get(4), 2); // Matrice
        discipline.setTalentRank(talents.get(5), 2); // Matrice
        discipline.setTalentRank(talents.get(6), 4); // Tissage
        discipline.setTalentRank(talents.get(7), 0); // Endurance
        discipline.setTalentRank(talents.get(8), 1); // GuerisonFeu
        discipline.setTalentRank(talents.get(9), 1); // MatriceSort


        //malack.addEquipment(EquipmentManager.getWeaponList().get(4));
        malack.addEquipment(EquipmentManager.getArmorList().get(7)); // Armure de plaques en cristal
        malack.addEquipment(EquipmentManager.getArmorList().get(11)); // Galets de sang

        // Anneau Kelnone
        List<List<Mod>> bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(new Mod(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_MAG, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_SOC, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_MAG, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_SOC, 1.0)));
        MagicalEquipment ring = new MagicalEquipment("Kelnone", bonuses);
        ring.incrementRank();
        ring.incrementRank();
        ring.incrementRank();
        ring.incrementRank();
        malack.addEquipment(ring);

        // Hurleuse de Délitra
        bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 8), new Mod(Pointcuts.WEIGHT, 1.5)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.POWER, 0, "Hurlement d'Horreur")));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.POWER, 0, "Soie noire")));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 1), new Mod(Pointcuts.POWER, 0, "Bourdonne en présence d'Horreur")));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.POWER, 0, "Défenses +4 pour résister aux Horreurs (hors sorts)")));
        final MagicalEquipment hurleuse = new MagicalEquipment("Hurleuse de Délitra", bonuses);
        hurleuse.incrementRank();
        hurleuse.incrementRank();
        hurleuse.incrementRank();
        malack.addEquipment(hurleuse);

        // Anneau de Malack
        bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(new Mod(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.TALENT, 1, Talents.ArmesMelee)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.POWER, 0, "Rappel de l'arme (Gradius)")));
        ring = new MagicalEquipment("Anneau de Malack", bonuses);
        ring.incrementRank();
        ring.incrementRank();
        malack.addEquipment(ring);

        // Anneau de Malack
        bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(new Mod(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.POWER, 0, "Absorbe 3 points de fatigue par jour")));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.POWER, 0, "Absorbe 6 points de fatigue par jour")));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.POWER, 0, "Absorbe 9 points de fatigue par jour")));
        ring = new MagicalEquipment("Anneau du Combattant", bonuses);
        ring.incrementRank();
        ring.incrementRank();
        ring.incrementRank();
        malack.addEquipment(ring);

        return malack;
    }

    private static Character loadForgeron()
    {
        final Character forgeron = new Character("Nimriel", "Homme", 125, 199, 65, Races.Elfe, 16, 1, 11, 2, 11, 1, 15, 0, 11, 0, 14, 1);
        forgeron.setMainDiscipline(Disciplines.Forgeron, 6);
        forgeron.setSecondDiscipline(Disciplines.Troubadour, 5);

        Discipline discipline = forgeron.getMainDiscipline();
        List<Talent> talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 8); // ArmesMelee
        discipline.setTalentRank(talents.get(1), 7); // Esquive
        discipline.setTalentRank(talents.get(2), 6); // HistoireArmes
        discipline.setTalentRank(talents.get(3), 6); // PerfectionnementLame
        discipline.setTalentRank(talents.get(4), 7); // VolonteFer
        discipline.setTalentRank(talents.get(5), 2); // RituelKarma
        discipline.setTalentRank(talents.get(6), 7); // Endurance
        discipline.setTalentRank(talents.get(7), 5); // LectureEcriture
        discipline.setTalentRank(talents.get(8), 5); // Marchandage
        discipline.setTalentRank(talents.get(9), 6); // ContreMalediction
        discipline.setTalentRank(talents.get(10), 4); // DetectionArmes
        discipline.setTalentRank(talents.get(11), 5); // DonLangues
        discipline.setTalentRank(talents.get(12), 6); // TissageForgeron
        discipline.setTalentRank(talents.get(13), 6); // AlterationArmeTir
        discipline.setTalentRank(talents.get(14), 4); // Endurcissement
        discipline.setTalentRank(talents.get(15), 0); // RituelMaitreFantome
        discipline.setTalentRank(talents.get(16), 3); // DetectionDefautsArmure
        discipline.setTalentRank(talents.get(17), 3); // DissimulationArme

        discipline = forgeron.getSecondDiscipline();
        talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 0); // ArmesMelee
        discipline.setTalentRank(talents.get(1), 1); // RituelKarma
        discipline.setTalentRank(talents.get(2), 4); // ChantEmouvant
        discipline.setTalentRank(talents.get(3), 5); // DeguisementMagique
        discipline.setTalentRank(talents.get(4), 4); // ImitationVoix
        discipline.setTalentRank(talents.get(5), 5); // PremiereImpression
        discipline.setTalentRank(talents.get(6), 0); // Endurance
        discipline.setTalentRank(talents.get(7), 0); // DonLangues
        discipline.setTalentRank(talents.get(8), 5); // HistoireObjets
        discipline.setTalentRank(talents.get(9), 0); // LectureEcriture
        discipline.setTalentRank(talents.get(10), 4); // SensEmpathique
        discipline.setTalentRank(talents.get(11), 5); // Sarcasmes
        discipline.setTalentRank(talents.get(12), 1); // TissageTroubadour
        discipline.setTalentRank(talents.get(13), 2); // ArmesJet
        discipline.setTalentRank(talents.get(14), 2); // Distraction
        discipline.setTalentRank(talents.get(15), 0); // RituelMaitreFantome

        // Anneau à filaments
        List<List<Mod>> bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(new Mod(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_SOC, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_MAG, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_SOC, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_MAG, 1.0)));
        final MagicalEquipment ring = new MagicalEquipment("Anneau", bonuses);
        ring.incrementRank();
        ring.incrementRank();
        ring.incrementRank();
        ring.incrementRank();
        forgeron.addEquipment(ring);

        // Bottes à filaments
        bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(new Mod(Pointcuts.WEIGHT, 1)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_PHY, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_PHY, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.TALENT, 1.0, Talents.Escalade)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_PHY, 1.0)));
        final MagicalEquipment boots = new MagicalEquipment("Bottes", bonuses);
        boots.incrementRank();
        boots.incrementRank();
        boots.incrementRank();
        boots.incrementRank();
        forgeron.addEquipment(boots);

        // Armure de cui bouilli à filaments
        bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(new Mod(Pointcuts.ARM_PHY, 5), new Mod(Pointcuts.ARM_MYS, 0), new Mod(Pointcuts.INIT, -1), new Mod(Pointcuts.WEIGHT, 10)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.ARM_PHY, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.ARM_MYS, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.ARM_PHY, 1.0), new Mod(Pointcuts.ARM_MYS, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.ARM_PHY, 1.0)));
        final MagicalEquipment cuir = new MagicalEquipment("Armure de cui bouilli", bonuses);
        cuir.incrementRank();
        cuir.incrementRank();
        cuir.incrementRank();
        cuir.incrementRank();
        forgeron.addEquipment(cuir);

        forgeron.addEquipment(new Equipment("Dague", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 4), new Mod(Pointcuts.WEIGHT, 0.5))));
        forgeron.addEquipment(new Equipment("Epée", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 6), new Mod(Pointcuts.WEIGHT, 1.5))));

        return forgeron;
    }

    public static String[] getAvailableCharacters()
    {
        // TODO
       // return new String[] {MALACK, ARDAMIR, FORGERON, PURIFICATEUR, MENESTREL};
        return new String[] {MALACK, FORGERON, PURIFICATEUR};
    }

}
