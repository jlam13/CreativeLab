package com.example.creativelab.Learn;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.creativelab.R;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {

    //private List<Movie> moviesList;

    private LearnInformation learnInformation;
    private ArrayList<Learn> learnArrayList;
    private Context mContext;

    public HorizontalAdapter (Context mContext,ArrayList<Learn> learnArrayList) {
        this.learnArrayList = learnArrayList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        final Learn learn = learnArrayList.get(position);
        holder.lessonName.setText(learn.getLessonName());
        holder.lessonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, learn.getLessonName(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return learnArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView lessonName;


        public ViewHolder(View view) {
            super(view);
            lessonName = (TextView) view.findViewById(R.id.lessonName);

        }
    }
}
