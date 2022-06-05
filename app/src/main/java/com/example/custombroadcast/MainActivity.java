package com.example.custombroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    BroadCasting broadCasting=new BroadCasting();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter=new IntentFilter("com.example.EXAMPLE_ACTION");
        registerReceiver(broadCasting,filter);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadCasting);

    }
}