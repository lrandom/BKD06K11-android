package com.example.bkd06k11.services;

import com.example.bkd06k11.domains.Employee;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("GetData.php")
    Call<ArrayList<Employee>> getEmployees();
}
