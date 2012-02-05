/**
 *
 */
package fr.android.earthdawn.activities.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.enums.Discipline;
import fr.android.earthdawn.character.enums.Talent;

/**
 * @author DrMabulle
 *
 */
public class TalentAdapter extends BaseAdapter implements ListAdapter
{
    private final LayoutInflater inflater;
    private final List<Talent> talents;
    private final OnClickListener listener;
    private final Discipline discipline;
    private final EDCharacter character;

    public TalentAdapter(final Context context, final EDCharacter character, final Discipline discipline, final OnClickListener listener)
    {
        this.listener = listener;
        this.character = character;
        this.discipline = discipline;
        this.talents = clean(discipline.getKnownTalents());

        // Cache the LayoutInflate to avoid asking for a new one each time.
        inflater = LayoutInflater.from(context);
    }

    private List<Talent> clean(final List<Talent> knownTalents)
    {
        final List<Talent> talents = new ArrayList<Talent>(knownTalents.size());
        for (final Talent talent : knownTalents)
        {
            if (discipline.getTalentRank(talent) != 0)
            {
                talents.add(talent);
            }
        }
        return talents;
    }

    @Override
    public int getCount()
    {
        return talents.size();
    }

    @Override
    public Object getItem(final int position)
    {
        return talents.get(position);
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
            convertView = inflater.inflate(R.layout.talent, parent, false);
        }
        final Talent talent = talents.get(position);

        ((TextView) convertView.findViewById(R.id.talents_talent)).setText(talent.getName());
        ((TextView) convertView.findViewById(R.id.talents_circle)).setText(Integer.toString(talent.getCircle()));
        ((TextView) convertView.findViewById(R.id.talents_rank)).setText(Integer.toString(character.getTalentRank(talent, discipline)));
        ((TextView) convertView.findViewById(R.id.talents_attribut)).setText(talent.getAttribut().getLabel());
        ((RadioButton) convertView.findViewById(R.id.talents_discipline)).setChecked(talent.isDiscipline());
        ((RadioButton) convertView.findViewById(R.id.talents_karma)).setChecked(talent.isKarmaMandatory());
        ((RadioButton) convertView.findViewById(R.id.talents_action)).setChecked(talent.isAction());
        ((TextView) convertView.findViewById(R.id.talents_effort)).setText(Integer.toString(talent.getStrain()));

        if (talent.isRollable())
        {
            ((ImageButton) convertView.findViewById(R.id.talent_roll)).setOnClickListener(listener);
            ((TextView) convertView.findViewById(R.id.talents_level)).setText(Integer.toString(character.getTalentLevel(talent, discipline)));
        }
        else
        {
            ((ImageButton) convertView.findViewById(R.id.talent_roll)).setVisibility(ImageButton.INVISIBLE);
            ((TextView) convertView.findViewById(R.id.talents_level)).setText("");
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
    public boolean isEnabled(final int arg0)
    {
        return true;
    }
}
