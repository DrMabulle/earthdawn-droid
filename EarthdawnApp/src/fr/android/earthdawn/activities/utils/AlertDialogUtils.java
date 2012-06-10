package fr.android.earthdawn.activities.utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.fragments.ShowResultFragment;

public class AlertDialogUtils
{
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

    public static void showDialogResult(final FragmentManager manager)
    {
        final FragmentTransaction ft = manager.beginTransaction();

        // Create and show the dialog.
        final ShowResultFragment newFragment = new ShowResultFragment();
        newFragment.show(ft, "DicesResultFragment");
    }
}
