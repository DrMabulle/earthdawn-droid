package fr.android.earthdawn.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fr.android.earthdawn.R;

public class EarthDawnActivity extends Activity implements View.OnClickListener
{
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.m_sheet).setOnClickListener(this);
        findViewById(R.id.m_new).setOnClickListener(this);
        findViewById(R.id.m_map).setOnClickListener(this);
        findViewById(R.id.m_tests).setOnClickListener(this);
    }

    @Override
    public void onClick(final View view)
    {
        switch (view.getId())
        {
            case R.id.m_sheet:
                startActivity(new Intent(EarthDawnActivity.this, ChooseCharacterActivity.class));
                break;
            case R.id.m_new:
                showDialog(0, null);
                break;
            case R.id.m_map:
                startActivity(new Intent(EarthDawnActivity.this, MapViewActivity.class));
                break;
            case R.id.m_tests:
                startActivity(new Intent(EarthDawnActivity.this, RollerActivity.class));
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(final int id, final Bundle args)
    {
        final Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle(R.string.not_yet_implemented);
        builder.setMessage(R.string.not_yet_implemented);
        builder.setNeutralButton(R.string.popup_close, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(final DialogInterface dialog, final int whichButton)
            {
                dialog.dismiss();
            }
        });
        return builder.create();
    }

}