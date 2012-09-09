package fr.android.earthdawn;

import junit.framework.TestSuite;
import android.test.suitebuilder.TestSuiteBuilder;

public class ActivityTestUnitSuite extends TestSuite
{
	public static TestSuite suite()
	{
        return new TestSuiteBuilder(ActivityTestUnitSuite.class).includePackages("fr.android.earthdawn.test").build();
    }
}
