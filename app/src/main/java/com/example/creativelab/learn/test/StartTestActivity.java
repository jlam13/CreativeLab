package com.example.creativelab.learn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.creativelab.R;
public class StartTestActivity extends AppCompatActivity {

    private TextView editor;
    private Button start;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String card = (String) extras.get("card");

            start = findViewById(R.id.startButton);
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartTestActivity.this, TestActivity.class);
                    intent.putExtra("card", card);
                    startActivity(intent);
                }
            });

            back = findViewById(R.id.goBackButton);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

        }
    }
}