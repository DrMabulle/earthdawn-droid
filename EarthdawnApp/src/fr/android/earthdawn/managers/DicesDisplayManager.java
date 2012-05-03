/**
 *
 */
package fr.android.earthdawn.managers;

import android.content.Context;
import fr.android.earthdawn.R;
import fr.android.earthdawn.dices.DicesLauncher;

/**
 * @author DrMabulle
 *
 */
public final class DicesDisplayManager
{
    private DicesDisplayManager() {}

    public static String getDetailedMessage(final Context ctx)
    {
        String msg = null;
        if (DicesLauncher.getDicesInfos() != null)
        {
            msg = DicesLauncher.getDicesInfos();
        }
        else
        {
            final int rank = DicesLauncher.getRank();
            msg = ctx.getString(R.string.roller_rank_msg, rank, RankManager.getDicesFromRank(rank));
        }
        return ctx.getString(R.string.roller_message, msg, DicesLauncher.getRollResult(), DicesLauncher.getRollLogs());
    }
}
