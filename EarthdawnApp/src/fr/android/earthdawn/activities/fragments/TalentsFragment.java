package fr.android.earthdawn.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.adapters.TalentAdapter;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.EDDicesLauncher;
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

            final int level = Integer.parseInt((String) ((TextView) parent.findViewById(R.id.talents_level)).getText());
            // TODO Talents pre and post actions.
            final String talentname = (String) ((TextView) parent.findViewById(R.id.talents_talent)).getText();
            final int talentId = Integer.parseInt((String) ((TextView) parent.findViewById(R.id.talents_talent_id)).getText());
            final Talents talents = Talents.findByLabel(talentId);
            final Talent talent = discicpline.findTalent(talents);
            talent.executePreAction();

            if (talent.isKarmaMandatory())
            {
                // TODO vérifier que le perso a suffisamment de karma dispo, et sinon ouvrir une popup

                // Definir les dés à lancer
                final String dices = RankManager.getDicesFromRank(level);
                final String karmaDice = RankManager.getDicesFromRank(character.getRace().getKarmaRank());
                // Mettre le karma en premier pour éviter les problème avec les modificateurs
                EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_TALENT, talentId, karmaDice + " " + dices);
                character.incrementKarmaSpent(1);
            }
            else
            {
                // Définir le niveau à lancer
                EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_TALENT, talentId, level);
            }
            // Nom du talent
            args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, talentname);

            // TODO Post action
            talent.executePostAction();
            // Strain
            CharacterManager.getLoadedCharacter().incrementStrain(talent.getStrain());

            // Dialog box
            showDialogResult(args);
        }
    }
}
