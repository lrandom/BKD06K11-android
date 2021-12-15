package com.example.bkd06k11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bkd06k11.adapters.AdapterCountry;
import com.example.bkd06k11.domains.Country;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView rcCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rcCountry = findViewById(R.id.rcCountry);
        ArrayList<Country> countries = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            countries.add(new Country("Country " + i));
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecyclerViewActivity.this, LinearLayoutManager.VERTICAL, true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(RecyclerViewActivity.this, 3, LinearLayoutManager.VERTICAL, false);
        rcCountry.setLayoutManager(linearLayoutManager);
        AdapterCountry adapterCountry = new AdapterCountry(RecyclerViewActivity.this, countries);
        adapterCountry.setOnItemClickListener(new AdapterCountry.MyItemClickListener() {
            @Override
            public void itemClick(View ew, int position) {
                Toast.makeText(RecyclerViewActivity.this,
                        countries.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });


        rcCountry.setAdapter(adapterCountry);
    }
}