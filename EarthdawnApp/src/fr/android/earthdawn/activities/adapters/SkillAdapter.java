/**
 *
 */
package fr.android.earthdawn.activities.adapters;

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
import fr.android.earthdawn.character.enums.Skill;

/**
 * @author DrMabulle
 *
 */
public class SkillAdapter extends BaseAdapter implements ListAdapter
{
    private final LayoutInflater inflater;
    private final List<Skill> skills;
    private final OnClickListener listener;
    private final EDCharacter character;

    public SkillAdapter(final Context context, final EDCharacter character, final OnClickListener listener)
    {
        this.listener = listener;
        this.character = character;
        this.skills = character.getSkills();

        // Cache the LayoutInflate to avoid asking for a new one each time.
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return skills.size();
    }

    @Override
    public Object getItem(final int position)
    {
        return skills.get(position);
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
            convertView = inflater.inflate(R.layout.skill, parent, false);
        }
        final Skill skill = skills.get(position);

        ((TextView) convertView.findViewById(R.id.skills_skill)).setText(skill.getLabel());
        ((TextView) convertView.findViewById(R.id.skills_rank)).setText(Integer.toString(skill.getRank()));
        ((TextView) convertView.findViewById(R.id.skills_attribut)).setText(skill.getAttribut().getLabel());
        ((RadioButton) convertView.findViewById(R.id.skills_action)).setChecked(skill.isAction());
        ((TextView) convertView.findViewById(R.id.skills_effort)).setText(Integer.toString(skill.getStrain()));

        ((ImageButton) convertView.findViewById(R.id.skill_roll)).setOnClickListener(listener);
        ((TextView) convertView.findViewById(R.id.skills_level)).setText(Integer.toString(character.getSkillLevel(skill)));

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
