package com.rmcet.alumni;

import androidx.appcompat.app.AppCompatActivity;
import rmcet.db.Database;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.EditText;

public class register_page extends AppCompatActivity {

    EditText f,m,l,p,mi;
    Button b;
    Context context;
    public static Database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        f=(EditText)findViewById(R.id.enterfirstname2);
        m=(EditText)findViewById(R.id.entermidname2);
        l=(EditText)findViewById(R.id.enterlastname2);
        p=(EditText)findViewById(R.id.enterpassword2);
        mi=(EditText)findViewById(R.id.entermobileno2);

        d= new Database(getApplicationContext());

        b=(Button)findViewById(R.id.btnregister2);

        context=this;


        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String fn=f.getText().toString();
                String mn=m.getText().toString();
                String ln=l.getText().toString();
                String pw=p.getText().toString();
                String mb=mi.getText().toString();
                boolean l=d.getLogData(fn,mn,ln,pw,mb);


                if(l)
                {

                    Toast.makeText(getApplicationContext(),"Success Data Saved!", Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_SHORT).show();
                }



            }
        });





    }
}
