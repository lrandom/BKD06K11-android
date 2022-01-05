package com.example.bkd06k11.activities;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.bkd06k11.R;

public class StartedService extends Service {
    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("create service");
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.rap);
        mediaPlayer.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("start not sticky");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("destroy service");
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
