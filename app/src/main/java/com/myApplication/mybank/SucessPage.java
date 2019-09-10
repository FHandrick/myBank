package com.myApplication.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SucessPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucess_page);

        Intent intent = getIntent();
        String message = intent.getStringExtra(CreateCount.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textSucess);
        textView.setText(message);
    }
    public void confirmOperation(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
