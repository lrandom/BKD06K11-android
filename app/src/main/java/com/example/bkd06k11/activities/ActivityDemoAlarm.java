package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
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
    public static final int JOB_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_alarm);
        btnSetAlarm = findViewById(R.id.btnSetAlarm);
        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JobInfo.Builder jobInfoBuilder = new JobInfo.Builder(JOB_ID,
                        new ComponentName(getPackageName(), MyJobService.class.getName())
                );
                jobInfoBuilder
                        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);

                JobInfo jobInfo = jobInfoBuilder.build();

                JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
                jobScheduler.schedule(jobInfo);
            }
        });
    }
}
