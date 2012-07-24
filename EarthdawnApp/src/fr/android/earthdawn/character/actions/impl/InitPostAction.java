package fr.android.earthdawn.character.actions.impl;

import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.actions.IAction;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.managers.CharacterManager;

public class InitPostAction implements IAction
{
    private final Pointcuts pointcut;

    public InitPostAction(final Pointcuts aPointcut)
    {
        this.pointcut = aPointcut;
    }

    @Override
    public void execute(final int nomTalent, final Object... args)
    {
        final EDCharacter character = CharacterManager.getLoadedCharacter();

        character.removeTempMod(character.getTempMod(pointcut));
    }
}
