/**
 *
 */
package fr.android.earthdawn.character.equipement.impl;

import java.io.Serializable;
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
public class Equipment implements IEquipment, Serializable
{
    private static final long serialVersionUID = 4947121231383859309L;

    private final String name;
    private final List<Mod> bonuses;
    /**
     * @param name
     * @param bonuses
     */
    public Equipment(final String name, final List<Mod> bonuses)
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
        return bonuses;
    }

    @Override
    public void drawDetails(final LinearLayout details, final Context ctx)
    {
        for (final Mod mod : bonuses)
        {
            final TextView tv = new TextView(ctx);
            tv.setText(mod.toString());
            details.addView(tv);
        }
    }
}
