package com.rmcet.alumni;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import rmcet.db.Database;
public class AlumniRegActivity extends Activity {

    Spinner spin;
    private Button register;
    EditText mobileno,usern,pass,mname,lname;
    Context context;
    public static Database d;

//    public static void start(Context context,String id){
//        Intent intent = new Intent(context,AlumniRegActivity.class);
//        intent.putString("",id);
//        context.startActivity(intent);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni_reg);

        mobileno=(EditText)findViewById(R.id.entermobileno);


        usern=(EditText)findViewById(R.id.enterusername);
        mname=(EditText)findViewById(R.id.entermiddlename);
        lname=(EditText)findViewById(R.id.Enterlastname);
        pass=(EditText)findViewById(R.id.enterpassword);

        d=new Database(getApplicationContext());

        addListenerOnButton();
        addListenerOnSpinnerItemSelection();}

    private void addListenerOnSpinnerItemSelection() {
        spin = (Spinner) findViewById(R.id.spinner);

    }

    private void addListenerOnButton() {

        spin = (Spinner) findViewById(R.id.spinner);
        register = (Button) findViewById(R.id.btnregister);



        register.setOnClickListener(new OnClickListener() {



            @Override
            public void onClick(View v) {



                    String mo=mobileno.getText().toString();
                    String unn=usern.getText().toString();
                    String pwn=pass.getText().toString();

                    if( mobileno.length()==0 ||usern.length()==0 ||pass.length()==0)
                    {

                        Toast.makeText(getApplicationContext(), "plz fill all the feilds", Toast.LENGTH_SHORT).show();

                    }

                    else
                    {


                        d.addUsers( unn, pwn, mo);

                        Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();

                        mobileno.setText("");
                        usern.setText("");
                        pass.setText("");
                        mname.setText("");
                        lname.setText("");


                    }




        }
        });

    }
}
