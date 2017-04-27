package adastudio.idareyou.Pagers;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by NoCool on 4/26/2017.
 */


public class Vertical_Pager extends ViewPager {

    private final String TAG = "Vertical_Pager";
    public Vertical_Pager(Context context)
    {
        super(context);
        init();
    }

    private void init()
    {
        setPageTransformer(true, new VerticalPageTransformer());
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev); // return touch coordinates to original reference frame for any child views
        return intercepted;

    }


    private MotionEvent swapXY(MotionEvent ev) {
        float width = getWidth();
        float height = getHeight();

        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;

        ev.setLocation(newX, newY);

        return ev;
    }

    private class VerticalPageTransformer  implements ViewPager.PageTransformer
    {

        @Override
        public void transformPage(View view, float position)
        {

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                view.setAlpha(1);

                // Counteract the default slide transition
                view.setTranslationX(view.getWidth() * -position);

                //set Y position to swipe in from top
                float yPosition = position * view.getHeight();
                view.setTranslationY(yPosition);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }

    }
    }


