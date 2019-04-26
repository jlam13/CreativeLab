package com.example.creativelab.hub;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.creativelab.R;
import com.example.creativelab.learn.test.User;

import java.util.List;

public class HubAdapter extends RecyclerView.Adapter<HubAdapter.ViewHolder> {

    private List<User> userList;
    private Context context;

    public HubAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.hub_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        User user = userList.get(i);
        holder.name.setText(user.getName());
        holder.total.setText(String.valueOf(user.getTotal()));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name, total;

        public ViewHolder(@NonNull View item) {
            super(item);
            name = item.findViewById(R.id.name);
            total = item.findViewById(R.id.total);
        }

    }
}