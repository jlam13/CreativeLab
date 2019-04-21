package com.example.creativelab.Learn.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.creativelab.Learn.Interface.OnClickListener;
import com.example.creativelab.Learn.Data.LearnCardData;
import com.example.creativelab.Learn.Data.LearnCards;
import com.example.creativelab.R;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {

    private Context context;
    private List<LearnCards> dataList;
    private OnClickListener mOnClickListener;

    public VerticalAdapter(Context context, List<LearnCards> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.vertical_list, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        holder.editor.setText(dataList.get(i).getEditor());
        List<LearnCardData> learnCardData = dataList.get(i).getLearnCard();

        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(context, learnCardData, mOnClickListener);
        holder.horizontalRVChild.setHasFixedSize(true);
        holder.horizontalRVChild.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.horizontalRVChild.setAdapter(horizontalAdapter);

        holder.horizontalRVChild.setNestedScrollingEnabled(false);


    }

    @Override
    public int getItemCount() {
        return (dataList != null ? dataList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView editor;
        RecyclerView horizontalRVChild;

        public ViewHolder(@NonNull View view) {
            super(view);
            editor = view.findViewById(R.id.editor);
            horizontalRVChild = view.findViewById(R.id.horizontalRVChild);
        }
    }
}

