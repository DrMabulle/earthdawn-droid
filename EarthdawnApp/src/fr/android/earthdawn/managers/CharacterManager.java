/**
 *
 */
package fr.android.earthdawn.managers;

import java.util.List;

import fr.android.earthdawn.character.Character;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Races;
import fr.android.earthdawn.character.enums.Talent;
/**
 * @author DrMabulle
 *
 */
public class CharacterManager
{
    public static Character loadCharacter(final String id)
    {
        final Character malack = new Character("Malack", "N/A", 121, 245, 421, Races.Obsidien, 17, 1, 15, 1, 15, 1, 12, 1, 11, 0, 8, 0);
        malack.setMainDiscipline(Disciplines.Guerrier, 6);
        malack.setSecondDiscipline(Disciplines.Elementaliste, 1);

        Discipline discipline = malack.getMainDiscipline();
        List<Talent> talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 8); // Arme de mêlée
        discipline.setTalentRank(talents.get(1), 5); // Attaque accrobatique
        discipline.setTalentRank(talents.get(2), 6); // CombatMainsNues
        discipline.setTalentRank(talents.get(3), 6); // DanseAir
        discipline.setTalentRank(talents.get(4), 6); // PeauBois
        discipline.setTalentRank(talents.get(5), 2); // RituelKarmique
        discipline.setTalentRank(talents.get(6), 6); // Longevite
        discipline.setTalentRank(talents.get(7), 5); // ArmesJet
        discipline.setTalentRank(talents.get(8), 6); // Anticipation
        discipline.setTalentRank(talents.get(9), 6); // Esquive
        discipline.setTalentRank(talents.get(10), 6); // VivaciteTigre
        discipline.setTalentRank(talents.get(11), 5); // AttaquePlongeante
        discipline.setTalentRank(talents.get(12), 7); // Tissage
        discipline.setTalentRank(talents.get(13), 4); // CoupDouble
        discipline.setTalentRank(talents.get(14), 6); // Envol
        discipline.setTalentRank(talents.get(15), 1); // ArmesTrait
        discipline.setTalentRank(talents.get(16), 2); // UltimeSursaut

        discipline = malack.getSecondDiscipline();
        talents = discipline.getKnownTalents();
        discipline.setTalentRank(talents.get(0), 4); // Incantation
        discipline.setTalentRank(talents.get(1), 1); // RituelKarmique
        discipline.setTalentRank(talents.get(2), 2); // LectureEcriture
        discipline.setTalentRank(talents.get(3), 3); // LectureEcritureMagie
        discipline.setTalentRank(talents.get(4), 2); // Matrice
        discipline.setTalentRank(talents.get(5), 2); // Matrice
        discipline.setTalentRank(talents.get(6), 4); // Tissage

        return malack;
    }

}
