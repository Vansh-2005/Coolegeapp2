package com.dpbs.collegeapp.Pdf;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.load.model.FileLoader;
import com.dpbs.collegeapp.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfViewActivity extends AppCompatActivity {

    private String url;
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("PDF View");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        url = getIntent().getStringExtra("pdfUrl");
        pdfView = findViewById(R.id.pdfView);

        new PdfDownload().execute(url);
//        loadFile(url);

    }

    private  class PdfDownload extends AsyncTask<String,Void, InputStream>{

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


                if (urlConnection.getResponseCode()==200){
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }

    }


//    private void loadFile(String url) {
//        FileLoader.with(this)
//                .load(url)
//                .fromDirectory("test4", FileLoader.DIR_INTERNAL)
//                .asFile(new FileRequestListener<File>() {
//                    @Override
//                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {
//                        File loadedFile = response.getBody();
//                        progressBar.setVisibility(View.GONE);
//                        pdfView.fromFile(loadedFile)
//                                .password(null)
//                                .defaultPage(0)
//                                .enableSwipe(true)
//                                .swipeHorizontal(false)
//                                .enableDoubletap(true)
//                                .spacing(5)
//                                .load();
//                    }
//
//                    @Override
//                    public void onError(FileLoadRequest request, Throwable t) {
//                        Toast.makeText(PdfViewActivity.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
//                        progressBar.setVisibility(View.GONE);
//                    }
//                });
//    }

}