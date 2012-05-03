/**
 *
 */
package fr.android.earthdawn.activities.fragments;

import java.util.List;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import fr.android.earthdawn.R;
import fr.android.earthdawn.character.enums.Attributs;
import fr.android.earthdawn.character.equipement.IEquipment;
import fr.android.earthdawn.dices.DicesLauncher;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.EDDicesLauncher;
import fr.android.earthdawn.utils.CharacterUtils;
import fr.android.earthdawn.utils.Constants;
import fr.android.earthdawn.utils.EquipmentUtils;

/**
 * @author DrMabulle
 *
 */
public class RollDamagesFragment extends DialogFragment implements OnClickListener
{
    private final Bundle args;
    private List<IEquipment> weapons;

    public RollDamagesFragment()
    {
        super();
        args = new Bundle(3);
    }

    public RollDamagesFragment(final Bundle aArgs)
    {
        super();
        args = aArgs;
    }

    public static RollDamagesFragment newInstance(final Bundle aArgs)
    {
        return new RollDamagesFragment(aArgs);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View v = inflater.inflate(R.layout.popup_roll_damages, container, false);

        // title of the dialog fragment
        getDialog().setTitle("Jet de dégâts");

        // Fill RadioGroup with avaliables weapons
        final RadioGroup rg = (RadioGroup) v.findViewById(R.id.radioGroupDamages);
        weapons = CharacterUtils.getWeapons(CharacterManager.getLoadedCharacter());

        RadioButton rd;

        int i=0;
        for (final int size=weapons.size(); i<size; i++)
        {
            final IEquipment weapon = weapons.get(i);
            rd = new RadioButton(getActivity());
            rd.setText(weapon.getName() + " (+" + getDamageRank(weapon) + ")");
            rd.setId(i);
            rd.setChecked(i==0);
            rg.addView(rd);
        }
        // Ajouter le combat à mains nues
        rd = new RadioButton(getActivity());
        rd.setText("Mains nues (+0)");
        rd.setId(i++);
        rg.addView(rd);

        // Close Button
        Button button = (Button) v.findViewById(R.id.popup_close);
        button.setOnClickListener(this);
        // Details Button
        button = (Button) v.findViewById(R.id.popup_hit);
        button.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(final View v)
    {
        switch (v.getId())
        {
            case R.id.popup_close:
                weapons = null;
                dismiss();
                break;
            case R.id.popup_hit:
                // retrieve weapon choice
                final int mod = getChosenWeaponDamageBonus(v);

                // compute total damage rank
                final int strengh = getCharacterStrengh();

                // roll dices
                EDDicesLauncher.get().rollDices(EDDicesLauncher.ROLL_DAMAGES, R.string.damages, strengh + mod);

                // open result popup
                final FragmentTransaction ft = getFragmentManager().beginTransaction();

                // Create and show the dialog.
                args.putCharSequence(Constants.BUNDLE_ROLL_TYPE, "Dégâts");
                final ShowResultFragment newFragment = ShowResultFragment.newInstance(args);
                this.dismiss();
                newFragment.show(ft, "tag");
                break;
        }
    }

    private int getChosenWeaponDamageBonus(final View v)
    {
        final View parentView = (View)  v.getParent().getParent();
        final RadioGroup rg = (RadioGroup) parentView.findViewById(R.id.radioGroupDamages);
        final int id = rg.getCheckedRadioButtonId();
        return id < weapons.size() ? getDamageRank(weapons.get(id)) : 0;
    }

    private int getCharacterStrengh()
    {
        return CharacterManager.getLoadedCharacter().getAttributRank(Attributs.STR);
    }

    private int getDamageRank(final IEquipment weapon)
    {
        return EquipmentUtils.getDamageRank(weapon);
    }
}
