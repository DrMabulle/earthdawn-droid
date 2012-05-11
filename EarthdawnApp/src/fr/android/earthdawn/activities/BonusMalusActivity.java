package fr.android.earthdawn.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.adapters.BonusMalusAdapter;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.managers.CharacterManager;

public class BonusMalusActivity extends ListActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonusmalus);

        final fr.android.earthdawn.character.EDCharacter character = CharacterManager.getLoadedCharacter();
        final List<Mod> mods = new ArrayList<Mod>(character.getPermanentMods());
        mods.addAll(character.getTempMods());

        final BonusMalusAdapter adapter = new BonusMalusAdapter(this, mods);
        setListAdapter(adapter);
    }
}