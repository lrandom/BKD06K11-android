package com.example.bkd06k11.loader;

import android.content.Context;
import android.os.Build;
import android.os.Environment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImageLoader extends AsyncTaskLoader<File> {
    private String fileUrl;
    public DownloadImageLoader(@NonNull Context context, String fileUrl) {
        super(context);
        this.fileUrl = fileUrl;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public File loadInBackground() {
        try {
            URL url = new URL(this.fileUrl);
            URLConnection urlConnection = url.openConnection();
            long fileSize = urlConnection.getContentLengthLong();//trả về độ dài file dưới dạng byte
            InputStream inputStream = urlConnection.getInputStream();
            FileOutputStream fos = new FileOutputStream(
                    new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                            "anh_1.jpg"));

            byte[] myBytes = new byte[1024 * 4];
            int count = 0;
            int readingCounter = 0;
            while ((count = inputStream.read(myBytes)) != -1) {
                fos.write(myBytes, 0, count);
                readingCounter += count;
                long percent = (readingCounter / fileSize) * 100; //phần trăm download đc là bn
            }
            return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                    "anh_1.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
