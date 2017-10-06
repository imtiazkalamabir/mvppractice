package com.androidtime.mvp.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidtime.mvp.Adapter.RecyclerAdapter;
import com.androidtime.mvp.POJO.MovieList;
import com.androidtime.mvp.R;
import com.androidtime.mvp.interfaces.MainActivityView;
import com.androidtime.mvp.presenter.MainActivityPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @BindView(R.id.recyclerview)//dd
    RecyclerView recyclerview;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainActivityPresenter mPresenter = new MainActivityPresenter(this); // just created a presenter object here
        mPresenter.getIpInformation();

    }


    @Override
    public void showIpInfo(MovieList infoData) {
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(MainActivity.this,infoData.getProductionCompanies());
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void startLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

}
