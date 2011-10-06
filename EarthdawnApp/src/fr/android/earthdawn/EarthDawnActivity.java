package fr.android.earthdawn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import fr.android.earthdawn.activities.RollerActivity;

public class EarthDawnActivity extends Activity implements OnGestureListener
{
    protected static final int MAJOR_MOVE = 60;
    private GestureDetector detector;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        detector = new GestureDetector(this, this);
    }


    @Override
    public boolean onDown(final MotionEvent e)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onFling(final MotionEvent e1, final MotionEvent e2, final float velocityX, final float velocityY)
    {
        Log.i("EarthDawnActivity", "Fling");
        final Intent myIntent = new Intent(getApplicationContext(), RollerActivity.class);
        startActivityForResult(myIntent, 0);
        return false;
    }

    @Override
    public void onLongPress(final MotionEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(final MotionEvent e1, final MotionEvent e2, final float distanceX, final float distanceY)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(final MotionEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(final MotionEvent e)
    {
        // TODO Auto-generated method stub
        return false;
    }

}