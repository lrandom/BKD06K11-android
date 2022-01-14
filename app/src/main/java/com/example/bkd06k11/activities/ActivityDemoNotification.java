package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.example.bkd06k11.R;

public class ActivityDemoNotification extends AppCompatActivity {
    public static final String CHANNEL_NAME = "demo_app_bkacad";
    public static final String CHANNEL_ID = "com.example.bkd06k11.123";
    public static final int NOTIFICATION_ID = 1;
    Button btnShowNotification, btnHideNotification;
    NotificationChannel channel;
    NotificationCompat.Builder notificationBuilder;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_notification);
        btnShowNotification = findViewById(R.id.btnShowNotification);
        btnHideNotification = findViewById(R.id.btnHideNotification);
        btnShowNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });

        btnHideNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.cancel(NOTIFICATION_ID);
            }
        });
        notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
    }

    public void showNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //android 8
            channel = new NotificationChannel(CHANNEL_ID,
                    NotificationChannel.EDIT_CONVERSATION, NotificationManager.IMPORTANCE_HIGH);
            channel.setSound(null, null);
            channel.enableVibration(true);

            notificationManager.createNotificationChannel(channel);

            Intent intent = new Intent(ActivityDemoNotification.this, ActivitySecond.class);
            PendingIntent startActivity = PendingIntent.getActivity(ActivityDemoNotification.this,
                    NOTIFICATION_ID,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_layout);
            remoteViews.setOnClickPendingIntent(R.id.btnStartActivity, startActivity);
            notificationBuilder = new NotificationCompat.Builder(ActivityDemoNotification.this)
                    .setChannelId(CHANNEL_ID)
                    //.setContentText("Bạn có một email mới")
                    ///.setContentTitle("Thông báo")
                    .setSmallIcon(R.drawable.ic_android_black_24dp)
                    //.setContentIntent(startActivity)
                    //.setAutoCancel(true)
                    .setCustomContentView(remoteViews)
                    .setCustomBigContentView(remoteViews)
                    .addAction(R.drawable.ic_android_black_24dp, "Mark as read", startActivity);
            Notification notification = notificationBuilder.build();
            notificationManager.notify(NOTIFICATION_ID, notification);

        } else {
            //android duoi 8
            notificationBuilder = new NotificationCompat.Builder(ActivityDemoNotification.this)
                    .setChannelId(CHANNEL_ID)
                    .setContentText("Bạn có một email mới")
                    .setContentTitle("Thông báo")
                    .setSmallIcon(R.drawable.ic_android_black_24dp);
            Notification notification = notificationBuilder.build();
            notificationManager.notify(NOTIFICATION_ID, notification);
        }
    }
}