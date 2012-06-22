package fr.android.earthdawn.activities.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.utils.AlertDialogUtils;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.EDDicesLauncher;
import fr.android.earthdawn.managers.RankManager;
import fr.android.earthdawn.utils.Constants;

/**
 * @author DrMabulle
 *
 */
public class TalentWithKarmaFragment extends DialogFragment implements View.OnClickListener
{
    private Talent talent;
    private int talentLevel;

    public TalentWithKarmaFragment()
    {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.popup_talent_with_karma, container);

        // Title

        talent = (Talent) getArguments().get(Constants.BUNDLE_TALENT);
        talentLevel = (Integer) getArguments().get(Constants.BUNDLE_TALENT_LEVEL);
        getDialog().setTitle(getString(R.string.talent_with_karma_title, getString(talent.getName())));

        // Retrieve concerned character and talent
        final EDCharacter character = CharacterManager.getLoadedCharacter();
        final int availablePoints = character.getAvailableKarma();

        // Karma mandatory checkbox
        CheckBox box = (CheckBox) view.findViewById(R.id.talent_with_karma_mandatory);
        if (talent.isKarmaMandatory())
        {
            box.setChecked(true);
            box.setClickable(false);
        }
        else
        {
            box.setChecked(false);
            box.setVisibility(View.GONE);
        }

        // Discipline checkbox
        box = (CheckBox) view.findViewById(R.id.talent_with_karma_discipline);
        box.setChecked(true);
        if (talent.isKarmaMandatory() && availablePoints == 1 || !talent.isKarmaMandatory() && availablePoints == 0)
        {
            box.setChecked(false);
            box.setClickable(false);
        }

        // Available karma points
        ((TextView) view.findViewById(R.id.talent_with_karma_available_points)).setText(getString(R.string.talent_with_karma_available_points, availablePoints));

        // Close Button
        view.findViewById(R.id.popup_close).setOnClickListener(this);
        // Details Button
        view.findViewById(R.id.popup_roll).setOnClickListener(this);
        // Hide action Button
        view.findViewById(R.id.popup_action).setVisibility(View.GONE);

        return view;
    }

    @Override
    public void onClick(final View aView)
    {
        switch (aView.getId())
        {
            case R.id.popup_close:
                dismiss();
                break;
            case R.id.popup_roll:

                // Retrieve number of karma point spent
                final View parent = (View) aView.getParent().getParent().getParent();
                final boolean isDisciplineChecked = ((CheckBox) parent.findViewById(R.id.talent_with_karma_discipline)).isChecked();
                final boolean isMandatoryChecked = ((CheckBox) parent.findViewById(R.id.talent_with_karma_mandatory)).isChecked();
                int karmaAdded = 0;
                if (isDisciplineChecked && isMandatoryChecked)
                {
                    karmaAdded = 2;
                }
                else if (isDisciplineChecked || isMandatoryChecked)
                {
                    karmaAdded = 1;
                }

                // Definir les dés à lancer
                final EDCharacter character = CharacterManager.getLoadedCharacter();
                final String dices = RankManager.getDicesFromRank(talentLevel);
                final String karmaDice = RankManager.getDicesFromRank(character.getRace().getKarmaRank());
                // Mettre le karma en premier pour éviter les problème avec les modificateurs
                final StringBuilder dicesInfos = new StringBuilder(16);
                for (int i=0; i<karmaAdded; i++)
                {
                    dicesInfos.append(karmaDice);
                    dicesInfos.append(" + ");
                }
                dicesInfos.append(dices);

                // Execute talent
                talent.executePreAction();
                EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_TALENT, talent.getName(), dicesInfos.toString(), character.getWounds());
                character.incrementKarmaSpent(karmaAdded);
                character.incrementStrain(talent.getStrain());
                talent.executePostAction();

                // Dismiss current popup
                dismiss();
                // Show results
                AlertDialogUtils.showDialogResult(getFragmentManager());

                break;
        }
    }
}
