package com.myApplication.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AuditorCount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auditor_count);

        Intent intent = getIntent();
        String message = MainActivity.bb.auditor();
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textValue);
        textView.setText(message);

    }
    public void confirmOperation(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
