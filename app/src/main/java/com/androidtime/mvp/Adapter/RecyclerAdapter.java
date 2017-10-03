package com.androidtime.mvp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidtime.mvp.POJO.ProductionCompaniesItem;
import com.androidtime.mvp.POJO.ProductionCompaniesItem;
import com.androidtime.mvp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sadikul on 9/30/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ShowsViewHolder> {

    public Context context;

    private List<ProductionCompaniesItem> notices;
    private String changeMessage = "";

    public RecyclerAdapter(Context context, List<ProductionCompaniesItem> notices) {
        this.context = context;
        this.notices = notices;


    }

    @Override
    public ShowsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false);
        return new ShowsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ShowsViewHolder holder, int position) {

        ProductionCompaniesItem ProductionCompaniesItem =notices.get(position);
            holder.movie_name.setText(ProductionCompaniesItem.getName());



/*

        holder.textViewTime.setText(ProductionCompaniesItem.getTime());
        String link=Constant.baseURL+ ProductionCompaniesItem.getImageLink();
        Log.e("link",link);

        Glide.with(context).load(link).placeholder(R.drawable.default_pro_pic).fitCenter().override(100,100).dontAnimate().into(holder.patientProfileIcon);
*/

    }

    @Override
    public int getItemCount() {

        //Log.e("size",notices.size()+" ");
        return notices.size();
    }

    public class ShowsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.movie_name)
        TextView movie_name;

        public ShowsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {/*
            //Toast.makeText(context, "clicked item", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(context, NoticeDetails.class);
            intent.putExtra("id",notices.get(getAdapterPosition()).getId());
            context.startActivity(intent);*/
        }
    }

}

