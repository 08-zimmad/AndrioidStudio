package com.example.custombroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadCasting extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if("com.example.EXAMPLE_ACTION".equals(intent.getAction())){
           String text=intent.getStringExtra("com.example.EXTRA_TEXT");
           Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
        }
    }
}
