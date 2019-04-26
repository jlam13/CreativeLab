package com.example.creativelab.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.creativelab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authListener;
    private TextView link_back_to_login;
    private EditText reset_email_input;
    private Button send_email_button;
    private FirebaseAuth authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        link_back_to_login = findViewById(R.id.link_back_to_login);
        reset_email_input = findViewById(R.id.emailText);
        send_email_button = findViewById(R.id.SendEmailButton);

        authentication = FirebaseAuth.getInstance();
        link_back_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(ForgotPasswordActivity.this, LogInActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        send_email_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = reset_email_input.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter valid email address", Toast.LENGTH_SHORT).show();
                }
                else{
                    authentication.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotPasswordActivity.this, "Please Check Your Email", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ForgotPasswordActivity.this, LogInActivity.class));
                            }
                            else{
                                String message =task.getException().getMessage();
                                Toast.makeText(ForgotPasswordActivity.this,"Email address not valid" + message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}