package com.example.creativelab.Learn;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.creativelab.R;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {

    //private List<Movie> moviesList;

    private LearnInformation learnInformation;
    private Context mContext;

    public VerticalAdapter(LearnInformation learnInformation, Context mContext) {
        this.learnInformation = learnInformation;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LearnLessons learnLessons = learnInformation.getLearnLessonsList().get(position);
        holder.editor.setText(learnLessons.getEditor());

        LinearLayoutManager hs_linearLayout = new LinearLayoutManager(this.mContext, LinearLayoutManager.HORIZONTAL, false);
        holder.horizontalRVChild.setLayoutManager(hs_linearLayout);
        holder.horizontalRVChild.setHasFixedSize(true);
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(this.mContext,learnInformation.getLearnLessonsList().get(position).getLessons());
        holder.horizontalRVChild.setAdapter(horizontalAdapter);

    }

    @Override
    public int getItemCount() {
        return learnInformation.getLearnLessonsList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView editor;
        public RecyclerView horizontalRVChild;

        public ViewHolder(View view) {
            super(view);
            editor = view.findViewById(R.id.editor);
            horizontalRVChild = view.findViewById(R.id.horizontalRVChild);
        }
    }
}