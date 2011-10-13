package fr.android.earthdawn.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.character.Character;
import fr.android.earthdawn.character.enums.Attributs;
import fr.android.earthdawn.managers.DicesLauncher;
import fr.android.earthdawn.utils.Constants;

public class CharacterFragment extends AbstractRollingFragment implements View.OnClickListener
{
    private Character character;
    /**
     * The Fragment's UI is just a simple text view showing its
     * instance number.
     */
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.description, container, false);

        character = (Character) this.getArguments().get(Constants.BUNDLE_CHARACTER);

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


        return view;
    }

    private void fillGeneralInfos(final View view, final Character character)
    {
        view.findViewById(R.id.sheet_character).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        ((TextView) view.findViewById(R.id.sheet_name)).setText(character.getName());
        ((TextView) view.findViewById(R.id.sheet_race)).setText(character.getRace().getName());
        ((TextView) view.findViewById(R.id.sheet_age)).setText(Integer.toString(character.getAge()));
        ((TextView) view.findViewById(R.id.sheet_sex)).setText(character.getSex());
        ((TextView) view.findViewById(R.id.sheet_height)).setText(Integer.toString(character.getHeight()));
        ((TextView) view.findViewById(R.id.sheet_weight)).setText(Integer.toString(character.getWeight()));
    }

    private void fillAttributs(final View view, final Character character)
    {
        view.findViewById(R.id.sheet_attributs).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        // Dex
        ((ProgressBar) view.findViewById(R.id.progressDex)).setProgress(character.getAttribut(Attributs.DEX).getEvol());
        ((TextView) view.findViewById(R.id.sheet_indice_dex)).setText(Integer.toString(character.getAttribut(Attributs.DEX).getResultingIndice()));
        ((TextView) view.findViewById(R.id.sheet_level_dex)).setText(Integer.toString(character.getAttribut(Attributs.DEX).getRank()));
        ((ImageButton) view.findViewById(R.id.sheet_dex_roll)).setOnClickListener(this);
        // Str
        ((ProgressBar) view.findViewById(R.id.progressStr)).setProgress(character.getAttribut(Attributs.STR).getEvol());
        ((TextView) view.findViewById(R.id.sheet_indice_str)).setText(Integer.toString(character.getAttribut(Attributs.STR).getResultingIndice()));
        ((TextView) view.findViewById(R.id.sheet_level_str)).setText(Integer.toString(character.getAttribut(Attributs.STR).getRank()));
        ((ImageButton) view.findViewById(R.id.sheet_str_roll)).setOnClickListener(this);
        // End
        ((ProgressBar) view.findViewById(R.id.progressEnd)).setProgress(character.getAttribut(Attributs.END).getEvol());
        ((TextView) view.findViewById(R.id.sheet_indice_end)).setText(Integer.toString(character.getAttribut(Attributs.END).getResultingIndice()));
        ((TextView) view.findViewById(R.id.sheet_level_end)).setText(Integer.toString(character.getAttribut(Attributs.END).getRank()));
        ((ImageButton) view.findViewById(R.id.sheet_end_roll)).setOnClickListener(this);
        // Per
        ((ProgressBar) view.findViewById(R.id.progressPer)).setProgress(character.getAttribut(Attributs.PER).getEvol());
        ((TextView) view.findViewById(R.id.sheet_indice_per)).setText(Integer.toString(character.getAttribut(Attributs.PER).getResultingIndice()));
        ((TextView) view.findViewById(R.id.sheet_level_per)).setText(Integer.toString(character.getAttribut(Attributs.PER).getRank()));
        ((ImageButton) view.findViewById(R.id.sheet_per_roll)).setOnClickListener(this);
        // Vol
        ((ProgressBar) view.findViewById(R.id.progressVol)).setProgress(character.getAttribut(Attributs.VOL).getEvol());
        ((TextView) view.findViewById(R.id.sheet_indice_vol)).setText(Integer.toString(character.getAttribut(Attributs.VOL).getResultingIndice()));
        ((TextView) view.findViewById(R.id.sheet_level_vol)).setText(Integer.toString(character.getAttribut(Attributs.VOL).getRank()));
        ((ImageButton) view.findViewById(R.id.sheet_vol_roll)).setOnClickListener(this);
        // Cha
        ((ProgressBar) view.findViewById(R.id.progressCha)).setProgress(character.getAttribut(Attributs.CHA).getEvol());
        ((TextView) view.findViewById(R.id.sheet_indice_cha)).setText(Integer.toString(character.getAttribut(Attributs.CHA).getResultingIndice()));
        ((TextView) view.findViewById(R.id.sheet_level_cha)).setText(Integer.toString(character.getAttribut(Attributs.CHA).getRank()));
        ((ImageButton) view.findViewById(R.id.sheet_cha_roll)).setOnClickListener(this);
    }

    private void fillDisciplines(final View view, final Character character)
    {
        view.findViewById(R.id.sheet_disciplines).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        ((TextView) view.findViewById(R.id.sheet_main_discipline)).setText(character.getMainDisciplineDisplay());
        ((TextView) view.findViewById(R.id.sheet_second_discipline)).setText(character.getSecondDisciplineDisplay());
        ((TextView) view.findViewById(R.id.sheet_third_discipline)).setText(character.getThirdDisciplineDisplay());

        ((TextView) view.findViewById(R.id.sheet_main_circle)).setText(character.getMainCircleDisplay());
        ((TextView) view.findViewById(R.id.sheet_second_circle)).setText(character.getSecondCircleDisplay());
        ((TextView) view.findViewById(R.id.sheet_third_circle)).setText(character.getThirdCircleDisplay());
    }

    private void fillDeductibles(final View view, final Character character)
    {
        view.findViewById(R.id.sheet_deductibles).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        // Defenses
        ((TextView) view.findViewById(R.id.sheet_def_phy)).setText(Integer.toString(character.getPhysicalDefense()));
        ((TextView) view.findViewById(R.id.sheet_def_mag)).setText(Integer.toString(character.getMagicalDefense()));
        ((TextView) view.findViewById(R.id.sheet_def_soc)).setText(Integer.toString(character.getSocialDefense()));

        // TODO Equipement
        ((TextView) view.findViewById(R.id.sheet_equ_tra)).setText(Integer.toString(character.getCarryingCapacity()));
        ((TextView) view.findViewById(R.id.sheet_equ_lev)).setText(Integer.toString(character.getLiftingCapacity()));
        ((TextView) view.findViewById(R.id.sheet_equ_car)).setText("TODO"); // see equipment

        // TODO Initiative
        ((TextView) view.findViewById(R.id.sheet_init_dex)).setText(Integer.toString(character.getAttribut(Attributs.DEX).getRank()));
        ((TextView) view.findViewById(R.id.sheet_init_pen)).setText("TODO"); // see equipment
        ((TextView) view.findViewById(R.id.sheet_init_lvl)).setText(Integer.toString(character.getInitiativeLevel()));
        ((ImageButton) view.findViewById(R.id.roll_initiative)).setOnClickListener(this);

        // TODO Armor
        ((TextView) view.findViewById(R.id.sheet_arm_type)).setText("TODO"); // see equipment
        ((TextView) view.findViewById(R.id.sheet_arm_phy)).setText("TODO"); // see equipment
        ((TextView) view.findViewById(R.id.sheet_arm_mag)).setText(Integer.toString(character.getMysticArmor())); // see equipment

        // Mouvement
        ((TextView) view.findViewById(R.id.sheet_mvn_run)).setText(Integer.toString(character.getRunningMouvement()));
        ((TextView) view.findViewById(R.id.sheet_mvn_cbt)).setText(Integer.toString(character.getCombatMouvement()));
        ((TextView) view.findViewById(R.id.sheet_mvn_mel)).setText(Integer.toString(character.getCombatMouvement()));

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
                DicesLauncher.get().rollDices(character.getAttribut(Attributs.DEX).getRank());
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_dex));
                showDialogResult(args);
                break;
            case R.id.sheet_str_roll:
                DicesLauncher.get().rollDices(character.getAttribut(Attributs.STR).getRank());
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_str));
                showDialogResult(args);
                break;
            case R.id.sheet_end_roll:
                DicesLauncher.get().rollDices(character.getAttribut(Attributs.END).getRank());
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_end));
                showDialogResult(args);
                break;
            case R.id.sheet_per_roll:
                DicesLauncher.get().rollDices(character.getAttribut(Attributs.PER).getRank());
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_per));
                showDialogResult(args);
                break;
            case R.id.sheet_vol_roll:
                DicesLauncher.get().rollDices(character.getAttribut(Attributs.VOL).getRank());
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, getString(R.string.sheet_vol));
                showDialogResult(args);
                break;
            case R.id.sheet_cha_roll:
                DicesLauncher.get().rollDices(character.getAttribut(Attributs.CHA).getRank());
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

    private void fillHealthInfos(final View view, final Character character)
    {
        view.findViewById(R.id.sheet_health).setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        ((TextView) view.findViewById(R.id.sheet_health_points)).setText(Integer.toString(character.getHealthPoints()));
        ((TextView) view.findViewById(R.id.sheet_h_blood_magic)).setText("TODO"); // TODO with equipment
        ((TextView) view.findViewById(R.id.sheet_h_inconsciousness)).setText(Integer.toString(character.getUnconsciousnessPoints()));
        ((TextView) view.findViewById(R.id.sheet_h_restore_dices)).setText(Double.toString(character.getNbRecoveryTests()));
        ((TextView) view.findViewById(R.id.sheet_h_restore_dices_infos)).setText(character.getRecoveryDices());
        ((TextView) view.findViewById(R.id.sheet_h_wound_threshold)).setText(Integer.toString(character.getWoundThreshold()));
    }
}
