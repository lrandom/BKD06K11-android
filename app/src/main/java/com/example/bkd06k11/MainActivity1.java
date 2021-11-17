package com.example.bkd06k11;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity1 extends AppCompatActivity {
    public static final String TAG_NAME = "NAME";
    public static final int REQUEST_CODE = 100;
    public static final int REQUEST_CODE_2 = 101;
    Button btnStartActivity, btnOpenLink, btnStartActivityForResult;


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


        ActivityResultLauncher<Intent> startActivity2ForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            String name = data.getStringExtra("NAME");
                            Log.i("RESULT", name);
                        }
                    }
                }
        );


        btnStartActivityForResult = findViewById(R.id.btnStartaForResult);
        btnStartActivityForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                //startActivityForResult(intent, REQUEST_CODE);
                startActivity2ForResult.launch(intent);
            }
        });


    }


/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String name = data.getStringExtra("NAME");
                    Log.i("RESULT", name);
                }
                break;

            case REQUEST_CODE_2:
                break;
        }
    }*/
}