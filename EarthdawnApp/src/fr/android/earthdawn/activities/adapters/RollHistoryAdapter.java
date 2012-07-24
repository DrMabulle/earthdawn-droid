/**
 *
 */
package fr.android.earthdawn.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.managers.EDDicesLauncher;

/**
 * @author DrMabulle
 *
 */
public class RollHistoryAdapter extends BaseAdapter
{
    private final LayoutInflater inflater;
    private final Context ctx;
    private final int rollHistorySize;
    private final boolean[] expanded;

    public RollHistoryAdapter(final Context context, final int aRollHistorySize)
    {
        this.rollHistorySize = aRollHistorySize;
        expanded = new boolean[rollHistorySize];
        // Cache the LayoutInflate to avoid asking for a new one each time.
        inflater = LayoutInflater.from(context);
        ctx = context;
    }

    @Override
    public int getCount()
    {
        return rollHistorySize;
    }

    @Override
    public Object getItem(final int position)
    {
        return null;
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
            convertView = inflater.inflate(R.layout.roll_history_item, parent, false);

            // Roll general message
            String msg = EDDicesLauncher.getRollHistoryMsg(ctx, position);
            ((TextView) convertView.findViewById(R.id.roll_hitory_item_info)).setText(msg);

            // Roll detailed message
            msg = EDDicesLauncher.getRollHistoryDetails(ctx, position);
            ((TextView) convertView.findViewById(R.id.roll_hitory_item_details)).setText(msg);
        }

        final boolean visible = isVisible(position);
        convertView.findViewById(R.id.roll_hitory_item_details).setVisibility(visible ? View.VISIBLE : View.GONE);

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
