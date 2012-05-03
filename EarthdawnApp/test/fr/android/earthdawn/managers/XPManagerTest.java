package fr.android.earthdawn.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fr.android.earthdawn.R;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Attributs;
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

public class XPManagerTest
{
    private EDCharacter malack;
    private EDCharacter forgeron;

    @Before
    public void setUp() throws Exception
    {
        malack = new EDCharacter("Malack", "N/A", 121, 245, 421, Races.Obsidien, 17, 1, 15, 1, 13, 1, 13, 1, 11, 0, 8, 0);
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

        forgeron = new EDCharacter("Arjaän", "Homme", 125, 195, 72, Races.Elfe, 16, 1, 11, 2, 11, 1, 15, 0, 11, 0, 14, 1);
        forgeron.setMainDiscipline(Disciplines.Forgeron, 6);
        forgeron.setSecondDiscipline(Disciplines.Troubadour, 5);

        discipline = forgeron.getMainDiscipline();
        talents = discipline.getKnownTalents();
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
        discipline.setTalentRank(talents.get(10), 5); // DetectionArmes
        discipline.setTalentRank(talents.get(11), 5); // DonLangues
        discipline.setTalentRank(talents.get(12), 6); // TissageForgeron
        discipline.setTalentRank(talents.get(13), 4); // AlterationArmeTir
        discipline.setTalentRank(talents.get(14), 6); // Endurcissement
        discipline.setTalentRank(talents.get(15), 0); // RituelMaitreFantome
        discipline.setTalentRank(talents.get(16), 5); // DetectionDefautsArmure
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
        discipline.setTalentRank(talents.get(14), 3); // Distraction
        discipline.setTalentRank(talents.get(15), 0); // RituelMaitreFantome

        // Anneau à filaments
        List<List<Mod>> bonuses = new ArrayList<List<Mod>>();
        bonuses.add(Arrays.asList(new Mod(Pointcuts.WEIGHT, 0.1)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_SOC, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_MAG, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_SOC, 1.0)));
        bonuses.add(Arrays.asList(new Mod(Pointcuts.DEF_MAG, 1.0)));
        final MagicalEquipment ring = new MagicalEquipment("Anneau à filaments", bonuses, new int[] {200, 300, 500, 800});
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
        final MagicalEquipment boots = new MagicalEquipment("Bottes à filaments", bonuses, new int[] {100, 200, 300, 500});
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
        final MagicalEquipment cuir = new MagicalEquipment("Armure de cuir bouilli à filaments", bonuses, new int[] {100, 200, 300, 500});
        cuir.incrementRank();
        cuir.incrementRank();
        cuir.incrementRank();
        cuir.incrementRank();
        forgeron.addEquipment(cuir);

        forgeron.addEquipment(new Equipment("Dague forgée", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 4), new Mod(Pointcuts.WEIGHT, 0.5))));
        forgeron.addEquipment(new Equipment("Epée large forgée", Arrays.asList(new Mod(Pointcuts.WEAPON_DAMAGE, 8), new Mod(Pointcuts.WEIGHT, 1.5))));

        forgeron.addSkill(new Skill("Création d'armes", Attributs.PER, true, 0).incrementRank().incrementRank());
        forgeron.addSkill(new Skill("Création d'armures", Attributs.PER, true, 0).incrementRank());
        forgeron.addSkill(new Skill("Cartographie", Attributs.PER, true, 0).incrementRank());
        forgeron.addSkill(new Skill("Survie", Attributs.PER, true, 0).incrementRank());
        forgeron.addSkill(new Skill("Connaissances : Horreurs", Attributs.PER, true, 0));
        forgeron.addSkill(new Skill("Connaissances : Géographie de Barsaive", Attributs.PER, true, 0).incrementRank());
        forgeron.addSkill(new Skill("Connaissances : Histoire de Barsaive", Attributs.PER, true, 0).incrementRank());
        forgeron.addSkill(new Skill("Connaissances : Légendes et Héros", Attributs.PER, true, 0).incrementRank().incrementRank());
        forgeron.addSkill(new Skill("Analyse de créature", Attributs.PER, true, 1));
        forgeron.addSkill(new Skill("Natation", Attributs.STR, true, 1));
        forgeron.addSkill(new Skill("Escalade", Attributs.DEX, true, 0));

        forgeron.incrementKarmaBought(20);
    }

    @Test
    public void testEvaluateCharacter()
    {
        Assert.assertEquals(57900, XPManager.get().evaluateCharacter(malack));
        Assert.assertEquals(81900, XPManager.get().evaluateCharacter(forgeron));
    }

    @Test
    public void testEvaluateDiscipline()
    {
        Assert.assertEquals(50000, XPManager.get().evaluateDiscipline(malack.getMainDiscipline()));
        Assert.assertEquals(4700, XPManager.get().evaluateDiscipline(malack.getSecondDiscipline()));

        Assert.assertEquals(55600, XPManager.get().evaluateDiscipline(forgeron.getMainDiscipline()));
        Assert.assertEquals(12300, XPManager.get().evaluateDiscipline(forgeron.getSecondDiscipline()));
    }

    @Test
    public void testEvaluateTalent()
    {
        final Talent talent1 = new Talent(Talents.AbriVegetal, 1, false, null, null);
        final Talent talent2 = new Talent(Talents.AbriVegetal, 4, false, null, null);
        final Talent talent3 = new Talent(Talents.AbriVegetal, 5, false, null, null);
        final Talent talent4 = new Talent(Talents.AbriVegetal, 8, false, null, null);
        final Talent talent5 = new Talent(Talents.AbriVegetal, 9, false, null, null);
        final Talent talent6 = new Talent(Talents.AbriVegetal, 12, false, null, null);
        final Talent talent7 = new Talent(Talents.AbriVegetal, 13, false, null, null);
        final Talent talent8 = new Talent(Talents.AbriVegetal, 15, false, null, null);

        // Rank 1
        Assert.assertEquals(100, XPManager.get().evaluateTalent(talent1, 1));
        Assert.assertEquals(100, XPManager.get().evaluateTalent(talent2, 1));
        Assert.assertEquals(200, XPManager.get().evaluateTalent(talent3, 1));
        Assert.assertEquals(200, XPManager.get().evaluateTalent(talent4, 1));
        Assert.assertEquals(300, XPManager.get().evaluateTalent(talent5, 1));
        Assert.assertEquals(300, XPManager.get().evaluateTalent(talent6, 1));
        Assert.assertEquals(500, XPManager.get().evaluateTalent(talent7, 1));
        Assert.assertEquals(500, XPManager.get().evaluateTalent(talent8, 1));

        // Rank 5
        Assert.assertEquals(1900, XPManager.get().evaluateTalent(talent1, 5));
        Assert.assertEquals(1900, XPManager.get().evaluateTalent(talent2, 5));
        Assert.assertEquals(3100, XPManager.get().evaluateTalent(talent3, 5));
        Assert.assertEquals(3100, XPManager.get().evaluateTalent(talent4, 5));
        Assert.assertEquals(5000, XPManager.get().evaluateTalent(talent5, 5));
        Assert.assertEquals(5000, XPManager.get().evaluateTalent(talent6, 5));
        Assert.assertEquals(8100, XPManager.get().evaluateTalent(talent7, 5));
        Assert.assertEquals(8100, XPManager.get().evaluateTalent(talent8, 5));

        // Rank 10
        Assert.assertEquals(23100, XPManager.get().evaluateTalent(talent1, 10));
        Assert.assertEquals(23100, XPManager.get().evaluateTalent(talent2, 10));
        Assert.assertEquals(37400, XPManager.get().evaluateTalent(talent3, 10));
        Assert.assertEquals(37400, XPManager.get().evaluateTalent(talent4, 10));
        Assert.assertEquals(60500, XPManager.get().evaluateTalent(talent5, 10));
        Assert.assertEquals(60500, XPManager.get().evaluateTalent(talent6, 10));
        Assert.assertEquals(97900, XPManager.get().evaluateTalent(talent7, 10));
        Assert.assertEquals(97900, XPManager.get().evaluateTalent(talent8, 10));
    }

    @Test
    public void testEvaluateAttributs()
    {
        Assert.assertEquals(0, XPManager.get().evaluateAttributs(0));
        Assert.assertEquals(800, XPManager.get().evaluateAttributs(1));
        Assert.assertEquals(2100, XPManager.get().evaluateAttributs(2));
        Assert.assertEquals(4200, XPManager.get().evaluateAttributs(3));
        Assert.assertEquals(7600, XPManager.get().evaluateAttributs(4));
        Assert.assertEquals(13100, XPManager.get().evaluateAttributs(5));
    }

    @Test
    public void testEvaluateEquipment()
    {
        Assert.assertEquals(4000, XPManager.get().evaluateEquipment(forgeron));
    }

    @Test
    public void testEvaluateSkills()
    {
        malack.addSkill(new Skill("Test1", Attributs.DEX, true, 1)); // 200 PL
        Assert.assertEquals(200, XPManager.get().evaluateSkills(malack.getSkills()));

        malack.addSkill(new Skill("Test2", Attributs.DEX, true, 1)); // 200 PL
        Assert.assertEquals(400, XPManager.get().evaluateSkills(malack.getSkills()));

        malack.addSkill(new Skill("Test3", Attributs.DEX, true, 1).incrementRank()); // 200 + 300 PL
        Assert.assertEquals(900, XPManager.get().evaluateSkills(malack.getSkills()));

        malack.addSkill(new Skill("Test4", Attributs.DEX, true, 1).incrementRank().incrementRank()); // 200 + 300 + 500 PL
        Assert.assertEquals(1900, XPManager.get().evaluateSkills(malack.getSkills()));
    }

    @Test
    public void testEvaluateKarma()
    {
        Assert.assertEquals(1000, XPManager.get().evaluateKarma(Races.Elfe, 100));
        Assert.assertEquals(600, XPManager.get().evaluateKarma(Races.Humain, 100));
        Assert.assertEquals(1000, XPManager.get().evaluateKarma(Races.Nain, 100));
        Assert.assertEquals(1000, XPManager.get().evaluateKarma(Races.Obsidien, 100));
        Assert.assertEquals(700, XPManager.get().evaluateKarma(Races.Ork, 100));
        Assert.assertEquals(500, XPManager.get().evaluateKarma(Races.Sylphelin, 100));
        Assert.assertEquals(1000, XPManager.get().evaluateKarma(Races.Troll, 100));
        Assert.assertEquals(800, XPManager.get().evaluateKarma(Races.Tskrang, 100));
    }

}
