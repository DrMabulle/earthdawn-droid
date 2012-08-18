package fr.android.earthdawn.test.activities;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;

import com.jayway.android.robotium.solo.Solo;

import fr.android.earthdawn.activities.EarthDawnActivity;

public class EarthDawnActivityTest extends ActivityInstrumentationTestCase2<EarthDawnActivity>
{
    private Solo solo;

    public EarthDawnActivityTest()
    {
        super(EarthDawnActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Smoke
    public void testButtons() throws Exception
    {
        //Assert that EarthDawnActivity activity is opened
        solo.assertCurrentActivity("Expected EarthDawn Activity", "EarthDawnActivity");
        // Ensure orientation of activity
        solo.setActivityOrientation(Solo.LANDSCAPE);
        // click on "create character" button
        solo.clickOnButton("Création perso");
        // We expect a popup with a error message
        solo.clickOnButton("Fermer");


        //Assert that EarthDawnActivity activity is opened
        solo.assertCurrentActivity("Expected EarthDawn Activity", "EarthDawnActivity");
        // click on "Carte de Barsaive" button
        solo.clickOnButton("Carte de Barsaive");
        //Assert that MapViewActivity activity is opened
        solo.assertCurrentActivity("Expected MapViewActivity", "MapViewActivity");
        // We expect a popup with a error message
        solo.goBack();
        //Assert that EarthDawnActivity activity is opened
        solo.assertCurrentActivity("Expected EarthDawn Activity", "EarthDawnActivity");


        // Click on the "Test" button
        solo.clickOnButton("Lanceur de dés");
        //Assert that RollerActivity is opened
        solo.assertCurrentActivity("Expected RollerActivity", "RollerActivity");
        // We expect a popup with a error message
        solo.goBack();
        //Assert that EarthDawnActivity activity is opened
        solo.assertCurrentActivity("Expected EarthDawn Activity", "EarthDawnActivity");


        // Click on the "Fiches de persos" button
        solo.clickOnButton("Fiche de perso");
        //Assert that ChooseCharacterActivity is opened
        solo.assertCurrentActivity("Expected ChooseCharacterActivity", "ChooseCharacterActivity");
        // We expect a popup with a error message
        solo.goBack();
        //Assert that EarthDawnActivity activity is opened
        solo.assertCurrentActivity("Expected EarthDawn Activity", "EarthDawnActivity");
    }
}
