package com.example.creativelab.Learn.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.creativelab.Learn.Interface.OnClickListener;
import com.example.creativelab.Learn.Data.LearnCardData;
import com.example.creativelab.Learn.Lesson.LessonActivity;
import com.example.creativelab.Learn.Lesson.TestActivity;
import com.example.creativelab.R;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {

    private Context context;
    private List<LearnCardData> learnCardDataList;
    private OnClickListener mOnClickListener;

    public HorizontalAdapter(Context context, List<LearnCardData> learnCardDataList, OnClickListener mOnClickListener) {
        this.context = context;
        this.learnCardDataList = learnCardDataList;
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.horizontal_list, parent, false);
        return new ViewHolder(itemView, mOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        holder.learnCardName.setText(learnCardDataList.get(i).getLearnCardName());
        holder.learnCardName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (learnCardDataList.get(i).getLearnCardId().contains("T")) {
                    Intent intent = new Intent(context, TestActivity.class);
                    intent.putExtra("card", learnCardDataList.get(i).getLearnCardId());
                    context.startActivity(intent);
                }
                else {
                    Intent intent = new Intent(context, LessonActivity.class);
                    intent.putExtra("card", learnCardDataList.get(i).getLearnCardId());
                    intent.putExtra("youtube", learnCardDataList.get(i).getYoutubeId());
                    context.startActivity(intent);
                }
                Toast.makeText(context, "" + learnCardDataList.get(i).getLearnCardId()  , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return learnCardDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView learnCardName;
        OnClickListener onClickListener;

        public ViewHolder(@NonNull View view, OnClickListener onClickListener) {
            super(view);
            learnCardName = view.findViewById(R.id.learnCardName);
            this.onClickListener = onClickListener;
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {

            onClickListener.onClick(view, getAdapterPosition());
        }

    }
}