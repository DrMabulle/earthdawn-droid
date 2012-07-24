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
import android.widget.EditText;
import android.widget.Toast;
import fr.android.earthdawn.R;
import fr.android.earthdawn.managers.CharacterManager;

/**
 * @author DrMabulle
 *
 */
public class GainLegendFragment extends DialogFragment implements OnClickListener
{
    public GainLegendFragment()
    {
        super();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View v = inflater.inflate(R.layout.popup_gain_legend, container, false);

        // title of the dialog fragment
        getDialog().setTitle(getString(R.string.popup_legend_title));

        // Close Button
        v.findViewById(R.id.popup_close).setOnClickListener(this);
        // Details Button
        final Button action = (Button) v.findViewById(R.id.popup_action);
        action.setOnClickListener(this);
        action.setText(R.string.popup_legend_button);
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
                final View parentView = (View)  v.getParent().getParent().getParent();
                final EditText edit = (EditText) parentView.findViewById(R.id.legend_editText);
                final int legend = Integer.parseInt(edit.getText().toString());

                CharacterManager.getLoadedCharacter().incrementLegendPoints(legend);
                Toast.makeText(getActivity(), getString(R.string.popup_legend_msg_ok, legend), Toast.LENGTH_LONG).show();
                this.dismiss();
                break;
        }
    }
}
