package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bkd06k11.R;

public class ActivityDemoAlarm extends AppCompatActivity {
    Button btnSetAlarm;
    public static final String ACTION_ALARM_WAKEUP = "bk.com.ACTION_ALARM_WAKEUP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_alarm);
        btnSetAlarm = findViewById(R.id.btnSetAlarm);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentTime = System.currentTimeMillis();//lấy về timestamp tính từ 1-1-1970 OO:OO:0000 (ra đời Unix)
                Intent intent = new Intent(ACTION_ALARM_WAKEUP);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(ActivityDemoAlarm.this, 1,
                        intent, PendingIntent.FLAG_UPDATE_CURRENT);
                //alarmManager.setExact(AlarmManager.RTC_WAKEUP, currentTime + 2000, pendingIntent);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, currentTime + 2000,
                        60000,
                        pendingIntent);

                //ANDROID 8 // trạng thái Doze (0 cắm sạc, đt ở chế độ tắt màn hình)
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,currentTime+2000,
                        pendingIntent);
            }/**/
        });

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_ALARM_WAKEUP);
        registerReceiver(new MyReceiver(), intentFilter);
    }


    class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case ACTION_ALARM_WAKEUP:
                    Toast.makeText(getApplicationContext(), "Báo thức bật", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
