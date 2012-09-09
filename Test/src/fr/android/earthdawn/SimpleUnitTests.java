package fr.android.earthdawn;

import junit.framework.TestSuite;
import android.test.suitebuilder.TestSuiteBuilder;

public class SimpleUnitTests extends TestSuite
{
    public static TestSuite suite()
    {
        return new TestSuiteBuilder(SimpleUnitTests.class)
        .includePackages("fr.android.earthdawn.character", "fr.android.earthdawn.dices", "fr.android.earthdawn.managers", "fr.android.earthdawn.utils")
        .build();
    }
}
