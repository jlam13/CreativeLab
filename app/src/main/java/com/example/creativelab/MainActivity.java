package com.example.creativelab;

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

import com.example.creativelab.LoginSignup.SignUptest;
import com.google.android.gms.common.oob.SignUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private TextView password;
    private TextView username;
    private Button login;
    private Button register;
    private CheckBox rememberme;
    private SharedPreferences preferences;
    private static final String PREFS_NAME = "PrefsFile";
    FirebaseDatabase loginsignupdatabase;

    private FirebaseAuth authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(MainActivity.this);

        authentication = FirebaseAuth.getInstance();

        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        password = (TextView) findViewById(R.id.passwordtext);
        username = (TextView) findViewById(R.id.usernametext);
        login = (Button) findViewById(R.id.loginbutton);
        register = (Button) findViewById(R.id.createaccountbutton);
        rememberme = (CheckBox) findViewById(R.id.remembermecheckbox);
    }

        public void btn_login_Click (View view){
            final ProgressDialog progressDialog= ProgressDialog.show(MainActivity.this, "Please wait", "Processing...", true);
            (authentication.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString()))
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();

                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent login = new Intent(MainActivity.this, DashboardActivity.class);
                                login.putExtra("Email", authentication.getCurrentUser().getEmail());
                                startActivity(login);
                            } else {
                                Log.e("Wrong email or password", task.getException().toString());
                                Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

        public void btn_signUp_Click (View v){
            Intent openactivity = new Intent (MainActivity.this, SignUptest.class);
            startActivity(openactivity);
        }

}


 /* if(rememberme.isChecked()){
                    Boolean boolIschecked = rememberme.isChecked();
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("pref_name", username.getText().toString());
                    editor.putString("pref_pass", password.getText().toString());
                    editor.putBoolean("pref_check", boolIschecked);
                    editor.apply();
                    Toast.makeText(getApplicationContext(), "Login Saved", Toast.LENGTH_SHORT).show();
                }
                else{
                    preferences.edit().clear().apply();
                }
                getPreferencesData(); */




   /*

    public void getPreferencesData(){
        SharedPreferences sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        if(sp.contains("pref_name")){
            String u =sp.getString("pref_name", "not found");
            username.setText(u.toString());
        }
        if(sp.contains("pref_pass")){
            String u =sp.getString("pref_pass", "not found");
            password.setText(u.toString());
        }
        if(sp.contains("pref_check")){
            Boolean b =sp.getBoolean("pref_check", false);
            rememberme.setChecked(b);
        }
    } */


