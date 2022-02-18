package com.example.bkd06k11.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.bkd06k11.R;
import com.example.bkd06k11.adapter.NoteAdapter;
import com.example.bkd06k11.db.dals.DalNote;
import com.example.bkd06k11.models.Note;

import java.util.ArrayList;

public class ListNoteActivity extends AppCompatActivity {
    RecyclerView rcListNote;
    NoteAdapter noteAdapter;
    DalNote dalNote;
    ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_note);
        rcListNote = findViewById(R.id.rcListNote);
        noteAdapter = new NoteAdapter(ListNoteActivity.this, notes);
        noteAdapter.setOnDeleteItem(new NoteAdapter.OnDeleteButtonClick() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void deleteItem(Long id) {
                //xoá ở đây
                dalNote.deleteNote(id);
                Note note = notes.stream().filter(item -> item.getId() == id).findFirst().get();
                notes.remove(note);
                noteAdapter.notifyDataSetChanged();
            }
        });
        noteAdapter.setOnUpdateItem(new NoteAdapter.OnUpdateButtonClick() {
            @Override
            public void updateItem(Long id) {
                Intent intent = new Intent(ListNoteActivity.this, UpdateNoteActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        rcListNote.setAdapter(noteAdapter);
        rcListNote.setLayoutManager(new LinearLayoutManager(ListNoteActivity.this,
                RecyclerView.VERTICAL, false
        ));
        dalNote = new DalNote(ListNoteActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.notes.clear();

        ArrayList<Note> notes = dalNote.getNotes();
        for (Note note : notes
        ) {
            this.notes.add(note);
        }
        noteAdapter.notifyDataSetChanged();
    }

    public void goToAddNoteActivity(View view) {
        Intent intent = new Intent(ListNoteActivity.this, AddNoteActivity.class);
        startActivity(intent);
    }
}