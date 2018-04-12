package com.example.rpl88.wallezz;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by rpl88 on 11/04/18.
 */

public interface ApiInterface {
    @GET("test/fruits")
    Call<Fruits> getFruits(@Header("apikey") String apikey);

    @POST("test/biodata")
    Call<Biodata> saveBiodata(@Body Biodata biodata, @Header("apikey")String apikey);
}
