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
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.equipement.IEquipment;
import fr.android.earthdawn.character.equipement.impl.MagicalEquipment;

/**
 * @author DrMabulle
 *
 */
public class EquipmentAdapter extends BaseAdapter
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
    public View getView(final int position, final View aView, final ViewGroup parent)
    {
        View convertView = aView;
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.possession, parent, false);
            final IEquipment possession = possessions.get(position);

            ((TextView) convertView.findViewById(R.id.possession_name)).setText(possession.getName());
            final TextView details = (TextView) convertView.findViewById(R.id.possession_details);

            // Draw details for magical equipment
            if (possession.isMagical())
            {
                final MagicalEquipment loot = (MagicalEquipment) possession;
                final int rank = loot.getRank();

                String tab = EMPTY;
                List<Mod> mods;
                final StringBuilder msg = new StringBuilder(96);
                for (int i = 0; i < rank+1; i++)
                {
                    mods = loot.getBonuses(i);
                    if (i > 0)
                    {
                        tab = TAB;
                        msg.append(ctx.getString(R.string.msg_loot_thread, Integer.toString(i), Integer.toString(loot.getCosts()[i - 1])));
                        msg.append('\n');
                    }
                    for (final Mod mod : mods)
                    {
                        msg.append(tab);
                        msg.append(mod.toString());
                        msg.append('\n');
                    }
                }
                details.setText(msg.toString());
            }
            // Draw details for classical equipment
            else
            {
                final List<Mod> bonuses = possession.getBonuses();
                final StringBuilder msg = new StringBuilder(96);
                for (final Mod mod : bonuses)
                {
                    msg.append(mod.toString());
                    msg.append('\n');
                }
                details.setText(msg.toString());
            }
        }


        final boolean visible = isVisible(position);
        convertView.findViewById(R.id.possession_details).setVisibility(visible ? View.VISIBLE : View.GONE);

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
