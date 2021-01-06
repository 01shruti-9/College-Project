package com.rmcet.alumni;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import rmcet.db.Database;
public class feedback_page extends AppCompatActivity {

    EditText a1,a2,a3;
    Button b1,b2;
    Context context;

    public static Database d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_page);

        a1=(EditText)findViewById(R.id.txtbyuser);
        a2=(EditText)findViewById(R.id.txtcontactno);
        a3=(EditText)findViewById(R.id.txtcomment);
        b1=(Button)findViewById(R.id.btnaddfeedback);
        d=new Database(getApplicationContext());
        context=this;

        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //code for add
                String b11=a1.getText().toString();
                String b22=a2.getText().toString();
                String b33=a3.getText().toString();


                d.addFeedback(b11, b22, b33);

                Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();

                a1.setText("");
                a2.setText("");
                a3.setText("");


            }
        });

    }
}
