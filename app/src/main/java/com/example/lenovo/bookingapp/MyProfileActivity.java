package com.example.lenovo.bookingapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.lenovo.bookingapp.Fragments.UserDatewiseFragment;
import com.example.lenovo.bookingapp.Fragments.UserPopularitywiseFragment;
import com.example.lenovo.bookingapp.Utils.CommonFunctions;
import com.example.lenovo.bookingapp.Utils.Constants;

/**
 * Created by Lenovo on 06-02-2016.
 */
public class MyProfileActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentManager fragmentManager;
    private String[] titles = {"DATE", "POPULARITY"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile_activity);
        InitViews();
    }

    private void InitViews() {

        fragmentManager = getSupportFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager.setAdapter(new PagerAdapter(fragmentManager, 2));
        tabLayout.setupWithViewPager(viewPager);
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment eventFragment = null;
            switch (position) {

                case 0:
                    eventFragment = UserDatewiseFragment.getInstance();
                    return eventFragment;
                case 1:
                    eventFragment = UserPopularitywiseFragment.getInstance();
                    return eventFragment;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
    @Override
    public void onBackPressed() {
        if (CommonFunctions.popupWindow != null && CommonFunctions.popupWindow.isShowing()) {
            CommonFunctions.popupWindow.dismiss();
            CommonFunctions.popupWindow = null;
        } else
            super.onBackPressed();
    }
}
