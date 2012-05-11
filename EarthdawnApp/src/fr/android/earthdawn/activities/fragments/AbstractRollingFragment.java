/**
 *
 */
package fr.android.earthdawn.activities.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * @author DrMabulle
 *
 */
public class AbstractRollingFragment extends Fragment
{
    protected void showDialogResult()
    {
        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        // Create and show the dialog.
        final ShowResultFragment newFragment = new ShowResultFragment();
        newFragment.show(ft, "tag");
    }
}
