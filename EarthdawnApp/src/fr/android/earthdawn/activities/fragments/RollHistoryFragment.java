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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.adapters.RollHistoryAdapter;
import fr.android.earthdawn.managers.EDDicesLauncher;

/**
 * @author DrMabulle
 *
 */
public class RollHistoryFragment extends DialogFragment implements OnClickListener, OnItemClickListener
{
    public RollHistoryFragment()
    {
        super();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View v = inflater.inflate(R.layout.popup_roll_history, container, false);

        // title of the dialog fragment
        getDialog().setTitle(R.string.popup_roll_history_title);

        final ListView listV = (ListView) v.findViewById(R.id.popup_roll_history_list);
        final RollHistoryAdapter adpater = new RollHistoryAdapter(getActivity(), EDDicesLauncher.getRollHistorySize());
        listV.setAdapter(adpater);
        listV.setOnItemClickListener(this);


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

    @Override
    public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id)
    {
        final ListView listV = (ListView) parent.findViewById(R.id.popup_roll_history_list);
        ((RollHistoryAdapter) listV.getAdapter()).toggle(position);
    }
}
