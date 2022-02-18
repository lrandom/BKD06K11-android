package com.example.bkd06k11.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper {
    public SqliteHelper(@Nullable Context context) {
        super(context, "my-db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE notes(\n" +
                "     id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t title TEXT(200),\n" +
                "\t content TEXT(1000)\n" +
                ") ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notes");
    }
}
