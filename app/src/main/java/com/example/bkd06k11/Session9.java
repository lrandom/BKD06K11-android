package com.example.bkd06k11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.ToggleButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Session9 extends AppCompatActivity {
    ArrayList<String> arrayList = new ArrayList<>();
    String gender = "";
    ToggleButton tglAvancedConfig;
    boolean configOn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session9);
        tglAvancedConfig = findViewById(R.id.tglAvancedConfig);
        tglAvancedConfig.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                configOn = isChecked;
                if (isChecked) {
                    System.out.println("on");
                }else{
                    System.out.println("off");
                }
            }
        });
    }

    public void onCheckboxClickedHandler(View view) {
        boolean checked = ((CheckBox) view).isChecked();//kiểm tra xem checkbox có được chọn hay không
        switch (view.getId()) {
            case R.id.cboGame:
                //người ta check vào cái ô game
                if (checked) {
                    //người ta đã check
                    arrayList.add("game");
                } else {
                    //nguờii ta bỏ check
                    arrayList.remove("game");
                }
                break;

            case R.id.cboCoding:
                //check vào ô coding
                if (checked) {
                    //người ta đã check
                    arrayList.add("coding");
                } else {
                    //nguờii ta bỏ check
                    arrayList.remove("coding");
                }
                break;

            case R.id.cboBoxing:
                //check vào ô boxing
                if (checked) {
                    //người ta đã check
                    arrayList.add("boxing");
                } else {
                    //nguờii ta bỏ check
                    arrayList.remove("boxing");
                }
                break;
        }
    }

    public void showResult(View view) {
        for (String item : arrayList
        ) {
            System.out.println(item);
        }

        //Gioi tinh la
        System.out.println(gender);
    }

    public void getGender(View v) {
        //kiểm tra xem radio có đc check hay ko
        boolean checked = ((RadioButton) v).isChecked();
/*        if (checked) {
            if (v.getId() == R.id.rdoFemale) {
                gender = "female";
            } else if (v.getId() == R.id.rdoMale) {
                gender = "male";
            } else if (v.getId() == R.id.rdoLGBT) {
                gender = "LGBT";
            }
        }*/

        switch (v.getId()) {
            case R.id.rdoFemale:
                if (checked) {
                    gender = "female";
                }
                break;

            case R.id.rdoMale:
                if (checked) {
                    gender = "male";
                }
                break;

            case R.id.rdoLGBT:
                if (checked) {
                    gender = "lgbt";
                }
                break;
        }
    }
}