package com.example.bkd06k11.activities;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class MyJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        //đưa công việc mà cần thực thi vào đây
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        ;
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
