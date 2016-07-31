package com.example.user.listviewassign;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main22Activity extends AppCompatActivity {
    ListView lv;
    SQLiteDatabase db;
    Cursor c;
    String name="";
    String price="";
    ArrayAdapter<String> ad;
//    private ArrayList<String> namea = new ArrayList<String>();
//    private ArrayList<String> pricea = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        lv=(ListView)findViewById(R.id.listView);
        String value = getIntent().getExtras().getString("catid");
        Toast.makeText(getApplicationContext(), value , Toast.LENGTH_SHORT).show();
        db=openOrCreateDatabase("CategoryDb", Context.MODE_PRIVATE, null);
        String q="select distinct name,price from product where cat_id='"+value+"'";
        c=db.rawQuery(q, null);
        //Toast.makeText(getApplicationContext(), c +"", Toast.LENGTH_SHORT).show();
        ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);

        while (c.moveToNext())
        {
            name=c.getString(c.getColumnIndex("name"));
            price=c.getString(c.getColumnIndex("price"));


            ad.add("Name :" + c.getString(c.getColumnIndex("name")) + " Price:" + c.getString(c.getColumnIndex("price")));
           // String items[]={name,price};

            Toast.makeText(getApplicationContext(), name+" "+price, Toast.LENGTH_SHORT).show();
        }
        lv.setAdapter(ad);


    }

}
