package com.example.creativelab.learn.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.creativelab.DashboardActivity;
import com.example.creativelab.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FinishTestActivity extends AppCompatActivity {
    TextView finalScore;
    Button retry, home;
    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener authStateListener;
    FirebaseDatabase database;
    DatabaseReference questionScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_test);

        finalScore = findViewById(R.id.finalScore);
        retry = findViewById(R.id.retryButton);
        home = findViewById(R.id.homeButton);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        questionScore = database.getReference("QuestionScore");

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            int score = extras.getInt("finalScore");
            finalScore.setText("You scored " + score + " out of 100");
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