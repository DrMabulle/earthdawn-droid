package fr.android.earthdawn.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Attributs;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.DicesLauncher;
import fr.android.earthdawn.managers.RankManager;
import fr.android.earthdawn.managers.XPManager;
import fr.android.earthdawn.utils.CharacterUtils;
import fr.android.earthdawn.utils.Constants;
import fr.android.earthdawn.utils.NumberUtils;

public class CharacterFragment extends AbstractRollingFragment implements View.OnClickListener
{
    private EDCharacter character;
    /**
     * The Fragment's UI is just a simple text view showing its
     * instance number.
     */
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.description, container, false);

        character = CharacterManager.getLoadedCharacter();

        // Fill Character Description with character infos
        fillGeneralInfos(view, character);

        // Fill Attributs with character infos
        fillAttributs(view, character);

        // Fill Disciplines with character infos
        fillDisciplines(view, character);

        // Fill Deductibles with character infos
        fillDeductibles(view, character);

        // Fill health infos
        fillHealthInfos(view, character);

        // Fill legend points infos
        fillLegendInfos(view, character);

        // Fill karma points infos
        fillKarmaInfos(view, character);


        return view;
    }

    private void fillGeneralInfos(final View view, final EDCharacter character)
    {
        view.findViewById(R.id.sheet_character).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        ((TextView) view.findViewById(R.id.sheet_name)).setText(character.getName());
        ((TextView) view.findViewById(R.id.sheet_race)).setText(character.getRace().getName());
        ((TextView) view.findViewById(R.id.sheet_age)).setText(Integer.toString(character.getAge()));
        ((TextView) view.findViewById(R.id.sheet_sex)).setText(character.getSex());
        ((TextView) view.findViewById(R.id.sheet_height)).setText(Integer.toString(character.getHeight()));
        ((TextView) view.findViewById(R.id.sheet_weight)).setText(Integer.toString(character.getWeight()));
    }

    private void fillAttributs(final View view, final EDCharacter character)
    {
        view.findViewById(R.id.sheet_attributs).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        // Dex
        ((ProgressBar) view.findViewById(R.id.progressDex)).setProgress(character.getAttributEvols(Attributs.DEX));
        ((TextView) view.findViewById(R.id.sheet_indice_dex)).setText(Integer.toString(character.getAttributIndice(Attributs.DEX)));
        ((TextView) view.findViewById(R.id.sheet_level_dex)).setText(Integer.toString(character.getAttributRank(Attributs.DEX)));
        ((ImageButton) view.findViewById(R.id.sheet_dex_roll)).setOnClickListener(this);
        // Str
        ((ProgressBar) view.findViewById(R.id.progressStr)).setProgress(character.getAttributEvols(Attributs.STR));
        ((TextView) view.findViewById(R.id.sheet_indice_str)).setText(Integer.toString(character.getAttributIndice(Attributs.STR)));
        ((TextView) view.findViewById(R.id.sheet_level_str)).setText(Integer.toString(character.getAttributRank(Attributs.STR)));
        ((ImageButton) view.findViewById(R.id.sheet_str_roll)).setOnClickListener(this);
        // End
        ((ProgressBar) view.findViewById(R.id.progressEnd)).setProgress(character.getAttributEvols(Attributs.END));
        ((TextView) view.findViewById(R.id.sheet_indice_end)).setText(Integer.toString(character.getAttributIndice(Attributs.END)));
        ((TextView) view.findViewById(R.id.sheet_level_end)).setText(Integer.toString(character.getAttributRank(Attributs.END)));
        ((ImageButton) view.findViewById(R.id.sheet_end_roll)).setOnClickListener(this);
        // Per
        ((ProgressBar) view.findViewById(R.id.progressPer)).setProgress(character.getAttributEvols(Attributs.PER));
        ((TextView) view.findViewById(R.id.sheet_indice_per)).setText(Integer.toString(character.getAttributIndice(Attributs.PER)));
        ((TextView) view.findViewById(R.id.sheet_level_per)).setText(Integer.toString(character.getAttributRank(Attributs.PER)));
        ((ImageButton) view.findViewById(R.id.sheet_per_roll)).setOnClickListener(this);
        // Vol
        ((ProgressBar) view.findViewById(R.id.progressVol)).setProgress(character.getAttributEvols(Attributs.VOL));
        ((TextView) view.findViewById(R.id.sheet_indice_vol)).setText(Integer.toString(character.getAttributIndice(Attributs.VOL)));
        ((TextView) view.findViewById(R.id.sheet_level_vol)).setText(Integer.toString(character.getAttributRank(Attributs.VOL)));
        ((ImageButton) view.findViewById(R.id.sheet_vol_roll)).setOnClickListener(this);
        // Cha
        ((ProgressBar) view.findViewById(R.id.progressCha)).setProgress(character.getAttributEvols(Attributs.CHA));
        ((TextView) view.findViewById(R.id.sheet_indice_cha)).setText(Integer.toString(character.getAttributIndice(Attributs.CHA)));
        ((TextView) view.findViewById(R.id.sheet_level_cha)).setText(Integer.toString(character.getAttributRank(Attributs.CHA)));
        ((ImageButton) view.findViewById(R.id.sheet_cha_roll)).setOnClickListener(this);
    }

    private void fillDisciplines(final View view, final EDCharacter character)
    {
        view.findViewById(R.id.sheet_disciplines).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        ((TextView) view.findViewById(R.id.sheet_main_discipline)).setText(character.getMainDisciplineDisplay());
        ((TextView) view.findViewById(R.id.sheet_second_discipline)).setText(character.getSecondDisciplineDisplay());
        ((TextView) view.findViewById(R.id.sheet_third_discipline)).setText(character.getThirdDisciplineDisplay());

        ((TextView) view.findViewById(R.id.sheet_main_circle)).setText(character.getMainCircleDisplay());
        ((TextView) view.findViewById(R.id.sheet_second_circle)).setText(character.getSecondCircleDisplay());
        ((TextView) view.findViewById(R.id.sheet_third_circle)).setText(character.getThirdCircleDisplay());
    }

    private void fillDeductibles(final View view, final EDCharacter character)
    {
        view.findViewById(R.id.sheet_deductibles).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        // Defenses
        ((TextView) view.findViewById(R.id.sheet_def_phy)).setText(Integer.toString(character.getPhysicalDefense()));
        ((TextView) view.findViewById(R.id.sheet_def_mag)).setText(Integer.toString(character.getMagicalDefense()));
        ((TextView) view.findViewById(R.id.sheet_def_soc)).setText(Integer.toString(character.getSocialDefense()));

        ((TextView) view.findViewById(R.id.sheet_equ_tra)).setText(Integer.toString(character.getCarryingCapacity()));
        ((TextView) view.findViewById(R.id.sheet_equ_lev)).setText(Integer.toString(character.getLiftingCapacity()));

        ((TextView) view.findViewById(R.id.sheet_init_dex)).setText(Integer.toString(character.getAttributRank(Attributs.DEX)));
        ((TextView) view.findViewById(R.id.sheet_init_pen)).setText(Integer.toString(character.computeBonusesInt(Pointcuts.INIT)));
        ((TextView) view.findViewById(R.id.sheet_init_lvl)).setText(Integer.toString(character.getInitiativeLevel()));
        ((ImageButton) view.findViewById(R.id.roll_initiative)).setOnClickListener(this);

        // TODO Armor
        ((TextView) view.findViewById(R.id.sheet_arm_type)).setText("TODO"); // see equipment
        ((TextView) view.findViewById(R.id.sheet_arm_phy)).setText(Integer.toString(character.getPhysicalArmor())); // see equipment
        ((TextView) view.findViewById(R.id.sheet_arm_mag)).setText(Integer.toString(character.getMysticArmor())); // see equipment

        // Mouvement
        ((TextView) view.findViewById(R.id.sheet_mvn_run)).setText(Integer.toString(character.getRunningMouvement()));
        ((TextView) view.findViewById(R.id.sheet_mvn_cbt)).setText(Integer.toString(character.getCombatMouvement()));

        // Racial abilities
        final int[] ids = {R.id.sheet_racial_apt1, R.id.sheet_racial_apt2, R.id.sheet_racial_apt3, R.id.sheet_racial_apt4};
        final int[] apts = character.getRace().getAptitudes();
        for (int i = 0, l=apts.length; i < l; i++)
        {
            ((TextView) view.findViewById(ids[i])).setText(getString(apts[i]));
        }
    }

    @Override
    public void onClick(final View view)
    {
        final Bundle args = new Bundle(1);
        switch (view.getId())
        {
            case R.id.sheet_dex_roll:
                DicesLauncher.get().rollDices(character.getAttributRank(Attributs.DEX));
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_dex));
                showDialogResult(args);
                break;
            case R.id.sheet_str_roll:
                DicesLauncher.get().rollDices(character.getAttributRank(Attributs.STR));
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_str));
                showDialogResult(args);
                break;
            case R.id.sheet_end_roll:
                DicesLauncher.get().rollDices(character.getAttributRank(Attributs.END));
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_end));
                showDialogResult(args);
                break;
            case R.id.sheet_per_roll:
                DicesLauncher.get().rollDices(character.getAttributRank(Attributs.PER));
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_per));
                showDialogResult(args);
                break;
            case R.id.sheet_vol_roll:
                DicesLauncher.get().rollDices(character.getAttributRank(Attributs.VOL));
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_vol));
                showDialogResult(args);
                break;
            case R.id.sheet_cha_roll:
                DicesLauncher.get().rollDices(character.getAttributRank(Attributs.CHA));
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_cha));
                showDialogResult(args);
                break;
            case R.id.roll_initiative:
                DicesLauncher.get().rollDices(character.getInitiativeLevel());
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_initiative));
                showDialogResult(args);
                break;
        }
    }

    private void fillHealthInfos(final View view, final EDCharacter character)
    {
        view.findViewById(R.id.sheet_health).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        ((TextView) view.findViewById(R.id.sheet_health_points)).setText(Integer.toString(character.getHealthPoints()));
        ((TextView) view.findViewById(R.id.sheet_h_blood_magic)).setText(Integer.toString(character.computeBonusesInt(Pointcuts.BLOOD_MAGIC)));
        ((TextView) view.findViewById(R.id.sheet_h_inconsciousness)).setText(Integer.toString(character.getUnconsciousnessPoints()));
        ((TextView) view.findViewById(R.id.sheet_h_restore_dices)).setText(NumberUtils.format(character.getNbRecoveryTests()));
        ((TextView) view.findViewById(R.id.sheet_h_restore_dices_infos)).setText(character.getRecoveryDices());
        ((TextView) view.findViewById(R.id.sheet_h_wound_threshold)).setText(Integer.toString(character.getWoundThreshold()));
    }

    private void fillLegendInfos(final View view, final EDCharacter character)
    {
        view.findViewById(R.id.sheet_legend).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        // Total earned
        ((TextView) view.findViewById(R.id.sheet_legend_total)).setText(Integer.toString(character.getLegendPoints()));
        // Total spent
        final int legendSpent = XPManager.get().evaluateCharacter(character);
        ((TextView) view.findViewById(R.id.sheet_legend_spent)).setText(Integer.toString(legendSpent));
        // Spent in karma
        final int legendKarma = XPManager.get().evaluateKarma(character.getRace(), character.getKarmaBought());
        ((TextView) view.findViewById(R.id.sheet_legend_karma)).setText(Integer.toString(legendKarma));
        // Available
        ((TextView) view.findViewById(R.id.sheet_legend_available)).setText(Integer.toString(character.getLegendPoints() - legendSpent));
    }

    private void fillKarmaInfos(final View view, final EDCharacter character)
    {
        view.findViewById(R.id.sheet_karma).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        // Points de karma disponibles : <available> / <max>
        final String karmaAvailable = getString(R.string.sheet_karma_available_detail,
                character.getAvailableKarma(),
                CharacterUtils.getMaxKarma(character));
        ((TextView) view.findViewById(R.id.sheet_karma_available)).setText(karmaAvailable);
        // Niveau de karma : <level> (<dices>)
        final String karmaLvl = getString(R.string.sheet_karma_lvl_detail,
                character.getRace().getKarmaRank(),
                RankManager.getDicesFromRank(character.getRace().getKarmaRank()));
        ((TextView) view.findViewById(R.id.sheet_karma_level)).setText(karmaLvl);
        // Special uses
        // TODO see discipline perks
    }
}
