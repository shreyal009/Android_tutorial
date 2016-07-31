package com.example.user.listviewassign;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1;
    SQLiteDatabase db;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.btnStart);
        db=openOrCreateDatabase("CategoryDb", Context.MODE_PRIVATE,null);
        db.execSQL("create table if not exists category(cat_id varchar,cat_name varchar) ;");
        db.execSQL("create table if not exists product(prod_id varchar,name varchar,price int,infodate varchar,pathno int,cat_id varchar,foreign key(cat_id) references category(cat_id)) ;");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String q1="insert into category values('aa1','Hardware')";
                String q2="insert into category values('aa2','Software')";
                String q3="insert into category values('aa3','Roomware')";
                db.execSQL(q1);
                db.execSQL(q2);
                db.execSQL(q3);
                String p1="insert into product values('a1','Keyboard',2000,'12-2-2015',123,'aa1');";
                String p2="insert into product values('a2','Mouse',1000,'12-2-2015',123,'aa2');";
                String p3="insert into product values('a3','Monitor',3000,'12-2-2015',123,'aa3');";
                db.execSQL(p1);
                db.execSQL(p2);
                db.execSQL(p3);

                String pq1="insert into product values('b1','ITAMS',2000,'12-2-2015',123,'aa1');";
                String pq2="insert into product values('b2','RITAMS',1000,'12-2-2015',123,'aa2');";
                String pq3="insert into product values('b3','SITAMS',3000,'12-2-2015',123,'aa3');";
                db.execSQL(pq1);
                db.execSQL(pq2);
                db.execSQL(pq3);

                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);

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
