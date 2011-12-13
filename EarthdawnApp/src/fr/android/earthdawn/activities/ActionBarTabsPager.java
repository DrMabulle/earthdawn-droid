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

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.fragments.CharacterFragment;
import fr.android.earthdawn.activities.fragments.EquipmentFragment;
import fr.android.earthdawn.activities.fragments.TalentsFragment;
import fr.android.earthdawn.character.Character;
import fr.android.earthdawn.managers.CharacterManager;
import fr.android.earthdawn.managers.DicesLauncher;
import fr.android.earthdawn.utils.Constants;

/**
 * This demonstrates the use of action bar tabs and how they interact
 * with other action bar features.
 */
public class ActionBarTabsPager extends Activity
{
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
        final Character character = CharacterManager.getLoadedCharacter();
        Bundle bundle;

        // Infos générales
        bundle = new Bundle(2);
        bundle.putSerializable(Constants.BUNDLE_CHARACTER, character);
        mTabsAdapter.addTab(bar.newTab().setText("Description"), CharacterFragment.class, bundle);
        // Talents, par discipline
        if (character.getMainDiscipline() != null)
        {
            bundle = new Bundle(2);
            bundle.putSerializable(Constants.BUNDLE_CHARACTER, character);
            bundle.putSerializable(Constants.BUNDLE_DISCIPLINE, character.getMainDiscipline());
            mTabsAdapter.addTab(bar.newTab().setText(character.getMainDiscipline().getName()), TalentsFragment.class, bundle);
        }
        if (character.getSecondDiscipline() != null)
        {
            bundle = new Bundle(2);
            bundle.putSerializable(Constants.BUNDLE_CHARACTER, character);
            bundle.putSerializable(Constants.BUNDLE_DISCIPLINE, character.getSecondDiscipline());
            mTabsAdapter.addTab(bar.newTab().setText(character.getSecondDiscipline().getName()), TalentsFragment.class, bundle);
        }
        if (character.getThirdDiscipline() != null)
        {
            bundle = new Bundle(2);
            bundle.putSerializable(Constants.BUNDLE_CHARACTER, character);
            bundle.putSerializable(Constants.BUNDLE_DISCIPLINE, character.getThirdDiscipline());
            mTabsAdapter.addTab(bar.newTab().setText(character.getThirdDiscipline().getName()), TalentsFragment.class, bundle);
        }
        // Equipement
        bundle = new Bundle(2);
        bundle.putSerializable(Constants.BUNDLE_CHARACTER, character);
        mTabsAdapter.addTab(bar.newTab().setText("Equipement"), EquipmentFragment.class, bundle);
        // Grimoire

        // Trésors magiques


        if (savedInstanceState != null)
        {
            bar.setSelectedNavigationItem(savedInstanceState.getInt("tab", 0));
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
    }

    @Override
    protected Dialog onCreateDialog(final int id, final Bundle args)
    {
        final Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setTitle(getString(R.string.roller_popup_title2, args.getCharSequence(Constants.BUNDLE_ROLL_TYPE)));
        builder.setMessage(DicesLauncher.get().getDetailedMessage(this));
        builder.setNeutralButton("Close", new DialogInterface.OnClickListener()
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
        ((AlertDialog) dialog).setMessage(DicesLauncher.get().getDetailedMessage(this));
        ((AlertDialog) dialog).setTitle(getString(R.string.roller_popup_title2, args.getCharSequence(Constants.BUNDLE_ROLL_TYPE)));

        super.onPrepareDialog(id, dialog, args);
    }

    /**
     * This is a helper class that implements the management of tabs and all
     * details of connecting a ViewPager with associated TabHost.  It relies on a
     * trick.  Normally a tab host has a simple API for supplying a View or
     * Intent that each tab will show.  This is not sufficient for switching
     * between pages.  So instead we make the content part of the tab host
     * 0dp high (it is not shown) and the TabsAdapter supplies its own dummy
     * view to show as the tab content.  It listens to changes in tabs, and takes
     * care of switch to the correct paged in the ViewPager whenever the selected
     * tab changes.
     */
    public static class TabsAdapter extends FragmentPagerAdapter implements ActionBar.TabListener, ViewPager.OnPageChangeListener
    {
        private final Context mContext;
        private final ActionBar mActionBar;
        private final ViewPager mViewPager;
        private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

        static final class TabInfo
        {
            private final Class<?> clss;
            private final Bundle args;

            TabInfo(final Class<?> _class, final Bundle _args)
            {
                clss = _class;
                args = _args;
            }
        }

        public TabsAdapter(final Activity activity, final ViewPager pager)
        {
            super(activity.getFragmentManager());
            mContext = activity;
            mActionBar = activity.getActionBar();
            mViewPager = pager;
            mViewPager.setAdapter(this);
            mViewPager.setOnPageChangeListener(this);
        }

        public void addTab(final ActionBar.Tab tab, final Class<?> clss, final Bundle args)
        {
            final TabInfo info = new TabInfo(clss, args);
            tab.setTag(info);
            tab.setTabListener(this);
            mTabs.add(info);
            mActionBar.addTab(tab);
            notifyDataSetChanged();
        }

        @Override
        public int getCount()
        {
            return mTabs.size();
        }

        @Override
        public Fragment getItem(final int position)
        {
            final TabInfo info = mTabs.get(position);
            return Fragment.instantiate(mContext, info.clss.getName(), info.args);
        }

        @Override
        public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels)
        {
        }

        @Override
        public void onPageSelected(final int position)
        {
            mActionBar.setSelectedNavigationItem(position);
        }

        @Override
        public void onPageScrollStateChanged(final int state)
        {
        }

        @Override
        public void onTabSelected(final Tab tab, final FragmentTransaction ft)
        {
            final Object tag = tab.getTag();
            for (int i = 0; i < mTabs.size(); i++)
            {
                if (mTabs.get(i) == tag)
                {
                    mViewPager.setCurrentItem(i);
                }
            }
        }

        @Override
        public void onTabUnselected(final Tab tab, final FragmentTransaction ft)
        {
        }

        @Override
        public void onTabReselected(final Tab tab, final FragmentTransaction ft)
        {
        }
    }
}
