package com.example.bkd06k11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Session10 extends AppCompatActivity {
    Button btnOpenContextMenu, btnStartActionMode, btnOpenPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session10);
        btnOpenContextMenu = findViewById(R.id.btnOpenContextMenu);
        btnStartActionMode = findViewById(R.id.btnStartActionMode);
        btnOpenPopupMenu = findViewById(R.id.btnOpenPopupMenu);
        registerForContextMenu(btnOpenContextMenu);

        btnStartActionMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Session10.this.startActionMode(new ActionMode.Callback() {
                    @Override
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        MenuInflater menuInflater = getMenuInflater();
                        menuInflater.inflate(R.menu.context_action_bar_menu, menu);
                        return true;
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_share:
                                Toast.makeText(Session10.this, "you click share", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.item_note:
                                Toast.makeText(Session10.this, "you click note", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode mode) {

                    }
                });
                return false;
            }

        });
        btnOpenPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show popup mendu
                PopupMenu popupMenu = new PopupMenu(Session10.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                //xử lý khi tap vào item menu
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_menu_1:
                                Toast.makeText(Session10.this, "Bạn đã chọn 1", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.item_menu_2:
                                Toast.makeText(Session10.this, "Bạn đã chọn 2", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();

            }
        });
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