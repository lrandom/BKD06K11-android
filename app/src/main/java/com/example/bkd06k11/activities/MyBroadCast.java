package com.example.bkd06k11.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case Intent.ACTION_BATTERY_LOW:
                Toast.makeText(context, "Pin yêu rồi bro ơi, sạc đi",
                        Toast.LENGTH_LONG).show();
                break;

            case ActivitySendBroadcast.ACTION_SEND_FULL_NAME:
                System.out.println(intent.getStringExtra("NAME"));
                break;

        }

    }
}