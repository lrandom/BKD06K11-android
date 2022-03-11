package com.example.bkd06k11.services;


import com.example.bkd06k11.models.DataNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/v2/everything?apiKey=33426eaf1f124fe0b7c3eb9277daa942")
    Call<DataNews> getDataNews(@Query("q") String q);
}
