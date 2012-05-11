package fr.android.earthdawn.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.RollerActivity;

public class RollerActivityTest extends ActivityInstrumentationTestCase2<RollerActivity>
{
    private RollerActivity mActivity;
    private NumberPicker mRankPicker;
    private TextView mDicesInfos;
    private Button mButton;;

    public RollerActivityTest()
    {
        super("fr.android.earthdawn.activities", RollerActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        mActivity = this.getActivity();
        mRankPicker = (NumberPicker) mActivity.findViewById(R.id.rankPicker);
        mDicesInfos = (TextView) mActivity.findViewById(R.id.rollerDiceText);
        mButton = (Button) mActivity.findViewById(R.id.rollerButton);
    }

    public void testPreconditions()
    {
        assertNotNull(mRankPicker);
        assertNotNull(mDicesInfos);
        assertNotNull(mButton);
    }

    public void testMainActivity()
    {
        mActivity.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                mRankPicker.requestFocus();
                mRankPicker.setValue(10);

                mButton.performClick();
            }
        });
    }
}
