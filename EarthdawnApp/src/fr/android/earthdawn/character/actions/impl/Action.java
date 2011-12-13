package fr.android.earthdawn.character.actions.impl;

import fr.android.earthdawn.character.Character;
import fr.android.earthdawn.character.actions.IAction;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.DicesLauncher;

public class Action
{

    public static class TempModAction implements IAction
    {
        private final Pointcuts[] pointcuts;
        public TempModAction(final Pointcuts... pointcuts)
        {
            this.pointcuts = pointcuts;
        }

        @Override
        public void execute(final String nomTalent)
        {
            final Character character = CharacterManager.getLoadedCharacter();

            for (final Pointcuts pointcut : pointcuts)
            {
                character.addOrReplaceTempMod(new Mod(pointcut, DicesLauncher.get().getRollResult(), nomTalent));
            }
        }
    };

}
