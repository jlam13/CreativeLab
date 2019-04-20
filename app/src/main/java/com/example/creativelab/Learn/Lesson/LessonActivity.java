package com.example.creativelab.Learn.Lesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.creativelab.Learn.Data.LearnCardData;
import com.example.creativelab.R;

public class LessonActivity extends AppCompatActivity {

    private LearnCardData learnCardData;
    private TextView lessonId;
    private TextView youtubeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String card = (String) extras.get("card");
            lessonId = findViewById(R.id.lessonId);
            lessonId.setText(card);

            String youtube = (String) extras.get("youtube");
            youtubeId = findViewById(R.id.yt);
            youtubeId.setText(youtube);

        }

    }
}

