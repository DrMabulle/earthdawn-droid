package fr.android.earthdawn.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.NumberPicker;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.utils.AlertDialogUtils;
import fr.android.earthdawn.managers.EDDicesLauncher;
import fr.android.earthdawn.utils.Constants;

public class RollerActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roller);

        final NumberPicker rankPicker = (NumberPicker) findViewById(R.id.rankPicker);
        rankPicker.setMinValue(1);
        rankPicker.setMaxValue(100);
        // Hide soft keyboard on NumberPickers by overwriting the OnFocusChangeListener
        final OnFocusChangeListener fcl = new OnFocusChangeListener() {
            @Override
            public void onFocusChange(final View aView, final boolean hasFocus) {
                // Do nothing to suppress keyboard
            }
        };
        ((EditText) rankPicker.getChildAt(1)).setOnFocusChangeListener(fcl);
        // Suppress soft keyboard from the beginning
        ((EditText) rankPicker.getChildAt(1)).setInputType(InputType.TYPE_NULL);

        findViewById(R.id.rollerButton).setOnClickListener(mAddContentListener);
    }

    private final OnClickListener mAddContentListener = new OnClickListener()
    {
        @Override
        public void onClick(final View v)
        {
            final EditText editText = (EditText) findViewById(R.id.rollerDiceText);
            final String dicesInfos = editText.getText().toString();

            if (dicesInfos != null && dicesInfos.length() > 0)
            {

                final boolean isInputCorrect = EDDicesLauncher.testInputDicesInfos(dicesInfos);

                if (!isInputCorrect)
                {
                    // Open error popup
                    showDialog(Constants.DIALOG_SHOW_ERROR, null);
                }
                else
                {
                    // Open result popup
                    EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_OTHER, R.string.empty, dicesInfos, 0);
                    AlertDialogUtils.showDialogResult(getFragmentManager());
                }
            }
            else
            {
                final NumberPicker rankPicker = (NumberPicker) findViewById(R.id.rankPicker);
                final int rank = rankPicker.getValue();

                // Open result popup
                EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_OTHER, R.string.empty, rank, 0);
                AlertDialogUtils.showDialogResult(getFragmentManager());
            }

        }
    };

    @Override
    protected Dialog onCreateDialog(final int id, final Bundle args)
    {
        switch (id)
        {
            case Constants.DIALOG_SHOW_ERROR:
                final Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(android.R.drawable.ic_dialog_info);
                builder.setTitle("Erreur de saisie");
                builder.setMessage(this.getString(R.string.roller_format_error));
                builder.setNeutralButton("Close", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(final DialogInterface dialog, final int whichButton)
                    {
                        dialog.dismiss();
                    }
                });
                return builder.create();

            case Constants.DIALOG_SHOW_DETAILS:
                final Builder builder2 = new AlertDialog.Builder(this);
                builder2.setIcon(android.R.drawable.ic_dialog_info);
                builder2.setTitle(this.getString(R.string.roller_popup_title));

                builder2.setMessage(buildMessage());

                builder2.setNeutralButton("Close", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(final DialogInterface dialog, final int whichButton)
                    {
                        dialog.dismiss();
                    }
                });
                return builder2.create();
        }
        return super.onCreateDialog(id, args);
    }

    /*
     * (non-Javadoc)
     *
     * @see android.app.Activity#onPrepareDialog(int, android.app.Dialog,
     * android.os.Bundle)
     */
    @Override
    protected void onPrepareDialog(final int id, final Dialog dialog, final Bundle args)
    {
        if (id == Constants.DIALOG_SHOW_DETAILS)
        {
            ((AlertDialog) dialog).setMessage(buildMessage());
        }

        super.onPrepareDialog(id, dialog, args);
    }

    private String buildMessage()
    {
        return  EDDicesLauncher.getDetailedMessage(this);
    }
}