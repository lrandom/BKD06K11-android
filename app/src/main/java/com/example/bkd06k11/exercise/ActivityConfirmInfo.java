package com.example.bkd06k11.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bkd06k11.R;

public class ActivityConfirmInfo extends AppCompatActivity {
    TextView tvUsername, tvFullName, tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_info);
        tvUsername = findViewById(R.id.tvUserName);
        tvFullName = findViewById(R.id.tvFullName);
        tvPhone = findViewById(R.id.tvPhone);

        tvUsername.setText(getIntent().getStringExtra("fullName"));
        tvFullName.setText(getIntent().getStringExtra("userName"));
        tvPhone.setText(getIntent().getStringExtra("phone"));

    }
}