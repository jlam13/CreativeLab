package com.example.creativelab.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.creativelab.DashboardActivity;
import com.example.creativelab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LogInActivity extends AppCompatActivity {
    private TextView password;
    private TextView username;
    private Button login;
    private Button register;
    private CheckBox rememberMe;
    private SharedPreferences preferences;
    private static final String PREFS_NAME = "PrefsFile";
    FirebaseDatabase loginsignupdatabase;
    private FirebaseAuth authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        FirebaseApp.initializeApp(LogInActivity.this);
        authentication = FirebaseAuth.getInstance();
        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        password = findViewById(R.id.passwordText);
        username = findViewById(R.id.usernameText);
        login = findViewById(R.id.loginButton);
        register = findViewById(R.id.createAccountButton);
        rememberMe = findViewById(R.id.rememberMeCheckbox);
    }

    public void logInClick (View view){
        final ProgressDialog progressDialog= ProgressDialog.show(LogInActivity.this, "Please wait", "Processing...", true);
        (authentication.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent login = new Intent(LogInActivity.this, DashboardActivity.class);
                            login.putExtra("Email", authentication.getCurrentUser().getEmail());
                            login.putExtra("Name", authentication.getCurrentUser().getDisplayName());
                            startActivity(login);
                        } else {
                            Log.e("Wrong email or password", task.getException().toString());
                            Toast.makeText(LogInActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void signUpClick (View v){
        Intent signUp = new Intent (LogInActivity.this, SignUpActivity.class);
        startActivity(signUp);
    }

}