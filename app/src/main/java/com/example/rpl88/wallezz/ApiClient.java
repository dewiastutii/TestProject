package com.example.rpl88.wallezz;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rpl88 on 11/04/18.
 */

public class ApiClient {
    public static final String BASE_URL="http://candidate.wallezzdev.com/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
