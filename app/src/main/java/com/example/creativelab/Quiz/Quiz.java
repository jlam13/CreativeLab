package com.example.creativelab.Quiz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.creativelab.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Quiz extends AppCompatActivity {
    final static long INTERVAL = 1000;
    final static long TIMEOUT = 10000;
    int progressValue = 0;

    CountDownTimer countDownTimer;

    int index = 0, score = 0, thisQuestions = 0, totalQuestions, correctAnswer;

    FirebaseDatabase db;
    DatabaseReference questions;

    ProgressBar progressBar;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    TextView questiontext;
    TextView quizscore;
    TextView questionnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        db=FirebaseDatabase.getInstance();
        questions = db.getReference("Questions");

        quizscore = (TextView)findViewById(R.id.quizscoretext);
        questionnumber = (TextView)findViewById(R.id.questionnumbertext);
        questiontext = (TextView)findViewById(R.id.questionnumbertext);

        progressBar = (ProgressBar)findViewById(R.id.progressbar);

        buttonA = (Button) findViewById(R.id.answerAbutton);
        buttonB = (Button) findViewById(R.id.answerBbutton);
        buttonC = (Button) findViewById(R.id.answerCbutton);
        buttonD = (Button) findViewById(R.id.answerDbutton);

        buttonA.setOnClickListener((View.OnClickListener) this);
        buttonB.setOnClickListener((View.OnClickListener) this);
        buttonC.setOnClickListener((View.OnClickListener) this);
        buttonD.setOnClickListener((View.OnClickListener) this);


    }

    @Override
    public void OnClick(View view){
        countDownTimer.cancel();
        if(index < totalQuestions){
            Button ClickedButton = (Button)view;
            if(ClickedButton.getText().equals(Common.questionsList.get(index).getCorrectanswer()))
            {
                score +=10;
                correctAnswer++;
                showQuestion(++index);
            } else{
                Intent intent = new Intent(this,FinshedQuiz.class);
                Bundle dataSend = new Bundle();
                dataSend.putInt("SCORE", score);
                dataSend.putInt("TOTAL", totalQuestions);
                dataSend.putInt("CORRECT", correctAnswer);
                intent.putExtras(dataSend);
                startActivity(intent);
                finish();
            }
            quizscore.setText(String.format("%d",score));
        }

    }

    private void showQuestion(int index) {
        if (index < totalQuestions){
            thisQuestions++;
            questionnumber.setText(String.format("%d / %d",thisQuestions,totalQuestions));
            progressBar.setProgress(0);
            progressValue = 0;
            questiontext.setText(Common.questionsList.get(index).getQuestion());
           buttonA.setText(Common.questionsList.get(index).getAnswerA());
           buttonB.setText(Common.questionsList.get(index).getAnswerB());
           buttonC.setText(Common.questionsList.get(index).getAnswerC());
           buttonD.setText(Common.questionsList.get(index).getAnswerD());

           countDownTimer.start();
        }else{
            Intent intent = new Intent(this,FinshedQuiz.class);
            Bundle dataSend = new Bundle();
            dataSend.putInt("SCORE", score);
            dataSend.putInt("TOTAL", totalQuestions);
            dataSend.putInt("CORRECT", correctAnswer);
            intent.putExtras(dataSend);
            startActivity(intent);
            finish();

        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        totalQuestions = Common.questionsList.size();

        countDownTimer = new CountDownTimer(TIMEOUT,INTERVAL) {
            @Override
            public void onTick(long minisec) {
                progressBar.setProgress(progressValue);
                progressValue++;

            }

            @Override
            public void onFinish() {
                countDownTimer.cancel();
                showQuestion(++index);

            }
        };
        showQuestion(++index);
    }

}
