package com.example.creativelab.hub;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.creativelab.hub.data.RSSObject;
import com.example.creativelab.R;
import com.google.gson.Gson;

import dmax.dialog.SpotsDialog;

public class HubFragment extends Fragment {

    AlertDialog dialog;
    RecyclerView recyclerView;
    RSSObject rssObject;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hub, container, false);

        dialog = new SpotsDialog.Builder().setContext(getContext()).build();
        recyclerView = rootView.findViewById(R.id.hubRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadRSS();
        return rootView;
    }

    // AsyncTask reference - https://developer.android.com/reference/android/os/AsyncTask

    private void loadRSS() {

        dialog.show();
        @SuppressLint("StaticFieldLeak") AsyncTask<String, String, String> loadRSSAsync = new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... strings) {
                String result;
                HTTPReader http = new HTTPReader();
                result = http.GetHTTPData(strings[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                dialog.dismiss();
                rssObject = new Gson().fromJson(s, RSSObject.class);
                HubAdapter adapter = new HubAdapter(rssObject, getContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };
        String RSSJsonAPI = "https://api.rss2json.com/v1/api.json?rss_url=";
        String RSSLink= "https://www.digitalartsonline.co.uk/rss/feeds/digitalarts-tutorials.xml";
        loadRSSAsync.execute(RSSJsonAPI + RSSLink);
    }
}
