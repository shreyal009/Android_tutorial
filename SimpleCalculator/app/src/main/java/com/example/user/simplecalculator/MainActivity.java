package com.example.user.simplecalculator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bc,bd,bp,bm,bml,be;
    EditText et;
    int val1,val2;
    int ad=0,sub=0,div=0,mult=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        b0=(Button)findViewById(R.id.b0);
        bc=(Button)findViewById(R.id.bc);
        bd=(Button)findViewById(R.id.bd);
        bp=(Button)findViewById(R.id.bp);
        bm=(Button)findViewById(R.id.bm);
        bml=(Button)findViewById(R.id.bml);
        be=(Button)findViewById(R.id.be);
        et=(EditText)findViewById(R.id.et);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"1");}});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et.setText(et.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"0");
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(" ");
            }
        });
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            val1=Integer.parseInt(et.getText()+"");
                ad=1;
                et.setText("");
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                val1=Integer.parseInt(et.getText()+"");
                sub=1;
                et.setText("");
            }
        });
        bml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1=Integer.parseInt(et.getText()+"");
                mult=1;
                et.setText("");            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1=Integer.parseInt(et.getText()+"");
                div=1;
                et.setText("");
            }
        });
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               val2=Integer.parseInt(et.getText()+"");
                if(ad==1)
                {
                    et.setText(val1+val2+"");
                    ad=0;
                }
                else if(sub==1)
                {
                    et.setText(val1-val2+"");
                    sub=0;
                }
                else if(mult==1)
                {
                    et.setText(val1*val2+"");
                    mult=0;
                }
                else if(div==1)
                {
                    et.setText(val1/val2+"");
                    div=0;
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
