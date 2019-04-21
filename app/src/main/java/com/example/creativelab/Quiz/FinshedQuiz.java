package com.example.creativelab.Quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.creativelab.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FinshedQuiz extends AppCompatActivity {
    Button tryagainbutton;
    TextView totalscoretext;
    TextView totalquestiontext;
    ProgressBar progressBar;

    FirebaseDatabase db;
    DatabaseReference question_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finshed_quiz);

        db = FirebaseDatabase.getInstance();
        question_score = db.getReference("Question_Score");

        totalscoretext = (TextView)findViewById(R.id.totalscore);
        totalquestiontext= (TextView)findViewById(R.id.totalquestion);
        progressBar = (ProgressBar)findViewById(R.id.finishedprogressbar);
        tryagainbutton = (Button)findViewById(R.id.tryagainbutton);

        tryagainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinshedQuiz.this, Finis);
                startActivity(intent);
                finish();
            }
        });
        Bundle extra =getIntent().getExtras();
        if(extra != null)
        {
            int score =extra.getInt("SCORE");
            int totalQuestion =extra.getInt("TOTAL");
            int correctAnswer =extra.getInt("CORRECT");

            totalscoretext.setText(String.format("SCORE: %d", score));
            totalquestiontext.setText(String.format("PASSED: %d / %d", correctAnswer, totalQuestion));

            progressBar.setMax(totalQuestion);
            progressBar.setProgress(correctAnswer);

            question_score.child(String.format("%s_%s", Common.currentuser.getUserName(),
                                                        Common.suiteid))
                    .setValue(new QuestionScore(String.format("%s_%s", Common.currentuser.getUserName(),
                            Common.suiteid),
                            Common.currentuser.getUserName(),
                            String.valueOf(score)));
        }
    }
}
