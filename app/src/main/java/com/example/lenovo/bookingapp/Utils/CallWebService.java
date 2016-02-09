package com.example.lenovo.bookingapp.Utils;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.lenovo.bookingapp.MyApplication;
import com.example.lenovo.bookingapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Lenovo on 30-10-2015.
 */
public class CallWebService {

    private static Context context = null;

    private static CallWebService instance = null;

    private static CustomProgressDialog progressDialog = null;


    public static CallWebService getInstance(Context context,boolean showProgressBar) {
        instance.context = context;
        if (context != null&& showProgressBar)
            progressDialog = new CustomProgressDialog(context, R.drawable.syc);
        else
            progressDialog = null;
        if (instance == null) {
            instance = new CallWebService();
        }

        return instance;
    }

    public void hitJSONObjectVolleyWebService(int requestType, String url, HashMap<String, String> json, final CallBackInterface callBackinerface) {
        if (progressDialog != null)
            progressDialog.show();

        JsonObjectRequest request = new JsonObjectRequest(requestType, url,json == null ? null: (new JSONObject(json)), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (progressDialog != null)
                    progressDialog.dismiss();
                try {
                    if (response.getString(Constants.SUCCESS).equals("1"))
                        callBackinerface.onJsonObjectSuccess(response);
                    else
                        callBackinerface.onFailure(response.optString(Constants.MESSAGE));
                } catch (JSONException e) {
                    callBackinerface.onFailure(e.getMessage());
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBackinerface.onFailure(error.getMessage());
                if (progressDialog != null)
                    progressDialog.dismiss();

            }
        });

        MyApplication.getInstance(context).addToRequestQueue(request);
    }

}
