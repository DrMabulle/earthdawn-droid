/**
 *
 */
package fr.android.earthdawn.activities.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * @author DrMabulle
 *
 */
public class AbstractRollingFragment extends Fragment
{
    protected void showDialogResult(final Bundle args)
    {
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        final Fragment prev = getFragmentManager().findFragmentByTag("ShowResult");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        final ShowResultFragment newFragment = ShowResultFragment.newInstance(args);
        newFragment.show(ft, "ShowResult");
    }
}