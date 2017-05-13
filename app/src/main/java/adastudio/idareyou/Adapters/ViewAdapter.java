package adastudio.idareyou.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import adastudio.idareyou.Fragments.Contacts_Fragment;
import adastudio.idareyou.Fragments.Dare_Fragment;
import adastudio.idareyou.Fragments.Profile_Fragment;

/**
 * Created by NoCool on 4/23/2017.
 */

public class ViewAdapter extends FragmentStatePagerAdapter{


    public ViewAdapter(FragmentManager fm)
    {
        super(fm);

    }

    @Override
    public Fragment getItem(int position)
    {

        Fragment returnFragment;
        switch (position){
            case 0:
                returnFragment= new  Dare_Fragment();
                break;
            case 1:
                returnFragment = new Profile_Fragment();
                break;
            case 2:
                Log.d("IDAREYOU","INSIDE CASE 2");
                returnFragment = new Contacts_Fragment();
                break;

            default:
                returnFragment = new Dare_Fragment();

    }
    return returnFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }


//    private MotionEvent swapXY(MotionEvent ev) {
//        float width = getWidth();
//        float height = getHeight();
//
//        float newX = (ev.getY() / height) * width;
//        float newY = (ev.getX() / width) * height;
//
//        ev.setLocation(newX, newY);
//
//        return ev;
//    }
//
//    private class VerticalPageTransformer  implements ViewPager.PageTransformer
//    {
//
//        @Override
//        public void transformPage(View view, float position)
//        {
//
//            if (position < -1) { // [-Infinity,-1)
//                // This page is way off-screen to the left.
//                view.setAlpha(0);
//
//            } else if (position <= 1) { // [-1,1]
//                view.setAlpha(1);
//
//                // Counteract the default slide transition
//                view.setTranslationX(view.getWidth() * -position);
//
//                //set Y position to swipe in from top
//                float yPosition = position * view.getHeight();
//                view.setTranslationY(yPosition);
//
//            } else { // (1,+Infinity]
//                // This page is way off-screen to the right.
//                view.setAlpha(0);
//            }
//        }

  //  }
}
