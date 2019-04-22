package com.example.creativelab.hub.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RSSObject {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("feed")
    @Expose
    private Feed feed;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}