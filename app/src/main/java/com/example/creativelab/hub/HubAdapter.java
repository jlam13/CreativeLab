package com.example.creativelab.hub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.creativelab.hub.data.RSSObject;
import com.example.creativelab.learn.Interface.OnClickListener;
import com.example.creativelab.R;

public class HubAdapter extends RecyclerView.Adapter<HubAdapter.ViewHolder> {

    private RSSObject rssObject;
    private Context context;

    public HubAdapter(RSSObject rssObject, Context context) {
        this.rssObject = rssObject;
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
        holder.title.setText(rssObject.getItems().get(i).getTitle());
        holder.pubDate.setText(rssObject.getItems().get(i).getPubDate());
        holder.content.setText(rssObject.getItems().get(i).getDescription());
        holder.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view, int i) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(rssObject.getItems().get(i).getLink()));
                browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rssObject.getItems().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title, pubDate, content;
        private OnClickListener onClickListener;

        public ViewHolder(@NonNull View item) {
            super(item);
            title = item.findViewById(R.id.title);
            pubDate = item.findViewById(R.id.pubDate);
            content = item.findViewById(R.id.content);
            itemView.setOnClickListener(this);
        }

        public void setOnClickListener(OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(view, getAdapterPosition());
        }
    }
}
