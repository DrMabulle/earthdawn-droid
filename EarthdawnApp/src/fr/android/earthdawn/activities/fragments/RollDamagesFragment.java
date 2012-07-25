/**
 *
 */
package fr.android.earthdawn.activities.fragments;

import java.util.List;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.utils.AlertDialogUtils;
import fr.android.earthdawn.character.enums.Attributs;
import fr.android.earthdawn.character.equipement.IEquipment;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.EDDicesLauncher;
import fr.android.earthdawn.utils.CharacterUtils;
import fr.android.earthdawn.utils.EquipmentUtils;

/**
 * @author DrMabulle
 *
 */
public class RollDamagesFragment extends DialogFragment implements OnClickListener
{
    private List<IEquipment> weapons;

    public RollDamagesFragment()
    {
        super();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
    {
        final View v = inflater.inflate(R.layout.popup_roll_damages, container, false);

        // title of the dialog fragment
        getDialog().setTitle(R.string.popup_roll_damages_title);

        // Fill RadioGroup with avaliables weapons
        final RadioGroup rg = (RadioGroup) v.findViewById(R.id.radioGroupDamages);
        weapons = CharacterUtils.getWeapons(CharacterManager.getLoadedCharacter());

        RadioButton rd;

        int i=0;
        final int size=weapons.size();
        for (; i<size; i++)
        {
            final IEquipment weapon = weapons.get(i);
            rd = new RadioButton(getActivity());
            rd.setText(getString(R.string.weapon_description, weapon.getName(), Integer.toString(getDamageRank(weapon))));
            rd.setId(i);
            rd.setChecked(i==0);
            rg.addView(rd);
        }
        // Ajouter le combat à mains nues
        rd = new RadioButton(getActivity());
        rd.setText(R.string.bare_hands);
        rd.setId(i++);
        rd.setChecked(size==0);
        rg.addView(rd);

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
                weapons = null;
                dismiss();
                break;
            case R.id.popup_roll:
                // retrieve weapon choice
                final int mod = getChosenWeaponDamageBonus(v);

                // compute total damage rank
                final int strengh = getCharacterStrengh();

                // roll dices
                EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_DAMAGES, R.string.damages, strengh + mod, 0);

                // open result popup
                this.dismiss();
                AlertDialogUtils.showDialogResult(getFragmentManager());
                break;
        }
    }

    private int getChosenWeaponDamageBonus(final View v)
    {
        final View parentView = (View) v.getParent().getParent().getParent();
        final RadioGroup rg = (RadioGroup) parentView.findViewById(R.id.radioGroupDamages);
        final int id = rg.getCheckedRadioButtonId();
        return id < weapons.size() ? getDamageRank(weapons.get(id)) : 0;
    }

    private static int getCharacterStrengh()
    {
        return CharacterManager.getLoadedCharacter().getAttributRank(Attributs.STR);
    }

    private static int getDamageRank(final IEquipment weapon)
    {
        return EquipmentUtils.getDamageRank(weapon);
    }
}
