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
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class FinishTestActivity extends AppCompatActivity {
    TextView finalScore;
    Button retry, home;
    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener authStateListener;
    FirebaseDatabase database;
    DatabaseReference questionScore;
    String uid;
    List<Results> list;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_test);

        finalScore = findViewById(R.id.finalScore);
        retry = findViewById(R.id.retryButton);
        home = findViewById(R.id.homeButton);


        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            final int score = extras.getInt("finalScore");
            finalScore.setText("You scored " + score + " out of 100");

            FirebaseApp.initializeApp(this);
            auth = FirebaseAuth.getInstance();
            database = FirebaseDatabase.getInstance();
            questionScore = database.getReference();
            final FirebaseUser user = auth.getCurrentUser();
            uid = user.getUid();
            questionScore = database.getReference("User").child(uid).child("Test");
            questionScore.child("T1").setValue(score);


/*            questionScore.child(String.format("%s_%s", Common.currentUser.getName(), Common.categoryId))
                    .setValue(new QuestionScore(String.format("%s_%s", Common.currentUser.getName(), Common.categoryId),
                            Common.currentUser.getName(),
                            String.valueOf(score)));*/
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
}