/**
 *
 */
package fr.android.earthdawn.managers;

import java.util.LinkedList;

import android.content.Context;
import fr.android.earthdawn.R;
import fr.android.earthdawn.dices.DicesLauncher;

/**
 * @author DrMabulle
 *
 */
public final class EDDicesLauncher
{
    public static final int ROLL_ATTRIBUT = 1;
    public static final int ROLL_TALENT = 2;
    public static final int ROLL_SKILL = 3;
    public static final int ROLL_DAMAGES = 4;
    public static final int ROLL_OTHER = 100;

    /**
     * FIFO rolls history
     */
    private static final LinkedList<Roll> rollsHistory = new LinkedList<Roll>();

    private EDDicesLauncher() {}

    // TODO être plus explicite avec les blessures graves

    public static int rollDices(final int aRollKind, final int aRollNameId, final int aRank, final int wounds)
    {
        final boolean rerollMax = shouldRerollOnMax(aRollKind);
        final boolean rerollMins = shouldRerollOnMin(aRollKind);

        final int result = DicesLauncher.rollDices(aRank, rerollMax, rerollMins) - wounds;

        addRollToHistory(new Roll(aRollKind, aRollNameId, aRank, result, DicesLauncher.getRollLogs(), wounds));

        return result;
    }

    public static int rollDices(final int aRollKind, final int aRollNameId, final String aDicesInfos, final int wounds)
    {
        final boolean rerollMax = shouldRerollOnMax(aRollKind);
        final boolean rerollMins = shouldRerollOnMin(aRollKind);

        final int result = DicesLauncher.rollDices(aDicesInfos, rerollMax, rerollMins) - wounds;

        addRollToHistory(new Roll(aRollKind, aRollNameId, aDicesInfos, result, DicesLauncher.getRollLogs(), wounds));

        return result;
    }

    private static void addRollToHistory(final Roll roll)
    {
        // Keep only ten rolls in history, at most
        if (rollsHistory.size() == 10)
        {
            rollsHistory.removeLast();
        }
        // Insert new roll in first position
        rollsHistory.addFirst(roll);
    }

    private static boolean shouldRerollOnMax(final int aRollKind)
    {
        return true;
    }

    private static boolean shouldRerollOnMin(final int aRollKind)
    {
        return ROLL_DAMAGES != aRollKind;
    }

    public static int getRollResult()
    {
        return rollsHistory.getFirst().rollResult;
    }

    public static int getRollType()
    {
        return rollsHistory.getFirst().rollNameId;
    }

    public static String getDetailedMessage(final Context ctx)
    {
        final Roll roll = rollsHistory.getFirst();
        String msg = null;
        if (roll.rollDicesInfos != null)
        {
            msg = roll.rollDicesInfos;
        }
        else
        {
            msg = ctx.getString(R.string.roller_rank_msg, roll.rollRank, RankManager.getDicesFromRank(roll.rollRank));
        }
        return ctx.getString(R.string.roller_message, msg, roll.rollResult, roll.rollWounds, roll.rollLogs);
    }

    public static boolean testInputDicesInfos(final String dicesInfos)
    {
        return DicesLauncher.testInputDicesInfos(dicesInfos);
    }



    private static class Roll
    {
        final int rollKind;
        final int rollNameId;
        final int rollRank;
        final String rollDicesInfos;
        final int rollResult;
        final String rollLogs;
        final int rollWounds;

        public Roll(final int aRollKind, final int aRollNameId, final int aRollRank, final int aRollResult, final String aRollLogs, final int aRollWounds)
        {
            super();
            this.rollKind = aRollKind;
            this.rollNameId = aRollNameId;
            this.rollRank = aRollRank;
            this.rollDicesInfos = null;
            this.rollResult = aRollResult;
            this.rollLogs = aRollLogs;
            this.rollWounds = aRollWounds;
        }

        public Roll(final int aRollKind, final int aRollNameId, final String aRollDicesInfos, final int aRollResult, final String aRollLogs, final int aRollWounds)
        {
            super();
            this.rollKind = aRollKind;
            this.rollNameId = aRollNameId;
            this.rollRank = 0;
            this.rollDicesInfos = aRollDicesInfos;
            this.rollResult = aRollResult;
            this.rollLogs = aRollLogs;
            this.rollWounds = aRollWounds;
        }
    }
}
