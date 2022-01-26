package com.example.bkd06k11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class DemoInternalStorage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_internal_storage);
        demoReadFile();
    }

    void demoWriteFile() {
        try {
            //ghi files
            FileOutputStream outputStream = openFileOutput("data.txt", MODE_PRIVATE);
            outputStream.write("Hello World".getBytes());
            outputStream.close();
        } catch (Exception e) {

        }
    }

    void demoReadFile() {
        try {
            FileInputStream fis = openFileInput("data.txt");
            Reader reader = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = "";
            while (( line = bufferedReader.readLine() )!= null) {
                System.out.println(line);
            }
           /* int i = 0;
            while ((i = fis.read()) != -1) {
                System.out.println((char) i);
            }*/
            fis.close();
        } catch (Exception e) {

        }
    }
}