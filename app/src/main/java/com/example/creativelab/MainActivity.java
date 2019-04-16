package com.example.creativelab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView password;
    private TextView username;
    private Button login;
    private Button register;
    LoginDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new LoginDatabaseHelper(this);
        password = (TextView) findViewById(R.id.Passwordtext);
        username = (TextView) findViewById(R.id.usernametext);
        login = (Button) findViewById(R.id.loginbutton);
        register = (Button) findViewById(R.id.createaccountbutton);
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
    public void opendashboard() {
        Intent intent =new Intent(this, DashboardActivity.class);
        startActivity(intent);

    }
    public void opensignup() {
        Intent intent =new Intent(this, SignUp.class);
        startActivity(intent);

    }
}


