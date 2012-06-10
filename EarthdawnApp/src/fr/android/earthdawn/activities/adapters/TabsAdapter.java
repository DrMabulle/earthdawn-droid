/**
 *
 */
package fr.android.earthdawn.activities.adapters;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * @author Google
 *
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
public class TabsAdapter extends FragmentPagerAdapter implements ActionBar.TabListener, ViewPager.OnPageChangeListener
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
        // Do Nothing
    }

    @Override
    public void onPageSelected(final int position)
    {
        mActionBar.setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(final int state)
    {
        // Do Nothing
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
        // Do Nothing
    }

    @Override
    public void onTabReselected(final Tab tab, final FragmentTransaction ft)
    {
        // Do Nothing
    }
}
