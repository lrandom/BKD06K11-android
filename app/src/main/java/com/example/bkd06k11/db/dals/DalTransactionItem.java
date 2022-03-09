package com.example.bkd06k11.db.dals;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.bkd06k11.db.SqliteHelper;
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
        this.sqLiteDatabase.insert("tb_transactions", null, contentValues);
    }


    public ArrayList<TransactionItem> getTransactionItems(String fromDate, String toDate) {
        ArrayList<TransactionItem> transactionItems = new ArrayList<>();
        String query = "SELECT * FROM tb_transactions";
        if (fromDate != null && toDate != null) {
            query += " WHERE dt BETWEEN '" + fromDate + "' AND '" + toDate + "'";
        }
        Cursor cursor = this.sqLiteDatabase.rawQuery(query, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") long id = cursor.getLong(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String purpose = cursor.getString(cursor.getColumnIndex("purpose"));
                @SuppressLint("Range") Double amount = cursor.getDouble(cursor.getColumnIndex("amount"));
                @SuppressLint("Range") Integer isPlus = cursor.getInt(cursor.getColumnIndex("plus"));
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

    //lấy về tổng chi
    @SuppressLint("Range")
    public double getTotalSpend(String fromDate, String toDate) {
        String sql = "SELECT SUM(amount) AS total_amount FROM tb_transactions WHERE plus=0";
        if (fromDate != null && toDate != null) {
            sql += " AND (dt BETWEEN '" + fromDate + "' AND '" + toDate + "')";
        }
        Cursor cursor = this.sqLiteDatabase.rawQuery(sql, null);
        Double totalAmount = 0.0;
        if (cursor.moveToFirst()) {
            totalAmount = cursor.getDouble(cursor.getColumnIndex("total_amount"));
        }
        return totalAmount;
    }

    //lấy về tổng thu
    @SuppressLint("Range")
    public double getTotalCollect(String fromDate, String toDate) {
        String sql = "SELECT SUM(amount) AS total_amount FROM tb_transactions WHERE plus=1";
        if (fromDate != null && toDate != null) {
            sql += " AND (dt BETWEEN '" + fromDate + "' AND '" + toDate + "')";
        }
        Cursor cursor = this.sqLiteDatabase.rawQuery(sql, null);
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
