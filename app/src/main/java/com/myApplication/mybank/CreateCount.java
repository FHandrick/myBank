package com.myApplication.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import business.*;


public class CreateCount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_count);
    }
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public void confirmCreateCount(View view){

        EditText ecountnumber = findViewById(R.id.enumber);
        String countNumber = ecountnumber.getText().toString();

        EditText eclientname = findViewById(R.id.evalue);
        String clientName = eclientname.getText().toString();
        Count c = new Count(countNumber,clientName);

        if (c.getName().equals("") || c.getNumber().equals("")){
            Intent intent = new Intent(this, ErroPage.class);
            String message = "You must fill all the fields!!";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        else {
            MainActivity.bb.register(c);
            Intent intent = new Intent(this, SucessPage.class);
            String message = "Count for Client: "+c.getName()+" created successfully!!"+"\n"+
                    "Balance: "+MainActivity.bb.balance(c.getNumber());
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }
}
