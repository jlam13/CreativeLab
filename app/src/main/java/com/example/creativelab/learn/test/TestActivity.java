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

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Questions questions;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String card = (String) extras.get("card");

            mScoreView = (TextView) findViewById(R.id.score);
            mQuestionView = (TextView) findViewById(R.id.question);
            mButtonChoice1 = (Button) findViewById(R.id.choice1);
            mButtonChoice2 = (Button) findViewById(R.id.choice2);
            mButtonChoice3 = (Button) findViewById(R.id.choice3);


            updateQuestion(card);

            //Start of Button Listener for Button1
            mButtonChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //My logic for Button goes in here

                    if (mButtonChoice1.getText() == mAnswer) {
                        mScore = mScore + 10;
                        updateScore(mScore);
                        updateQuestion(card);
                        //This line of code is optiona
                        Toast.makeText(TestActivity.this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(TestActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion(card);
                    }
                }
            });

            //End of Button Listener for Button1

            //Start of Button Listener for Button2
            mButtonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //My logic for Button goes in here

                    if (mButtonChoice2.getText() == mAnswer) {
                        mScore = mScore + 10;
                        updateScore(mScore);

                            updateQuestion(card);

                        //This line of code is optiona
                        Toast.makeText(TestActivity.this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(TestActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion(card);
                    }
                }
            });

            //End of Button Listener for Button2


            //Start of Button Listener for Button3
            mButtonChoice3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //My logic for Button goes in here

                    if (mButtonChoice3.getText() == mAnswer) {
                        mScore = mScore + 10;
                        updateScore(mScore);
                        updateQuestion(card);
                        //This line of code is optiona
                        Toast.makeText(TestActivity.this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(TestActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion(card);
                    }
                }
            });

            //End of Button Listener for Button3
        }
    }


    private void updateQuestion(String card){

        do {
            questions = Questions.getDummyQuestions().get(mQuestionNumber);
            mQuestionView.setText(questions.getQuestion());
            mButtonChoice1.setText(questions.getChoice1());
            mButtonChoice2.setText(questions.getChoice2());
            mButtonChoice3.setText(questions.getChoice3());
            mAnswer = questions.getCorrect();

            mQuestionNumber++;

            if (mQuestionNumber == 11) {
                Intent intent = new Intent(getApplicationContext(), FinishTestActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("finalScore", mScore);
                intent.putExtras(bundle);
                TestActivity.this.finish();
                startActivity(intent);
            }

        } while (!questions.getCategory().equals(card));


    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

    public void clickExit(View view) {
        askToClose();
    }


    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose (){
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