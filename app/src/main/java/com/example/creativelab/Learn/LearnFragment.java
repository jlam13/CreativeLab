package com.example.creativelab.Learn;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.creativelab.Learn.Adapters.Models.HorizontalModel;
import com.example.creativelab.Learn.Adapters.Models.VerticalModel;
import com.example.creativelab.Learn.Adapters.VerticalRVAdapter;
import com.example.creativelab.R;

import java.util.ArrayList;

public class LearnFragment extends Fragment {

    VerticalRVAdapter adapter;
    ArrayList<VerticalModel> arrayListVertical;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_learn, container, false);

        arrayListVertical = new ArrayList<>();
        RecyclerView verticalRV = rootView.findViewById(R.id.learnRV);
        verticalRV.setHasFixedSize(true);
        verticalRV.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL,false));

        adapter = new VerticalRVAdapter(this.getContext(), arrayListVertical);

        verticalRV.setAdapter(adapter);

        setData();

        return rootView;
    }

    private void setData() {
        for (int i = 1; i <= 5; i++) {
            VerticalModel mVerticalModel = new VerticalModel();
            mVerticalModel.setTitle("Title: " + i);

            ArrayList<HorizontalModel> arrayList = new ArrayList<>();

            for (int j = 0; j <= 5; j++) {
                HorizontalModel mHorizontalModel = new HorizontalModel();
                mHorizontalModel.setName("Name" + j);

                arrayList.add(mHorizontalModel);
            }

            mVerticalModel.setArrayList(arrayList);
            arrayListVertical.add(mVerticalModel);

        }

        adapter.notifyDataSetChanged();
    }
}