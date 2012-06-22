package fr.android.earthdawn.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.NumberPicker;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.EarthDawnActivity;
import fr.android.earthdawn.managers.EDDicesLauncher;

public class RollerTest extends ActivityInstrumentationTestCase2<EarthDawnActivity>
{
    private EarthDawnActivity mActivity;

    public RollerTest()
    {
        super(EarthDawnActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        mActivity = this.getActivity();
    }

    public void testMainActivity()
    {
        mActivity.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                final Button button = (Button) mActivity.findViewById(R.id.m_tests);
                button.performClick();

                final Activity roller = getActivity();
                final NumberPicker mRankPicker = (NumberPicker) roller.findViewById(R.id.rankPicker);
                assertNotNull(mRankPicker);
                final Button mButton = (Button) roller.findViewById(R.id.rollerButton);
                assertNotNull(mButton);

                mRankPicker.requestFocus();
                mRankPicker.setValue(10);

                mButton.requestFocus();
                mButton.performClick();

                assertTrue(EDDicesLauncher.getRollResult() > 0);

            }
        });
    }
}
