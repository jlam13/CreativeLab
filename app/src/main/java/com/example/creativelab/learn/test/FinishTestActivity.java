package com.example.creativelab.learn.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView finalScore, total;
    Button home;
    FirebaseAuth auth;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_test);

        finalScore = findViewById(R.id.finalScore);
        total = findViewById(R.id.total);
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
                showScores(uid);
                FinishTestActivity.this.finish();
                Intent intent = new Intent(FinishTestActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }

    // Updates score in database by retrieving current score and adding the most recent score
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
                    total.setText("Total score for this topic: " + card);
                }
                else {
                    total.setText("Total score for this topic: " + score);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

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
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}