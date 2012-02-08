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
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.equipement.IEquipment;
import fr.android.earthdawn.character.equipement.impl.MagicalEquipment;

/**
 * @author DrMabulle
 *
 */
public class EquipmentAdapter extends BaseAdapter implements ListAdapter
{
    private static final String TAB = "        ";
    private static final String EMPTY = "";

    private final LayoutInflater inflater;
    private final Context ctx;
    private final List<IEquipment> possessions;
    private final boolean[] expanded;

    public EquipmentAdapter(final Context context, final List<IEquipment> equipment)
    {
        possessions = equipment;
        expanded = new boolean[possessions.size()];
        // Cache the LayoutInflate to avoid asking for a new one each time.
        inflater = LayoutInflater.from(context);
        ctx = context;
    }

    @Override
    public int getCount()
    {
        return possessions.size();
    }

    @Override
    public Object getItem(final int position)
    {
        return possessions.get(position);
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
            convertView = inflater.inflate(R.layout.possession, parent, false);
            final IEquipment possession = possessions.get(position);

            ((TextView) convertView.findViewById(R.id.possession_name)).setText(possession.getName());
            final LinearLayout details = (LinearLayout) convertView.findViewById(R.id.possession_details);

            // Draw details for magical equipment
            if (possession.isMagical())
            {
                final MagicalEquipment loot = (MagicalEquipment) possession;
                final int rank = loot.getRank();

                TextView tv;
                String tab = EMPTY;
                List<Mod> mods;
                for (int i = 0; i < rank+1; i++)
                {
                    mods = loot.getBonuses(rank);
                    if (i > 0)
                    {
                        tab = TAB;
                        tv = new TextView(ctx);
                        final StringBuilder msg = new StringBuilder(24);
                        tv.setText(ctx.getString(R.string.msg_loot_thread, i, loot.getCosts()[i - 1]));
                        details.addView(tv);
                    }
                    for (final Mod mod : mods)
                    {
                        tv = new TextView(ctx);
                        tv.setText(tab + mod.toString());
                        details.addView(tv);
                    }
                }
            }
            // Draw details for classical equipment
            else
            {
                final List<Mod> bonuses = possession.getBonuses();
                for (final Mod mod : bonuses)
                {
                    final TextView tv = new TextView(ctx);
                    tv.setText(mod.toString());
                    details.addView(tv);
                }
            }
        }

        final boolean visible = isVisible(position);
        ((LinearLayout) convertView.findViewById(R.id.possession_details)).setVisibility(visible ? View.VISIBLE : View.GONE);

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

    public boolean isVisible(final int position)
    {
        return expanded[position];
    }

    public void toggle(final int position)
    {
        expanded[position] = !expanded[position];
        notifyDataSetChanged();
    }
}
