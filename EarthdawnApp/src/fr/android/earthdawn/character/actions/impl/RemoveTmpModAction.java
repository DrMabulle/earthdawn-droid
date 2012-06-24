package fr.android.earthdawn.character.actions.impl;

import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.actions.IAction;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.utils.CharacterUtils;

public class RemoveTmpModAction implements IAction
{
    private final Pointcuts[] pointcuts;

    public RemoveTmpModAction(final Pointcuts... somePointcuts)
    {
        this.pointcuts = somePointcuts;
    }

    @Override
    public void execute(final int nomTalent, final Object... args)
    {
        final EDCharacter character = CharacterManager.getLoadedCharacter();
        // Ajouter le rang du talent aux seuils de blessure grave, de mort et d'inconscience.
        final int talentRank = CharacterUtils.getTalentRank(character, Talents.Endurance);
        for (final Pointcuts pointcut : pointcuts)
        {
            character.removeTempMod(Mod.get(pointcut, talentRank, nomTalent));
        }
    }
}
