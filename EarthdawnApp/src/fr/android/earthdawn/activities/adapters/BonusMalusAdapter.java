/**
 *
 */
package fr.android.earthdawn.activities.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.character.enums.Mod;

/**
 * @author DrMabulle
 *
 */
public class BonusMalusAdapter extends BaseAdapter implements ListAdapter
{
    private final LayoutInflater inflater;
    private final List<Mod> mods;

    public BonusMalusAdapter(final Context context, final List<Mod> mods)
    {
        this.mods = mods;
        // Cache the LayoutInflate to avoid asking for a new one each time.
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return mods.size();
    }

    @Override
    public Object getItem(final int position)
    {
        return mods.get(position);
    }

    @Override
    public long getItemId(final int position)
    {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.modificator, parent, false);
            final Mod mod = mods.get(position);

            ((TextView) convertView.findViewById(R.id.mod)).setText(mod.toString());
        }

        return convertView;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }

    @Override
    public boolean isEnabled(final int position)
    {
        return true;
    }

}
