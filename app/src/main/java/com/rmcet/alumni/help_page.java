package com.rmcet.alumni;

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
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import rmcet.db.Database;
public class help_page extends AppCompatActivity {

    EditText getUserkeyno,g;
    Button changepassword;
    TextView pass;
    public Database d;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);


        getUserkeyno=(EditText)findViewById(R.id.User);
        g=(EditText)findViewById(R.id.Userphoneof);
        changepassword=(Button)findViewById(R.id.changepassword);
        pass=(TextView)findViewById(R.id.Yourpassword);


        context = this;

        d=new Database(getApplicationContext());

        Button h1=(Button)findViewById(R.id.btnhretrive);
        h1.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String uu1=getUserkeyno.getText().toString();
                String uu11=g.getText().toString();

                String l1= d.getHelpPass(uu1,uu11);
                if(l1!=null)
                {
                    pass.setText(l1);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Enter Accurate Key", Toast.LENGTH_SHORT).show();
                    pass.setText("");
                }
            }
        });

        // Creating to open new page
        Button l=(Button)findViewById(R.id.btnbacktologin);
        l.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent toLog=new Intent(context,Alogin.class);
                context.startActivity(toLog);
                finish();
            }
        });

        changepassword=(Button)findViewById(R.id.changepassword);
        l.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent toLog=new Intent(context,mail.class);
                context.startActivity(toLog);
                finish();
            }
        });


    }
}
