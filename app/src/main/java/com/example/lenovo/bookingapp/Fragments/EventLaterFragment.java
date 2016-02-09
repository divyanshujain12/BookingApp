package com.example.lenovo.bookingapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.Request;
import com.example.lenovo.bookingapp.Adapters.EventViewPagerAdapter;
import com.example.lenovo.bookingapp.Models.EventsModel;
import com.example.lenovo.bookingapp.R;
import com.example.lenovo.bookingapp.Utils.CallBackInterface;
import com.example.lenovo.bookingapp.Utils.CallWebService;
import com.example.lenovo.bookingapp.Utils.Constants;
import com.example.lenovo.bookingapp.Utils.ParsingResponse;
import com.example.lenovo.bookingapp.Utils.UpdateEventCountInterface;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Lenovo on 08-02-2016.
 */
public class EventLaterFragment extends Fragment implements CallBackInterface, View.OnClickListener, ViewPager.OnPageChangeListener {

    public ViewPager pager;
    private ImageView imgPrevious, imgCorrect, imgNext;
    private static String webUrl = "";
    private int currentItemPos = 0;
    private static UpdateEventCountInterface updateEventCountInterface;
    private static EventLaterFragment eventFragment = null;
    public ArrayList<EventsModel> eventsModels = new ArrayList<>();
    private SparseBooleanArray selectedArray = new SparseBooleanArray();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static EventLaterFragment getInstance(String url, UpdateEventCountInterface updateCountInterface) {
        if (eventFragment == null)
            eventFragment = new EventLaterFragment();
        updateEventCountInterface = updateCountInterface;
        webUrl = url;
        return eventFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_fragment, container,
                false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        InitViews();
    }

    private void InitViews() {

        pager = (ViewPager) getView().findViewById(R.id.pager);
      //  CallWebService.getInstance(getActivity(), false).hitJSONObjectVolleyWebService(Request.Method.GET, webUrl, null, this);
        imgPrevious = (ImageView) getView().findViewById(R.id.imgPrevious);
        imgPrevious.setOnClickListener(this);
        imgNext = (ImageView) getView().findViewById(R.id.imgNext);
        imgNext.setOnClickListener(this);
        imgCorrect = (ImageView) getView().findViewById(R.id.imgCorrect);
        imgCorrect.setOnClickListener(this);
        if(eventsModels.isEmpty())
            CallWebService.getInstance(getActivity(), true).hitJSONObjectVolleyWebService(Request.Method.GET, webUrl, null, this);
        else{
            EventViewPagerAdapter eventViewPagerAdapter = new EventViewPagerAdapter(getActivity(), eventsModels);
            pager.setAdapter(eventViewPagerAdapter);
            pager.setOnPageChangeListener(this);
            updateEventCountInterface.updateCount(String.valueOf(pager.getCurrentItem()+1) + "/" + String.valueOf(eventsModels.size()) + " " + "EVENTS");
        }
    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) {

        try {
            ParsingResponse parsingResponse = new ParsingResponse();
            eventsModels = parsingResponse.parseJsonArrayWithJsonObject(object.optJSONArray(Constants.EVENTS), EventsModel.class);
            //eventsModels.addAll(eventsModels);
            EventViewPagerAdapter eventViewPagerAdapter = new EventViewPagerAdapter(getActivity(), eventsModels);
            pager.setAdapter(eventViewPagerAdapter);
            pager.setOnPageChangeListener(this);

            updateEventCountInterface.updateCount(String.valueOf(pager.getCurrentItem()+1) + "/" + String.valueOf(eventsModels.size()) + " " + "EVENTS");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onJsonArrarSuccess(JSONArray array) {

    }

    @Override
    public void onFailure(String str) {

    }

    @Override
    public void onClick(View view) {
        if (view == imgNext)
            goNext();
        else if (view == imgPrevious)
            goPrevious();
        else if (view == imgCorrect) {
            int pagerPosition = pager.getCurrentItem();
            if (!selectedArray.get(pagerPosition, false)) {
                view.setBackgroundResource(R.drawable.green_circle);
                selectedArray.put(pagerPosition, true);
            } else {
                view.setBackgroundResource(R.drawable.faded_circle);
                selectedArray.delete(pagerPosition);
            }

        }
    }

    private void goNext() {

        if (currentItemPos < eventsModels.size()) {
            currentItemPos = currentItemPos + 1;
            pager.setCurrentItem(currentItemPos, true);
        }
    }

    private void goPrevious() {
        if (currentItemPos != 0) {
            currentItemPos = currentItemPos - 1;
            pager.setCurrentItem(currentItemPos, true);
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        updateEventCountInterface.updateCount(String.valueOf(position + 1) + "/" + String.valueOf(eventsModels.size()) + " " + "EVENTS");

        if (selectedArray.get(position, false)) {
            imgCorrect.setBackgroundResource(R.drawable.green_circle);

        } else {
            imgCorrect.setBackgroundResource(R.drawable.faded_circle);

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
