package fr.android.earthdawn;

import java.util.List;

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
import fr.android.earthdawn.dices.Dice;
import fr.android.earthdawn.dices.DicesLauncher;

public class EarthDawnActivity extends Activity
{
    private static final StringBuilder MSG_ERROR = new StringBuilder("Le format est incorrect.\n").append(
            "Le format attendu est xDy, répété à l'envie, séparé par un espace.\n")
            .append("Exemples :\n1D20\n1D20 2D12\n1D20 1D12 2D10 1D8 1D6 3D4\n");

    private static final int DIALOG_SHOW_ERROR = 1;
    private static final int DIALOG_SHOW_RESULT = 2;

    private final DicesLauncher launcher = new DicesLauncher();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(mAddContentListener);
    }

    private final OnClickListener mAddContentListener = new OnClickListener()
    {
        @Override
        public void onClick(final View v)
        {
            final EditText editText = (EditText) findViewById(R.id.editText1);
            final String dicesInfos = editText.getText().toString();

            final boolean isInputCorrect = launcher.testInputDicesInfos(dicesInfos);

            if (!isInputCorrect)
            {
                // Open error popup
                showDialog(DIALOG_SHOW_ERROR, null);
            }
            else
            {
                // Open result popup
                final List<Dice> dices = launcher.parseDicesInfos(dicesInfos);
                final int rollingResult = launcher.rollDices(dices);
                final Bundle args = new Bundle(3);
                args.putString("DicesInfos", dicesInfos);
                args.putInt("result", rollingResult);
                args.putString("logs", launcher.getLogs());
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
                builder.setMessage(MSG_ERROR.toString());
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener()
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
                builder2.setTitle("Résultat du jet de dés :");

                builder2.setMessage(buildMessage(args));

                builder2.setNeutralButton("OK", new DialogInterface.OnClickListener()
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
        return String.format("Vous avez jeté : %s \nRésultat : %d \n\nDétails du lancé : \n%s", args.get("DicesInfos"), args.get("result"), args.get("logs"));
    }
}