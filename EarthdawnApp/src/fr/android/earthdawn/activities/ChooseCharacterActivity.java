package fr.android.earthdawn.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import fr.android.earthdawn.R;
import fr.android.earthdawn.managers.CharacterManager;

public class ChooseCharacterActivity extends Activity implements View.OnClickListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_character);

        final LinearLayout ll = (LinearLayout) findViewById(R.id.choice);

        final String[] charNames = CharacterManager.getAvailableCharacters(this);

        final LayoutParams layoutParams = new LayoutParams(250, 100);
        layoutParams.setMargins(25, 25, 25, 25);
        Button button;
        for (final String string : charNames)
        {
            button = new Button(getApplicationContext());
            button.setGravity(Gravity.CENTER);
            button.setLayoutParams(layoutParams);
            button.setText(string);
            button.setOnClickListener(this);

            ll.addView(button);
        }
    }

    @Override
    public void onClick(final View v)
    {
        final String charName = (String) ((Button) v).getText();

        CharacterManager.getCharacter(charName, this);

        startActivity(new Intent(ChooseCharacterActivity.this, ActionBarTabsPager.class));
    }

}
