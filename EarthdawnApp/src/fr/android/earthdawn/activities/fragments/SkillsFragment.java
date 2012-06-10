package fr.android.earthdawn.activities.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.adapters.SkillAdapter;
import fr.android.earthdawn.activities.utils.AlertDialogUtils;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.EDDicesLauncher;

public class SkillsFragment extends Fragment implements View.OnClickListener
{
    private EDCharacter character;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.skills, container, false);

        character = CharacterManager.getLoadedCharacter();

        final ListView listV = (ListView) view.findViewById(R.id.sheet_skill_list);
        final SkillAdapter skillAdpater = new SkillAdapter(getActivity(), character, this);
        listV.setAdapter(skillAdpater);

        view.findViewById(R.id.skills_new).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(final View view)
    {
        if (view.getId() == R.id.skill_roll)
        {
            final View parent = (View) view.getParent();

            // Level of the skill
            final int level = Integer.parseInt((String) ((TextView) parent.findViewById(R.id.skills_level)).getText());

//            // XXX Name of the skill
//            final String skillname = (String) ((TextView) parent.findViewById(R.id.skills_skill)).getText();

            // Définir le niveau à lancer
            EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_SKILL, R.string.skill, level, character.getWounds()); // XXX

            // Strain
            final int strain = Integer.parseInt((String) ((TextView) parent.findViewById(R.id.skills_effort)).getText());
            CharacterManager.getLoadedCharacter().incrementStrain(strain);

            // Dialog box
            AlertDialogUtils.showDialogResult(getFragmentManager());
        }
        else if (view.getId() == R.id.skills_new)
        {
            // show popup for new Skill creation
            // Commun code
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            new NewSkillFragment().show(ft, "tag");
        }
    }
}
