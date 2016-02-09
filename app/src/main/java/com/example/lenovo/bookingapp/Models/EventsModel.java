package com.example.lenovo.bookingapp.Models;

/**
 * Created by Lenovo on 05-02-2016.
 */
public class EventsModel {
    String id;
    String category;
    String image;
    String title;
    String eventtime;
    String descp;
    String address;
    String status;
    String adddate;
    String min_rsvp;
    String eventid;
    String edate;
    String etime;
    public String date;
    public String eday;
    String currentrsvp;

    public String getCurrentrsvp() {
        return currentrsvp;
    }

    public void setCurrentrsvp(String currentrsvp) {
        this.currentrsvp = currentrsvp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEday() {
        return eday;
    }

    public void setEday(String eday) {
        this.eday = eday;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getMin_rsvp() {
        return min_rsvp;
    }

    public void setMin_rsvp(String min_rsvp) {
        this.min_rsvp = min_rsvp;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }
}
