package com.example.lenovo.bookingapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.bookingapp.Models.EventsModel;
import com.example.lenovo.bookingapp.R;
import com.neopixl.pixlui.components.textview.TextView;

import java.util.ArrayList;

/**
 * Created by Lenovo on 08-02-2016.
 */
public class UserPopularitywiseAdapter extends RecyclerView
        .Adapter<UserPopularitywiseAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<EventsModel> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            {
        TextView txtDayOfMonth;
        TextView txtDay;
        TextView txtTime, txtAroundTime, txtDescription, txtRanking;

        public DataObjectHolder(View itemView, int viewType) {
            super(itemView);

            txtDayOfMonth = (TextView) itemView.findViewById(R.id.txtDayOfMonth);
            txtDay = (TextView) itemView.findViewById(R.id.txtDay);
            txtTime = (TextView) itemView.findViewById(R.id.txtTime);
            txtAroundTime = (TextView) itemView.findViewById(R.id.txtAroundTime);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            txtRanking = (TextView) itemView.findViewById(R.id.txtRanking);
            Log.i(LOG_TAG, "Adding Listener");

        }


    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public UserPopularitywiseAdapter(ArrayList<EventsModel> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_popularity_wise_adapter, parent, false);


        DataObjectHolder dataObjectHolder = new DataObjectHolder(view, viewType);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        EventsModel eventsModel = mDataset.get(position);
        holder.txtDayOfMonth.setText(eventsModel.getDate());
        holder.txtDay.setText(eventsModel.getEday());
        holder.txtTime.setText(eventsModel.getEtime());
        holder.txtDescription.setText(eventsModel.getDescp());
        holder.txtAroundTime.setText(eventsModel.getEtime());
        holder.txtRanking.setText(eventsModel.getCurrentrsvp());

    }

    public void addItem(EventsModel dataObj, int index) {
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

}
