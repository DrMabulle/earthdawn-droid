package fr.android.earthdawn.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import fr.android.earthdawn.R;
import fr.android.earthdawn.dices.RankManager;
import fr.android.earthdawn.managers.DicesLauncher;

public class RollerActivity extends Activity
{
    private static final String LOGS = "logs";
    private static final String RESULT = "result";
    private static final String DICES_INFOS = "DicesInfos";
    private static final int DIALOG_SHOW_ERROR = 1;
    private static final int DIALOG_SHOW_RESULT = 2;

    private final DicesLauncher launcher = new DicesLauncher();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roller);

        final NumberPicker rankPicker = (NumberPicker) findViewById(R.id.rankPicker);
        rankPicker.setMinValue(1);
        rankPicker.setMaxValue(100);

        final Button button = (Button) findViewById(R.id.rollerButton);
        button.setOnClickListener(mAddContentListener);
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

                final boolean isInputCorrect = launcher.testInputDicesInfos(dicesInfos);

                if (!isInputCorrect)
                {
                    // Open error popup
                    showDialog(DIALOG_SHOW_ERROR, null);
                }
                else
                {
                    // Open result popup
                    final int rollingResult = launcher.rollDices(dicesInfos);
                    final Bundle args = new Bundle(3);
                    args.putString(DICES_INFOS, dicesInfos);
                    args.putInt(RESULT, rollingResult);
                    args.putString(LOGS, launcher.getLogs());
                    showDialog(DIALOG_SHOW_RESULT, args);
                }
            }
            else
            {
                final NumberPicker rankPicker = (NumberPicker) findViewById(R.id.rankPicker);
                final int rank = rankPicker.getValue();

                // Open result popup
                final int rollingResult = launcher.rollDices(rank);
                final Bundle args = new Bundle(3);
                args.putString(DICES_INFOS, "rang " + rank + " : " + RankManager.getDicesFromRank(rank));
                args.putInt(RESULT, rollingResult);
                args.putString(LOGS, launcher.getLogs());
                showDialog(DIALOG_SHOW_RESULT, args);
            }

        }
    };

    @Override
    protected Dialog onCreateDialog(final int id, final Bundle args)
    {
        switch (id)
        {
            case DIALOG_SHOW_ERROR:
                final Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(android.R.drawable.ic_dialog_alert);
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

            case DIALOG_SHOW_RESULT:
                final Builder builder2 = new AlertDialog.Builder(this);
                builder2.setIcon(android.R.drawable.ic_dialog_alert);
                builder2.setTitle(this.getString(R.string.roller_popup_title));

                builder2.setMessage(buildMessage(args));

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
        return super.onCreateDialog(id);
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
        if (id == DIALOG_SHOW_RESULT)
        {
            ((AlertDialog) dialog).setMessage(buildMessage(args));
        }

        super.onPrepareDialog(id, dialog, args);
    }

    private String buildMessage(final Bundle args)
    {
        return this.getString(R.string.roller_invalid_input, args.get(DICES_INFOS), args.get(RESULT), args.get(LOGS));
    }
}