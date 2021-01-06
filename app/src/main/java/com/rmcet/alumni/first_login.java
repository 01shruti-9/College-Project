package com.rmcet.alumni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class first_login extends AppCompatActivity {



        Button alumni,student,staff,guest,faq;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_first_login);
            alumni = findViewById(R.id.btnalumni);
            alumni.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(first_login.this,Alogin.class);
                    startActivity(intent);


                }
            });

            student = findViewById(R.id.btnstudent);
            student.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(first_login.this,login.class);
                    startActivity(intent);


                }
            });

            staff = findViewById(R.id.btnstaff);
            staff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(first_login.this,login_page.class);
                    startActivity(intent);


                }
            });

            guest = findViewById(R.id.btnguest);
            guest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(first_login.this,tab7.class);
                    startActivity(intent);




                }
            });

            faq = findViewById(R.id.btnfaq);
            faq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(first_login.this,faq.class);
                    startActivity(intent);




                }
            });
        }


}
