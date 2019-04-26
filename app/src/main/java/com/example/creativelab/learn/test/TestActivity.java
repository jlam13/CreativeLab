package com.example.creativelab.learn.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.creativelab.R;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView scoreView;
    private TextView question;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Questions questions;

    private String answer;
    private int score = 0;
    private int questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final int card = (int) extras.get("number");
            questionNumber = card;
            scoreView = findViewById(R.id.score);
            question = findViewById(R.id.question);
            choice1 = findViewById(R.id.choice1);
            choice2 = findViewById(R.id.choice2);
            choice3 = findViewById(R.id.choice3);

            updateQuestion(card);

            choice1.setOnClickListener(this);
            choice2.setOnClickListener(this);
            choice3.setOnClickListener(this);
            choice1.setTag(card);
            choice2.setTag(card);
            choice3.setTag(card);
        }
    }

    // Moving between questions
    @Override
    public void onClick(View v) {
        Button clickedButton = (Button)v;
        if (clickedButton.getText() == answer) {
            score += 10;
            updateScore(score);
            updateQuestion((Integer) v.getTag());
            Toast.makeText(TestActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            updateQuestion((Integer) v.getTag());
            Toast.makeText(TestActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

    // Presents 10 questions
    private void updateQuestion(int card) {
        if (questionNumber == card + 10) {
            Intent intent = new Intent(TestActivity.this, FinishTestActivity.class);
            intent.putExtra("finalScore", score);
            intent.putExtra("card", String.valueOf(card));
            TestActivity.this.finish();
            startActivity(intent);
        } else {
            questions = Questions.getDummyQuestions().get(questionNumber);
            question.setText(questions.getQuestion());
            choice1.setText(questions.getChoice1());
            choice2.setText(questions.getChoice2());
            choice3.setText(questions.getChoice3());
            answer = questions.getCorrect();
            questionNumber++;
        }
    }

    private void updateScore(int i) {
        scoreView.setText("" + score);
    }

    // When a user exits the test
    public void clickExit(View view) {
        closePrompt();
    }

    @Override
    public void onBackPressed() {
        closePrompt();
    }

    private void closePrompt (){
        AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);
        builder.setMessage("Are you sure you want to quit?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


}