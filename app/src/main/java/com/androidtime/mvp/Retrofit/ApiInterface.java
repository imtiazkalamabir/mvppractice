package com.androidtime.mvp.Retrofit;

import com.androidtime.mvp.POJO.MovieList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Sadikul on 9/30/2017.
 */

public interface ApiInterface {

    @GET("3/movie/550")
    Call<MovieList> getMovieList(@Query("api_key") String key);
}
