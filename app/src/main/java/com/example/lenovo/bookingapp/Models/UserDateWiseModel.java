package com.example.lenovo.bookingapp.Models;

import java.util.ArrayList;

/**
 * Created by Lenovo on 08-02-2016.
 */
public class UserDateWiseModel {
    String date;
    String day;
    ArrayList<EventsModel> data;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ArrayList<EventsModel> getData() {
        return data;
    }

    public void setData(ArrayList<EventsModel> data) {
        this.data = data;
    }
}
