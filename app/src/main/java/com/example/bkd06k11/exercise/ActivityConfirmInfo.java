package com.example.bkd06k11.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bkd06k11.R;

public class ActivityConfirmInfo extends AppCompatActivity {
    TextView tvUsername, tvFullName, tvPhone;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_info);
        tvUsername = findViewById(R.id.tvUserName);
        tvFullName = findViewById(R.id.tvFullName);
        tvPhone = findViewById(R.id.tvPhone);

        this.userName = getIntent().getStringExtra("userName");
        tvUsername.setText(getIntent().getStringExtra("fullName"));
        tvFullName.setText(this.userName);
        tvPhone.setText(getIntent().getStringExtra("phone"));

    }

    public void next(View v) {
        Intent intent = new Intent(this, ActivitySignupSuccess.class);
        intent.putExtra("userName", this.userName);
        startActivity(intent);
    }
}