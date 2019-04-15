package com.example.creativelab.Learn.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.creativelab.Learn.Adapters.Models.HorizontalModel;
import com.example.creativelab.R;

import java.util.ArrayList;

public class HorizontalRVAdapter extends RecyclerView.Adapter<HorizontalRVAdapter.HorizontalViewHolder> {

    Context context;
    ArrayList<HorizontalModel> arrayList;

    public HorizontalRVAdapter(Context context, ArrayList<HorizontalModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent,false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        final HorizontalModel horizontalModel = arrayList.get(position);
        holder.titleHorizontal.setText(horizontalModel.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, horizontalModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        TextView titleHorizontal;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            titleHorizontal = itemView.findViewById(R.id.cardTitle);
        }
    }
}
