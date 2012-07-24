package fr.android.earthdawn.character.actions.impl;

import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.actions.IAction;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.managers.CharacterManager;

public class InitPreAction implements IAction
{
    private final Pointcuts pointcut;

    public InitPreAction(final Pointcuts aPointcut)
    {
        this.pointcut = aPointcut;
    }

    @Override
    public void execute(final int nomTalent, final Object... args)
    {
        final EDCharacter character = CharacterManager.getLoadedCharacter();

        character.addOrReplaceTempMod(Mod.get(pointcut, (Integer) args[0], nomTalent));
    }
}
