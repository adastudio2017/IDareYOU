package adastudio.idareyou.Activites;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import adastudio.idareyou.Adapters.ViewAdapter;
import adastudio.idareyou.Pagers.Vertical_Pager;
import adastudio.idareyou.R;


public class MainActivity extends FragmentActivity {


    private final String TAG = "MAIN_ACTIVITY";

    private ViewPager  mPager;
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mPager = (ViewPager) findViewById(R.id.container);
        mPagerAdapter = new ViewAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

    }


}
