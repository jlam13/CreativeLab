package com.example.creativelab.Learn.Lesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.creativelab.Learn.Learn;
import com.example.creativelab.R;

public class LessonActivity extends AppCompatActivity {

    private Learn learn;
    private TextView lessonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);


    }
}
