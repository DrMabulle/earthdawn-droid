/**
 *
 */
package fr.android.earthdawn.managers;

import java.util.LinkedList;

import android.content.Context;
import fr.android.earthdawn.R;

/**
 * @author DrMabulle
 *
 */
/**
 * @author Bubulle
 *
 */
public class EDDicesLauncher
{
    public static final int ROLL_ATTRIBUT = 1;
    public static final int ROLL_TALENT = 2;
    public static final int ROLL_SKILL = 3;
    public static final int ROLL_DAMAGES = 4;
    public static final int ROLL_OTHER = 100;

    private static final EDDicesLauncher INSTANCE = new EDDicesLauncher();

    /**
     * FIFO rolls history
     */
    private final LinkedList<Roll> rollsHistory = new LinkedList<Roll>();

    private EDDicesLauncher() {}

    public static EDDicesLauncher get()
    {
        return INSTANCE;
    }


    public int rollDices(final int aRollKind, final int aRollNameId, final int aRank)
    {
        final boolean rerollMax = shouldRerollOnMax(aRollKind);
        final boolean rerollMins = shouldRerollOnMin(aRollKind);

        final int result = DicesLauncher.get().rollDices(aRank, rerollMax, rerollMins);

        addRollToHistory(new Roll(aRollKind, aRollNameId, aRank, result, DicesLauncher.get().getRollLogs()));

        return result;
    }

    public int rollDices(final int aRollKind, final int aRollNameId, final String aDicesInfos)
    {
        final boolean rerollMax = shouldRerollOnMax(aRollKind);
        final boolean rerollMins = shouldRerollOnMin(aRollKind);

        final int result = DicesLauncher.get().rollDices(aDicesInfos, rerollMax, rerollMins);

        addRollToHistory(new Roll(aRollKind, aRollNameId, aDicesInfos, result, DicesLauncher.get().getRollLogs()));

        return result;
    }

    private void addRollToHistory(final Roll roll)
    {
        // Keep only ten rolls in history, at most
        if (rollsHistory.size() == 10)
        {
            rollsHistory.removeLast();
        }
        // Insert new roll in first position
        rollsHistory.addFirst(roll);
    }

    private boolean shouldRerollOnMax(final int aRollKind)
    {
        return true;
    }

    private boolean shouldRerollOnMin(final int aRollKind)
    {
        return ROLL_DAMAGES != aRollKind;
    }

    public int getRollResult()
    {
        return rollsHistory.getFirst().rollResult;
    }

    public int getRollType()
    {
        return rollsHistory.getFirst().rollNameId;
    }

    public String getDetailedMessage(final Context ctx)
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
        return ctx.getString(R.string.roller_message, msg, DicesLauncher.get().getRollResult(), roll.rollLogs);
    }

    public boolean testInputDicesInfos(final String dicesInfos)
    {
        return DicesLauncher.get().testInputDicesInfos(dicesInfos);
    }



    private class Roll
    {
        final int rollKind;
        final int rollNameId;
        final int rollRank;
        final String rollDicesInfos;
        final int rollResult;
        final String rollLogs;

        public Roll(final int aRollKind, final int aRollNameId, final int aRollRank, final int aRollResult, final String aRollLogs)
        {
            super();
            this.rollKind = aRollKind;
            this.rollNameId = aRollNameId;
            this.rollRank = aRollRank;
            this.rollDicesInfos = null;
            this.rollResult = aRollResult;
            this.rollLogs = aRollLogs;
        }

        public Roll(final int aRollKind, final int aRollNameId, final String aRollDicesInfos, final int aRollResult, final String aRollLogs)
        {
            super();
            this.rollKind = aRollKind;
            this.rollNameId = aRollNameId;
            this.rollRank = 0;
            this.rollDicesInfos = aRollDicesInfos;
            this.rollResult = aRollResult;
            this.rollLogs = aRollLogs;
        }
    }
}
