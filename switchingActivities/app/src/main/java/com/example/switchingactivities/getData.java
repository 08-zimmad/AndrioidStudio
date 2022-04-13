package com.example.switchingactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class getData extends AppCompatActivity {
    TextView getOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
        getOutput=findViewById(R.id.output);
        String s=getIntent().getStringExtra("key");

        getOutput.setText(s);

    }
}