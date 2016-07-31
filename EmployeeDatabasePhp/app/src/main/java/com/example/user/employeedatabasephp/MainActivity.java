package com.example.user.employeedatabasephp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    URL url;
    HttpURLConnection htpc;
    Button b1;
    EditText e1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
         StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    String empid=e1.getText().toString();
                    url=new URL("http://192.168.43.95/empdb.php?empid="+empid);

                    htpc=(HttpURLConnection)url.openConnection();
                    BufferedReader br=new BufferedReader(new InputStreamReader(htpc.getInputStream()));

                    StringBuffer sb=new StringBuffer(500);
                    String ln;

                    while((ln=br.readLine())!=null)
                    {
                        sb.append(ln);
                    }
                    Toast.makeText(getApplicationContext(),sb.toString(),Toast.LENGTH_SHORT).show();

                    Intent i=new Intent(MainActivity.this,Main2Activity.class);
                    i.putExtra("result",sb.toString());
                    startActivity(i);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Error"+e.getMessage(),Toast.LENGTH_SHORT).show();
                  e.printStackTrace();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
