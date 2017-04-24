package adastudio.idareyou.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import adastudio.idareyou.Fragments.Dare_Fragment;

/**
 * Created by NoCool on 4/23/2017.
 */

public class ViewAdapter extends FragmentStatePagerAdapter{


    public ViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {

        return new Dare_Fragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
