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
    }

    public void openWebPage(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vnexpress.vn"));
       // intent.addCategory(Intent.CATEGORY_BROWSABLE);
        // if (intent.resolveActivity(getPackageManager()) != null) {
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //}
    }

    public void callPhone(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:012384567"));
        startActivity(intent);
    }

    public void sendSMS(View v) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:012435678"));
        //intent.putExtra("sms_body", "Hello");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openMap(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:21.04451419793164, 105.82012212627899"));
        startActivity(intent);
    }
}