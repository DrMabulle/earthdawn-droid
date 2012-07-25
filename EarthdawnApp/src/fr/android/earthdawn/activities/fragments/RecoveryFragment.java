package fr.android.earthdawn.activities.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import fr.android.earthdawn.R;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.EDDicesLauncher;
import fr.android.earthdawn.managers.RankManager;
import fr.android.earthdawn.utils.NumberUtils;

public class RecoveryFragment extends DialogFragment implements OnClickListener
{
    public RecoveryFragment()
    {
        super();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View v = inflater.inflate(R.layout.popup_recup, container, false);

        // title of the dialog fragment
        getDialog().setTitle(R.string.popup_recup_title);

        // Infos on recovery level
        final EDCharacter character = CharacterManager.getLoadedCharacter();
        ((TextView) v.findViewById(R.id.popup_recup_default_rank)).setText(getString(R.string.popup_recup_title, Integer.toBinaryString(character.getRecoveryRank())));

        // Numberpickers : set values and prevent keyboard from showing up
        final OnFocusChangeListener fcl = new OnFocusChangeListener() {
            @Override
            public void onFocusChange(final View aView, final boolean hasFocus) {
                // Do nothing to suppress keyboard
            }
        };

        final NumberPicker rankPicker = (NumberPicker) v.findViewById(R.id.recup_rank_bonus);
        rankPicker.setMinValue(-100);
        rankPicker.setMaxValue(100);
        rankPicker.setValue(0);
        // Hide soft keyboard on NumberPickers by overwriting the OnFocusChangeListener
        ((EditText) rankPicker.getChildAt(1)).setOnFocusChangeListener(fcl);
        // Suppress soft keyboard from the beginning
        ((EditText) rankPicker.getChildAt(1)).setInputType(InputType.TYPE_NULL);

        final NumberPicker bonusPicker = (NumberPicker) v.findViewById(R.id.recup_rank_bonus);
        bonusPicker.setMinValue(-100);
        bonusPicker.setMaxValue(100);
        bonusPicker.setValue(0);
        // Hide soft keyboard on NumberPickers by overwriting the OnFocusChangeListener
        ((EditText) bonusPicker.getChildAt(1)).setOnFocusChangeListener(fcl);
        // Suppress soft keyboard from the beginning
        ((EditText) bonusPicker.getChildAt(1)).setInputType(InputType.TYPE_NULL);

        // Close Button
        v.findViewById(R.id.popup_close).setOnClickListener(this);
        // Details Button
        v.findViewById(R.id.popup_roll).setOnClickListener(this);
        // Hide roll Button
        v.findViewById(R.id.popup_action).setVisibility(View.GONE);

        return v;
    }

    @Override
    public void onClick(final View v)
    {
        switch (v.getId())
        {
            case R.id.popup_close:
                dismiss();
                break;
            case R.id.popup_roll:
                // Retrieve recovery test rank from player
                final EDCharacter character = CharacterManager.getLoadedCharacter();
                final int recoveryRank = character.getRecoveryRank();

                // Retrieve recovery bonuses from UI : rank and fixed value
                final View parent = (View) v.getParent().getParent().getParent();
                final NumberPicker bonusRank = (NumberPicker) parent.findViewById(R.id.recup_rank_bonus);
                final NumberPicker bonusFix = (NumberPicker) parent.findViewById(R.id.recup_fix_bonus);

                final int rankBonus = bonusRank.getValue();
                final int fixBonus = bonusFix.getValue();

                // Compute final recovery test
                final String recoveryDices = RankManager.getDicesFromRank(recoveryRank + rankBonus, fixBonus);

                // Roll the dices
                final int result = EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_ATTRIBUT, R.string.recup, recoveryDices, 0);

                // Remove wounds
                final int healed = NumberUtils.ensureMinimum(result - character.getWounds(), 1);

                // Heal character
                character.incrementDamages(healed * -1);

                // Show informative message
                final String msg = getString(R.string.msg_damages_healed,
                        Integer.toString(result),
                        Integer.toString(character.getWounds()),
                        Integer.toString(healed));
                Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();

                this.dismiss();
                break;
        }
    }

}
