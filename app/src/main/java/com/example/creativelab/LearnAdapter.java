package com.example.creativelab;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.ViewHolder> {
    private LearnFragment mParentFragment;
    private ArrayList<LearnData> mLearnData;


    public LearnAdapter(LearnFragment parent, ArrayList<LearnData> learnData) {
        mParentFragment = parent;
        mLearnData = learnData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView difficulty;

        public ViewHolder(View v) {
            super(v);
            difficulty = v.findViewById(R.id.difficulty);
        }
    }

    @Override
    public LearnAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.learn_list, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LearnData learnData = mLearnData.get(position);
        holder.difficulty.setText(learnData.getDifficulty());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mLearnData.size();
    }

}