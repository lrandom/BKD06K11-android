package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bkd06k11.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goToAddAmountActivity(View view) {
        Intent intent = new Intent(HomeActivity.this, AddAmountActivity.class);
        startActivity(intent);
    }
}