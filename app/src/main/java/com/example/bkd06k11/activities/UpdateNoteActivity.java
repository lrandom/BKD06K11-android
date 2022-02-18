package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bkd06k11.R;
import com.example.bkd06k11.db.dals.DalNote;
import com.example.bkd06k11.models.Note;

public class UpdateNoteActivity extends AppCompatActivity {
    EditText edtTitle, edtContent;
    Button btnUpdate;
    Long id;
    DalNote dalNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);
        id = getIntent().getLongExtra("id", 0);
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        btnUpdate = findViewById(R.id.btnUpdate);
        DalNote dalNote = new DalNote(UpdateNoteActivity.this);
        Note note = dalNote.findById(id);
        edtTitle.setText(note.getTitle());
        edtContent.setText(note.getContent());
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dalNote.updateNote(id, edtTitle.getText().toString(), edtContent.getText().toString());

            }
        });
    }
}