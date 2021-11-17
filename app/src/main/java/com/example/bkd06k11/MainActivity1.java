package com.example.bkd06k11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity1 extends AppCompatActivity {
    public static final String TAG_NAME = "NAME";
    Button btnStartActivity, btnOpenLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        btnStartActivity = findViewById(R.id.btnStartActivity);

        //mong muốn rõ ràng
        btnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển sang activity 2
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
/*
                intent.putExtra("NAME", "Luan");
                intent.putExtra("ADDRESS", "QN");
*/

                Bundle bundle = new Bundle();
                bundle.putString(TAG_NAME, "Nam");
                bundle.putString("ADDRESS", "HN");
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        //mong muốn mơ hồ
        btnOpenLink = findViewById(R.id.btnOpenLink);
        btnOpenLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://google.com.vn");

           /*     Intent intent = new Intent(Intent.ACTION_VIEW, uri);*/

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
}