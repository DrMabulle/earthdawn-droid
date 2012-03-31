/**
 *
 */
package fr.android.earthdawn.activities.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.Toast;
import fr.android.earthdawn.R;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.utils.Constants;

/**
 * @author DrMabulle
 *
 */
public class TakeDamagesFragment extends DialogFragment implements OnClickListener
{
    private final Bundle args;

    public TakeDamagesFragment(final Bundle aArgs)
    {
        super();
        args = aArgs;
    }
    public TakeDamagesFragment()
    {
        super();
        args = new Bundle(3);
    }

    public static TakeDamagesFragment newInstance(final Bundle aArgs)
    {
        return new TakeDamagesFragment(aArgs);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View v = inflater.inflate(R.layout.popup_take_damages, container, false);

        // title of the dialog fragment
        getDialog().setTitle("Subir des dégâts");

        final NumberPicker rankPicker = (NumberPicker) v.findViewById(R.id.damagesPicker);
        rankPicker.setMinValue(1);
        rankPicker.setMaxValue(200);
        // Hide soft keyboard on NumberPickers by overwriting the OnFocusChangeListener
        final OnFocusChangeListener fcl = new OnFocusChangeListener() {
            @Override
            public void onFocusChange(final View v, final boolean hasFocus) {
                // Do nothing to suppress keyboard
            }
        };
        ((EditText) rankPicker.getChildAt(1)).setOnFocusChangeListener(fcl);
        // Suppress soft keyboard from the beginning
        ((EditText) rankPicker.getChildAt(1)).setInputType(InputType.TYPE_NULL);


        // Close Button
        Button button = (Button) v.findViewById(R.id.popup_close);
        button.setOnClickListener(this);
        // Take Damages Button
        button = (Button) v.findViewById(R.id.popup_take_damages);
        button.setOnClickListener(this);

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
            case R.id.popup_take_damages:
                // popup
                final View parentView = (View)  v.getParent().getParent();

                // Récupérer le nombre de dommages subis
                final int damages = ((NumberPicker) parentView.findViewById(R.id.damagesPicker)).getValue();

                // Déterminer l'armure en fonction du choix de l'utilisateur

                final int armor = computeArmor(parentView);

                // calculer le nombre de points de vie perdus
                int healthPointsLost = damages - armor;
                if (healthPointsLost < 1)
                {
                    healthPointsLost = 1;
                }

                // calculer le nombre de blessures graves
                final int wounds = computeWounds(healthPointsLost);

                // ajouter un temp mod au perso avec les nouvelles blessures
                final EDCharacter character = CharacterManager.getLoadedCharacter();
                final int totalDamages = character.incrementDamages(healthPointsLost);
                final int strain = character.getStrain();
                if (wounds > 0)
                {
                    character.incrementWounds(wounds);
                }
                // Show message if death or unconsciousness
                if (totalDamages + strain >= character.getHealthPoints())
                {
                    Toast.makeText(getActivity(), "Vous êtes mort...", Toast.LENGTH_LONG).show();
                }
                else if (totalDamages + strain >= character.getUnconsciousnessPoints())
                {
                    Toast.makeText(getActivity(), "Vous sombrez dans l'inconscience...", Toast.LENGTH_LONG).show();
                }

                // Ouvrir une popup résumant toutes ces infos
                args.putCharSequence(Constants.BUNDLE_DMG_TAKEN_ARM, computeArmorMsg(armor));
                args.putInt(Constants.BUNDLE_DMG_TAKEN_PV, healthPointsLost);
                args.putInt(Constants.BUNDLE_DMG_TAKEN_WOUND, wounds);

                // open result popup
                getActivity().showDialog(Constants.DIALOG_SHOW_DAMAGES_TAKEN, args);
                dismiss();
                break;
        }
    }

    private int computeArmor(final View parentView)
    {
        final RadioGroup rg = (RadioGroup) parentView.findViewById(R.id.radioGroupArmor);
        final int id = rg.getCheckedRadioButtonId();
        final EDCharacter character = CharacterManager.getLoadedCharacter();
        int armor = 0;
        switch (id)
        {
            case R.id.radioArmorPhy:
                armor = character.getPhysicalArmor();
                break;
            case R.id.radioArmorMys:
                armor = character.getMysticArmor();
                break;
            default:
                break;
        }
        return armor;
    }

    private int computeWounds(final int healthPointsLost)
    {
        final int woundThreshold = CharacterManager.getLoadedCharacter().getWoundThreshold();
        return healthPointsLost / woundThreshold;
    }

    private CharSequence computeArmorMsg(final int armor)
    {
        if (armor == 0)
        {
            return "Vous ne bénéficiez d'aucune armure";
        }
        return "Votre armure vous protège (" + armor + " points),";
    }

}
