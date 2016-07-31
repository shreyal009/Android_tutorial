package com.example.user.address;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.layout;
import static android.R.layout.simple_spinner_item;

public class MainActivity extends AppCompatActivity {
    Spinner spCountry,spState,spCity;
    Button b1;
    ArrayAdapter <String>ad,adIn,adOm,adCh,adKer,adMah,adYong,adChin,adMe;
    String cnt="",state="",city="";
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spCountry=(Spinner)findViewById(R.id.spCountry);
        spState=(Spinner)findViewById(R.id.spState);
        spCity=(Spinner)findViewById(R.id.spCity);
        e1=(EditText)findViewById(R.id.editText2);
        e1.setEnabled(false);
        String country[]={"India","China","Oman"};
        ad=new ArrayAdapter<String>(this, simple_spinner_item,country);
        ad.setDropDownViewResource(layout.simple_spinner_dropdown_item);
        spCountry.setAdapter(ad);


        final String cnIn[]={"Kerala","Maharashtra"};
        adIn=new ArrayAdapter<String>(this, simple_spinner_item);
        adIn.setDropDownViewResource(layout.simple_spinner_dropdown_item);

        final String cnOm[]={"Yong"};
        adOm=new ArrayAdapter<String>(this, simple_spinner_item);
        adOm.setDropDownViewResource(layout.simple_spinner_dropdown_item);

        final String cnCh[]={"Chinchau","Meow"};
        adCh=new ArrayAdapter<String>(this, simple_spinner_item);
        adCh.setDropDownViewResource(layout.simple_spinner_dropdown_item);

        final String stKer[]={"Kochi","Thrissur"};
        adKer=new ArrayAdapter<String>(this, simple_spinner_item);
        adKer.setDropDownViewResource(layout.simple_spinner_dropdown_item);

        final String stMah[]={"Pune","Mumbai"};
        adMah=new ArrayAdapter<String>(this, simple_spinner_item);
        adMah.setDropDownViewResource(layout.simple_spinner_dropdown_item);

        final String stYong[]={"fds","fsdf"};
        adYong=new ArrayAdapter<String>(this, simple_spinner_item);
        adYong.setDropDownViewResource(layout.simple_spinner_dropdown_item);

        final String stChin[]={"MII","LIii"};
        adChin=new ArrayAdapter<String>(this, simple_spinner_item);
        adChin.setDropDownViewResource(layout.simple_spinner_dropdown_item);

        final String stMe[]={"Reee","dsfd"};
        adMe=new ArrayAdapter<String>(this, simple_spinner_item);
        adMe.setDropDownViewResource(layout.simple_spinner_dropdown_item);

        spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cnt = spCountry.getSelectedItem().toString();
                if (cnt.equals("India")) {
                    String[] cnI;
                    cnI = cnIn;
                    adIn.clear();
                    adIn.addAll(cnI);
                    spState.setAdapter(adIn);

                } else if (cnt.equals("Oman")) {
                    String[] cnO;
                    cnO = cnOm;
                    adOm.clear();
                    adOm.addAll(cnO);
                    spState.setAdapter(adOm);
                } else if (cnt.equals("China")) {
                    String[] cnC;
                    cnC = cnCh;
                    adCh.clear();
                    adCh.addAll(cnC);
                    spState.setAdapter(adCh);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 state = spState.getSelectedItem().toString();
                if (state.equals("Kerala")) {
                    String[] cnC;
                    cnC = stKer;
                    adKer.clear();
                    adKer.addAll(cnC);
                    spCity.setAdapter(adKer);
                } else if (state.equals("Maharashtra")) {
                    String[] cnC;
                    cnC = stMah;
                    adMah.clear();
                    adMah.addAll(cnC);
                    spCity.setAdapter(adMah);
                } else if (state.equals("Yong")) {
                    String[] cnC;
                    cnC = stYong;
                    adYong.clear();
                    adYong.addAll(cnC);
                    spCity.setAdapter(adYong);
                } else if (state.equals("Meow")) {
                    String[] cnC;
                    cnC = stMe;
                    adMe.clear();
                    adMe.addAll(cnC);
                    spCity.setAdapter(adMe);
                } else if (state.equals("Chinchau")) {
                    String[] cnC;
                    cnC = stChin;
                    adChin.clear();
                    adChin.addAll(cnC);
                    spCity.setAdapter(adChin);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                city=spCity.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), cnt + " " + state + " " + city, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }



  //  }


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
