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
    private Questions questions;
    private int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String card = (String) extras.get("card");

            if (card != null) {
                switch (card) {
                    case "T1":
                        number = 0;
                        break;
                    case "T2":
                        number = 10;
                        break;
                    case "T3":
                        number = 20;
                        break;
                    case "T4":
                        number = 30;
                        break;
                    case "T5":
                        number = 40;
                        break;
                    default:
                        number = 50;
                        break;
                }
            }

            start = findViewById(R.id.startButton);
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartTestActivity.this, TestActivity.class);
                    intent.putExtra("number", number);
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