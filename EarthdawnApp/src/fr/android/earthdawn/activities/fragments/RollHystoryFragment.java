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
import android.widget.ListView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.adapters.RollHistoryAdapter;
import fr.android.earthdawn.managers.EDDicesLauncher;

/**
 * @author DrMabulle
 *
 */
public class RollHystoryFragment extends DialogFragment implements OnClickListener
{
    public RollHystoryFragment()
    {
        super();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View v = inflater.inflate(R.layout.popup_roll_history, container, false);

        // XXX Externalise String
        // title of the dialog fragment
        getDialog().setTitle("Historique des jets");

        final ListView listV = (ListView) v.findViewById(R.id.popup_roll_history_list);
        final RollHistoryAdapter adpater = new RollHistoryAdapter(getActivity(), EDDicesLauncher.getRollHistorySize());
        listV.setAdapter(adpater);


        // Close Button
        v.findViewById(R.id.popup_close).setOnClickListener(this);
        // Details Button
        v.findViewById(R.id.popup_roll).setVisibility(View.GONE);
        // Hide roll Button
        v.findViewById(R.id.popup_action).setVisibility(View.GONE);

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
        }
    }
}
