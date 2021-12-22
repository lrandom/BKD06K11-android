package com.example.bkd06k11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.bkd06k11.adapters.EmployeeAdapter;
import com.example.bkd06k11.domains.Employee;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ActivityListEmployee extends AppCompatActivity {
    RecyclerView rcListEmployee;
    ArrayList<Employee> employees = new ArrayList<>();
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employee);
        new LoadEmployeeAsyncTask("http://192.168.1.5/employee_services/GetData.php").execute();
        rcListEmployee = findViewById(R.id.rcEmployee);

        adapter = new EmployeeAdapter(ActivityListEmployee.this, employees);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ActivityListEmployee.this, LinearLayoutManager.VERTICAL, false);
        rcListEmployee.setLayoutManager(linearLayoutManager);
        rcListEmployee.setAdapter(adapter);
    }

    public class LoadEmployeeAsyncTask extends AsyncTask<Void, Long, String> {
        String url;

        public LoadEmployeeAsyncTask(String url) {
            this.url = url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(this.url);
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                String line = null;
                StringBuilder builder = new StringBuilder();
                BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(inputStream));
                while ((line = inputStreamReader.readLine()) != null) {
                    //tiếp tục đọc
                    builder.append(line + "\n");
                }
                return builder.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //nhận dữ liệu
            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    System.out.println(jsonObject.getString("name"));
                    System.out.println(jsonObject.getString("address"));

                    String name = jsonObject.getString("name");
                    String address = jsonObject.getString("address");
                    String salary = jsonObject.getString("salary");
                    String id = jsonObject.getString("id");
                    Employee employee = new Employee(id, name, address, salary);
                    employees.add(employee);
                }
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}