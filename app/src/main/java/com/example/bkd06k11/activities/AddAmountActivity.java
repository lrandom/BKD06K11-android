package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.bkd06k11.R;

public class AddAmountActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText edtInputDate, edtInputAmount;
    RadioButton rdoSelectPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);
        btnSubmit = findViewById(R.id.btnSubmit);

    }
}