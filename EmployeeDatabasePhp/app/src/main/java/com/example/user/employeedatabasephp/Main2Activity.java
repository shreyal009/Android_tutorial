package com.example.user.employeedatabasephp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=(TextView)findViewById(R.id.txtName);
        t2=(TextView)findViewById(R.id.txtDesg);
        String result=getIntent().getExtras().getString("result");
        String[] strar;
        strar=result.split(",");
       // Toast.makeText(getApplicationContext(),strar[0],Toast.LENGTH_SHORT).show();
        t1.setText(strar[0]);
        t2.setText(strar[1]);



    }

}
