package com.example.creativelab.hub;

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
import android.widget.TextView;

import com.example.creativelab.R;
import com.example.creativelab.learn.test.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;

public class HubFragment extends Fragment {

    AlertDialog dialog;
    private HubAdapter adapter;
    RecyclerView recyclerView;
    private List<User> userList;
    private TextView playerScore;
    private String uid;
    private FirebaseAuth auth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hub, container, false);

        dialog = new SpotsDialog.Builder().setContext(getContext()).build();
        dialog.show();
        recyclerView = rootView.findViewById(R.id.hubRV);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        userList = new ArrayList<>();
        adapter = new HubAdapter(userList, this.getContext());
        recyclerView.setAdapter(adapter);

        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = auth.getCurrentUser();
        uid = user.getUid();

        TextView name = rootView.findViewById(R.id.title);
        TextView total = rootView.findViewById(R.id.score);
        playerScore = rootView.findViewById(R.id.playerScore);

        showScores(uid);

        // Query & ValueEventListener reference - https://www.youtube.com/watch?v=WeoryL3XyA4
        Query order = FirebaseDatabase.getInstance().getReference("User").orderByChild("total").limitToFirst(5);
        order.addListenerForSingleValueEvent(valueEventListener);

        Query self = FirebaseDatabase.getInstance().getReference("User").orderByChild(uid).equalTo(uid);
        self.addListenerForSingleValueEvent(valueEventListener);
        return rootView;
    }

    // Populates the leaderboard RecyclerView
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            userList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    User users = ds.getValue(User.class);
                    userList.add(users);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        }
        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    // Sums the scores of a player's results
    private void showScores(String uid) {
        DatabaseReference questionScore = FirebaseDatabase.getInstance().getReference();
        questionScore.child("User").child(uid).child("test").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long total = 0;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    long value = ds.getValue(Long.class);
                    total = total + value;
                }
                dataSnapshot.getRef().getParent().child("total").setValue(total);
                playerScore.setText(String.valueOf(total));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}