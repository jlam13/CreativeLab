package com.example.creativelab.Learn.Lesson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.creativelab.Learn.Data.LearnCardData;
import com.example.creativelab.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

public class LessonActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private LearnCardData learnCardData;
    private TextView lessonId;
    private TextView youtubeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        Log.d(TAG, "onCreate: Starting.");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String card = (String) extras.get("card");
            lessonId = findViewById(R.id.lessonId);
            lessonId.setText(card);

            final String youtube = (String) extras.get("youtube");
            youtubeId = findViewById(R.id.yt);
            youtubeId.setText(youtube);

            Log.d(TAG, "onClick: Initialising YouTube Player.");
            YouTubePlayerFragment youtubeFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtubeFragment);
            youtubeFragment.initialize("AIzaSyABzb30H7e266HUeV4iYRVjfrvwM_xAgi0", new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    youTubePlayer.cueVideo(youtube);
                    Log.d(TAG, "onClick: Done Initialising.");
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    Log.d(TAG, "onClick: Done Initialising.");
                }
            });

        }






    }
}

