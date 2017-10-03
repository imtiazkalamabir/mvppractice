package com.androidtime.mvp.model;

import android.content.Context;

import com.androidtime.mvp.POJO.MovieList;
import com.androidtime.mvp.Retrofit.ApiInterface;
import com.androidtime.mvp.Retrofit.Constant;
import com.androidtime.mvp.Retrofit.RetrofitClient;
import com.androidtime.mvp.interfaces.OnRequestComplete;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvokeApi {
    OnRequestComplete requestComplete;

    public InvokeApi(final Context context, final OnRequestComplete onRequestComplete) {
        this.requestComplete = onRequestComplete;

        ApiInterface apiInterface= RetrofitClient.getApiInterface();
        Call<MovieList> call=apiInterface.getMovieList(Constant.Api);
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                MovieList movieList=response.body();
                onRequestComplete.onRequestComplete(movieList);
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {

                onRequestComplete.onRequestError("Something went wrong..");
            }
        });
    }
}
