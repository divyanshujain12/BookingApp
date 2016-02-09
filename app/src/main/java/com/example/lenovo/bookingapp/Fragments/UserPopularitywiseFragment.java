package com.example.lenovo.bookingapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.example.lenovo.bookingapp.Adapters.UserPopularitywiseAdapter;
import com.example.lenovo.bookingapp.Models.EventsModel;
import com.example.lenovo.bookingapp.R;
import com.example.lenovo.bookingapp.Utils.CallBackInterface;
import com.example.lenovo.bookingapp.Utils.CallWebService;
import com.example.lenovo.bookingapp.Utils.CommonFunctions;
import com.example.lenovo.bookingapp.Utils.Constants;
import com.example.lenovo.bookingapp.Utils.ParsingResponse;
import com.example.lenovo.bookingapp.Utils.RecyclerItemClickListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Lenovo on 06-02-2016.
 */
public class UserPopularitywiseFragment extends Fragment implements CallBackInterface {


    private RecyclerView userEventsRecyclerView;
    private ArrayList<EventsModel> dataList;
    private UserPopularitywiseAdapter userPopularitywiseAdapter;

    public static UserPopularitywiseFragment getInstance() {

        return new UserPopularitywiseFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_events_fragment, container,
                false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        InitViews();
    }

    private void InitViews() {
        dataList = new ArrayList<>();
        userEventsRecyclerView = (RecyclerView) getView().findViewById(R.id.userEventsRecyclerView);
        userEventsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        CallWebService.getInstance(getActivity(), false).hitJSONObjectVolleyWebService(Request.Method.GET, Constants.WebServices.USER_EVENT_BY_POPULARITY, null, this);

        userEventsRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                EventsModel eventsModel = dataList.get(position);
                CommonFunctions.showEventDescriptionPopup(eventsModel, getActivity(), userEventsRecyclerView);
            }
        }));
    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) {

        try {
            ParsingResponse parsingResponse = new ParsingResponse();
            dataList = parsingResponse.parseJsonArrayWithJsonObject(object.getJSONArray(Constants.EVENTS), EventsModel.class);
            userPopularitywiseAdapter = new UserPopularitywiseAdapter(dataList);
            userEventsRecyclerView.setAdapter(userPopularitywiseAdapter);
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
}
