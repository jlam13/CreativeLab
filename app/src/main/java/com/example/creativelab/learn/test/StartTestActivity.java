package com.example.creativelab.learn.test;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.creativelab.R;
import com.example.creativelab.learn.test.data.Common;
import com.example.creativelab.learn.test.data.Questions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;

public class StartTestActivity extends AppCompatActivity {

    private TextView testId;
    private Button button;
    FirebaseDatabase database;
    DatabaseReference questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);
/*
        FirebaseApp testApp = FirebaseApp.getInstance("Test");
        FirebaseDatabase testDatabase = FirebaseDatabase.getInstance(testApp);*/

        database = FirebaseDatabase.getInstance();
        questions = database.getReference("Questions");

        loadQuestion(Common.learnCardId);

            button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartTestActivity.this, TestActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

        }



    private void loadQuestion(String learnCardId) {

        if(Common.questionsList.size() > 0)
            Common.questionsList.clear();

        questions.orderByChild("learnCardId").equalTo(learnCardId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds:dataSnapshot.getChildren()) {
                            Questions questions = ds.getValue(Questions.class);
                            Common.questionsList.add(questions);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
        Collections.shuffle(Common.questionsList);
    }


}