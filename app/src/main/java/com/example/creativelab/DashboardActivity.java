package com.example.creativelab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.creativelab.hub.HubFragment;
import com.example.creativelab.learn.LearnFragment;
import com.example.creativelab.login.LogInActivity;
import com.example.creativelab.profile.ProfileFragment;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Logs out of the application if log out button is pressed in profile
        boolean finish = getIntent().getBooleanExtra("finish", false);
        if (finish) {
            startActivity(new Intent(this, LogInActivity.class));
            finish();
            return;
        }

        // Sets the Learn tab as the default tab
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_learn);

        // Loads the selected fragment
        loadFragment(new LearnFragment());

        // Connects the Learn database
        FirebaseOptions optionsLearn = new FirebaseOptions.Builder()
                .setApplicationId("1:62125859406:android:c7b3867e4f759f5e")
                .setApiKey("AIzaSyB5gBPq8CySbeSSkEJd1Vrb3_cPDxvL40A")
                .setDatabaseUrl("https://rvpop-a60e9.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(this, optionsLearn, "Learn");
        }
        
    // Method to load the selected fragment
    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }

    // Assigns the fragment with its corresponding navigation tab
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch(item.getItemId()) {
            case R.id.navigation_hub:
                fragment = new HubFragment();
                break;
            case R.id.navigation_learn:
                fragment = new LearnFragment();
                break;
            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
