package com.example.android.myapp.remote;

import com.example.android.myapp.network.RemService;


public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "https://foodapi8.herokuapp.com/";

    public static RemService getUserService(){
        return RetrofitClient.getClient(API_URL).create(RemService.class);
    }

}