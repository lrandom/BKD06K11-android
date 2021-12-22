package com.example.bkd06k11.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkd06k11.R;
import com.example.bkd06k11.domains.Country;
import com.example.bkd06k11.domains.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Employee> employees = new ArrayList<>();
    public static String TAG = "EmployeeAdapter";
    public AdapterCountry.MyItemClickListener myItemClickListener;

    public EmployeeAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.employees = employees;
    }


    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder,
                                 int position) {
        Employee employee = employees.get(position);
        holder.tvId.setText(employee.getId());
        holder.tvName.setText(employee.getName());
        holder.tvAddress.setText(employee.getAddress());
        holder.tvSalary.setText(employee.getSalary());
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.item_employee, parent, false);
        EmployeeViewHolder myViewHolder = new EmployeeAdapter.EmployeeViewHolder(v);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return this.employees.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvName;
        TextView tvAddress;
        TextView tvSalary;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvId = itemView.findViewById(R.id.tvId);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.tvAddress = itemView.findViewById(R.id.tvAddress);
            this.tvSalary = itemView.findViewById(R.id.tvSalary);
        }
    }
}
