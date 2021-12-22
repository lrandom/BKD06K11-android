package com.example.bkd06k11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;

import java.net.NetworkInterface;

public class ActivityCheckState extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_state);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
       /* NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            //bạn đã kết nối đến internet
            System.out.println("Bạn đã kết nối đến internet");
        }else{
            //bạn chưa kết nối đến internet
            System.out.println("Bạn chưa kết nối đến internet");
        }*/
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo != null && networkInfo.isConnected()) {
            System.out.println("Bạn đã kết nối qua WIFI");
        }

        NetworkInfo networkInfo1 = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo1 != null && networkInfo1.isConnected()) {
            System.out.println("Bạn đã kết nối qua MOBILE INTERNET");
        }

    }
}