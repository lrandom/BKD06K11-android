package com.example.bkd06k11;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    Button btnReturnResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

/*        String name = getIntent().getStringExtra("NAME");
        String address = getIntent().getStringExtra("ADDRESS");*/

       /* Bundle bundle = getIntent().getExtras();
        String name1 = bundle.getString(MainActivity1.TAG_NAME);
        String address1 = bundle.getString("ADDRESS");*/

/*
        Log.i("name", name);
        Log.i("address", address);
*/

        /*Log.i("name", name1);
        Log.i("address", address1);*/


        btnReturnResult = findViewById(R.id.btnReturnResult);
        btnReturnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("NAME", "Nguyen Thanh Luan");
                setResult(RESULT_OK,intent);
                finish();
            }

        });
    }
}
