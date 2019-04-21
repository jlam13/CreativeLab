package com.example.creativelab.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.creativelab.LoginSignup.SignUptest;
import com.example.creativelab.MainActivity;
import com.example.creativelab.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileInformation extends AppCompatActivity {
    private TextView nametext;
    private TextView emailtext;
    private Button logoutbtn;
    private FirebaseAuth authentication;
    private FirebaseAuth.AuthStateListener authenticationlistener;
    private FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;
    private FirebaseDatabase db;
    private String userid;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
        FirebaseApp.initializeApp(ProfileInformation.this);
        authentication = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference();
        FirebaseUser user = authentication.getCurrentUser();
        userid = user.getUid();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        logoutbtn = (Button) findViewById(R.id.logoutbtn);

    }

    public void showData(DataSnapshot dataSnapshot){
        for (DataSnapshot ds: dataSnapshot.getChildren()){
            UserInformation userinformation = new UserInformation();
            userinformation.setName(ds.child(userid).getValue(UserInformation.class).getName());
            userinformation.setEmail(ds.child(userid).getValue(UserInformation.class).getEmail());

            nametext = findViewById(R.id.nametextprofile);
            emailtext = findViewById(R.id.emailtextprofile);
            nametext.setText(userinformation.getName());
            emailtext.setText(userinformation.getEmail());


        }
    }
    public void logoutbtn_Click (View v){
        Intent openactivity = new Intent (ProfileInformation.this, MainActivity.class);
        startActivity(openactivity);
    }
}
