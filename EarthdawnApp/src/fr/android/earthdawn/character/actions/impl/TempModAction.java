package fr.android.earthdawn.character.actions.impl;

import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.actions.IAction;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.EDDicesLauncher;

public class TempModAction implements IAction
{
    private final Pointcuts[] pointcuts;

    public TempModAction(final Pointcuts... somePointcuts)
    {
        this.pointcuts = somePointcuts;
    }

    @Override
    public void execute(final int nomTalent, final Object... args)
    {
        final EDCharacter character = CharacterManager.getLoadedCharacter();

        for (final Pointcuts pointcut : pointcuts)
        {
            character.addOrReplaceTempMod(Mod.get(pointcut, EDDicesLauncher.getRollResult(), nomTalent));
        }
    }
}
