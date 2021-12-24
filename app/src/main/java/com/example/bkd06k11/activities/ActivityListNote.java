package com.example.bkd06k11.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bkd06k11.R;
import com.example.bkd06k11.adapters.AdapterNote;
import com.example.bkd06k11.domains.Note;
import com.example.bkd06k11.services.ApiService;
import com.example.bkd06k11.services.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityListNote extends AppCompatActivity {
    AdapterNote adapterNote;
    ArrayList<Note> notes = new ArrayList<>();
    RecyclerView rcListNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_note);
        rcListNote = findViewById(R.id.rcListNote);
        adapterNote = new AdapterNote(this, notes);
        LinearLayoutManager lln = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcListNote.setLayoutManager(lln);
        rcListNote.setAdapter(adapterNote);
    }

    @Override
    protected void onResume() {
        super.onResume();
        notes.clear();
        ApiService apiService = RestClient.getApiService();
        Call<ArrayList<Note>> call = apiService.getNotes();
        call.enqueue(new Callback<ArrayList<Note>>() {
            @Override
            public void onResponse(Call<ArrayList<Note>> call, Response<ArrayList<Note>> response) {
                ArrayList<Note> tmpNotes = response.body();
                for (Note note : tmpNotes
                ) {
                    notes.add(note);
                }
                adapterNote.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Note>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_add) {
            Intent intent = new Intent(ActivityListNote.this, ActivityAddNote.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}