package com.example.bkd06k11.db.dals;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.bkd06k11.db.SqliteHelper;
import com.example.bkd06k11.models.Note;
import com.example.bkd06k11.models.TransactionItem;

import java.util.ArrayList;

public class DalTransactionItem {
    private SQLiteDatabase sqLiteDatabase;

    public DalTransactionItem(Context context) {
        SqliteHelper sqliteHelper = new SqliteHelper(context);
        this.sqLiteDatabase = sqliteHelper.getWritableDatabase();
    }

    public void addTransactionItem(String purpose, double amount, int isPlus, String dt) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("purpose", purpose);
        contentValues.put("amount", amount);
        contentValues.put("plus", isPlus);
        contentValues.put("dt", dt);
        Log.w("TEST", dt);
        this.sqLiteDatabase.insert("tb_transactions", null, contentValues);
    }

    public void updateTransactionItem(Long id, String purpose, double amount, int isPlus, String dt) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("purpose", purpose);
        contentValues.put("amount", amount);
        contentValues.put("isPlus", isPlus);
        contentValues.put("dt", dt);
        this.sqLiteDatabase.update("tb_transactions", contentValues, "id =" + id, null);
    }

    public void deleteTransactionItem(Long id) {
        this.sqLiteDatabase.delete("tb_transactions", "id =" + id, null);
    }

    public ArrayList<TransactionItem> getTransactionItems() {
        ArrayList<TransactionItem> transactionItems = new ArrayList<>();
        Cursor cursor = this.sqLiteDatabase.rawQuery("SELECT * FROM tb_transactions", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") long id = cursor.getLong(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String purpose = cursor.getString(cursor.getColumnIndex("purpose"));
                @SuppressLint("Range") Double amount = cursor.getDouble(cursor.getColumnIndex("double"));
                @SuppressLint("Range") Integer isPlus = cursor.getInt(cursor.getColumnIndex("isPlus"));
                @SuppressLint("Range") String dt = cursor.getString(cursor.getColumnIndex("dt"));
                TransactionItem transactionItem = new TransactionItem();
                transactionItem.setAmount(amount);
                transactionItem.setId(id);
                transactionItem.setPlus(isPlus);
                transactionItem.setDateTime(dt);
                transactionItem.setPurpose(purpose);
                transactionItems.add(transactionItem);
            } while (cursor.moveToNext());
        }
        return transactionItems;
    }

    public TransactionItem findById(Long id) {
        TransactionItem transactionItem = new TransactionItem();
        Cursor cursor = this.sqLiteDatabase.rawQuery("SELECT * FROM tb_transactions WHERE id=" + id, null);
        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String purpose = cursor.getString(cursor.getColumnIndex("purpose"));
            @SuppressLint("Range") Double amount = cursor.getDouble(cursor.getColumnIndex("double"));
            @SuppressLint("Range") Integer isPlus = cursor.getInt(cursor.getColumnIndex("isPlus"));
            @SuppressLint("Range") String dt = cursor.getString(cursor.getColumnIndex("dt"));
            transactionItem.setAmount(amount);
            transactionItem.setId(id);
            transactionItem.setPlus(isPlus);
            transactionItem.setDateTime(dt);
            transactionItem.setPurpose(purpose);
        }
        return transactionItem;
    }

    //lấy về tổng chi
    @SuppressLint("Range")
    public double getTotalSpend() {
        Cursor cursor = this.sqLiteDatabase.rawQuery("SELECT SUM(amount) AS total_amount FROM tb_transactions WHERE plus=0", null);
        Double totalAmount = 0.0;
        if (cursor.moveToFirst()) {
            totalAmount = cursor.getDouble(cursor.getColumnIndex("total_amount"));
        }
        return totalAmount;
    }

    //lấy về tổng thu
    @SuppressLint("Range")
    public double getTotalCollect() {
        Cursor cursor = this.sqLiteDatabase.rawQuery("SELECT SUM(amount) AS total_amount FROM tb_transactions WHERE plus=1", null);
        Double totalAmount = 0.0;
        if (cursor.moveToFirst()) {
            totalAmount = cursor.getDouble(cursor.getColumnIndex("total_amount"));
        }
        return totalAmount;
    }

    public void close() {
        if (this.sqLiteDatabase != null) {
            this.sqLiteDatabase.close();
        }
    }
}
