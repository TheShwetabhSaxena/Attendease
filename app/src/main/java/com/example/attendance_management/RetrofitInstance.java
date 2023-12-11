package com.example.attendance_management;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Gson gson;
    private static Retrofit retrofit;
    private static final String BASEURL="http://65.2.9.68/api/";


    public static Retrofit getRetrofit(){

        gson=new GsonBuilder()
                .setLenient()
                .create();

        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }

}
