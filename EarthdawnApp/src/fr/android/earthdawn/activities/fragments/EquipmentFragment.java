package fr.android.earthdawn.activities.fragments;

import java.util.List;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.adapters.EquipmentAdapter;
import fr.android.earthdawn.character.Character;
import fr.android.earthdawn.character.equipement.IEquipment;
import fr.android.earthdawn.utils.Constants;

public class EquipmentFragment extends ListFragment
{
    private Character character;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.equipment, container, false);

        character = (Character) this.getArguments().get(Constants.BUNDLE_CHARACTER);
        final List<IEquipment> equipment = character.getEquipment();

        final EquipmentAdapter equipmentAdapter = new EquipmentAdapter(getActivity(), equipment);
        setListAdapter(equipmentAdapter);

        return view;
    }

    @Override
    public void onListItemClick(final ListView l, final View v, final int position, final long id)
    {
       ((EquipmentAdapter)getListAdapter()).toggle(position);
       super.onListItemClick(l, v, position, id);
    }
}
