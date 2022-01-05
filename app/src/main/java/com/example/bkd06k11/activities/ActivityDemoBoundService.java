package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.example.bkd06k11.R;

public class ActivityDemoBoundService extends AppCompatActivity {
    Button btnBindService, btnPlayMusic, btnPauseMusic, btnResumeMusic;
    MyBoundService myBoundService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_bound_service);
        btnBindService = findViewById(R.id.btnBindService);
        btnPlayMusic = findViewById(R.id.btnPlayMusic);
        btnPauseMusic = findViewById(R.id.btnPauseMusic);
        btnResumeMusic = findViewById(R.id.btnResumeMusic);
        btnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(ActivityDemoBoundService.this, MyBoundService.class);
                //bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                Intent intent = new Intent(ActivityDemoBoundService.this, MyIntentService.class);
                intent.putExtra("KEY", "LUAN");
                startService(intent);
            }
        });

        btnPlayMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myBoundService != null) {
                    myBoundService.playMusic();
                }
            }
        });

        btnPauseMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myBoundService != null) {
                    myBoundService.pauseMusic();
                }
            }
        });

        btnResumeMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myBoundService != null) {
                    myBoundService.resumeMusic();
                }
            }
        });
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) binder;
            myBoundService = (MyBoundService) myBinder.getService();//trả về instance của MyBoundService
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}