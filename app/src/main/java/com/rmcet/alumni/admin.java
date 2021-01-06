package com.rmcet.alumni;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.rmcet.alumni.model.Student;

import java.util.concurrent.Executors;

import rmcet.db.Database;

public class admin extends Activity {

    Button addalumni,allalumni,contribution,donation,fd,exit;

    Context context;
    public Database d;
    String usernames;
    MutableLiveData<Student>dbResLiveData = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        d=new Database(getApplicationContext());

        usernames = getIntent().getStringExtra("U_RNAME");

        Toast.makeText(getApplicationContext(),usernames, Toast.LENGTH_SHORT).show();

        addalumni=(Button)findViewById(R.id.btnaddalumni);

        allalumni=(Button)findViewById(R.id.btnallalumni);

        contribution=(Button)findViewById(R.id.btncontribution);

        donation=(Button)findViewById(R.id.btndonation);

        fd=(Button)findViewById(R.id.btnfeedback);

        exit=(Button)findViewById(R.id.btnlogoff);

        context=this;




        //thread do background operation
        Executors.newSingleThreadExecutor().submit(new Runnable() {
            @Override
            public void run() {
                //long db operation
                dbResLiveData.postValue(new Student("abc",6));//backgroudn thread
            }
        });

        addalumni.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent register=new Intent(context,admin_addalumni.class);
                context.startActivity(register);




            }
        });

        allalumni.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent register=new Intent(context,admin_allalumni.class);
                context.startActivity(register);


            }
        });

        contribution.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent register=new Intent(context,admin_contribution.class);
                context.startActivity(register);


            }
        });


        donation.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub

                Intent register=new Intent(context,admin_donation.class);
                context.startActivity(register);


            }
        });


        fd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent register=new Intent(context,admin_feedback.class);
                context.startActivity(register);


            }
        });


        exit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();

            }
        });







    }
}
