package com.example.bkd06k11.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bkd06k11.R;

public class ActivitySignup extends AppCompatActivity {
    EditText edtFullName, edtUserName, edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edtFullName = findViewById(R.id.edtFullName);
        edtUserName = findViewById(R.id.edtUserName);
        edtPhone = findViewById(R.id.edtPhone);
    }

    public void next(View view) {
        Intent intent = new Intent(this, ActivityConfirmInfo.class);
        intent.putExtra("fullName", edtFullName.getText().toString());
        intent.putExtra("userName", edtUserName.getText().toString());
        intent.putExtra("phone", edtPhone.getText().toString());
        startActivity(intent);
    }
}