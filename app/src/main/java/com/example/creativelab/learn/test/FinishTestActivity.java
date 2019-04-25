package com.example.creativelab.learn.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.creativelab.DashboardActivity;
import com.example.creativelab.R;

public class FinishTestActivity extends AppCompatActivity {
    TextView finalScore;
    Button retry, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_test);

        finalScore = findViewById(R.id.finalScore);
        retry = findViewById(R.id.retryButton);
        home = findViewById(R.id.homeButton);


        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        finalScore.setText("You scored " + score + " out of 100");
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