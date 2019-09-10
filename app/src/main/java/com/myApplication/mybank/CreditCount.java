package com.myApplication.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import business.Count;

public class CreditCount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_count);
    }
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public void confirmCreditCount(View view){

        EditText ecountnumber = findViewById(R.id.enumber);
        String countNumber = ecountnumber.getText().toString();

        EditText evalue = findViewById(R.id.evalue);
        String v = evalue.getText().toString();
        double value;

        Count c = MainActivity.bb.find(countNumber);

        if (c==null){
            Intent intent = new Intent(this, ErroPage.class);
            String message = "Count not Found!!";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        else {

            if (v.equals("")){
                Intent intent = new Intent(this, ErroPage.class);
                String message = "You must fill the value!!";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
            else{
                value = Double.parseDouble(v);
                MainActivity.bb.credit(c.getNumber(),value);
                Intent intent = new Intent(this, SucessPage.class);
                String message = "Sucess Credit!"+"\n"+
                        "Count: "+c.getNumber()+"\n"+
                        "Value: "+String.valueOf(value)+"\n"+
                        "New Balance: "+c.getBalance()+"\n";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        }
    }


}
