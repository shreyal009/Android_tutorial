package com.example.vinit.assignment7_menu_program;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Registration_Layout extends AppCompatActivity {

    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText etName=(EditText)findViewById(R.id.etReg_Name);
        final EditText etUsername=(EditText)findViewById(R.id.etReg_Username);
        final EditText etPassword=(EditText)findViewById(R.id.etReg_Password);
        final EditText etEmail=(EditText)findViewById(R.id.etReg_Email);

        btnRegister=(Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etUsername.equals("") && !etName.equals("") && !etPassword.equals("") && !etEmail.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Registration_Layout.this,After_Login.class);
                    startActivity(intent);
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
