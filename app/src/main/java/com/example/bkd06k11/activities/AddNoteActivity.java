package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bkd06k11.R;
import com.example.bkd06k11.db.dals.DalNote;

public class AddNoteActivity extends AppCompatActivity {
    EditText edtTitle, edtContent;
    Boolean isPlus = true;
    Button  btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);

        btnAdd = findViewById(R.id.btnSubmit);
        DalNote dalNote = new DalNote(AddNoteActivity.this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String content = edtContent.getText().toString();

                dalNote.addNote(title, content);
                //dalNote.close();
                edtTitle.setText("");
                edtContent.setText("");
            }
        });
    }
}