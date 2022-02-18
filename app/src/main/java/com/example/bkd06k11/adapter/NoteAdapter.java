package com.example.bkd06k11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkd06k11.R;
import com.example.bkd06k11.models.Note;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Note> notes = new ArrayList<>();
    public static String TAG = "NoteAdapter";
    // public NoteAdapter.MyItemClickListener myItemClickListener;

    public NoteAdapter(Context context, ArrayList<Note> notes) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.notes = notes;
    }


    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteViewHolder holder,
                                 int position) {
        Note note = notes.get(position);
        holder.tvTitle.setText(note.getTitle());
     /*   holder.tvId.setText(employee.getId());
        holder.tvName.setText(employee.getName());
        holder.tvAddress.setText(employee.getAddress());
        holder.tvSalary.setText(employee.getSalary());*/
    }

    @NonNull
    @Override
    public NoteAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.note_item, parent, false);
        NoteAdapter.NoteViewHolder myViewHolder = new NoteAdapter.NoteViewHolder(v);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}

