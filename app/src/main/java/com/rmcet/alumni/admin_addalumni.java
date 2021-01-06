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

public class admin_addalumni extends AppCompatActivity {

    EditText afname,amname,alname,mobi,mail;

    Button add;
    public static Database d;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_addalumni);


        afname=(EditText)findViewById(R.id.enterfirname);
        amname=(EditText)findViewById(R.id.entermidname);
        alname=(EditText)findViewById(R.id.enterlastname);
        mobi=(EditText)findViewById(R.id.entercontact);
        mail=(EditText)findViewById(R.id.enteremail);
        add=(Button)findViewById(R.id.btn_Addalumni);

        d=new Database(getApplicationContext());
        context=this;


        add.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub



                String t1=afname.getText().toString();
                String t2=amname.getText().toString();
                String t3=alname.getText().toString();
                String t4=mobi.getText().toString();
                String t5=mail.getText().toString();

                if(t1.length()==0 || t2.length()==0 ||t3.length()==0 ||t4.length()==0 ||t5.length()==0)
                {

                    Toast.makeText(getApplicationContext(), "plz fill all the feilds", Toast.LENGTH_SHORT).show();

                }

                else
                {


                    d.addalumni(t1, t2, t3, t4, t5);

                    afname.setText("");
                    amname.setText("");
                    alname.setText("");
                    mobi.setText("");
                    mail.setText("");



                    Toast.makeText(getApplicationContext(), "New Alumni is added!", Toast.LENGTH_SHORT).show();



                }

            }
        });

    }
}
