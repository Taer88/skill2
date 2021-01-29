package com.anydog.qaedu.data.remote;

import com.anydog.qaedu.BuildConfig;

public final class EndPoint {
    private final static int API_VERSION = 1;
    private final static String URL = BuildConfig.BASE_URL + ":" + BuildConfig.BASE_PORT;
    private final static String API_URL = URL + "/api/v" + API_VERSION;
    // Resources
    public final static String RESOURCES_URL = URL + "/";
    // Endpoints
    public static final String REST_LOGIN = API_URL + "/users/login";
    public static final String REST_REGISTER = API_URL + "/users/register";
    public static final String REST_PROFILE = API_URL + "/profile";
    public static final String REST_PRODUCTS = API_URL + "/products";
    public static final String REST_COMMENTS = API_URL + "/comments";

    public static final String REST_ACTION_PRODUCTS = API_URL + "/products/actions";
    public static final String SESSION = API_URL + "/session";
    public static final String USER_DATA = API_URL + "/user";
    public static final String ENDPOINT_LOGOUT = API_URL + "/logout";


    private EndPoint() {
    }
}
