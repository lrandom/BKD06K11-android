package com.example.bkd06k11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkd06k11.R;
import com.example.bkd06k11.helpers.Helpers;
import com.example.bkd06k11.models.TransactionItem;

import java.util.ArrayList;

public class StatementItemAdapter extends RecyclerView.Adapter<StatementItemAdapter.StatementItemHolder> {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<TransactionItem> notes = new ArrayList<>();
    public static String TAG = "NoteAdapter";
    // public NoteAdapter.MyItemClickListener myItemClickListener;
    NoteAdapter.OnDeleteButtonClick onDeleteButtonClick;
    NoteAdapter.OnUpdateButtonClick onUpdateButtonClick;

    public StatementItemAdapter(Context context, ArrayList<TransactionItem> notes) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.notes = notes;
    }


    @Override
    public void onBindViewHolder(@NonNull StatementItemAdapter.StatementItemHolder holder,
                                 int position) {
        TransactionItem transactionItem = notes.get(position);
        holder.tvAmount.setText(Helpers.formatCurrency(transactionItem.getAmount()));
        holder.tvPurpose.setText(transactionItem.getPurpose());
    }


    @NonNull
    @Override
    public StatementItemAdapter.StatementItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.statement_item, parent, false);
        StatementItemAdapter.StatementItemHolder myViewHolder = new StatementItemAdapter.StatementItemHolder(v);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class StatementItemHolder extends RecyclerView.ViewHolder {
        TextView tvPurpose, tvAmount;

        public StatementItemHolder(@NonNull View itemView) {
            super(itemView);
            this.tvPurpose = itemView.findViewById(R.id.tvPurpose);
            this.tvAmount = itemView.findViewById(R.id.tvAmount);
        }
    }
}


