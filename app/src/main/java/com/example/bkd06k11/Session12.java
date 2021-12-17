package com.example.bkd06k11;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Session12 extends AppCompatActivity {
    ProgressBar progressBar;
    TextView tvNotify;
    ImageView imgView;
    Button btnStartDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session12);
        progressBar = findViewById(R.id.progressBar);
        tvNotify = findViewById(R.id.tvNotify);
        imgView = findViewById(R.id.imageView);
        btnStartDownload = findViewById(R.id.btnStartDownload);
        btnStartDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();
            }
        });
    }

    void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                //chưa đc cấp quyền
                //yêu cầu người dùng cáp quyền ghi
                requestPermissions(new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 2);
            } else {
                new ImageDownloadAsyncTask("https://www.teahub.io/photos/full/10-106526_download-free-nature-wallpapers-for-mobile-phones-wallpapers.jpg").execute();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==2){
            //hiểu là phản hồi của người dùng từ yêu cầu cấp quyền có mã request code là 2
            if (grantResults.length > 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    new ImageDownloadAsyncTask("https://www.teahub.io/photos/full/10-106526_download-free-nature-wallpapers-for-mobile-phones-wallpapers.jpg").execute();
                }
            }
        }
    }

    public class ImageDownloadAsyncTask extends AsyncTask<Void, Long, File> {
        private String fileUrl;

        public ImageDownloadAsyncTask(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected File doInBackground(Void... voids) {
            try {
                URL url = new URL(this.fileUrl);
                URLConnection urlConnection = url.openConnection();
                long fileSize = urlConnection.getContentLengthLong();//trả về độ dài file dưới dạng byte
                InputStream inputStream = urlConnection.getInputStream();
                FileOutputStream fos = new FileOutputStream(
                        new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                                "anh.jpg"));

                byte[] myBytes = new byte[1024 * 4];
                int count = 0;
                int readingCounter = 0;
                while ((count = inputStream.read(myBytes)) != -1) {
                    fos.write(myBytes, 0, count);
                    readingCounter += count;
                    long percent = (readingCounter / fileSize) * 100; //phần trăm download đc là bn
                    publishProgress(percent);
                }
                return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                        "anh.jpg");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvNotify.setText("Bắt đầu download");
        }

        @Override
        protected void onPostExecute(File file) {
            super.onPostExecute(file);
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            imgView.setImageBitmap(bitmap);
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
        }
    }
}
