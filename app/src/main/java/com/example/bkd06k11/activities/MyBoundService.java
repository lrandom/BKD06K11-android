package com.example.bkd06k11.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.bkd06k11.R;

public class MyBoundService extends Service {
    MediaPlayer mediaPlayer;
    Notification notificationCompat;
    NotificationManager notificationManagerCompat;

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("create service");
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.rap);
        notificationManagerCompat = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void playMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();

            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
            builder.setSmallIcon(R.drawable.ic_launcher_foreground).setContentTitle(getString(R.string.app_name));
            notificationCompat = builder.build();
            notificationManagerCompat.notify(1000, notificationCompat);
        }
    }

    public void pauseMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void resumeMusic() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder {
        public Service getService() {
            return MyBoundService.this;
        }
    }

}
