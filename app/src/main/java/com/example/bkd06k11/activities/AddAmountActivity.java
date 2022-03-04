package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.bkd06k11.R;
import com.example.bkd06k11.db.dals.DalTransactionItem;

import java.util.Calendar;

public class AddAmountActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText edtInputDate, edtInputAmount, edtPurpose;
    Integer isPlus = 1;
    String inputDate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);
        btnSubmit = findViewById(R.id.btnSubmit);
        edtInputAmount = findViewById(R.id.edtInputAmount);
        edtInputDate = findViewById(R.id.edtInputDate);
        edtPurpose = findViewById(R.id.edtPurpose);

        edtInputDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                new DatePickerDialog(AddAmountActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                int convertMonth = month + 1;
                                String sConvertMonth = convertMonth+"";

                                if (convertMonth < 10) {
                                    sConvertMonth = "0" + convertMonth;
                                }
                                int convertDayOfMonth = dayOfMonth;
                                String sConvertDayOfMonth = convertDayOfMonth + "";
                                if (convertDayOfMonth < 10) {
                                    sConvertDayOfMonth = "0" + convertDayOfMonth;
                                }
                                edtInputDate.setText(sConvertDayOfMonth + "-" + sConvertMonth  + "-" + year);

                                inputDate = year + "-" + sConvertMonth + "-" + sConvertDayOfMonth;
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    public void onTypeRadioChecked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rdoPlus:
                if (checked)
                    isPlus = 1;
                break;

            case R.id.rdoSub:
                if (checked)
                    isPlus = 0;
                break;
        }
    }

    public void saveAmount(View view) {
        String purpose = edtPurpose.getText().toString();
        String amount = edtInputAmount.getText().toString();
        DalTransactionItem dalTransactionItem = new DalTransactionItem(AddAmountActivity.this);
        dalTransactionItem.addTransactionItem(purpose, new Double(amount), isPlus, inputDate);
    }
}