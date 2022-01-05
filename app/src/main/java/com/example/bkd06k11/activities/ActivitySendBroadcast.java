package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bkd06k11.R;

public class ActivitySendBroadcast extends AppCompatActivity {
    Button btnSendBroadcast;
    public static final String ACTION_SEND_FULL_NAME = "com.example.bkd06k11.SEND_FULL_NAME";
    MyBroadCast myBroadCast = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_broadcast);
      /*  myBroadCast = new MyBroadCast();*/
       /* IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        intentFilter.addAction(ActivitySendBroadcast.ACTION_SEND_FULL_NAME);*/
        //registerReceiver(myBroadCast, intentFilter);

        btnSendBroadcast = findViewById(R.id.btnSendBroadcast);
        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_SEND_FULL_NAME);
                intent.putExtra("NAME", "Nguyen Thanh Luan");
                sendBroadcast(intent);

            }
        });
    }



}