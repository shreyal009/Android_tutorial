package com.example.user.listviewassign;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    SQLiteDatabase db;
    Spinner sp;
    Button b1;
    ArrayAdapter <String>ad;
    Cursor c;
    String catid="";
    String cat="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sp=(Spinner)findViewById(R.id.spinner);
        b1=(Button)findViewById(R.id.btnSubmit);
        db=openOrCreateDatabase("CategoryDb", Context.MODE_PRIVATE, null);
        String q="select distinct cat_name,cat_id from category";
        c=db.rawQuery(q,null);
        ArrayList<String> list=new ArrayList<String>();



        while (c.moveToNext())
        {

            cat=c.getString(c.getColumnIndex("cat_name"));
            //catid=c.getString(c.getColumnIndex("cat_id"));
            //Toast.makeText(getApplicationContext(), cat, Toast.LENGTH_SHORT).show();
            list.add(cat);
            ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
            ad.setDropDownViewResource(android.R.layout.simple_spinner_item);
            sp.setAdapter(ad);
            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(), sp.getSelectedItem() + "", Toast.LENGTH_SHORT).show();

                    String q1="select cat_id from category where cat_name='"+sp.getSelectedItem()+"'";
                    c=db.rawQuery(q1,null);
                    while(c.moveToNext())
                    {
                        catid=c.getString(c.getColumnIndex("cat_id"));
                       // Toast.makeText(getApplicationContext(), catid+"", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


        }



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), catid + "", Toast.LENGTH_SHORT).show();
               Intent i = new Intent(Main2Activity.this, Main22Activity.class);
                i.putExtra("catid", catid);
                startActivity(i);
            }
        });


    }

}
