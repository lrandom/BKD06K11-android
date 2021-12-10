package com.example.bkd06k11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Session10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session10);
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
}