package com.example.custombroadcast2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText getOutput;
    Button btnn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnn=findViewById(R.id.btn);
        getOutput=findViewById(R.id.output);
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.EXAMPLE_ACTION");
                intent.putExtra("com.example.EXTRA_TEXT","BroadCast Received");
                sendBroadcast(intent);
            }
        });

    }
    private BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String getText=intent.getStringExtra("com.example.EXTRA_TEXT");
            getOutput.setText(getText);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter=new IntentFilter("com.example.EXAMPLE_ACTION");
        registerReceiver(broadcastReceiver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}