/**
 *
 */
package fr.android.earthdawn.managers;

import fr.android.earthdawn.character.Character;
import fr.android.earthdawn.character.enums.Disciplines;
import fr.android.earthdawn.character.enums.Races;
/**
 * @author DrMabulle
 *
 */
public class CharacterManager
{
    public static Character loadCharacter(final String id)
    {
        final Character malack = new Character("Malack", "N/A", 121, 245, 421, Races.Obsidien, 17, 1, 15, 2, 15, 3, 12, 4, 11, 5, 8, 0);
        malack.setMainDiscipline(Disciplines.Guerrier, 6);
        malack.setSecondDiscipline(Disciplines.Elementaliste, 1);

        return malack;
    }

}
