package com.example.bkd06k11.activities;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("intent");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String name = intent.getStringExtra("KEY");
        //chứa code thực thi khi mà intent chạy
        for (int i = 0; i < 10000; i++) {
            System.out.println(name+i);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Tự huỷ");
    }
}
