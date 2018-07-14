package com.example.vivek.tablyoutdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivek.tablyoutdemo.model.BabyName;

import java.util.List;

public class BabyAdapter extends RecyclerView.Adapter<BabyAdapter.MyViewHolder> {
    private Context context;
    private List<BabyName> babyNames;

    public BabyAdapter(Context context, List<BabyName> babyNames) {
        this.context = context;
        this.babyNames = babyNames;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
