package com.example.lenovo.bookingapp.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lenovo.bookingapp.Models.EventsModel;
import com.example.lenovo.bookingapp.R;
import com.example.lenovo.bookingapp.Utils.CommonFunctions;
import com.example.lenovo.bookingapp.Utils.RoundedImageView;
import com.neopixl.pixlui.components.textview.TextView;

import java.util.ArrayList;

/**
 * Created by Lenovo on 05-02-2016.
 */
public class EventViewPagerAdapter extends PagerAdapter implements View.OnClickListener {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<EventsModel> eventsModels;
    Dialog dialog;
    RoundedImageView roundedPartyImage;
    ImageView imgClose;


    public EventViewPagerAdapter(Context context, ArrayList<EventsModel> eventsModels) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.eventsModels = eventsModels;
    }

    @Override
    public int getCount() {
        return eventsModels.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.event_pager_adapter, container, false);
        roundedPartyImage = (RoundedImageView) itemView.findViewById(R.id.roundedPartyImage);
        roundedPartyImage.setTag(position);
        roundedPartyImage.setOnClickListener(this);
        TextView txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
        TextView txtDate = (TextView) itemView.findViewById(R.id.txtDate);
        TextView txtEventType = (TextView) itemView.findViewById(R.id.txtEventType);
        TextView txtDay = (TextView) itemView.findViewById(R.id.txtDay);
        TextView txtTime = (TextView) itemView.findViewById(R.id.txtTime);
        TextView txtApprox = (TextView) itemView.findViewById(R.id.txtApprox);
        TextView txtRanking = (TextView) itemView.findViewById(R.id.txtRanking);

        txtDescription.setText(eventsModels.get(position).getTitle());
        txtDate.setText(eventsModels.get(position).getEdate());
        txtTime.setText(eventsModels.get(position).getEtime());
        txtDay.setText(eventsModels.get(position).getEday());
        txtRanking.setText(eventsModels.get(position).getCurrentrsvp());
        txtEventType.setText(eventsModels.get(position).getCategory());
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.roundedPartyImage)
            CommonFunctions.showEventDescriptionPopup(eventsModels.get((Integer) view.getTag()), mContext, roundedPartyImage);
    }


}
