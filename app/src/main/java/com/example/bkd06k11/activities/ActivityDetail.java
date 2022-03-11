package com.example.bkd06k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.example.bkd06k11.R;
import com.example.bkd06k11.models.Article;

public class ActivityDetail extends AppCompatActivity {
    Article article;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        webView = findViewById(R.id.webView);
        article = (Article) getIntent().getSerializableExtra("ARTICLE");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(article.getUrl());
    }
}