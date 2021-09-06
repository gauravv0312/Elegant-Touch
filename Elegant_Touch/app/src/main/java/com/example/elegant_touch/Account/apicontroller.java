package com.example.elegant_touch.Account;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apicontroller {
    static final String url ="http://192.168.202.179/eleganttouch/";
    private static apicontroller clientobject;
    private static Retrofit retrofit;

    apicontroller()
    {   Gson gson = new GsonBuilder()
            .setLenient()
            .create();

        retrofit=new Retrofit.Builder()
                              .baseUrl(url)
                              .addConverterFactory(GsonConverterFactory.create(gson))
                              .build();
    }

    public static synchronized apicontroller getInstance()
    {
        if(clientobject==null)
            clientobject=new apicontroller();
        return clientobject;
    }


    apiset getapi()
    {
        return retrofit.create(apiset.class);
    }
}
