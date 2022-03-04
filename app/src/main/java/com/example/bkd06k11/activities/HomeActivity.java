package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bkd06k11.R;
import com.example.bkd06k11.adapter.StatementItemAdapter;
import com.example.bkd06k11.db.dals.DalTransactionItem;
import com.example.bkd06k11.helpers.Helpers;
import com.example.bkd06k11.models.TransactionItem;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;

public class HomeActivity extends AppCompatActivity {
    TextView tvTotalCollect, tvTotalSpent;
    DalTransactionItem dalTransactionItem;
    RecyclerView recyclerView;
    StatementItemAdapter statementItemAdapter;
    ArrayList<TransactionItem> transactionItems = new ArrayList<>();

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
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<TransactionItem> transactionItemsFromDb = dalTransactionItem.getTransactionItems();


        Double totalCollect = dalTransactionItem.getTotalCollect();
        Double totalSpent = dalTransactionItem.getTotalSpend();

        tvTotalCollect.setText(Helpers.formatCurrency(totalCollect));
        tvTotalSpent.setText(Helpers.formatCurrency(totalSpent));
    }

    public void goToAddAmountActivity(View view) {
        Intent intent = new Intent(HomeActivity.this, AddAmountActivity.class);
        startActivity(intent);
    }
}