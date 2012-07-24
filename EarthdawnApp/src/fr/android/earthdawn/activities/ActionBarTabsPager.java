/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.android.earthdawn.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.adapters.TabsAdapter;
import fr.android.earthdawn.activities.fragments.CharacterFragment;
import fr.android.earthdawn.activities.fragments.EquipmentFragment;
import fr.android.earthdawn.activities.fragments.GainLegendFragment;
import fr.android.earthdawn.activities.fragments.RollDamagesFragment;
import fr.android.earthdawn.activities.fragments.RollHystoryFragment;
import fr.android.earthdawn.activities.fragments.SkillsFragment;
import fr.android.earthdawn.activities.fragments.TakeDamagesFragment;
import fr.android.earthdawn.activities.fragments.TalentsFragment;
import fr.android.earthdawn.character.EDCharacter;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.EDDicesLauncher;
import fr.android.earthdawn.utils.Constants;
import fr.android.earthdawn.utils.NumberUtils;
import fr.android.earthdawn.utils.SerializationUtils;

/**
 * This demonstrates the use of action bar tabs and how they interact
 * with other action bar features.
 */
public class ActionBarTabsPager extends Activity
{
    private static final String TAB = "tab";
    private ViewPager mViewPager;
    private TabsAdapter mTabsAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.pager);
        setContentView(mViewPager);

        final ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

        mTabsAdapter = new TabsAdapter(this, mViewPager);

        // Load character and store it in bundle
        final EDCharacter character = CharacterManager.getLoadedCharacter();
        Bundle bundle;

        // Infos générales
        mTabsAdapter.addTab(bar.newTab().setText(R.string.tab_description), CharacterFragment.class, null);
        // Talents, par discipline
        if (character.getMainDiscipline() != null)
        {
            bundle = new Bundle(1);
            bundle.putSerializable(Constants.BUNDLE_DISCIPLINE, character.getMainDiscipline());
            mTabsAdapter.addTab(bar.newTab().setText(character.getMainDiscipline().getName()), TalentsFragment.class, bundle);
        }
        if (character.getSecondDiscipline() != null)
        {
            bundle = new Bundle(1);
            bundle.putSerializable(Constants.BUNDLE_DISCIPLINE, character.getSecondDiscipline());
            mTabsAdapter.addTab(bar.newTab().setText(character.getSecondDiscipline().getName()), TalentsFragment.class, bundle);
        }
        if (character.getThirdDiscipline() != null)
        {
            bundle = new Bundle(1);
            bundle.putSerializable(Constants.BUNDLE_DISCIPLINE, character.getThirdDiscipline());
            mTabsAdapter.addTab(bar.newTab().setText(character.getThirdDiscipline().getName()), TalentsFragment.class, bundle);
        }
        // Equipement
        mTabsAdapter.addTab(bar.newTab().setText(R.string.tab_stuff), EquipmentFragment.class, null);

        // Compétences
        mTabsAdapter.addTab(bar.newTab().setText(R.string.tab_skills), SkillsFragment.class, null);

        // Grimoire


        if (savedInstanceState != null)
        {
            bar.setSelectedNavigationItem(savedInstanceState.getInt(TAB, 0));
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        // save character on disk
        final EDCharacter character = CharacterManager.getLoadedCharacter();
        SerializationUtils.serializeOnDisk(character, character.getName(), this);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt(TAB, getActionBar().getSelectedNavigationIndex());
        // save character on disk
        final EDCharacter character = CharacterManager.getLoadedCharacter();
        SerializationUtils.serializeOnDisk(character, character.getName(), this);
    }

    @Override
    protected Dialog onCreateDialog(final int id, final Bundle args)
    {
        final Builder builder = new AlertDialog.Builder(this);

        switch (id)
        {
            case Constants.DIALOG_SHOW_DETAILS:
                builder.setTitle(getString(R.string.roller_popup_title2, getString(EDDicesLauncher.getRollType())));
                builder.setMessage(EDDicesLauncher.getDetailedMessage(this));
                break;
            case Constants.DIALOG_SHOW_DAMAGES_TAKEN:
                builder.setTitle(R.string.popup_damages_taken_title);
                builder.setMessage(getString(R.string.popup_damages_taken_msg,
                        args.getCharSequence(Constants.BUNDLE_DMG_TAKEN_ARM),
                        Integer.toString(args.getInt(Constants.BUNDLE_DMG_TAKEN_PV)),
                        Integer.toString(args.getInt(Constants.BUNDLE_DMG_TAKEN_WOUND))));
                break;

            default:
                break;
        }

        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setNeutralButton(R.string.button_close, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(final DialogInterface dialog, final int whichButton)
            {
                dialog.dismiss();
            }
        });
        return builder.create();
    }

    @Override
    protected void onPrepareDialog(final int id, final Dialog dialog, final Bundle args)
    {
        final AlertDialog alert = (AlertDialog) dialog;
        switch (id)
        {
            case Constants.DIALOG_SHOW_DETAILS:
                alert.setTitle(getString(R.string.roller_popup_title2, getString(EDDicesLauncher.getRollType())));
                alert.setMessage(EDDicesLauncher.getDetailedMessage(this));
                break;

            case Constants.DIALOG_SHOW_DAMAGES_TAKEN:
                alert.setTitle(R.string.popup_damages_taken_title);
                alert.setMessage(getString(R.string.popup_damages_taken_msg,
                        args.getCharSequence(Constants.BUNDLE_DMG_TAKEN_ARM),
                        Integer.toString(args.getInt(Constants.BUNDLE_DMG_TAKEN_PV)),
                        Integer.toString(args.getInt(Constants.BUNDLE_DMG_TAKEN_WOUND))));
                break;

            default:
                break;
        }

        super.onPrepareDialog(id, dialog, args);
    }



    @Override
    public boolean onCreateOptionsMenu(final Menu menu)
    {
        getMenuInflater().inflate(R.menu.actionbarmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item)
    {
        // Commun code
        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        final EDCharacter character = CharacterManager.getLoadedCharacter();

        // Depending on chosen action
        switch (item.getItemId()) {
            case R.id.itemBonusMalus:
                startActivity(new Intent(ActionBarTabsPager.this, BonusMalusActivity.class));
                return true;
            case R.id.itemRollDamages:
                // Show Roll Damages Fragment popup
                new RollDamagesFragment().show(ft, "tag");
                return true;
            case R.id.itemTakeDamages:
                // Show Take Damages Fragment popup
                new TakeDamagesFragment().show(ft, "tag");
                return true;
            case R.id.itemHealthStatus:
                final StringBuilder builder = new StringBuilder();
                builder.append(getString(R.string.msg_health_status,
                        Integer.toString(character.getStrain()),
                        Integer.toString(character.getDamages()),
                        Integer.toString(character.getWounds())));
                if (character.getStrain() + character.getDamages() >= character.getHealthPoints())
                {
                    builder.append('\n').append(getString(R.string.msg_health_status_dead));
                }
                else if (character.getStrain() + character.getDamages() >= character.getUnconsciousnessPoints())
                {
                    builder.append('\n').append(getString(R.string.msg_health_status_uncounscious));
                }
                else
                {
                    builder.append('\n').append(getString(R.string.msg_health_status_normal));
                }
                Toast.makeText(getApplication(), builder.toString(), Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemHealStrain:
                character.incrementStrain(character.getStrain() * -1);
                Toast.makeText(getApplication(), R.string.msg_strain_healed, Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemHealDamages:
                final String recoveryDices = character.getRecoveryDices();
                final int result = EDDicesLauncher.rollDices(EDDicesLauncher.ROLL_ATTRIBUT, R.string.recup, recoveryDices, 0);
                // soustraire les blessures graves aux PV récupérés (min 1)
                final int healed = NumberUtils.ensureMinimum(result - character.getWounds(), 1);
                character.incrementDamages(healed * -1);
                final String msg = getString(R.string.msg_damages_healed,
                        Integer.toString(result),
                        Integer.toString(character.getWounds()),
                        Integer.toString(healed));
                Toast.makeText(getApplication(), msg, Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemHealWounds:
                character.incrementWounds(-1);
                Toast.makeText(getApplication(), R.string.msg_wound_healed, Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemHealEverything:
                character.incrementStrain(character.getStrain() * -1);
                character.incrementDamages(character.getDamages() * -1);
                character.incrementWounds(character.getWounds() * -1);
                Toast.makeText(getApplication(), R.string.msg_fully_healed, Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemGainLegend:
                new GainLegendFragment().show(ft, "tag");
                return true;
            case R.id.itemFreeRolls:
                startActivity(new Intent(ActionBarTabsPager.this, RollerActivity.class));
                return true;
            case R.id.itemRollHistory:
                new RollHystoryFragment().show(ft, "tag");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
