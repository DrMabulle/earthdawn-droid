/**
 *
 */
package fr.android.earthdawn.managers;

import java.util.LinkedList;

import android.content.Context;
import android.util.Log;
import fr.android.earthdawn.R;
import fr.android.earthdawn.dices.DicesLauncher;
import fr.android.earthdawn.utils.NumberUtils;

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
    public static final int ROLL_RECOVERY = 5;
    public static final int ROLL_OTHER = 100;

    /**
     * FIFO rolls history
     */
    protected static final LinkedList<Roll> rollsHistory = new LinkedList<Roll>();

    private EDDicesLauncher() {}

    /**
     * Rolls the dices the EarthDawn way
     * @param aRollKind type of roll : Attribute, Talent, Skill, Damages, Recovery, Other
     * @param aRollNameId id of the roll (talent or attribute name, etc.)
     * @param aRank step to be rolled
     * @param wounds character wounds (gives maluses)
     * @return result of the dices rolled
     */
    public static int rollDices(final int aRollKind, final int aRollNameId, final int aRank, final int wounds)
    {
        final boolean rerollMax = shouldRerollOnMax(aRollKind);
        final boolean rerollMins = shouldRerollOnMin(aRollKind);

        // X blessures graves font un malus de X-1 points (min 0)
        final int malusWounds = NumberUtils.ensureMinimum(wounds - 1, 0);

        final int result = DicesLauncher.rollDices(aRank, rerollMax, rerollMins) - malusWounds;

        addRollToHistory(new Roll(aRollKind, aRollNameId, aRank, result, DicesLauncher.getRollLogs(), malusWounds));

        return result;
    }

    /**
     * Rolls the dices the EarthDawn way
     * @param aRollKind type of roll : Attribute, Talent, Skill, Damages, Recovery, Other
     * @param aRollNameId id of the roll (talent or attribute name, etc.)
     * @param aDicesInfos dices to be rolled
     * @param wounds character wounds (gives maluses)
     * @return result of the dices rolled
     */
    public static int rollDices(final int aRollKind, final int aRollNameId, final String aDicesInfos, final int wounds)
    {
        final boolean rerollMax = shouldRerollOnMax(aRollKind);
        final boolean rerollMins = shouldRerollOnMin(aRollKind);

        // X blessures graves font un malus de X-1 points (min 0)
        final int malusWounds = NumberUtils.ensureMinimum(wounds - 1, 0);

        final int result = DicesLauncher.rollDices(aDicesInfos, rerollMax, rerollMins) - malusWounds;

        addRollToHistory(new Roll(aRollKind, aRollNameId, aDicesInfos, result, DicesLauncher.getRollLogs(), malusWounds));

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
        return ROLL_DAMAGES != aRollKind && ROLL_RECOVERY != aRollKind;
    }

    /**
     * Previous roll result
     * @return Previous roll result
     */
    public static int getRollResult()
    {
        return rollsHistory.getFirst().rollResult;
    }

    /**
     * Previous roll type (name id)
     * @return Previous roll type (name id)
     */
    public static int getRollType()
    {
        return rollsHistory.getFirst().rollNameId;
    }

    /**
     * Tests the dices informations to be rolled.
     * @param dicesInfos dices to be rolled
     * @return true if the given dices informations respect the expected syntax
     */
    public static boolean testInputDicesInfos(final String dicesInfos)
    {
        return DicesLauncher.testInputDicesInfos(dicesInfos);
    }

    /**
     * Roll history size (max 10)
     * @return Roll history size (max 10)
     */
    public static int getRollHistorySize()
    {
        return rollsHistory.size();
    }

    /**
     * Retrieves the display message of a previous roll, in rolls history
     * @param ctx Android Context
     * @param aPosition a roll position in history [0-9]
     * @return the display message of the chosen roll
     */
    public static String getRollHistoryMsg(final Context ctx, final int aPosition)
    {
        // <Talent> : <result>
        final Roll roll = rollsHistory.get(aPosition);
        Log.w("EDDicesLauncher", "Roll Name Id is: " + roll.rollNameId + ", roll kind: " + roll.rollKind);
        return ctx.getString(R.string.roller_history_info, ctx.getString(roll.rollNameId), Integer.toString(roll.rollResult));
    }
    /**
     * Retrieves the logs of a previous roll, in rolls history
     * @param ctx Android Context
     * @param aPosition a roll position in history [0-9]
     * @return the logs of the chosen roll, ready for display
     */
    public static String getRollHistoryDetails(final Context ctx, final int aPosition)
    {
        final Roll roll = rollsHistory.get(aPosition);
        return getDetailedMessage(ctx, roll);
    }
    /**
     * Retrieves the logs of the previous roll
     * @param ctx Android Context
     * @return the logs of the previous roll
     */
    public static String getDetailedMessage(final Context ctx)
    {
        final Roll roll = rollsHistory.getFirst();
        return getDetailedMessage(ctx, roll);
    }

    private static String getDetailedMessage(final Context ctx, final Roll roll)
    {
        final String msg = getRolledDicesInfos(ctx, roll);
        return ctx.getString(R.string.roller_message, msg, Integer.toString(roll.rollResult), Integer.toString(roll.rollWounds), roll.rollLogs);
    }

    /**
     * Retrieves dices informations of the previous roll
     * @param ctx Android Context
     * @return dices informations of the previous roll
     */
    public static String getRolledDicesInfos(final Context ctx)
    {
        final Roll roll = rollsHistory.getFirst();
        return getRolledDicesInfos(ctx, roll);
    }

    private static String getRolledDicesInfos(final Context ctx, final Roll roll)
    {
        String msg = null;
        if (roll.rollDicesInfos != null)
        {
            msg = roll.rollDicesInfos;
        }
        else
        {
            msg = ctx.getString(R.string.roller_rank_msg, Integer.toString(roll.rollRank), RankManager.getDicesFromRank(roll.rollRank));
        }
        return msg;
    }



    protected static class Roll
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
