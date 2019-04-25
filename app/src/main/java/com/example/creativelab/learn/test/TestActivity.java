/*
HELLO
So the problem with this page is that the commented out section in
private void UpdateQuestion
only allows me to play the photoshop quiz and get the result for it
Right now it what the quiz does is

1. Runs the 10 questions associated with the card you clicked on
2. Kills itself when it has no more questions to run

 */

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


public class TestActivity extends AppCompatActivity {

    private TextView scoreView;
    private TextView question;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Questions questions;

    private String answer;
    private int score = 0;
    private int questionNumber = 0;
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String card = (String) extras.get("card");

            test = findViewById(R.id.test);
            test.setText(card);

            scoreView = findViewById(R.id.score);
            question = findViewById(R.id.question);
            choice1 = findViewById(R.id.choice1);
            choice2 = findViewById(R.id.choice2);
            choice3 = findViewById(R.id.choice3);

            updateQuestion(card);

            choice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (choice1.getText() == answer) {
                        score =+ 10;
                        updateScore(score);
                        updateQuestion(card);
                        Toast.makeText(TestActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(TestActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                        updateQuestion(card);
                    }
                }
            });

            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (choice2.getText() == answer) {
                        score =+ 10;
                        updateScore(score);
                        updateQuestion(card);
                        Toast.makeText(TestActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(TestActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                        updateQuestion(card);
                    }
                }
            });

            choice3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (choice3.getText() == answer) {
                        score =+ 10;
                        updateScore(score);
                        updateQuestion(card);
                        Toast.makeText(TestActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(TestActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                        updateQuestion(card);
                    }
                }
            });
        }
    }

    private void updateQuestion(String card){

        do {
            questions = Questions.getDummyQuestions().get(questionNumber);
            question.setText(questions.getQuestion());
            choice1.setText(questions.getChoice1());
            choice2.setText(questions.getChoice2());
            choice3.setText(questions.getChoice3());
            answer = questions.getCorrect();

            if (questionNumber == questions.getCorrect().length()) {
                Intent intent = new Intent(TestActivity.this, FinishTestActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("finalScore", score);
                intent.putExtras(bundle);
                TestActivity.this.finish();
                startActivity(intent);
            }
            questionNumber++;
        } while (!questions.getCategory().equals(card));
    }


    private void updateScore(int point) {
        scoreView.setText("" + score);
    }

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