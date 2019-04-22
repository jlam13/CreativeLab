package com.example.creativelab.learn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.creativelab.DashboardActivity;
import com.example.creativelab.R;
import com.example.creativelab.learn.test.data.Common;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {


    int index = 0, score = 0, thisQuestion = 0, totalQuestion, correctAnswer;

    Button buttonA, buttonB;
    TextView scoreView, questionNumber, question;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        totalQuestion = Common.questionsList.size();

        scoreView = findViewById(R.id.score);
        question = findViewById(R.id.question);
        buttonA = (Button)findViewById(R.id.choice1);
        buttonB = (Button)findViewById(R.id.choice2);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (index < totalQuestion) {
            Button clickedButton = (Button)view;
            if(clickedButton.getText().equals(Common.questionsList.get(index).getCorrectAnswer())) {
                score += 10;
                correctAnswer++;
                showQuestion(++index);
            }
            else {
                showQuestion(++index);
            }
            scoreView.setText((String.valueOf(score)));
        }

    }

    private void showQuestion(int index) {
        if (index < totalQuestion) {
            thisQuestion++;
            question.setText(Common.questionsList.get(index).getQuestion());
            buttonA.setText(Common.questionsList.get(index).getAnswerA());
            buttonB.setText(Common.questionsList.get(index).getAnswerB());

        } else {

            Intent intent = new Intent(this, StartTestActivity.class);
            startActivity(intent);
            finish();

        }

    }
}