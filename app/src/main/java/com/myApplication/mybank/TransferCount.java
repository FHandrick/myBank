package com.myApplication.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import business.Count;

public class TransferCount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_count);
    }

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public void confirmTranferCount(View view){

        EditText source = findViewById(R.id.esource);
        String s = source.getText().toString();

        EditText target = findViewById(R.id.etarget);
        String t = target.getText().toString();

        EditText evalue = findViewById(R.id.evalue);
        String v = evalue.getText().toString();
        double value;

        Count c1 = MainActivity.bb.find(s);
        Count c2 = MainActivity.bb.find(t);

        if (c1==null || c2==null){
            Intent intent = new Intent(this, ErroPage.class);
            String message = "Count source or target not Found!!";
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
                MainActivity.bb.transfer(c1.getNumber(),c2.getNumber(),value);
                Intent intent = new Intent(this, SucessPage.class);
                String message = "Transfer Credit!"+"\n"+
                        "Source: "+c1.getNumber()+"\n"+
                        "New Balance: "+c1.getBalance()+"\n"+
                        "Target: "+c2.getNumber()+"\n"+
                        "New Balance: "+c2.getBalance()+"\n"+
                        "Value: "+String.valueOf(value)+"\n";

                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        }
    }
}
