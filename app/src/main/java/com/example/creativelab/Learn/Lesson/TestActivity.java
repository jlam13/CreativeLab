package com.example.creativelab.Learn.Lesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.creativelab.Learn.LearnCardData;
import com.example.creativelab.R;

public class TestActivity extends AppCompatActivity {

    private LearnCardData learnCardData;
    private TextView testId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String card = (String) extras.get("card");

            testId = findViewById(R.id.testId);
            testId.setText(card);
        }
    }
}
