/**
 *
 */
package fr.android.earthdawn.activities.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.adapters.AttributsAdapter;
import fr.android.earthdawn.character.enums.Attributes;
import fr.android.earthdawn.character.enums.Skill;
import fr.android.earthdawn.managers.CharacterManager;

/**
 * @author DrMabulle
 *
 */
public class NewSkillFragment extends DialogFragment implements OnClickListener
{
    public NewSkillFragment()
    {
        super();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View v = inflater.inflate(R.layout.skill_new, container, false);

        // title of the dialog fragment
        getDialog().setTitle(getString(R.string.skill_new_title));

        // Spinner
        final Spinner spinner = (Spinner) v.findViewById(R.id.skill_new_attribut);
        spinner.setAdapter(new AttributsAdapter(this.getActivity()));


        // Close Button
        v.findViewById(R.id.popup_close).setOnClickListener(this);
        // Details Button
        final Button action = (Button) v.findViewById(R.id.popup_action);
        action.setOnClickListener(this);
        action.setText(R.string.skill_new_add);
        // Hide roll Button
        v.findViewById(R.id.popup_roll).setVisibility(View.GONE);

        return v;
    }

    @Override
    public void onClick(final View v)
    {
        switch (v.getId())
        {
            case R.id.popup_close:
                dismiss();
                break;
            case R.id.popup_action:

                final View parent = (View) v.getParent().getParent().getParent();
                final String label = ((EditText) parent.findViewById(R.id.skill_new_label)).getText().toString();

                final long att = ((Spinner) parent.findViewById(R.id.skill_new_attribut)).getSelectedItemId();
                final Attributes attribut = Attributes.values()[(int)att];
                final boolean isAction = ((CheckBox) parent.findViewById(R.id.skill_new_isaction)).isChecked();
                final int strain = ((CheckBox) parent.findViewById(R.id.skill_new_strain)).isChecked() ? 1 : 0;

                final Skill skill = new Skill(label, attribut, isAction, strain);

                CharacterManager.getLoadedCharacter().addSkill(skill);

                dismiss();
                break;
        }
    }

}
