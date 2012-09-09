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
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.managers.EDDicesLauncher;
import fr.android.earthdawn.utils.Constants;

/**
 * @author DrMabulle
 *
 */
public class ShowResultFragment extends DialogFragment implements OnClickListener
{
    public ShowResultFragment()
    {
        super();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View v = inflater.inflate(R.layout.popup_roll, container);

        // Disable hardware acceleration for this view to enable very big text size
        v.setLayerType(View.LAYER_TYPE_NONE, null);

        // Disable cancel when touching outside of the dialog
        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);

        // Set title
        getDialog().setTitle(getString(R.string.roller_popup_title2, getString(EDDicesLauncher.getRollType())));

        // Set Dices informations
        TextView tv = (TextView) v.findViewById(R.id.popup_roll_dices_infos);
        tv.setText(getString(R.string.popup_roll_dices_infos, EDDicesLauncher.getRolledDicesInfos(getActivity())));

        // Set result
        tv = (TextView) v.findViewById(R.id.popup_result);
        tv.setText(Integer.toString(EDDicesLauncher.getRollResult()));


        // Close Button
        v.findViewById(R.id.popup_close).setOnClickListener(this);
        // Details Button
        final Button action = (Button) v.findViewById(R.id.popup_action);
        action.setOnClickListener(this);
        action.setText(R.string.popup_roll_dices_button);
        // Hide roll Button
        v.findViewById(R.id.popup_roll).setVisibility(View.GONE);

        return v;
    }

    @Override
    public void onClick(final View aView)
    {
        switch (aView.getId())
        {
            case R.id.popup_close:
                dismiss();
                break;
            case R.id.popup_action:
                // When Details button is clicked, call up to owning activity.
                getActivity().showDialog(Constants.DIALOG_SHOW_DETAILS);
                break;
        }
    }
}
