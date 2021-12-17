package com.example.bkd06k11.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkd06k11.R;
import com.example.bkd06k11.RecyclerViewActivity;
import com.example.bkd06k11.Session10;
import com.example.bkd06k11.domains.Country;

import java.util.ArrayList;

public class AdapterCountry extends RecyclerView.Adapter<AdapterCountry.MyViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Country> countries = new ArrayList<>();
    public static String TAG = "AdapterCountry";
    public MyItemClickListener myItemClickListener;

    public AdapterCountry(Context context, ArrayList<Country> countries) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.countries = countries;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.item_country, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.tvName.setText(country.getName());
        holder.btnOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setTag(country);
                _showPopupMenu(v);
            }
        });
    }

    private void _showPopupMenu(View v) {
        Country country = (Country) v.getTag();
        PopupMenu popupMenu = new PopupMenu(context, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        //xử lý khi tap vào item menu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu_1:
                        Toast.makeText(context, "Bạn đã chọn xoá"+country.getName(), Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.item_menu_2:
                        Toast.makeText(context, "Bạn đã chọn sửa"+country.getName(), Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public int getItemCount() {
        return this.countries.size();
    }

    public interface MyItemClickListener {
        public void itemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageButton btnOpenMenu;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.btnOpenMenu = itemView.findViewById(R.id.btnOpenMenu);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent intent = new Intent(RecyclerViewActivity.this, Session10.class);
                    //context.startActivity(intent);
                    Log.d(TAG, "onClick: ");
                    myItemClickListener.itemClick(itemView, getAdapterPosition());
                }
            });
        }
    }

    public void setOnItemClickListener(MyItemClickListener clickListener) {
        this.myItemClickListener = clickListener;
    }
}
