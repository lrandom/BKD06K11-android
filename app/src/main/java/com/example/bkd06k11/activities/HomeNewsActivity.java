package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

import com.example.bkd06k11.R;
import com.example.bkd06k11.adapter.NewsAdapter;
import com.example.bkd06k11.models.Article;
import com.example.bkd06k11.models.DataNews;
import com.example.bkd06k11.services.ApiService;
import com.example.bkd06k11.services.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeNewsActivity extends AppCompatActivity {
    ArrayList<Article> articles = new ArrayList<>();
    NewsAdapter newsAdapter;
    RecyclerView recyclerView;
    String query = "economics";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_news);
        recyclerView = findViewById(R.id.rcListNews);
        newsAdapter = new NewsAdapter(HomeNewsActivity.this, articles);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeNewsActivity.this
                , RecyclerView.VERTICAL, false));
        newsAdapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Article article = articles.get(position);
                Intent intent = new Intent(HomeNewsActivity.this, ActivityDetail.class);
                intent.putExtra("ARTICLE", article);
                startActivity(intent);
            }
        });

        handleIntent();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void handleIntent() {
        ApiService apiService = RestClient.getApiService();
        Call<DataNews> call = apiService.getDataNews(query);
        call.enqueue(new Callback<DataNews>() {
            @Override
            public void onResponse(Call<DataNews> call, Response<DataNews> response) {
                DataNews dataNews = response.body();
                ArrayList<Article> responseArticles = dataNews.getArticles();
                articles.clear();
                for (Article article : responseArticles
                ) {
                    articles.add(article);
                }
                newsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DataNews> call, Throwable t) {

            }
        });
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        query = intent.getStringExtra(SearchManager.QUERY);
        System.out.println(query);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);
            System.out.println(query);
            handleIntent();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.news_menu_item, menu);


        ///LK cấu hình searchable với searchview
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.seach).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
}