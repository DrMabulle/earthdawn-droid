package fr.android.earthdawn.character.equipement;

import java.util.List;

import android.content.Context;
import android.widget.LinearLayout;
import fr.android.earthdawn.character.enums.Mod;

public interface IEquipment
{

    /**
     * @return the name
     */
    public String getName();

    /**
     * @return the bonuses
     */
    public List<Mod> getBonuses();

    public void drawDetails(LinearLayout details, Context ctx);

}