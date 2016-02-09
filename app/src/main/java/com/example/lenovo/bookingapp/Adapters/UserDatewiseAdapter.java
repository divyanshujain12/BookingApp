package com.example.lenovo.bookingapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.bookingapp.Models.EventsModel;
import com.example.lenovo.bookingapp.Models.UserDateModel;
import com.example.lenovo.bookingapp.R;
import com.neopixl.pixlui.components.textview.TextView;

import java.util.ArrayList;

/**
 * Created by Lenovo on 08-02-2016.
 */

public class UserDatewiseAdapter extends RecyclerView
        .Adapter<UserDatewiseAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Object> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView txtDayOfMonth;
        TextView txtDay;
        TextView txtTime, txtAroundTime, txtDescription, txtRanking;

        public DataObjectHolder(View itemView, int viewType) {
            super(itemView);
            switch (viewType) {
                case 0:
                    txtDayOfMonth = (TextView) itemView.findViewById(R.id.txtDayOfMonth);
                    txtDay = (TextView) itemView.findViewById(R.id.txtDay);
                    break;
                case 1:
                    txtTime = (TextView) itemView.findViewById(R.id.txtTime);
                    txtAroundTime = (TextView) itemView.findViewById(R.id.txtAroundTime);
                    txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
                    txtRanking = (TextView) itemView.findViewById(R.id.txtRanking);
                    break;
            }


            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           // myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public UserDatewiseAdapter(ArrayList<Object> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.user_event_by_time_header, parent, false);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.user_date_wise_adapter, parent, false);
                break;
        }


        DataObjectHolder dataObjectHolder = new DataObjectHolder(view, viewType);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                UserDateModel userDateModel = (UserDateModel) mDataset.get(position);
                holder.txtDayOfMonth.setText(userDateModel.getDate());
                holder.txtDay.setText(userDateModel.getDay());

                break;
            case 1:
                EventsModel eventsModel = (EventsModel) mDataset.get(position);
                holder.txtTime.setText(eventsModel.getEdate());
                holder.txtDescription.setText(eventsModel.getDescp());
                holder.txtAroundTime.setText(eventsModel.getEtime());
                holder.txtRanking.setText(eventsModel.getCurrentrsvp());
                break;
        }
    }

    public void addItem(Object dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataset.get(position) instanceof UserDateModel)
            return 0;
        else
            return 1;
    }
}
