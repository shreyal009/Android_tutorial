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
import android.widget.Toast;

public class Login_Layout extends AppCompatActivity {

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText etUsername=(EditText)findViewById(R.id.etUsername);
        final EditText etPassword=(EditText)findViewById(R.id.etPassword);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usrnme=etUsername.getText().toString();
                String pwd=etPassword.getText().toString();

                if(usrnme.equals("admin") && pwd.equals("admin"))
                {
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(Login_Layout.this,After_Login.class);
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
