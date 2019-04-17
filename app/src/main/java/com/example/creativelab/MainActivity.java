package com.example.creativelab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView password;
    private TextView username;
    private Button login;
    private Button register;
    private CheckBox rememberme;
    private SharedPreferences preferences;
    private static final String PREFS_NAME = "PrefsFile";
    LoginDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        db = new LoginDatabaseHelper(this);
        password = (TextView) findViewById(R.id.passwordtext);
        username = (TextView) findViewById(R.id.usernametext);
        login = (Button) findViewById(R.id.loginbutton);
        register = (Button) findViewById(R.id.createaccountbutton);
        rememberme = (CheckBox) findViewById(R.id.remembermecheckbox);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = username.getText().toString();
                String pass = password.getText().toString();
                Boolean login = db.login(email, pass);
                if(login==true)
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                if(rememberme.isChecked()){
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
                getPreferencesData();
                opendashboard();

            }
        }
        );

        Button createaccountbutton;
        createaccountbutton = (Button) findViewById(R.id.createaccountbutton);
        createaccountbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                opensignup();
            }
        }
        );
    }

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
    }
    public void opendashboard() {
        Intent intent =new Intent(this, DashboardActivity.class);
        startActivity(intent);
        //username.getText().clear();
       // password.getText().clear();

    }
    public void opensignup() {
        Intent intent =new Intent(this, SignUp.class);
        startActivity(intent);

    }
}


