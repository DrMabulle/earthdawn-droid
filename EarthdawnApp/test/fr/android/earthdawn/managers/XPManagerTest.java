package fr.android.earthdawn.managers;

import static org.junit.Assert.fail;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fr.android.earthdawn.character.Character;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;

public class XPManagerTest
{
    private Character malack;
    private Character purifier;

    @Before
    public void setUp() throws Exception
    {
        malack = new Character("Malack", "N/A", 121, 245, 421, Races.Obsidien, 17, 1, 15, 1, 13, 1, 13, 1, 11, 0, 8, 0);
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

        purifier = new Character("Ajmar", "N/A", 121, 245, 421, Races.Obsidien, 17, 1, 15, 1, 13, 3, 12, 0, 10, 0, 11, 0);
        purifier.setMainDiscipline(Disciplines.Purificateur, 6);
        discipline = purifier.getMainDiscipline();
        talents = discipline.getKnownTalents();

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
        discipline.setTalentRank(talents.get(14), 1); // RituelMaitreFantome
        discipline.setTalentRank(talents.get(15), 7); // VolonteFer

        discipline.setTalentRank(talents.get(16), 5); // UltimeSursaut
        discipline.setTalentRank(talents.get(17), 6); // VivaciteTigre
    }

    @Test
    public void testEvaluateCharacter()
    {
        Assert.assertEquals(57900, XPManager.get().evaluateCharacter(malack));
        Assert.assertEquals(72600, XPManager.get().evaluateCharacter(purifier));
    }

    @Test
    public void testEvaluateDiscipline()
    {
        Assert.assertEquals(50000, XPManager.get().evaluateDiscipline(malack.getMainDiscipline()));
        Assert.assertEquals(4700, XPManager.get().evaluateDiscipline(malack.getSecondDiscipline()));

        Assert.assertEquals(66800, XPManager.get().evaluateDiscipline(purifier.getMainDiscipline()));
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
        fail("Not yet implemented");
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
