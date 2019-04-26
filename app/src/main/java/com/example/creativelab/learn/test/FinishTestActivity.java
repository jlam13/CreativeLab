package com.example.creativelab.learn.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.creativelab.DashboardActivity;
import com.example.creativelab.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class FinishTestActivity extends AppCompatActivity {
    TextView finalScore;
    Button home;
    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference questionScore;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_test);

        finalScore = findViewById(R.id.finalScore);
        home = findViewById(R.id.homeButton);


        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            final int score = extras.getInt("finalScore");
            final String card = (String) extras.get("card");
            finalScore.setText("You scored " + score + " out of 100");

            FirebaseApp.initializeApp(this);
            auth = FirebaseAuth.getInstance();
            final FirebaseUser user = auth.getCurrentUser();
            uid = user.getUid();
            updateScore(score, uid, card);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            FinishTestActivity.this.finish();
            Intent intent = new Intent(FinishTestActivity.this, DashboardActivity.class);
            startActivity(intent);
            }
        });

    }

    private void updateScore(final int score, String uid, String card) {
        DatabaseReference questionScore = FirebaseDatabase.getInstance().getReference();
        questionScore.child("User").child(uid).child("test").child(card).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSnapshot.getRef().setValue(score);
                Integer card = dataSnapshot.getValue(Integer.class);
                if (card != null) {
                    card = card + score;
                    dataSnapshot.getRef().setValue(card);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }
}