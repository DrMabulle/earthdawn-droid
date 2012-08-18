package fr.android.earthdawn.activities.utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.fragments.ShowResultFragment;

/**
 * Utility class for creating AlertDialogs
 * @author DrMabulle
 */
public class AlertDialogUtils
{
    /**
     * Creates and open an AlertDialog with the given title and message
     * @param ctx Android Context
     * @param title a title to display
     * @param msg a message to display
     */
    public static final void openAlertDialog(final Context ctx, final int title, final int msg)
    {
        final Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setNeutralButton(R.string.button_close, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(final DialogInterface dialog, final int whichButton)
            {
                dialog.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Creates an popup showing the Dice Roll Result and message.
     * @param manager Fragment Manager
     */
    public static void showDialogResult(final FragmentManager manager)
    {
        final FragmentTransaction ft = manager.beginTransaction();

        // Create and show the dialog.
        final ShowResultFragment newFragment = new ShowResultFragment();
        newFragment.show(ft, "DicesResultFragment");
    }
}
