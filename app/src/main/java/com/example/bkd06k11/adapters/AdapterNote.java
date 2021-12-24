package com.example.bkd06k11.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkd06k11.R;
import com.example.bkd06k11.activities.ActivityAddNote;
import com.example.bkd06k11.services.ApiService;
import com.example.bkd06k11.services.RestClient;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterNote extends RecyclerView.Adapter<com.example.bkd06k11.adapters.AdapterNote.EmployeeViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<com.example.bkd06k11.domains.Note> notes = new ArrayList<>();
    public static String TAG = "AdapterNote";
    //public com.example.bkd06k11.adapters.AdapterCountry.MyItemClickListener myItemClickListener;

    public AdapterNote(Context context, ArrayList<com.example.bkd06k11.domains.Note> notes) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.notes = notes;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.bkd06k11.adapters.AdapterNote.EmployeeViewHolder holder,
                                 int position) {
        com.example.bkd06k11.domains.Note note = notes.get(position);
        holder.tvTitle.setText(note.getTitle());
        holder.btnMenu.setTag(note.getId());
        holder.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        String idOfNote = (String) v.getTag();
                        switch (id) {
                            case R.id.item_delete:
                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setTitle(R.string.alert);
                                builder.setMessage(R.string.confirm_delete);
                                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                                builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        System.out.println("Delete confirm");

                                        //chạy lệnh xoá
                                        ApiService apiService = RestClient.getApiService();
                                        Call<JSONObject> call = apiService.deleteNote(idOfNote );
                                        call.enqueue(new Callback<JSONObject>() {
                                            @Override
                                            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                                                Toast.makeText(context, R.string.add_successfully,
                                                        Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void onFailure(Call<JSONObject> call, Throwable t) {

                                            }
                                        });

                                    }
                                });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                                break;

                            case R.id.item_edit:
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @NonNull
    @Override
    public com.example.bkd06k11.adapters.AdapterNote.EmployeeViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.item_note, parent, false);
        com.example.bkd06k11.adapters.AdapterNote.EmployeeViewHolder myViewHolder = new com.example.bkd06k11.adapters.AdapterNote.EmployeeViewHolder(v);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageButton btnMenu;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            this.btnMenu = itemView.findViewById(R.id.btnMenu);

        }
    }
}

