package com.example.creativelab.LoginSignup;

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

import com.example.creativelab.MainActivity;
import com.example.creativelab.Profile.User;
import com.example.creativelab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUptest extends AppCompatActivity {
    //private static final String TAG = "SignUpActivity";
    private EditText input_name;
    private EditText input_email;
    private EditText input_password;
    private EditText input_confirmpassword;
   // private Button btn_signUp;
    private TextView link_login;
    private FirebaseAuth authentication;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_uptest);


        input_name = (EditText) findViewById(R.id.input_name);
        input_email = (EditText) findViewById(R.id.input_email);
        input_password = (EditText) findViewById(R.id.input_password);
        input_confirmpassword = (EditText) findViewById(R.id.input_confirmpassword);
        // btn_signUp = (Button) findViewById(R.id.btn_signUp);
        link_login = (TextView) findViewById(R.id.link_login);


        authentication = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(SignUptest.this, MainActivity.class);
                    startActivity(intent);
                    finish();
         /*link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        }); */
                }
            }
        };
    }

    public void btn_signUpbutton_Click(View v){
        final ProgressDialog progressDialog= ProgressDialog.show(SignUptest.this, "Please wait...", "Processing...", true);
        (authentication.createUserWithEmailAndPassword(input_email.getText().toString(), input_password.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(SignUptest.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                            final String name = input_name.getText().toString().trim();
                            final String email = input_email.getText().toString().trim();
                            final String password = input_password.getText().toString().trim();
                            User user = new User( name, email);
                            authentication.signInWithEmailAndPassword(email, password);
                            //Toast.makeText(ActivityRegister.this, user_id, Toast.LENGTH_SHORT).show();

                            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("User");
                            DatabaseReference currentUserDB = mDatabase.child(authentication.getCurrentUser().getUid());
                            currentUserDB.child("name").setValue(name);
                            currentUserDB.child("email").setValue(email);
                            Intent signup = new Intent(SignUptest.this, MainActivity.class);
                            startActivity(signup);

                        }
                        else
                            {
                                Log.e("Unsuccessful", task.getException().toString());
                                Toast.makeText(SignUptest.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                    }
                }
                );

    }
    /* public void signUp() {
        Log.d(TAG, "SignUptest");

        if (!validate()) {
            onSignUpFailed();
            return;
        }

        btn_signUp.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignUptest.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = input_name.getText().toString().trim();
        String email = input_email.getText().toString().trim();
        String password = input_password.getText().toString().trim();
        String confirmpassword = input_confirmpassword.getText().toString().trim();

        authentication.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                        User user = new User( name, email);
                            FirebaseDatabase.getInstance().getReference("Users")
                            .child(authentication.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                 if(task.isSuccessful()){
                                 Toast.makeText(SignUptest.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                 }else{
                                 }
                                }
                            });
                        }else{
                            Toast.makeText(SignUptest.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                        }});

        // TODO: Implement your own signup logic here.

        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignUpSuccess();
                        // onSignUpFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignUpSuccess() {
        btn_signUp.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignUpFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        btn_signUp.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = input_name.getText().toString();
        String email = input_email.getText().toString();
        String password = input_password.getText().toString();
        String confirmpassword = input_confirmpassword.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            input_name.setError("at least 3 characters");
            valid = false;
        } else {
            input_name.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            input_email.setError("enter a valid email address");
            valid = false;
        } else {
            input_email.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            input_password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            input_password.setError(null);
        }

        if (password.equals(confirmpassword)) {
            input_confirmpassword.setError(null);
            valid = false;
        } else {
            input_confirmpassword.setError("passwords do not match");
        }


        return valid;
  */
}
