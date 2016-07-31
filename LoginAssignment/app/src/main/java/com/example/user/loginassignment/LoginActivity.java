package com.example.user.loginassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView t1,t2;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t1=(TextView)findViewById(R.id.textView3);
        t2=(TextView)findViewById(R.id.textView4);
        e1=(EditText)findViewById(R.id.editText3);
        Intent il=getIntent();
        String username=il.getExtras().getString("username");
        String password=il.getExtras().getString("password");
        if(username.equals("sruthi")&&(password.equals("jay")))
        {
            //Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
            t2.setVisibility(View.INVISIBLE);
            t1.setVisibility(View.VISIBLE);
            e1.setVisibility(View.VISIBLE);

        }
        else
        {
            //Toast.makeText(getApplicationContext(),"Invalid ",Toast.LENGTH_SHORT).show();
            t1.setVisibility(View.INVISIBLE);
            e1.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.VISIBLE);
            t2.setText("Incorrect username or password!!!");
        }

    }

}
