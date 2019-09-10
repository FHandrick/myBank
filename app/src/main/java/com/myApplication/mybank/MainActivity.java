package com.myApplication.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import business.Bank;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static Bank bb = new Bank();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void createCount(View view){
        Intent intent = new Intent(this, CreateCount.class);
        startActivity(intent);
    }
    public void showCount(View view){
        Intent intent = new Intent(this, ShowCount.class);
        startActivity(intent);
    }
    public void creditCount(View view){
        Intent intent = new Intent(this, CreditCount.class);
        startActivity(intent);
    }
    public void debitCount(View view){
        Intent intent = new Intent(this, DebitCount.class);
        startActivity(intent);
    }
    public void transferCount(View view){
        Intent intent = new Intent(this, TransferCount.class);
        startActivity(intent);
    }
    public void auditor(View view){
        Intent intent = new Intent(this, AuditorCount.class);
        startActivity(intent);
    }
    public void closeProgram(View view) {
        finishAffinity();
        System.exit(0);
    }
}
