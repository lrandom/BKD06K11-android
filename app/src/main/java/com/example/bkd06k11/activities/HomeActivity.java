package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bkd06k11.R;
import com.example.bkd06k11.adapter.StatementItemAdapter;
import com.example.bkd06k11.db.dals.DalTransactionItem;
import com.example.bkd06k11.helpers.Helpers;
import com.example.bkd06k11.models.TransactionItem;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;

public class HomeActivity extends AppCompatActivity {
    TextView tvTotalCollect, tvTotalSpent;
    DalTransactionItem dalTransactionItem;
    RecyclerView recyclerView;
    StatementItemAdapter statementItemAdapter;
    ArrayList<TransactionItem> transactionItems = new ArrayList<>();
    EditText edtFromDate, edtToDate;
    String fromDate, toDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvTotalCollect = findViewById(R.id.tvTotalCollect);
        tvTotalSpent = findViewById(R.id.tvTotalSpent);
        recyclerView = findViewById(R.id.rcFinanceList);
        dalTransactionItem = new DalTransactionItem(HomeActivity.this);
        statementItemAdapter = new StatementItemAdapter(HomeActivity.this, transactionItems);
        recyclerView.setAdapter(statementItemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this, RecyclerView.VERTICAL, false));
        edtFromDate = findViewById(R.id.edtFromDate);
        edtToDate = findViewById(R.id.edtToDate);

        edtFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                new DatePickerDialog(HomeActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                int convertMonth = month + 1;
                                String sConvertMonth = convertMonth + "";

                                if (convertMonth < 10) {
                                    sConvertMonth = "0" + convertMonth;
                                }
                                int convertDayOfMonth = dayOfMonth;
                                String sConvertDayOfMonth = convertDayOfMonth + "";
                                if (convertDayOfMonth < 10) {
                                    sConvertDayOfMonth = "0" + convertDayOfMonth;
                                }
                                edtFromDate.setText(sConvertDayOfMonth + "-" + sConvertMonth + "-" + year);
                                fromDate = year + "-" + sConvertMonth + "-" + sConvertDayOfMonth;
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });

        edtToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                new DatePickerDialog(HomeActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                int convertMonth = month + 1;
                                String sConvertMonth = convertMonth + "";

                                if (convertMonth < 10) {
                                    sConvertMonth = "0" + convertMonth;
                                }
                                int convertDayOfMonth = dayOfMonth;
                                String sConvertDayOfMonth = convertDayOfMonth + "";
                                if (convertDayOfMonth < 10) {
                                    sConvertDayOfMonth = "0" + convertDayOfMonth;
                                }
                                edtToDate.setText(sConvertDayOfMonth + "-" + sConvertMonth + "-" + year);
                                toDate = year + "-" + sConvertMonth + "-" + sConvertDayOfMonth;

                                if (fromDate != null && toDate != null) {
                                    ArrayList<TransactionItem> transactionItemsFromDb =
                                            dalTransactionItem.getTransactionItems(fromDate, toDate);
                                    transactionItems.clear();

                                    for (TransactionItem transactionItem : transactionItemsFromDb) {
                                        transactionItems.add(transactionItem);
                                    }
                                    statementItemAdapter.notifyDataSetChanged();//cập nhật lại dữ liệu mới vào adapter -> view recyclerview

                                    updateCollectAndSpent();
                                }
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<TransactionItem> transactionItemsFromDb = dalTransactionItem.getTransactionItems(null, null);
        for (TransactionItem transactionItem : transactionItemsFromDb) {
            transactionItems.add(transactionItem);
        }
        statementItemAdapter.notifyDataSetChanged();//cập nhật lại dữ liệu mới vào adapter -> view recyclerview
        updateCollectAndSpent();
    }

    private void updateCollectAndSpent() {
        Double totalCollect = dalTransactionItem.getTotalCollect(fromDate, toDate);
        Double totalSpent = dalTransactionItem.getTotalSpend(fromDate, toDate);

        tvTotalCollect.setText(Helpers.formatCurrency(totalCollect));
        tvTotalSpent.setText(Helpers.formatCurrency(totalSpent));
    }

    public void goToAddAmountActivity(View view) {
        Intent intent = new Intent(HomeActivity.this, AddAmountActivity.class);
        startActivity(intent);
    }
}