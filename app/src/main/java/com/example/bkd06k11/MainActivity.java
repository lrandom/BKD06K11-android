package com.example.bkd06k11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText edtShow;
    Button btnClear;
    String numberOne = "", numberTwo = "";
    Float result;
    String operationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtShow = findViewById(R.id.edtShow);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtShow.setText("");
                numberOne = "";
                numberTwo = "";
                result = null;
                operationName = null;
            }
        });
    }

    public void setValueForNumberOne(View v) {
        TextView tv = (TextView) v;
        //đang chọn số thứ nhất. cộng chuỗi
        this.numberOne += tv.getText().toString();
        System.out.println(this.numberOne);
    }

    public void setValueForNumberTwo(View v) {
        TextView tv = (TextView) v;
        this.numberTwo += tv.getText().toString();
        System.out.println(this.numberTwo);
    }

    public void setValueForNumberButton(View view) {
        if (this.operationName == null) {
            setValueForNumberOne(view);
        } else {
            setValueForNumberTwo(view);
        }
    }

    public void setOperationName(View view) {
        TextView tv = (TextView) view;
        this.operationName = tv.getText().toString();
    }

    public void calc(View view) {
        switch (this.operationName) {
            case "+":
                this.result = Float.parseFloat(this.numberOne) + Float.parseFloat(this.numberTwo);
                break;

            case "-":
                this.result = Float.parseFloat(this.numberOne) - Float.parseFloat(this.numberTwo);
                break;

            case "*":
                this.result = Float.parseFloat(this.numberOne) * Float.parseFloat(this.numberTwo);
                break;

            case "/":
                this.result = Float.parseFloat(this.numberOne) / Float.parseFloat(this.numberTwo);
                break;
        }

        //show kết quả
        edtShow.setText(String.format(this.result.toString()));
    }


}