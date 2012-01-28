package fr.android.earthdawn.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.adapters.TalentAdapter;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.DicesLauncher;
import fr.android.earthdawn.managers.RankManager;
import fr.android.earthdawn.utils.Constants;

public class TalentsFragment extends AbstractRollingFragment implements View.OnClickListener
{
    private EDCharacter character;
    private Discipline discicpline;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.talents, container, false);

        character = CharacterManager.getLoadedCharacter();
        discicpline = (Discipline) this.getArguments().get(Constants.BUNDLE_DISCIPLINE);

        final ListView listV = (ListView) view.findViewById(R.id.sheet_talent_list);
        final TalentAdapter talentAdpater = new TalentAdapter(getActivity(), character, discicpline, this);
        listV.setAdapter(talentAdpater);

        return view;
    }



    @Override
    public void onClick(final View view)
    {
        final Bundle args = new Bundle(2);
        if (view.getId() == R.id.talent_roll)
        {
            final View parent = (View) view.getParent();

            final boolean isKarmaMandatory = ((RadioButton) parent.findViewById(R.id.talents_karma)).isChecked();
            final int level = Integer.parseInt((String) ((TextView) parent.findViewById(R.id.talents_level)).getText());
            // TODO Talents pre and post actions.
            final String talentname = (String) ((TextView) parent.findViewById(R.id.talents_talent)).getText();
            final Talents talents = Talents.findByLabel(talentname);
            final Talent talent = discicpline.findTalent(talents);
            talent.executePreAction();

            if (isKarmaMandatory)
            {
                // Definir les dés à lancer
                final String dices = RankManager.getDicesFromRank(level);
                final String karmaDice = RankManager.getDicesFromRank(character.getRace().getKarmaRank());
                // Mettre le karma en premier pour éviter les problème avec les modificateurs
                DicesLauncher.get().rollDices(karmaDice + " " + dices);
            }
            else
            {
                // Définir le niveau à lancer
                DicesLauncher.get().rollDices(level);
            }
            // Nom du talent
            args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, ((TextView) parent.findViewById(R.id.talents_talent)).getText());

            // Post action
            talent.executePostAction();
            // Dialog box
            showDialogResult(args);
        }
    }
}
