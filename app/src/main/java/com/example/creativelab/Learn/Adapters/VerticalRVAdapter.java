package com.example.creativelab.Learn.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.creativelab.Learn.Adapters.Models.HorizontalModel;
import com.example.creativelab.Learn.Adapters.Models.VerticalModel;
import com.example.creativelab.R;

import java.util.ArrayList;

public class VerticalRVAdapter extends RecyclerView.Adapter<VerticalRVAdapter.VerticalViewHolder> {
    Context context;
    ArrayList<VerticalModel> arrayList;

    public VerticalRVAdapter(Context context, ArrayList<VerticalModel> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        VerticalModel verticalModel = arrayList.get(position);
        String title = verticalModel.getTitle();
        ArrayList<HorizontalModel> singleItem = verticalModel.getArrayList();

        holder.title.setText(title);
        HorizontalRVAdapter horizontalRVAdapter = new HorizontalRVAdapter(context, singleItem);

        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        holder.recyclerView.setAdapter(horizontalRVAdapter);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView title;

        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.horizontalRV);
            title = itemView.findViewById(R.id.editor);
        }
    }
}
