/**
 *
 */
package fr.android.earthdawn.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Attributes;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Skill;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.character.equipement.impl.Equipment;
import fr.android.earthdawn.character.equipement.impl.MagicalEquipment;
import fr.android.earthdawn.utils.SerializationUtils;
/**
 * @author DrMabulle
 *
 */
public final class CharacterManager
{
    private static EDCharacter CHAR = null;

    private static final String MALACK = "Malack";
    private static final String PURIFICATEUR = "Ajmar Coeur-Tendre";
    private static final String FORGERON = "Arjaän Messarim";
    private static final String VOLEUR = "Hyacinthe Casteltourbe";

    private CharacterManager() {}

    /**
     * Retrieves previously loaded character
     * @return  previously loaded character
     */
    public static EDCharacter getLoadedCharacter()
    {
        return CHAR;
    }
    /**
     * Loads a character in memory, given its ID (character name)
     * @param id ID of the character to load (character name)
     * @param ctx Android Context
     * @return the loaded character
     */
    public static EDCharacter getCharacter(final String id, final Context ctx)
    {
        final Object test = SerializationUtils.deserializeFromDisk(id, ctx);
        if ( test != null)
        {
            CHAR = (EDCharacter) test;
        }
        else
        {
            // XXX Remove this before release
            CHAR = loadCharacter(id);
        }
        return CHAR;
    }

    private static EDCharacter loadCharacter(final String id)
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
        else if (VOLEUR.equals(id))
        {
            return loadHyacinthe();
        }
        return loadForgeron();
    }

    private static EDCharacter loadPurifier()
    {
        final EDCharacter purifier = new EDCharacter(PURIFICATEUR, "N/A", 121, 245, 421, Races.Obsidien, 17, 1, 15, 1, 13, 3, 12, 0, 10, 0, 11, 0);
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

        purifier.incrementLegendPoints(82000);

        return purifier;
    }

    private static EDCharacter loadMalack()
    {
        final EDCharacter malack = new EDCharacter(MALACK, "N/A", 121, 245, 421, Races.Obsidien, 17, 1, 15, 1, 13, 1, 13, 1, 11, 0, 8, 0);
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
        discipline.setTalentRank(talents.get(7), 5); // Anticipation
        discipline.setTalentRank(talents.get(8), 4); // ArmesJet
        discipline.setTalentRank(talents.get(9), 6); // Esquive
        discipline.setTalentRank(talents.get(10), 6); // VivaciteTigre
        discipline.setTalentRank(talents.get(11), 4); // AttaquePlongeante
        discipline.setTalentRank(talents.get(12), 7); // Tissage
        discipline.setTalentRank(talents.get(13), 4); // CoupDouble
        discipline.setTalentRank(talents.get(14), 6); // Envol
        discipline.setTalentRank(talents.get(15), 0); // Rituel Maitre Fantome
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
        malack.addEquipment(EquipmentManager.getDefensesList().get(0)); // Bouclier d'infanterie

        // Anneau Kelnone
        List<List<Mod>> bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.DEF_MAG, 1.0)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.DEF_SOC, 1.0)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.DEF_MAG, 1.0)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.DEF_SOC, 1.0)));
        MagicalEquipment ring = new MagicalEquipment("Kelnone", bonuses, new int[] {200, 300, 500, 800});
        ring.incrementRank();
        ring.incrementRank();
        ring.incrementRank();
        ring.incrementRank();
        malack.addEquipment(ring);

        // Hurleuse de Délitra
        bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.WEAPON_DAMAGE, 8), Mod.get(Pointcuts.WEIGHT, 1.5)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.POWER, 0, "Hurlement d'Horreur")));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.POWER, 0, "Soie noire")));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.WEAPON_DAMAGE, 1), Mod.get(Pointcuts.POWER, 0, "Bourdonne en présence d'Horreur")));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.POWER, 0, "Défenses +4 pour résister aux Horreurs (hors sorts)")));
        final MagicalEquipment hurleuse = new MagicalEquipment("Hurleuse de Délitra", bonuses, new int[] {500, 800, 1300, 2100, 3400, 5500, 8900});
        hurleuse.incrementRank();
        hurleuse.incrementRank();
        hurleuse.incrementRank();
        malack.addEquipment(hurleuse);

        // Anneau de Malack
        bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.TALENT, 1, Talents.ArmesMelee)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.POWER, 0, "Rappel de l'arme (Gradius)")));
        ring = new MagicalEquipment("Anneau de Malack", bonuses, new int[] {200, 300, 500, 800, 1300});
        ring.incrementRank();
        ring.incrementRank();
        malack.addEquipment(ring);

        // Anneau de Malack
        bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.POWER, 0, "Absorbe 3 points de fatigue par jour")));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.POWER, 0, "Absorbe 6 points de fatigue par jour")));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.POWER, 0, "Absorbe 9 points de fatigue par jour")));
        ring = new MagicalEquipment("Anneau du Combattant", bonuses, new int[] {200, 300, 500});
        ring.incrementRank();
        ring.incrementRank();
        ring.incrementRank();
        malack.addEquipment(ring);

        malack.incrementKarmaBought(78);
        malack.incrementKarmaSpent(70);
        malack.incrementLegendPoints(82885);

        return malack;
    }

    private static EDCharacter loadForgeron()
    {
        final EDCharacter forgeron = new EDCharacter(FORGERON, "Homme", 125, 195, 72, Races.Elfe, 16, 1, 11, 2, 11, 1, 15, 0, 11, 0, 14, 1);
        forgeron.setMainDiscipline(Disciplines.Forgeron, 6);
        forgeron.setSecondDiscipline(Disciplines.Troubadour, 5);

        Discipline discipline = forgeron.getMainDiscipline();
        List<Talent> talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 8); // ArmesMelee
        discipline.setTalentRank(talents.get(1), 8); // Esquive
        discipline.setTalentRank(talents.get(2), 6); // HistoireArmes
        discipline.setTalentRank(talents.get(3), 6); // PerfectionnementLame
        discipline.setTalentRank(talents.get(4), 8); // VolonteFer
        discipline.setTalentRank(talents.get(5), 2); // RituelKarma
        discipline.setTalentRank(talents.get(6), 7); // Endurance
        discipline.setTalentRank(talents.get(7), 5); // LectureEcriture
        discipline.setTalentRank(talents.get(8), 5); // Marchandage
        discipline.setTalentRank(talents.get(9), 6); // ContreMalediction
        discipline.setTalentRank(talents.get(10), 5); // DetectionArmes
        discipline.setTalentRank(talents.get(11), 5); // DonLangues
        discipline.setTalentRank(talents.get(12), 6); // TissageForgeron
        discipline.setTalentRank(talents.get(13), 4); // AlterationArmeTir
        discipline.setTalentRank(talents.get(14), 7); // Endurcissement
        discipline.setTalentRank(talents.get(15), 0); // RituelMaitreFantome
        discipline.setTalentRank(talents.get(16), 6); // DetectionDefautsArmure
        discipline.setTalentRank(talents.get(17), 1); // DissimulationArme

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
        discipline.setTalentRank(talents.get(13), 1); // ArmesJet
        discipline.setTalentRank(talents.get(14), 4); // Distraction
        discipline.setTalentRank(talents.get(15), 0); // RituelMaitreFantome

        // Anneau à filaments
        List<List<Mod>> bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.DEF_SOC, 1.0)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.DEF_MAG, 1.0)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.DEF_SOC, 1.0)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.DEF_MAG, 1.0)));
        final MagicalEquipment ring = new MagicalEquipment("Anneau à filaments", bonuses, new int[] {200, 300, 500, 800});
        ring.incrementRank();
        ring.incrementRank();
        ring.incrementRank();
        ring.incrementRank();
        forgeron.addEquipment(ring);

        // Bottes à filaments
        bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.WEIGHT, 1)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.DEF_PHY, 1.0)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.DEF_PHY, 1.0)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.TALENT, 1.0, Talents.Escalade)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.DEF_PHY, 1.0)));
        final MagicalEquipment boots = new MagicalEquipment("Bottes à filaments", bonuses, new int[] {100, 200, 300, 500});
        boots.incrementRank();
        boots.incrementRank();
        boots.incrementRank();
        boots.incrementRank();
        forgeron.addEquipment(boots);

        // Armure de cui bouilli à filaments
        bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.ARM_PHY, 5), Mod.get(Pointcuts.ARM_MYS, 0), Mod.get(Pointcuts.INIT, -1), Mod.get(Pointcuts.WEIGHT, 10)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.ARM_PHY, 1.0)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.ARM_MYS, 1.0)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.ARM_PHY, 1.0), Mod.get(Pointcuts.ARM_MYS, 1.0)));
        bonuses.add(Arrays.asList(Mod.get(Pointcuts.ARM_PHY, 1.0)));
        final MagicalEquipment cuir = new MagicalEquipment("Armure de cuir bouilli à filaments", bonuses, new int[] {100, 200, 300, 500});
        cuir.incrementRank();
        cuir.incrementRank();
        cuir.incrementRank();
        cuir.incrementRank();
        forgeron.addEquipment(cuir);

        forgeron.addEquipment(new Equipment("Dague forgée", Arrays.asList(Mod.get(Pointcuts.WEAPON_DAMAGE, 3), Mod.get(Pointcuts.WEIGHT, 0.5))));
        forgeron.addEquipment(new Equipment("Epée large forgée", Arrays.asList(Mod.get(Pointcuts.WEAPON_DAMAGE, 8), Mod.get(Pointcuts.WEIGHT, 1.5))));

        forgeron.addSkill(new Skill("Création d'armes", Attributes.PER, true, 0).incrementRank().incrementRank());
        forgeron.addSkill(new Skill("Création d'armures", Attributes.PER, true, 0).incrementRank());
        forgeron.addSkill(new Skill("Cartographie", Attributes.PER, true, 0).incrementRank());
        forgeron.addSkill(new Skill("Survie", Attributes.PER, true, 0).incrementRank());
        forgeron.addSkill(new Skill("Connaissances : Horreurs", Attributes.PER, true, 0));
        forgeron.addSkill(new Skill("Connaissances : Géographie de Barsaive", Attributes.PER, true, 0).incrementRank());
        forgeron.addSkill(new Skill("Connaissances : Histoire de Barsaive", Attributes.PER, true, 0).incrementRank());
        forgeron.addSkill(new Skill("Connaissances : Légendes et Héros", Attributes.PER, true, 0).incrementRank().incrementRank());
        forgeron.addSkill(new Skill("Analyse de créature", Attributes.PER, true, 1));
        forgeron.addSkill(new Skill("Natation", Attributes.STR, true, 1));
        forgeron.addSkill(new Skill("Escalade", Attributes.DEX, true, 0));

        forgeron.incrementKarmaBought(18);
        forgeron.incrementKarmaSpent(11);
        forgeron.incrementLegendPoints(96000);

        return forgeron;
    }

    private static EDCharacter loadHyacinthe()
    {
        final EDCharacter hyacinthe = new EDCharacter(VOLEUR, "Homme", 111, 195, 72, Races.Elfe, 17, 0, 11, 2, 12, 0, 14, 1, 9, 0, 15, 1);
        hyacinthe.setMainDiscipline(Disciplines.MaitreArmes, 6);
        hyacinthe.setSecondDiscipline(Disciplines.Voleur, 5);

        Discipline discipline = hyacinthe.getMainDiscipline();
        List<Talent> talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 8); // ArmesMelee
        discipline.setTalentRank(talents.get(1), 3); // RituelKarma
        discipline.setTalentRank(talents.get(2), 6); // Esquive
        discipline.setTalentRank(talents.get(3), 6); // Manoeuvre
        discipline.setTalentRank(talents.get(4), 7); // Sarcasmes
        discipline.setTalentRank(talents.get(5), 4); // Stabilite
        discipline.setTalentRank(talents.get(6), 7); // Endurance
        discipline.setTalentRank(talents.get(7), 6); // PremiereImpression
        discipline.setTalentRank(talents.get(8), 8); // Riposte
        discipline.setTalentRank(talents.get(9), 4); // ArmesJet
        discipline.setTalentRank(talents.get(10), 4); // RireEncourageant
        discipline.setTalentRank(talents.get(11), 3); // DonLangues
        discipline.setTalentRank(talents.get(12), 5); // TissageMaitreArmes
        discipline.setTalentRank(talents.get(13), 7); // DeuxiemeArme
        discipline.setTalentRank(talents.get(14), 0); // RituelMaitreFantome
        discipline.setTalentRank(talents.get(15), 6); // SourireRavageur
        discipline.setTalentRank(talents.get(16), 7); // Desarmement
        discipline.setTalentRank(talents.get(17), 3); // Distraction

        discipline = hyacinthe.getSecondDiscipline();
        talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 0); // ArmesMelee
        discipline.setTalentRank(talents.get(1), 1); // RituelKarma
        discipline.setTalentRank(talents.get(2), 6); // Crochetage
        discipline.setTalentRank(talents.get(3), 5); // DeplacementSilencieux
        discipline.setTalentRank(talents.get(4), 4); // Escalade
        discipline.setTalentRank(talents.get(5), 6); // VolTire
        discipline.setTalentRank(talents.get(6), 0); // Endurance
        discipline.setTalentRank(talents.get(7), 4); // AttaqueSurprise
        discipline.setTalentRank(talents.get(8), 6); // SensSerrures
        discipline.setTalentRank(talents.get(9), 0); // Esquive
        discipline.setTalentRank(talents.get(10), 4); // Recel
        discipline.setTalentRank(talents.get(11), 3); // EsquivePieges
        discipline.setTalentRank(talents.get(12), 5); // TissageVoleur
        discipline.setTalentRank(talents.get(13), 4); // DesarmocagePieges
        discipline.setTalentRank(talents.get(14), 5); // DetectionPieges
        discipline.setTalentRank(talents.get(15), 0); // RituelMaitreFantome

        hyacinthe.addEquipment(new Equipment("Dague forgée", Arrays.asList(Mod.get(Pointcuts.WEAPON_DAMAGE, 3), Mod.get(Pointcuts.WEIGHT, 0.5))));
        hyacinthe.addEquipment(new Equipment("Rapière forgée", Arrays.asList(Mod.get(Pointcuts.WEAPON_DAMAGE, 8), Mod.get(Pointcuts.WEIGHT, 1.5))));
        hyacinthe.addEquipment(new Equipment("Dague filante", Arrays.asList(Mod.get(Pointcuts.WEAPON_DAMAGE, 3), Mod.get(Pointcuts.WEIGHT, 1.5))));
        hyacinthe.addEquipment(new Equipment("Arc court en if", Arrays.asList(Mod.get(Pointcuts.WEAPON_DAMAGE, 3), Mod.get(Pointcuts.WEIGHT, 1.5))));

        hyacinthe.addSkill(new Skill("Chant d'émotion", Attributes.CHA, true, 0).incrementRank());
        hyacinthe.addSkill(new Skill("Etiquette", Attributes.PER, true, 0));


        hyacinthe.incrementKarmaBought(18);
        hyacinthe.incrementKarmaSpent(11);
        hyacinthe.incrementLegendPoints(96000);

        return hyacinthe;
    }

    /**
     * List all character available for loading
     * @param ctx Android Context
     * @return all character available for loading
     */
    public static List<String> getAvailableCharacters(final Context ctx)
    {
        final List<String> names = new ArrayList<String>(10);
        final List<String> tmp = new ArrayList<String>(4);

        // Load from code
        tmp.add(FORGERON);
        tmp.add(VOLEUR);
        tmp.add(MALACK);
        tmp.add(PURIFICATEUR);

        // Load from file system
        final String[] files = ctx.fileList();
        if (files != null && files.length > 0)
        {
            for (final String file : files)
            {
                names.add(file.replace(".ser", ""));
            }
        }

        // Suppress/avoid double entries
        names.removeAll(tmp);
        names.addAll(tmp);

        // Sort names for better looking
        Collections.sort(names);

        return names;
    }

}
