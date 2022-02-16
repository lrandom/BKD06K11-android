package com.example.bkd06k11;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.bkd06k11.db.SqliteHelper;

public class DemoSqliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_sqlite);
        SqliteHelper sqliteHelper = new SqliteHelper(DemoSqliteActivity.this);
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();//tạo và trả về một instance thể hiện của sqlitedb

        db.execSQL("INSERT INTO users(name,address) VALUES('Nguyen Van Luan','Quang Ninh')");
        db.execSQL("INSERT INTO users(name,address) VALUES('Nguyen Van Luan','Quang Ninh')");
        db.execSQL("INSERT INTO users(name,address) VALUES('Nguyen Van Luan','Quang Ninh')");
        db.execSQL("INSERT INTO users(name,address) VALUES('Nguyen Van Luan','Quang Ninh')");
    }
}