package com.example.bkd06k11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();

        System.out.println("hello");

        test2();
    }


    public void test() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

    public void test2() {
        for (int j = 0; j < 5; j++) {
            System.out.println(j);
        }
    }
}