package com.androidtime.mvp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sadikul on 9/30/2017.
 */

public class RetrofitClient {
    public static Retrofit getRetrofitClient(){
        return new Retrofit.Builder().baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiInterface getApiInterface(){
        return getRetrofitClient().create(ApiInterface.class);
    }
}
