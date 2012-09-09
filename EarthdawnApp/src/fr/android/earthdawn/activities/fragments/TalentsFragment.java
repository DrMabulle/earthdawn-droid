package fr.android.earthdawn.activities.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.adapters.TalentAdapter;
import fr.android.earthdawn.activities.utils.AlertDialogUtils;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.EDDicesLauncher;
import fr.android.earthdawn.managers.RankManager;
import fr.android.earthdawn.utils.Constants;

public class TalentsFragment extends Fragment implements View.OnClickListener
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
        if (view.getId() == R.id.talent_roll)
        {
            final View parent = (View) view.getParent();

            // Retrieve talent rank, for dice roll
            final int level = Integer.parseInt((String) ((TextView) parent.findViewById(R.id.talents_level)).getText());

            // Retrieve talent itself
            final int talentId = Integer.parseInt((String) ((TextView) parent.findViewById(R.id.talents_talent_id)).getText());
            final Talents talents = Talents.findByLabel(talentId);
            final Talent talent = discicpline.findTalent(talents);

            // Lack of karma...
            if (talent.isKarmaMandatory() && character.getAvailableKarma() == 0)
            {
                AlertDialogUtils.openAlertDialog(getActivity(), R.string.talent_with_karma_alert_title, R.string.talent_with_karma_alert_msg);
            }
            else
            {
                /*
                 * if talent is Discipline, ask player if he wishes to use karma.
                 * If karma can or must be used, check if character has karma left
                 * If karma is not used, simply roll the dices and show result
                 */
                if (talent.isDiscipline())
                {
                    // Open a popup to ask if player wants to use karma
                    final FragmentManager fm = getFragmentManager();
                    final TalentWithKarmaFragment fragment = new TalentWithKarmaFragment();
                    final Bundle bundle = new Bundle(2);
                    bundle.putSerializable(Constants.BUNDLE_TALENT, talent);
                    bundle.putInt(Constants.BUNDLE_TALENT_LEVEL, level);
                    fragment.setArguments(bundle);
                    fragment.show(fm, "fragment_talent_with_karma");
                }
                else
                {
                    talent.executePreAction();

                    if (talent.isKarmaMandatory())
                    {
                        // Definir les dés à lancer
                        final String dices = RankManager.getDicesFromRank(level);
                        final String karmaDice = RankManager.getDicesFromRank(character.getRace().getKarmaRank());
                        // Mettre le karma en premier pour éviter les problème avec les modificateurs
                        EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_TALENT, talentId, karmaDice + " + " + dices, character.getWounds());
                        character.incrementKarmaSpent(1);
                    }
                    else
                    {
                        // Définir le niveau à lancer
                        EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_TALENT, talentId, level, character.getWounds());
                    }

                    // Strain
                    character.incrementStrain(talent.getStrain());

                    // TODO Post action
                    talent.executePostAction();

                    // Dialog box
                    AlertDialogUtils.showDialogResult(getFragmentManager());
                }
            }
        }
    }
}
