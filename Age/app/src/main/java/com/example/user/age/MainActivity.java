package com.example.user.age;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    Button b1;
    EditText et;
    int yr;
   int mnth;
    int dy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp=(DatePicker)findViewById(R.id.datePicker);
        b1=(Button)findViewById(R.id.button);
        et=(EditText)findViewById(R.id.editText);
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            yr=dp.getYear();
            mnth=dp.getMonth();
            dy=dp.getDayOfMonth();
               // Toast.makeText(getApplicationContext(),yr+" ",Toast.LENGTH_SHORT).show();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int year= Calendar.getInstance().get(Calendar.YEAR);
                int month=Calendar.getInstance().get(Calendar.MONTH);
                int day=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                int yr_diff=year-yr;
                int mnth_diff=month-mnth;
                int day_diff=day-dy;
                if(day_diff<0)
                {
                    day_diff=dy;
                }
                else
                {
                    day_diff=day-dy;
                }
                if (mnth_diff<0)
                {
                    mnth_diff=mnth_diff+12;
                    yr_diff=yr_diff-1;
                }
                else
                {
                    mnth_diff=month-mnth;
                }

                //Toast.makeText(getApplicationContext(),age+" ",Toast.LENGTH_SHORT).show();
                et.setText(yr_diff+"years "+mnth_diff+"months "+day_diff+"days");
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
