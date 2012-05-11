package fr.android.earthdawn.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import fr.android.earthdawn.R;
import fr.android.earthdawn.activities.EarthDawnActivity;

public class EarthDawnActivityTest extends ActivityInstrumentationTestCase2<EarthDawnActivity>
{
    private EarthDawnActivity mActivity;

    public EarthDawnActivityTest()
    {
        super(EarthDawnActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        mActivity = this.getActivity();
    }

    public void testPreconditions()
    {
        assertNotNull(mActivity.findViewById(R.id.m_map));
        assertNotNull(mActivity.findViewById(R.id.m_new));
        assertNotNull(mActivity.findViewById(R.id.m_sheet));
        assertNotNull(mActivity.findViewById(R.id.m_tests));
    }

    public void testMainActivity()
    {
        mActivity.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                final Button button = (Button) mActivity.findViewById(R.id.m_map);
                button.requestFocus();
            }
        });
    }
}
