package com.example.lenovo.bookingapp.Utils;

/**
 * Created by deii on 13-10-2015.
 */
public class Constants {
    public static final String TRUST_ONE_PREFERENCE = "trust_one";
    /*
    WebService Constants
     */
    public static String EMAIL_ID = "emailid";
    public static String USERNAME = "username";
    public static String LOG_IN = "log_in";
    public static String PHONE_NUMBER = "phonenumber";
    public static String PROFILE_IMAGE = "profileimage";
    public static String ARRAY = "Array";
    public static String STATUS_CODE = "statuscode";
    public static String MESSAGE = "message";
    public static String PASSWORD = "password";
    public static String DATA = "data";
    public static String CATEGORIES = "categories";
    public static String SUB_CATEGORIES = "subcategories";
    public static String CATEGORY_ID = "category_id";
    public static String CITY = "City";
    public static String PROFESSIONAL_LICENSE = "professional_license";
    public static String STATE = "state";
    public static String SUB_CATEGORY_ID = "subcategory_id";
    public static String NAME = "name";
    public static String PRODUCTS = "products";
    public static String BANNER = "banners";
    public static String TOPICS = "topics";
    public static String TOPIC_ID = "topicid";
    public static String TYPE = "type";
    public static String PAGE_NO = "pageno";
    public static String EVENTS = "events";
    public static String SUCCESS = "success";
    public static String PAGE_SIZE = "pagesize";

    public interface webServiceSendKeys {
        public static String EMAIL_ID = "EmailID";
        public static String SUB_CATEGORY_ID = "subcategory_id";

    }

    public interface WebServices {

        //public static String BASE = "http://whatsupguys.in/demo/trust1_api/api/";

        public static String BASE = "http://119.9.108.137/bookingapp/";

        public static String SIGN_UP = BASE + "registration";

        public static String LOG_IN = BASE + "login";

        public static String HOME = BASE + "home";

        public static String EVENTS = BASE + "events.php";

        public static String USER_EVENTS_BY_TIME = BASE+"userevents.php?accesstoken=8dd9294632aeed1b62a6bc2eba8b41c5";

        public static String USER_EVENT_BY_POPULARITY = BASE+"eventsbypopularity.php";

    }
}
