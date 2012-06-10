package fr.android.earthdawn;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.android.earthdawn.character.AttributTest;
import fr.android.earthdawn.character.CharacterTest;
import fr.android.earthdawn.character.enums.DisciplineTest;
import fr.android.earthdawn.dices.DiceTest;
import fr.android.earthdawn.dices.DicesLauncherTest;
import fr.android.earthdawn.managers.RankManagerTest;
import fr.android.earthdawn.managers.XPManagerTest;
import fr.android.earthdawn.utils.CharacterUtilsTest;
import fr.android.earthdawn.utils.NumberUtilsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(value={
        AttributTest.class,
        CharacterTest.class,
        DiceTest.class,
        XPManagerTest.class,
        NumberUtilsTest.class,
        DisciplineTest.class,
        RankManagerTest.class,
        DicesLauncherTest.class,
        CharacterUtilsTest.class })
public class AllTests
{
    // Tests
}
