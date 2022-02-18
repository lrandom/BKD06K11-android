package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        rcListNote.setAdapter(noteAdapter);
        rcListNote.setLayoutManager(new LinearLayoutManager(ListNoteActivity.this,
                RecyclerView.VERTICAL, false
                ));
        dalNote = new DalNote(ListNoteActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Note> notes  = dalNote.getNotes();
        for (Note note: notes
             ) {
            this.notes.add(note);
        }
        noteAdapter.notifyDataSetChanged();
    }
}