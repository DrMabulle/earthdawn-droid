package fr.android.earthdawn.test.activities;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;

import com.jayway.android.robotium.solo.Solo;

import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.EarthDawnActivity;

public class RollerActivityTest extends ActivityInstrumentationTestCase2<EarthDawnActivity>
{
    private Solo solo;

    public RollerActivityTest()
    {
        super(EarthDawnActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    protected void tearDown() throws Exception
    {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    @Smoke
    public void testRoller1() throws Exception
    {
        // Click on the "Test" button
        solo.clickOnButton("Lanceur de dés");
        //Assert that RollerActivity is opened
        solo.assertCurrentActivity("Expected RollerActivity", "RollerActivity");
        // Change spinner value and roll dices
        final NumberPicker picker = (NumberPicker) solo.getView(R.id.rankPicker);
        assertNotNull(picker);
        final ImageButton upButton = ((ImageButton) picker.getChildAt(0));
        assertNotNull(upButton);
        for(int i=1; i<20; i++)
        {
            solo.clickOnView(upButton);
        }
        solo.clickOnButton("Lancer les dés");
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet"));
        // Click on "Detail"
        solo.clickOnButton("Détails");
        solo.clickOnButton("Fermer");
        solo.clickOnButton("Fermer");
    }

    @Smoke
    public void testRoller2() throws Exception
    {
        // Click on the "Test" button
        solo.clickOnButton("Lanceur de dés");
        //Assert that RollerActivity is opened
        solo.assertCurrentActivity("Expected RollerActivity", "RollerActivity");
        // Change EditText and roll dices
        final EditText txt = solo.getEditText(1);
        assertNotNull(txt);
        solo.enterText(txt, "2D10 + 1D8 - 4 + 1D4");
        solo.clickOnButton("Lancer les dés");
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet"));
        // Click on "Detail"
        solo.clickOnButton("Détails");
        solo.clickOnButton("Fermer");
        solo.clickOnButton("Fermer");

        // Error test
        solo.clearEditText(txt);
        solo.enterText(txt, "2D10 1D8");
        solo.clickOnButton("Lancer les dés");
        // A popup should open showing an error message
        // Click on "Detail"
        assertTrue(solo.searchText("Erreur de saisie"));
        solo.clickOnButton("Fermer");
    }
}
