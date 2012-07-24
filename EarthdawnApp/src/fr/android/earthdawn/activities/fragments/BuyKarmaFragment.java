package fr.android.earthdawn.activities.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;
import fr.android.earthdawn.R;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.utils.CharacterUtils;

/**
 * @author DrMabulle
 *
 */
public class BuyKarmaFragment extends DialogFragment implements View.OnClickListener
{
    public BuyKarmaFragment()
    {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.popup_buy_karma, container);

        getDialog().setTitle(R.string.popup_buy_karma_title);

        final EDCharacter character = CharacterManager.getLoadedCharacter();
        // If this popup is displayed, then it is possible to buy at least one karma point.
        // Get max number of karma point buyable
        final int maxKarmaBuyable = CharacterUtils.maxKarmaBuyable(character);

        // Initialise NumberPicker
        final NumberPicker karmaPicker = (NumberPicker) view.findViewById(R.id.karmaPicker);
        karmaPicker.setMinValue(1);
        karmaPicker.setMaxValue(maxKarmaBuyable);
        karmaPicker.setValue(maxKarmaBuyable);
        // Hide soft keyboard on NumberPickers by overwriting the OnFocusChangeListener
        final OnFocusChangeListener fcl = new OnFocusChangeListener() {
            @Override
            public void onFocusChange(final View aView, final boolean hasFocus) {
                // Do nothing to suppress keyboard
            }
        };
        ((EditText) karmaPicker.getChildAt(1)).setOnFocusChangeListener(fcl);
        // Suppress soft keyboard from the beginning
        ((EditText) karmaPicker.getChildAt(1)).setInputType(InputType.TYPE_NULL);

        // Close Button
        view.findViewById(R.id.popup_close).setOnClickListener(this);
        // Details Button
        final Button action = (Button) view.findViewById(R.id.popup_action);
        action.setOnClickListener(this);
        action.setText(R.string.popup_buy_karma_button);
        // Hide roll Button
        view.findViewById(R.id.popup_roll).setVisibility(View.GONE);

        return view;
    }

    @Override
    public void onClick(final View aView)
    {
        switch (aView.getId())
        {
            case R.id.popup_close:
                dismiss();
                break;
            case R.id.popup_action:

                // Retrieve number of karma point bought
                final View parent = (View) aView.getParent().getParent().getParent();
                final int karmaBought = ((NumberPicker) parent.findViewById(R.id.karmaPicker)).getValue();

                // Increase karma in character sheat
                CharacterManager.getLoadedCharacter().incrementKarmaBought(karmaBought);

                dismiss();

                Toast.makeText(getActivity(), getString(R.string.popup_buy_karma_toast, karmaBought), Toast.LENGTH_LONG).show();
                break;
        }

    }
}
