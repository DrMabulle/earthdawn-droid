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
    private static final String HYACINTHE = "Hyacinthe Casteltourbe";
    private static final String MALACK = "Malack";
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
    public void testInitRoll1() throws Exception
    {
        gotoCharacterSheet(HYACINTHE);

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
    public void testInitRoll2() throws Exception
    {
        gotoCharacterSheet(MALACK);

        final ImageButton initButton = (ImageButton) solo.getView(R.id.roll_initiative);
        assertNotNull(initButton);
        solo.clickOnView(initButton);

        // First popup
        assertTrue(solo.searchText("Talents modificateurs d'Initiative"));
        final ImageButton button = (ImageButton) solo.getView(R.id.popup_roll);
        solo.clickOnView(button);

        // A popup should open
        assertTrue(solo.searchText("Résultat du jet de Initiative"));
        // Click on "Detail"
        solo.clickOnButton("Détails");
        assertTrue(solo.searchText("Résultat du jet de Initiative"));
        solo.clickOnButton("Fermer");
        solo.clickOnButton("Fermer");
    }

    @Smoke
    public void testBonusMalus() throws Exception
    {
        gotoCharacterSheet(HYACINTHE);

        solo.sendKey(Solo.MENU);
        solo.clickOnText("Bonus / Malus");

        solo.assertCurrentActivity("Expected RollerActivity", "BonusMalusActivity");

        solo.goBack();
        solo.assertCurrentActivity("Expected RollerActivity", "CharacterSheetActivity");
    }

    @Smoke
    public void testAttributeRoll() throws Exception
    {
        gotoCharacterSheet(HYACINTHE);

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
        gotoCharacterSheet(HYACINTHE);

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
        assertNotNull(picker);
        final ImageButton downButton = ((ImageButton) picker.getChildAt(2));
        assertNotNull(downButton);
        solo.clickOnView(downButton);
        solo.clickOnButton("Acheter");
        assertEquals(karmaBought + 2, character.getKarmaBought());


        // popup when cannot buy more karma
        character.incrementKarmaSpent(CharacterUtils.maxKarmaBuyable(character));
        solo.clickOnView(karmaButton);
        assertTrue(solo.searchText("Action impossible"));
        solo.clickOnButton("Fermer");
    }

    @Smoke
    public void testSkillCreation() throws Exception
    {
        gotoCharacterSheet(HYACINTHE);

        // Go to Equipment tab
        solo.drag(800, 10, 200, 200, 1);
        solo.waitForText("Sarcasmes");
        solo.drag(800, 10, 200, 200, 1);
        solo.waitForText("Crochetage");
        solo.drag(800, 10, 200, 200, 1);
        solo.waitForText("Liste de vos possessions");
        solo.drag(800, 10, 200, 200, 1);
        solo.waitForText("Nouvelle compétence");

        final String skillName = "Skill" + System.currentTimeMillis();

        // Check skill does not exist
        assertFalse(solo.searchText(skillName));

        // Create skill
        solo.clickOnButton("Nouvelle compétence");
        solo.waitForText("Nom");
        final EditText label = (EditText) solo.getView(R.id.skill_new_label);
        solo.enterText(label, skillName);
        //Spinner attribute = (Spinner) solo.getView(R.id.skill_new_attribut);
        solo.pressSpinnerItem(0, 3);
        solo.isSpinnerTextSelected("Perception");
        solo.clickOnCheckBox(0);
        solo.clickOnCheckBox(1);
        solo.clickOnButton("Ajouter");

        // Check skill is created
        assertTrue(solo.searchText(skillName));

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
        gotoCharacterSheet(HYACINTHE);

        // Ensure complete healing
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Guérison complète");
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Récupérer fatigue");
        final EDCharacter character = CharacterManager.getLoadedCharacter();
        assertTrue(character.getWounds() == 0 && character.getStrain() == 0 && character.getDamages() == 0);

        // Show health state
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Etat de santé");
        assertTrue(solo.waitForText("Personnage conscient"));

        // Take Damages
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Subir des dégâts");
        assertTrue(solo.waitForText("Dommages à subir"));
        NumberPicker picker = (NumberPicker) solo.getView(R.id.damagesPicker);
        assertNotNull(picker);
        ImageButton upButton = ((ImageButton) picker.getChildAt(0));
        assertNotNull(upButton);
        for(int i=1; i<20; i++)
        {
            Thread.sleep(500);
            solo.clickOnView(upButton);
        }
        solo.clickOnButton("Subir");
        assertTrue(solo.searchText("Récapitulatif des dommages subis"));
        solo.clickOnButton("Fermer");
        assertTrue(character.getWounds() == 2);
        assertTrue(character.getDamages() == 20);

        // Show health state
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Etat de santé");
        assertTrue(solo.waitForText("Personnage conscient"));

        // Heal a wound
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Guérir une blessure grave");
        assertTrue(solo.waitForText("Une blessure grave a été soignée"));
        assertTrue(character.getWounds() == 1);

        // Show health state
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Etat de santé");
        assertTrue(solo.waitForText("Personnage conscient"));

        // Take Damages
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Subir des dégâts");
        assertTrue(solo.waitForText("Dommages à subir"));
        picker = (NumberPicker) solo.getView(R.id.damagesPicker);
        assertNotNull(picker);
        upButton = ((ImageButton) picker.getChildAt(0));
        assertNotNull(upButton);
        for(int i=1; i<50; i++)
        {
            Thread.sleep(500);
            solo.clickOnView(upButton);
        }
        solo.clickOnButton("Subir");
        assertTrue(solo.searchText("Récapitulatif des dommages subis"));
        solo.clickOnButton("Fermer");
        assertTrue(character.getDamages() == 70);
        assertTrue(character.getWounds() == 7);

        // Show health state
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Etat de santé");
        assertTrue(solo.waitForText("Personnage dans l'inconscience"));

        // Take Damages
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Subir des dégâts");
        assertTrue(solo.waitForText("Dommages à subir"));
        picker = (NumberPicker) solo.getView(R.id.damagesPicker);
        assertNotNull(picker);
        upButton = ((ImageButton) picker.getChildAt(0));
        assertNotNull(upButton);
        for(int i=1; i<12; i++)
        {
            Thread.sleep(500);
            solo.clickOnView(upButton);
        }
        solo.clickOnButton("Subir");
        assertTrue(solo.searchText("Récapitulatif des dommages subis"));
        solo.clickOnButton("Fermer");

        // Show health state
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Etat de santé");
        assertTrue(solo.waitForText("Personnage mort"));

        // Ensure complete healing
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Guérison complète");
        assertTrue(character.getWounds() == 0 && character.getStrain() == 0 && character.getDamages() == 0);
    }

    @Smoke
    public void testMenuActions2() throws Exception
    {
        gotoCharacterSheet(HYACINTHE);

        // Ensure complete healing
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Jet de dégâts");

        solo.clickOnText("Rapière forgée (+8)");
        final ImageButton button = (ImageButton) solo.getView(R.id.popup_roll);
        solo.clickOnView(button);

        assertTrue(solo.searchText("Résultat du jet de Dommages"));
        solo.clickOnButton("Fermer");
    }

    @Smoke
    public void testMenuActions3() throws Exception
    {
        gotoCharacterSheet(HYACINTHE);

        solo.sendKey(Solo.MENU);
        solo.clickOnText("Jet de récupération");

        assertTrue(solo.searchText("Jet de récupération"));

        // Increment bonus on rank
        NumberPicker picker = (NumberPicker) solo.getView(R.id.recup_rank_bonus);
        assertNotNull(picker);
        ImageButton upButton = ((ImageButton) picker.getChildAt(0));
        assertNotNull(upButton);
        for(int i=1; i<5; i++)
        {
            Thread.sleep(500);
            solo.clickOnView(upButton);
        }

        // Increment bonus on result
        picker = (NumberPicker) solo.getView(R.id.recup_fix_bonus);
        assertNotNull(picker);
        upButton = ((ImageButton) picker.getChildAt(0));
        assertNotNull(upButton);
        for(int i=1; i<3; i++)
        {
            Thread.sleep(500);
            solo.clickOnView(upButton);
        }

        final ImageButton button = (ImageButton) solo.getView(R.id.popup_roll);
        solo.clickOnView(button);

        assertTrue(solo.waitForText("Résultat du jet de récupération"));
    }

    @Smoke
    public void testMenuActions4() throws Exception
    {
        gotoCharacterSheet(HYACINTHE);

        final EDCharacter character = CharacterManager.getLoadedCharacter();
        final int pl = character.getLegendPoints();

        solo.sendKey(Solo.MENU);
        solo.clickOnText("Recevoir des points de Légende");

        assertTrue(solo.searchText("Gain de points de Légende"));

        final EditText txt = solo.getEditText(0);
        assertNotNull(txt);
        solo.enterText(txt, "200");
        solo.clickOnButton("Ajouter");

        assertTrue(solo.searchText("200 points de Légende correctement ajoutés au personnage"));
        assertEquals(pl + 200, character.getLegendPoints());
    }

    @Smoke
    public void testMenuActions5() throws Exception
    {
        gotoCharacterSheet(HYACINTHE);

        solo.sendKey(Solo.MENU);
        solo.clickOnText("Jets de dés libres");

        solo.assertCurrentActivity("Expected RollerActivity", "RollerActivity");

        solo.goBack();
        solo.assertCurrentActivity("Expected RollerActivity", "CharacterSheetActivity");
    }

    @Smoke
    public void testMenuActions6() throws Exception
    {
        gotoCharacterSheet(HYACINTHE);

        // Str
        ImageButton attButton = (ImageButton) solo.getView(R.id.sheet_str_roll);
        assertNotNull(attButton);
        solo.clickOnView(attButton);
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet de Force"));
        solo.clickOnButton("Fermer");

        // End
        attButton = (ImageButton) solo.getView(R.id.sheet_end_roll);
        assertNotNull(attButton);
        solo.clickOnView(attButton);
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet de Endurance"));
        solo.clickOnButton("Fermer");

        // Per
        attButton = (ImageButton) solo.getView(R.id.sheet_per_roll);
        assertNotNull(attButton);
        solo.clickOnView(attButton);
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet de Perception"));
        solo.clickOnButton("Fermer");

        // Vol
        attButton = (ImageButton) solo.getView(R.id.sheet_vol_roll);
        assertNotNull(attButton);
        solo.clickOnView(attButton);
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet de Volonté"));
        solo.clickOnButton("Fermer");

        // Char
        attButton = (ImageButton) solo.getView(R.id.sheet_cha_roll);
        assertNotNull(attButton);
        solo.clickOnView(attButton);
        // A popup should open
        assertTrue(solo.searchText("Résultat du jet de Charisme"));
        solo.clickOnButton("Fermer");


        // See History
        solo.sendKey(Solo.MENU);
        solo.clickOnText("Historique des jets");

        final ListView rolls = (ListView) solo.getView(R.id.popup_roll_history_list);
        assertTrue(rolls.getChildCount() >= 5);
        assertTrue(solo.searchText("Jet de Force a donné"));
        assertTrue(solo.searchText("Jet de Endurance a donné"));
        assertTrue(solo.searchText("Jet de Perception a donné"));
        assertTrue(solo.searchText("Jet de Volonté a donné"));
        assertTrue(solo.searchText("Jet de Charisme a donné"));

        // Fold / Unfold
        assertFalse(solo.searchText("Détails du lancé", true));
        solo.clickOnText("Jet de Charisme a donné");
        assertTrue(solo.searchText("Détails du lancé :", true));
        solo.clickOnText("Jet de Charisme a donné");
        assertFalse(solo.searchText("Détails du lancé :", true));

        solo.clickOnButton("Fermer");
    }

    @Smoke
    public void testEquipment() throws Exception
    {
        gotoCharacterSheet(HYACINTHE);

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
        gotoCharacterSheet(HYACINTHE);

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

    private void gotoCharacterSheet(final String id)
    {
        // Click on the "Fiche de perso" button
        solo.clickOnButton("Fiche de perso");
        //Assert that RollerActivity is opened
        solo.assertCurrentActivity("Expected RollerActivity", "ChooseCharacterActivity");

        // Select a test character
        solo.clickOnButton(id);

        // Assert we are on the chosen character sheet
        solo.waitForActivity("CharacterSheetActivity");
        solo.assertCurrentActivity("Expected RollerActivity", "CharacterSheetActivity");
        solo.waitForText("Informations générales");
        assertTrue(solo.searchText(id));
        assertTrue(solo.searchText("Aptitudes raciales"));
    }

}
