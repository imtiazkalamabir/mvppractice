package com.androidtime.mvp.interfaces;

import android.content.Context;

import com.androidtime.mvp.POJO.MovieList;

import java.util.HashMap;
import java.util.Objects;

public interface MainActivityView {
    void showIpInfo(MovieList hashMap);

    void startLoading();

    void stopLoading();

    void showMessage(String msg);

    Context getAppContext();
}
