package com.example.lenovo.bookingapp.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.bookingapp.Models.EventsModel;
import com.example.lenovo.bookingapp.R;
import com.neopixl.pixlui.components.edittext.EditText;

/**
 * Created by deii on 10/12/2015.
 */
public class CommonFunctions {
    private Context context;
    private static Snackbar snackbar = null;
    public static PopupWindow popupWindow = null;

    public CommonFunctions(Context context) {
        this.context = context;

    }


    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            ((Activity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public boolean validateName(EditText inputName, TextInputLayout inputLayoutName) {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(((Activity) context).getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    public boolean validateEmpty(EditText inputName, TextInputLayout inputLayoutName) {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(((Activity) context).getString(R.string.err_msg_empty));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    public boolean validateCity(EditText inputName, TextInputLayout inputLayoutName) {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(((Activity) context).getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    public boolean validateEmail(EditText inputEmail, TextInputLayout inputLayoutEmail) {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(((Activity) context).getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    public boolean validatePassword(EditText inputPassword, TextInputLayout inputLayoutPassword) {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(((Activity) context).getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    public boolean compareOldPassword(EditText inputPassword, TextInputLayout inputLayoutPassword, String oldPass) {
        if (!inputPassword.getText().toString().trim().contentEquals(oldPass)) {
            inputLayoutPassword.setError(((Activity) context).getString(R.string.err_wrong_pass));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    public boolean validatePhone(EditText inputPhone, TextInputLayout inputLayoutPhone) {
        try {
            if (Integer.parseInt(inputPhone.getText().toString().trim()) < 10) {
                inputLayoutPhone.setError(((Activity) context).getString(R.string.err_msg_number));
                requestFocus(inputPhone);
                return false;
            } else {
                inputLayoutPhone.setErrorEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /*public static void showSnackBarWithAction(View view, String message, final SnackBarCallback callback) {

        snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                        callback.doAction();
                    }
                });

        // Changing message text color
        snackbar.setActionTextColor(Color.WHITE);
        View textView = snackbar.getView();
        TextView tv = (TextView) textView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snackbar.show();
    }*/

    public static void showSnackBarWithoutAction(View view, String message) {

        snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_LONG);

        // Changing message text color
        snackbar.setActionTextColor(Color.WHITE);
        View textView = snackbar.getView();
        TextView tv = (TextView) textView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snackbar.show();
    }

    public static void showEventDescriptionPopup(EventsModel eventsModel, Context context, View locationView) {

        View view = LayoutInflater.from(context).inflate(R.layout.event_detail, null);
        popupWindow = new PopupWindow(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setContentView(view);
        popupWindow.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.background_dark)));
        popupWindow.setAnimationStyle(R.style.DialogAnimation1);

        ImageView PartyImage = (ImageView) view.findViewById(R.id.PartyImage);
        com.neopixl.pixlui.components.textview.TextView txtEventType = (com.neopixl.pixlui.components.textview.TextView) view.findViewById(R.id.txtEventType);
        com.neopixl.pixlui.components.textview.TextView txtShortDescription = (com.neopixl.pixlui.components.textview.TextView) view.findViewById(R.id.txtShortDescription);

        com.neopixl.pixlui.components.textview.TextView txtDate = (com.neopixl.pixlui.components.textview.TextView) view.findViewById(R.id.txtDate);
        com.neopixl.pixlui.components.textview.TextView txtTime = (com.neopixl.pixlui.components.textview.TextView) view.findViewById(R.id.txtTime);
        com.neopixl.pixlui.components.textview.TextView txtDay = (com.neopixl.pixlui.components.textview.TextView) view.findViewById(R.id.txtDay);

        com.neopixl.pixlui.components.textview.TextView txtApprox = (com.neopixl.pixlui.components.textview.TextView) view.findViewById(R.id.txtApprox);
        com.neopixl.pixlui.components.textview.TextView txtRanking = (com.neopixl.pixlui.components.textview.TextView) view.findViewById(R.id.txtRanking);
        com.neopixl.pixlui.components.textview.TextView txtDescription = (com.neopixl.pixlui.components.textview.TextView) view.findViewById(R.id.txtDescription);
        com.neopixl.pixlui.components.textview.TextView txtDistance = (com.neopixl.pixlui.components.textview.TextView) view.findViewById(R.id.txtDistance);
        com.neopixl.pixlui.components.textview.TextView txtAddress = (com.neopixl.pixlui.components.textview.TextView) view.findViewById(R.id.txtAddress);

        LinearLayout correctLL = (LinearLayout) view.findViewById(R.id.correctLL);


        txtEventType.setText(eventsModel.getCategory());
        txtShortDescription.setText(eventsModel.getTitle());
        txtDate.setText(eventsModel.getEdate());
        txtTime.setText(eventsModel.getEtime());
        txtDay.setText(eventsModel.getEday());
        txtRanking.setText(eventsModel.getCurrentrsvp());
        txtAddress.setText(eventsModel.getAddress());
        txtDescription.setText(eventsModel.getDescp());

        ImageView imgClose = (ImageView) view.findViewById(R.id.imgClose);

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                popupWindow = null;
            }
        });

        popupWindow.showAtLocation(locationView, Gravity.TOP, 0, 0);

    }

}
