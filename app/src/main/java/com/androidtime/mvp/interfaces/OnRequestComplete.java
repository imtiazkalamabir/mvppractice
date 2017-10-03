package com.androidtime.mvp.interfaces;

import com.androidtime.mvp.POJO.MovieList;

public interface OnRequestComplete {
    void onRequestComplete(MovieList o);
    void onRequestError(String errorMsg);
}
