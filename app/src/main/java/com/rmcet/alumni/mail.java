package com.rmcet.alumni;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;


public class mail extends AppCompatActivity {

    private EditText recipient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        recipient = (EditText) findViewById(R.id.recipient);
        Button sendBtn = (Button) findViewById(R.id.send);
        // sendBtn.setOnClickListener(new View.OnClickListener() {
        //public void onClick(View view) {
//                // after sending the email, clear the fields
//                subject.setText("");
        //.setText("");
        //   }
        //});

        //private void check(String userName)
    }
}




