package fr.android.earthdawn.character.equipement;

import java.util.List;

import fr.android.earthdawn.character.enums.Mod;

/**
 * Represents the equipment available for characters in EarthDawn
 *
 * @author DrMabulle
 */
public interface IEquipment
{
    /**
     * @return the name of the piece of equipment
     */
    public String getName();

    /**
     * @return the bonuses given by the piece of equipment
     */
    public List<Mod> getBonuses();

    /**
     * @return true if this piece of equipment is magical
     */
    public boolean isMagical();

}