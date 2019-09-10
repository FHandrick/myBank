package com.myApplication.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import business.Count;

public class ShowCount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_count);
    }
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public void confirmShowCount(View view){

        EditText ecountnumber = findViewById(R.id.ecount);
        String countNumber = ecountnumber.getText().toString();
        Count c = MainActivity.bb.find(countNumber);

        if (c==null){
            Intent intent = new Intent(this, ErroPage.class);
            String message = "Count not Found!!";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, SucessPage.class);
            String message = "Client: "+c.getName()+"\n"+
                    "Number: "+c.getNumber()+"\n"+
                    "Balance: "+c.getBalance()+"\n";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }

}
