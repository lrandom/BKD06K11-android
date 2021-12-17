package com.example.bkd06k11;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.bkd06k11.loader.DownloadImageLoader;

import java.io.File;

public class DemoAsyncTaskLoader extends AppCompatActivity implements LoaderManager.LoaderCallbacks<File> {
    private LoaderManager loaderManager;
    Button btnStartDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_async_task_loader);
        loaderManager = LoaderManager.getInstance(this);
        Loader<File> loader = this.loaderManager.initLoader(1, null, this);
        btnStartDownload = findViewById(R.id.btnStartDownload);
        btnStartDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loader.forceLoad();
            }
        });
    }

    @NonNull
    @Override
    public Loader<File> onCreateLoader(int id, @Nullable Bundle args) {
        if (id == 1) {
            return new DownloadImageLoader(DemoAsyncTaskLoader.this, "https://www.pixelstalk.net/wp-content/uploads/2016/09/3D-Nature-Images-Free-Download-HD.jpg");
        }
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<File> loader, File data) {
        if (loader.getId() == 1) {
            Bitmap bitmap = BitmapFactory.decodeFile(data.getAbsolutePath());
            ImageView imgView = findViewById(R.id.imageView);
            imgView.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<File> loader) {

    }
}