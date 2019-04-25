package com.example.creativelab.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.creativelab.profile.User;
import com.example.creativelab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    private EditText input_name;
    private EditText input_email;
    private EditText input_password;
    private EditText input_confirm_password;
    private TextView link_login;
    private FirebaseAuth authentication;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        link_login = findViewById(R.id.link_login);
        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        input_name = findViewById(R.id.input_name);
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        input_confirm_password = findViewById(R.id.input_confirm_password);
        link_login = findViewById(R.id.link_login);
        authentication = FirebaseAuth.getInstance();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    public void btn_signUp_Click (View v) {
        final ProgressDialog progressDialog = ProgressDialog.show(SignUpActivity.this, "Please wait...", "Processing...", true);
        (authentication.createUserWithEmailAndPassword(input_email.getText().toString(), input_password.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            final String name = input_name.getText().toString().trim();
                            final String email = input_email.getText().toString().trim();
                            final String password = input_password.getText().toString().trim();
                            User user = new User(name, email);
                            authentication.signInWithEmailAndPassword(email, password);
                            //Toast.makeText(ActivityRegister.this, user_id, Toast.LENGTH_SHORT).show();

                            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("User");
                            DatabaseReference currentUserDB = mDatabase.child(authentication.getCurrentUser().getUid());
                            currentUserDB.child("name").setValue(name);
                            currentUserDB.child("email").setValue(email);
                            Intent signup = new Intent(SignUpActivity.this, LogInActivity.class);
                            startActivity(signup);
                        } else {
                            Log.e("Unsuccessful", task.getException().toString());
                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}