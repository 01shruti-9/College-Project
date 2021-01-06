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

public class login extends AppCompatActivity {

    TextView llable;
    EditText username,password;
    Button signin,register,help;

    Context context;
    public static Database d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        d= new Database(getApplicationContext());

        username=(EditText)findViewById(R.id.entername);
        password=(EditText)findViewById(R.id.enterpass);

        signin=(Button)findViewById(R.id.btnlog);

        register=(Button)findViewById(R.id.btnreg);
        help=(Button)findViewById(R.id.btnpass);

        context=this;


        signin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String un=username.getText().toString();
                String pw=password.getText().toString();
                boolean l=d.getLogData(un,pw);

                if(un.matches("shruti"))
                {

                    Intent Home=new Intent(context,tabs.class);
                    Home.putExtra("U_RNAME",un);
                    Home.putExtra("U_PASS",pw);

                    context.startActivity(Home);
                    //Toast.makeText(getApplicationContext(),"Admin", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {

                    if (l) {
                        Intent Home = new Intent(context, MainActivity.class);
                        Home.putExtra("U_RNAME", un);
                        //Home.putExtra("U_PASS",pw);

                        context.startActivity(Home);
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                        username.setText(" ");
                        password.setText(" ");


                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_SHORT).show();
                    }

                }



            }
        });

        register.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent register=new Intent(context,register_page.class);
                context.startActivity(register);
            }
        });

        help.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent help=new Intent(context,help_page.class);
                context.startActivity(help);
            }
        });

    }
}
