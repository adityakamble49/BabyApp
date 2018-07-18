package com.example.vivek.tablyoutdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vivek.tablyoutdemo.R;
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
            TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.items);

        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.baby_name,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(babyNames.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return babyNames.size();
    }


}
