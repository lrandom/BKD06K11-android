package com.example.bkd06k11.db.dals;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bkd06k11.db.SqliteHelper;
import com.example.bkd06k11.models.Note;

import java.util.ArrayList;

public class DalNote {
    private SQLiteDatabase sqLiteDatabase;

    public DalNote(Context context) {
        SqliteHelper sqliteHelper = new SqliteHelper(context);
        this.sqLiteDatabase = sqliteHelper.getWritableDatabase();
    }

    public void addNote(String title, String content) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("content", content);
        this.sqLiteDatabase.insert("notes", null, contentValues);
    }

    public void updateNote(Long id, String title, String content) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("content", content);
        this.sqLiteDatabase.update("notes", contentValues, "id =" + id, null);
    }

    public void deleteNote(Long id) {
        this.sqLiteDatabase.delete("notes", "id =" + id, null);
    }

    public ArrayList<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        Cursor cursor = this.sqLiteDatabase.rawQuery("SELECT * FROM notes", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") long id = cursor.getLong(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("title"));
                @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex("content"));
                Note note = new Note();
                note.setId(id);
                note.setTitle(title);
                note.setContent(content);
                notes.add(note);
            } while (cursor.moveToNext());
        }
        return notes;
    }

    void close() {
        if (this.sqLiteDatabase != null) {
            this.sqLiteDatabase.close();
        }
    }
}
