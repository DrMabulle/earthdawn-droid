package fr.android.earthdawn.test.activities;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.NumberPicker;

import com.jayway.android.robotium.solo.Solo;

import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.EarthDawnActivity;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.utils.CharacterUtils;

public class CharacterSheetActivityTest extends ActivityInstrumentationTestCase2<EarthDawnActivity>
{
    private Solo solo;

    public CharacterSheetActivityTest()
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
    public void testInitRoll() throws Exception
    {
        gotoCharacterSheet();

        final ImageButton initButton = (ImageButton) solo.getView(R.id.roll_initiative);
        assertNotNull(initButton);
        solo.clickOnView(initButton);
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet de Initiative"));
        // Click on "Detail"
        solo.clickOnButton("Détails");
        assertTrue(solo.searchText("Résultat du jet de Initiative"));
        solo.clickOnButton("Fermer");
        solo.clickOnButton("Fermer");
    }

    @Smoke
    public void testAttributeRoll() throws Exception
    {
        gotoCharacterSheet();

        final ImageButton dexButton = (ImageButton) solo.getView(R.id.sheet_dex_roll);
        assertNotNull(dexButton);
        solo.clickOnView(dexButton);
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet de Dextérité"));
        // Click on "Detail"
        solo.clickOnButton("Détails");
        assertTrue(solo.searchText("Résultat du jet de Dextérité"));
        solo.clickOnButton("Fermer");
        solo.clickOnButton("Fermer");
    }

    @Smoke
    public void testBuyKarma() throws Exception
    {
        gotoCharacterSheet();

        final EDCharacter character = CharacterManager.getLoadedCharacter();
        final int karmaBought = character.getKarmaBought();

        // Make sure character can buy 2 karma points
        if (CharacterUtils.maxKarmaBuyable(character) < 2)
        {
            character.incrementKarmaSpent(2);
        }

        final Button karmaButton = (Button) solo.getView(R.id.karma_buy);
        assertNotNull(karmaButton);
        solo.clickOnView(karmaButton);
        // A popup should open
        assertTrue(solo.searchText("Achat de Karma"));
        final NumberPicker picker = (NumberPicker) solo.getView(R.id.karmaPicker);
        assertTrue(picker != null);
        picker.setValue(2);
        solo.clickOnButton("Acheter");
        assertEquals(karmaBought + 2, character.getKarmaBought());
    }

    @Smoke
    public void testSkillCreation() throws Exception
    {
        gotoCharacterSheet();

        // Go to Equipment tab
        solo.drag(800, 10, 200, 200, 1);
        solo.waitForText("Sarcasmes");
        solo.drag(800, 10, 200, 200, 1);
        solo.waitForText("Crochetage");
        solo.drag(800, 10, 200, 200, 1);
        solo.waitForText("Liste de vos possessions");
        solo.drag(800, 10, 200, 200, 1);
        solo.waitForText("Nouvelle compétence");

        // Check skill does not exist
        assertFalse(solo.searchText("Connaissance des Horreurs"));

        // Create skill
        solo.clickOnButton("Nouvelle compétence");
        solo.waitForText("Nom");
        final EditText label = (EditText) solo.getView(R.id.skill_new_label);
        solo.enterText(label, "Connaissance des Horreurs");
        //Spinner attribute = (Spinner) solo.getView(R.id.skill_new_attribut);
        solo.pressSpinnerItem(0, 3);
        solo.isSpinnerTextSelected("Perception");
        solo.clickOnCheckBox(0);
        solo.clickOnCheckBox(1);
        solo.clickOnButton("Ajouter");

        // Check skill is created
        assertTrue(solo.searchText("Connaissance des Horreurs"));

        // Try to roll the new skill
        final Activity activity = solo.getCurrentActivity();
        final ListView skills = (ListView) activity.findViewById(R.id.sheet_skill_list);
        final View skill = skills.getChildAt(skills.getChildCount() -1);
        final ImageButton roll = (ImageButton) skill.findViewById(R.id.skill_roll);
        solo.clickOnView(roll);
        assertTrue(solo.searchText("Résultat du jet de Compétence"));
        solo.clickOnButton("Fermer");

    }


    @Smoke
    public void testMenuActions1() throws Exception
    {
        gotoCharacterSheet();

        // Ensure complete healing
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Guérison complète");
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Récupérer fatigue");
        final EDCharacter character = CharacterManager.getLoadedCharacter();
        assertTrue(character.getWounds() == 0 && character.getStrain() == 0 && character.getDamages() == 0);

        // Take Damages
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Subir des dégats");
        final NumberPicker picker = (NumberPicker) solo.getView(R.id.damagesPicker);
        assertTrue(picker != null);
        picker.setValue(20);
        solo.clickOnButton("Subir");
        assertTrue(solo.searchText("Récapitulatif des dommages subis"));
        solo.clickOnButton("Fermer");
        assertTrue(character.getWounds() == 2);
        assertTrue(character.getDamages() == 20);

        // Heal a wound
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Guérir une blessure grave");
        assertTrue(character.getWounds() == 1);

        // Ensure complete healing
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Guérison complète");
        assertTrue(character.getWounds() == 0 && character.getStrain() == 0 && character.getDamages() == 0);
    }

    @Smoke
    public void testEquipment() throws Exception
    {
        gotoCharacterSheet();

        // Go to Equipment tab
        solo.drag(800, 10, 200, 200, 1);
        solo.waitForText("Sarcasmes");
        solo.drag(800, 10, 200, 200, 1);
        solo.waitForText("Crochetage");
        solo.drag(800, 10, 200, 200, 1);
        solo.waitForText("Liste de vos possessions");

        // Check list of equipment
        // Hidden
        assertFalse(solo.searchText("Dommages de l'arme", true));

        // Show
        final Activity activity = solo.getCurrentActivity();
        final ListView weapons = (ListView) activity.findViewById(android.R.id.list);
        final View weapon = weapons.getChildAt(0);
        solo.clickOnView(weapon);
        assertTrue(solo.searchText("Dommages de l'arme", true));

        // Hide
        solo.clickOnView(weapon);
        assertFalse(solo.searchText("Dommages de l'arme", true));

    }

    @Smoke
    public void testTalentRoll() throws Exception
    {
        gotoCharacterSheet();

        // Go to "MAITRE D'ARMES" tab
        solo.drag(800, 10, 200, 200, 1);

        // Locate roll button of first talent
        final Activity activity = solo.getCurrentActivity();
        final ListView talents = (ListView) activity.findViewById(R.id.sheet_talent_list);
        View talentLine = talents.getChildAt(0);
        ImageButton button = (ImageButton) talentLine.findViewById(R.id.talent_roll);

        // Test "Arme de Mêlée" talent without karma
        solo.clickOnView(button);
        // A popup should open
        assertTrue(solo.searchText("Talent : Armes de mêlée"));
        assertFalse(solo.isCheckBoxChecked("karma de discipline"));
        ImageButton rollButton = (ImageButton) solo.getView(R.id.popup_roll);
        assertNotNull(rollButton);
        solo.clickOnView(rollButton);
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet de Armes de mêlée"));
        // TODO assertTrue(solo.searchText("Vous avez lancé 1D20 + 1D8"));
        solo.clickOnButton("Détails");
        assertTrue(solo.searchText("Résultat du jet de Armes de mêlée"));
        // TODO assertTrue(solo.searchText("Vous avez lancé 1D20 + 1D8"));
        solo.clickOnButton("Fermer");
        solo.clickOnButton("Fermer");

        // Test "Arme de Mêlée" talent with karma
        solo.clickOnView(button);
        // A popup should open
        assertTrue(solo.searchText("Talent : Armes de mêlée"));
        solo.clickOnCheckBox(0);
        assertTrue(solo.isCheckBoxChecked("karma de discipline"));
        rollButton = (ImageButton) solo.getView(R.id.popup_roll);
        assertNotNull(rollButton);
        solo.clickOnView(rollButton);
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet de Armes de mêlée"));
        // TODO assertTrue(solo.searchText("Vous avez lancé 1D6 + 1D20 + 1D8"));
        solo.clickOnButton("Détails");
        assertTrue(solo.searchText("Résultat du jet de Armes de mêlée"));
        // TODO assertTrue(solo.searchText("Vous avez lancé 1D6 + 1D20 + 1D8"));
        solo.clickOnButton("Fermer");
        solo.clickOnButton("Fermer");



        // Test talent "Sarcasme" (no karma)
        talentLine = talents.getChildAt(4);
        button = (ImageButton) talentLine.findViewById(R.id.talent_roll);
        solo.clickOnView(button);
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet de Sarcasmes"));
        // TODO assertTrue(solo.searchText("Vous avez lancé 1D20 + 1D8"));
        solo.clickOnButton("Détails");
        assertTrue(solo.searchText("Résultat du jet de Sarcasmes"));
        // TODO assertTrue(solo.searchText("Vous avez lancé 1D20 + 1D8"));
        solo.clickOnButton("Fermer");
        solo.clickOnButton("Fermer");
    }

    private void gotoCharacterSheet()
    {
        // Click on the "Fiche de perso" button
        solo.clickOnButton("Fiche de perso");
        //Assert that RollerActivity is opened
        solo.assertCurrentActivity("Expected RollerActivity", "ChooseCharacterActivity");

        // Select a test character
        solo.clickOnButton("Hyacinthe Casteltourbe");

        // Assert we are on the chosen character sheet
        solo.waitForActivity("CharacterSheetActivity");
        solo.assertCurrentActivity("Expected RollerActivity", "CharacterSheetActivity");
        solo.waitForText("Informations générales");
        assertTrue(solo.searchText("Hyacinthe Casteltourbe"));
        assertTrue(solo.searchText("Maitre d'Armes"));
        assertTrue(solo.searchText("Voleur"));
        assertTrue(solo.searchText("Vision nocturne"));
    }

}
