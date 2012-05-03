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
public class ShowResultFragment extends DialogFragment
{

    public ShowResultFragment()
    {
        super();
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View v = inflater.inflate(R.layout.popup_roll, container, false);

        // Disable hardware acceleration for this view to enable very big text size
        v.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        final TextView tv = (TextView) v.findViewById(R.id.popup_result);
        tv.setText(Integer.toString(EDDicesLauncher.getRollResult()));

        // Set title
        getDialog().setTitle(getString(R.string.roller_popup_title2, getString(EDDicesLauncher.getRollType())));

        // Close Button
        Button button = (Button) v.findViewById(R.id.popup_close);
        button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                // When button is clicked, close popup.
                dismiss();
            }
        });
        // Details Button
        button = (Button) v.findViewById(R.id.popup_details);
        button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                // When button is clicked, call up to owning activity.
                getActivity().showDialog(Constants.DIALOG_SHOW_DETAILS);
            }
        });

        return v;
    }

}
