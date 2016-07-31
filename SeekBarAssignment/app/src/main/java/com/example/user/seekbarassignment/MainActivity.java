package com.example.user.seekbarassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar s1,s2,s3;
    Button b1;
    EditText e1;
    int amount=0,year=0,interest=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1=(SeekBar)findViewById(R.id.sbamt);
        s2=(SeekBar)findViewById(R.id.sbyear);
        s3=(SeekBar)findViewById(R.id.sbint);
        b1=(Button)findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.editText);
        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
                                          @Override
                                          public void  onProgressChanged(SeekBar seekBar,int progress,boolean fromUser)
                                          {
                                                amount=s1.getProgress();
                                          }
                                          @Override
                                          public void onStartTrackingTouch(SeekBar seekBar) {

                                          }

                                          @Override
                                          public void onStopTrackingTouch(SeekBar seekBar) {

                                          }


                                      }
        );
        s2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
                                          @Override
                                          public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                              year=s2.getProgress();

                                          }

                                          @Override
                                          public void onStartTrackingTouch(SeekBar seekBar) {

                                          }

                                          @Override
                                          public void onStopTrackingTouch(SeekBar seekBar) {

                                          }

                                      }
        );
        s3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                          @Override
                                          public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                              interest=s3.getProgress();
                                          }

                                          @Override
                                          public void onStartTrackingTouch(SeekBar seekBar) {

                                          }

                                          @Override
                                          public void onStopTrackingTouch(SeekBar seekBar) {

                                          }
                                      }
        );
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int EMI=(amount*year*interest)/100;
                e1.setText(EMI+"");
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
