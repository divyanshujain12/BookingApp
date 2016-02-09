package com.example.lenovo.bookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lenovo.bookingapp.Fragments.EventFragment;
import com.example.lenovo.bookingapp.Fragments.EventLaterFragment;
import com.example.lenovo.bookingapp.Utils.CommonFunctions;
import com.example.lenovo.bookingapp.Utils.Constants;
import com.example.lenovo.bookingapp.Utils.UpdateEventCountInterface;
import com.neopixl.pixlui.components.textview.TextView;

/**
 * Created by Lenovo on 05-02-2016.
 */
public class HomeActivity extends AppCompatActivity implements UpdateEventCountInterface {

    private static FragmentManager manager;

    private TextView txtEventCount;
    private View todayLine, laterLine;
    private String[] titles = {"TODAY", "LATER"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        InitViews();
    }

    private void InitViews() {

        manager = getSupportFragmentManager();
        txtEventCount = (TextView) findViewById(R.id.txtEventCount);

        todayLine = findViewById(R.id.todayLine);
        laterLine = findViewById(R.id.laterLine);

        updateFragment(EventFragment.getInstance(Constants.WebServices.EVENTS, HomeActivity.this));
    }

    @Override
    public void onBackPressed() {
        if (CommonFunctions.popupWindow != null && CommonFunctions.popupWindow.isShowing()) {
            CommonFunctions.popupWindow.dismiss();
            CommonFunctions.popupWindow = null;
        } else
            finish();
    }

    public void MyProfile(View v) {

        Intent intent = new Intent(this, MyProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public void updateCount(String count) {

        txtEventCount.setText(count);

    }

    public void ReplaceFragment(View v) {
        switch (v.getId()) {
            case R.id.eventTodayLL:
                todayLine.setVisibility(View.VISIBLE);
                laterLine.setVisibility(View.GONE);
                updateFragment(EventFragment.getInstance(Constants.WebServices.EVENTS, HomeActivity.this));
                break;
            case R.id.eventLaterLL:
                todayLine.setVisibility(View.GONE);
                laterLine.setVisibility(View.VISIBLE);
                updateFragment(EventLaterFragment.getInstance(Constants.WebServices.EVENTS, HomeActivity.this));
                break;
        }
    }

    public static void updateFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        boolean fragShowing = manager.popBackStackImmediate(fragment.getClass().getName(), 0);

        if (!fragShowing) {
            if (!(fragment instanceof EventFragment))
                fragmentTransaction.addToBackStack(fragment.getClass().getName());
            fragmentTransaction.replace(R.id.nav_contentframe, fragment);
            fragmentTransaction.commit();

        }
    }


}
