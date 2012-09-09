package fr.android.earthdawn.character.actions.impl;

import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.character.actions.IAction;
import fr.android.earthdawn.character.enums.Attributes;
import fr.android.earthdawn.character.enums.Mod;
import fr.android.earthdawn.character.enums.Pointcuts;
import fr.android.earthdawn.character.enums.Talents;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.EDDicesLauncher;
import fr.android.earthdawn.utils.CharacterUtils;

public class EndurancePostAction implements IAction
{
    private final Pointcuts[] pointcuts;

    public EndurancePostAction(final Pointcuts... somePointcuts)
    {
        this.pointcuts = somePointcuts;
    }

    @Override
    public void execute(final int nomTalent, final Object... args)
    {
        final EDCharacter character = CharacterManager.getLoadedCharacter();
        final int dicesResult = EDDicesLauncher.getRollResult();
        if (dicesResult > character.getAttributRank(Attributes.END))
        {
            // Ajouter le rang du talent aux seuils de blessure grave, de mort et d'inconscience.
            final int talentRank = CharacterUtils.getTalentRank(character, Talents.Endurance);
            for (final Pointcuts pointcut : pointcuts)
            {
                character.addOrReplaceTempMod(Mod.get(pointcut, talentRank, nomTalent));
            }
        }
        else
        {
            // Subir une blessure grave
            character.incrementWounds(1);
            character.incrementDamages(character.getWoundThreshold());
        }

    }
}
