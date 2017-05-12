package adastudio.idareyou.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import adastudio.idareyou.Fragments.Contacts_Fragment;
import adastudio.idareyou.Fragments.Dare_Fragment;
import adastudio.idareyou.Fragments.Profile_Fragment;

/**
 * Created by NoCool on 4/23/2017.
 */

public class ViewAdapter extends FragmentStatePagerAdapter{

    FragmentManager fm;

    public ViewAdapter(FragmentManager fm)
    {
        super(fm);
        this.fm = fm;

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
}
