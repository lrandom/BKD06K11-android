package com.example.bkd06k11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Session10 extends AppCompatActivity {
    Button btnOpenContextMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session10);
        btnOpenContextMenu = findViewById(R.id.btnOpenContextMenu);
        registerForContextMenu(btnOpenContextMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_add:
                //phản ứng lại khi người dùng tap add item
                Toast.makeText(Session10.this, "Bạn đã chọn add", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_edit:
                Toast.makeText(Session10.this, "Bạn đã chọn edit", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_delete:
                Toast.makeText(Session10.this, "Bạn đã chọn delete", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.float_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_add:
                Toast.makeText(Session10.this, "Bạn đã chọn add", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_edit:
                Toast.makeText(Session10.this, "Bạn đã chọn edit", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_share:
                Toast.makeText(Session10.this, "Bạn đã chọn share", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}