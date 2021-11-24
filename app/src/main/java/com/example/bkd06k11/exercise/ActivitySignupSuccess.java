package com.example.bkd06k11.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bkd06k11.R;

public class ActivitySignupSuccess extends AppCompatActivity {
    TextView tvUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_success);
        tvUserName = findViewById(R.id.tvUserName);
        tvUserName.setText(getIntent().getStringExtra("userName"));
    }



}