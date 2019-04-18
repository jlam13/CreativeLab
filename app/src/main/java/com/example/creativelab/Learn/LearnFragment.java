package com.example.creativelab.Learn;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.creativelab.Learn.Adapter.VerticalAdapter;
import com.example.creativelab.Learn.Data.LearnCardData;
import com.example.creativelab.Learn.Data.LearnCards;
import com.example.creativelab.Learn.Interface.FirebaseLoadListener;
import com.example.creativelab.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;

public class LearnFragment extends Fragment implements FirebaseLoadListener {

    public static String ARG_ITEM_ID;
    AlertDialog dialog;
    FirebaseLoadListener firebaseLoadListener;
    RecyclerView verticalRVParent;
    DatabaseReference myData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_learn, container, false);

        myData = FirebaseDatabase.getInstance().getReference("LearnData");
        dialog = new SpotsDialog.Builder().setContext(getContext()).build();
        firebaseLoadListener = this;
        verticalRVParent = rootView.findViewById(R.id.verticalRVParent);
        verticalRVParent.setLayoutManager(new LinearLayoutManager(getContext()));

        getFirebaseData();

        return rootView;

    }

    private void getFirebaseData() {
        dialog.show();
        myData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<LearnCards> learnCards = new ArrayList<>();
                for(DataSnapshot groupSnapshot:dataSnapshot.getChildren()) {
                    LearnCards learnCard = new LearnCards();
                    learnCard.setEditor(groupSnapshot.child("editor").getValue(true).toString());
                    GenericTypeIndicator<ArrayList<LearnCardData>> t = new GenericTypeIndicator<ArrayList<LearnCardData>>(){};
                    learnCard.setLearnCard(groupSnapshot.child("learnCard").getValue(t));
                    learnCards.add(learnCard);
                }

                firebaseLoadListener.onFirebaseLoadSuccess(learnCards);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                firebaseLoadListener.onFirebaseLoadFailed(databaseError.getMessage());
            }
        });
    }


    @Override
    public void onFirebaseLoadSuccess(List<LearnCards> learnCardsList) {
        VerticalAdapter adapter = new VerticalAdapter(getContext(), learnCardsList);
        verticalRVParent.setAdapter(adapter);
        dialog.dismiss();
    }

    @Override
    public void onFirebaseLoadFailed(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}