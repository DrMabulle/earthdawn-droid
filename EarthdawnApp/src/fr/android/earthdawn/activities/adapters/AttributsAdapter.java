package fr.android.earthdawn.activities.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import fr.android.earthdawn.character.enums.Attributs;

public class AttributsAdapter extends BaseAdapter implements SpinnerAdapter
{
    private final Context ctx;

    public AttributsAdapter(final Context context)
    {
        ctx = context;
    }

    @Override
    public int getCount()
    {
        return Attributs.values().length;
    }

    @Override
    public Object getItem(final int position)
    {
        return Attributs.values()[position];
    }

    @Override
    public long getItemId(final int position)
    {
        return Attributs.values()[position].getId();
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent)
    {
        final TextView text = new TextView(ctx);
        text.setText(Attributs.values()[position].getFullName());
        text.setPadding(4, 4, 4, 4);
        text.setTextAppearance(ctx, android.R.style.TextAppearance_Medium);
        return text;
    }

    @Override
    public View getDropDownView(final int position, final View convertView, final ViewGroup parent)
    {
        final TextView text = new TextView(ctx);
        text.setText(Attributs.values()[position].getFullName());
        text.setPadding(4, 4, 4, 4);
        text.setTextAppearance(ctx, android.R.style.TextAppearance_Medium);
        return text;
    }
}
