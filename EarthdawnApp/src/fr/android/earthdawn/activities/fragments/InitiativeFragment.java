package fr.android.earthdawn.activities.fragments;

import java.util.ArrayList;
import java.util.List;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.utils.AlertDialogUtils;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Talent;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.EDDicesLauncher;
import fr.android.earthdawn.utils.CharacterUtils;

/**
 * @author DrMabulle
 *
 */
public class InitiativeFragment extends DialogFragment implements View.OnClickListener
{
    private static final Talents[] INIT_TALENTS = new Talents[] { Talents.DanseAirs, Talents.VivaciteTigre };


    public InitiativeFragment()
    {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.popup_initiative, container);

        getDialog().setTitle(R.string.popup_init_title);

        final EDCharacter character = CharacterManager.getLoadedCharacter();
        final LinearLayout layout =  (LinearLayout) view.findViewById(R.id.popup_init_talents);
        CheckBox checkBox;
        final LayoutParams layoutParams = new LayoutParams(250, 40);
        layoutParams.setMargins(20, 2, 2, 2);
        for (final Talents talent : INIT_TALENTS)
        {
            if (CharacterUtils.knowsTalent(character, talent))
            {
                checkBox = new CheckBox(getActivity());
                checkBox.setText(talent.getLabel());
                checkBox.setChecked(true);
                checkBox.setId(talent.getLabel());
                checkBox.setLayoutParams(layoutParams);
                layout.addView(checkBox);
            }
        }

        // Close Button
        view.findViewById(R.id.popup_close).setOnClickListener(this);
        // Details Button
        view.findViewById(R.id.popup_init_roll).setOnClickListener(this);

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
            case R.id.popup_init_roll:

                final View parent = (View) aView.getParent().getParent();
                final EDCharacter character = CharacterManager.getLoadedCharacter();

                // find checked talents
                final List<Talent> checkedTalents = findCheckedTalents(character, parent);

                // for each checked talent, see if it modifies the initiative rank or adds a bonus

                // for each talent, execute preAction
                for (final Talent talent : checkedTalents)
                {
                   talent.executePreAction(CharacterUtils.getTalentRank(character, talent.getEnum()));
                }

                // define initiative rank to be rolled and roll it
                final String dicesInfos = CharacterUtils.computeInitiativeTest(character);
                EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_ATTRIBUT, R.string.init, dicesInfos, 0); // XXX

                // for each talent, increment strain
                for (final Talent talent : checkedTalents)
                {
                    character.incrementStrain(talent.getStrain());
                }

                // for each talent, execute postAction
                for (final Talent talent : checkedTalents)
                {
                   talent.executePostAction(CharacterUtils.getTalentRank(character, talent.getEnum()));
                }
                dismiss();

                AlertDialogUtils.showDialogResult(getFragmentManager());
                break;
        }
    }


    private static List<Talent> findCheckedTalents(final EDCharacter aCharacter, final View aParent)
    {
        final List<Talent> checkedTalents = new ArrayList<Talent>(INIT_TALENTS.length);
        CheckBox checkBox;
        for (final Talents talent : INIT_TALENTS)
        {
            if (CharacterUtils.knowsTalent(aCharacter, talent))
            {
                checkBox = (CheckBox) aParent.findViewById(talent.getLabel());
                if (checkBox != null && checkBox.isChecked())
                {
                    checkedTalents.add(CharacterUtils.getTalent(aCharacter, talent));
                }
            }
        }

        return checkedTalents;
    }

    public static final void rollInitiative(final EDCharacter aCharacter, final FragmentManager manager)
    {
        // If character has talents that could boost initiative test, open dialog to choose wich one to activate.
        for (final Talents talent : INIT_TALENTS)
        {
            if (CharacterUtils.knowsTalent(aCharacter, talent))
            {
                final FragmentTransaction ft = manager.beginTransaction();
                final InitiativeFragment newFragment = new InitiativeFragment();
                newFragment.show(ft, "InitiativeFragfment");
                return;
            }
        }

        // Else, just roll the dices and show result.
        EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_ATTRIBUT, R.string.init, aCharacter.getInitiativeLevel(), 0);
        AlertDialogUtils.showDialogResult(manager);
    }
}
