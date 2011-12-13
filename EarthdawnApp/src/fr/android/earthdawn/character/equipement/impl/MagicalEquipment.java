/**
 *
 */
package fr.android.earthdawn.character.equipement.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.equipement.IEquipment;

/**
 * @author DrMabulle
 *
 */
public class MagicalEquipment implements IEquipment, Serializable
{
    private static final String TAB = "        ";
    private static final String EMPTY = "";

    private static final long serialVersionUID = 6525264693377432928L;

    private final String name;
    private int rank = 0;
    private final List<List<Mod>> bonuses;
    /**
     * @param name
     * @param bonuses
     */
    public MagicalEquipment(final String name, final List<List<Mod>> bonuses)
    {
        super();
        this.name = name;
        this.bonuses = bonuses;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public List<Mod> getBonuses()
    {
        final List<Mod> result = new ArrayList<Mod>();
        for (int i = 0; i < rank+1; i++)
        {
            result.addAll(bonuses.get(i));
        }
        return result;
    }
    public void incrementRank()
    {
        rank++;
    }

    @Override
    public void drawDetails(final LinearLayout details, final Context ctx)
    {
        TextView tv;
        String tab = EMPTY;
        for (int i = 0; i < rank+1; i++)
        {
            final List<Mod> mods = bonuses.get(i);
            if (i > 0)
            {
                tab = TAB;
                tv = new TextView(ctx);
                tv.setText("Filament " + i);
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


}
