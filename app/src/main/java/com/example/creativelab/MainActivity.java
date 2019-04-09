package com.example.creativelab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Password;
    private TextView Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button viewbutton;
        viewbutton = (Button) findViewById(R.id.loginbutton);
        viewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        Intent intent =new Intent(this, SignUpActivity.class);
        startActivity(intent);

    }
}
