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
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String card = (String) extras.get("card");

            editor = findViewById(R.id.editor);
            if (card == "T1") {
                editor.setText("Have you mastered Photoshop?");
            }
            else if (card == "T2") {
                editor.setText("Have you mastered Illustrator?");
            }
            else if (card == "T3") {
                editor.setText("Have you mastered Premiere Pro?");
            }
            else if (card == "T4") {
                editor.setText("Think you've mastered After Effects?");
            }
            else if (card == "T5") {
                editor.setText("Have you mastered Lightroom?");
            }
            else if (card == "T6") {
                editor.setText("Have you mastered InDesign?");
            }

            button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartTestActivity.this, TestActivity.class);
                    intent.putExtra("card", card);
                    startActivity(intent);
                }
            });
        }
    }
}