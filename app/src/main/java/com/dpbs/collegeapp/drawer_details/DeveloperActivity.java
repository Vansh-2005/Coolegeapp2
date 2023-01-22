package com.dpbs.collegeapp.drawer_details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.dpbs.collegeapp.R;

public class DeveloperActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        getSupportActionBar().setTitle("");

        webView = (WebView) findViewById(R.id.developer);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Html%20Files%2Fdeveloper.html?alt=media&token=9c612bb0-b42b-4ad7-8d11-7a9b891dbcc6");
        // webView.loadUrl("file:///android_asset/"+fileName);
    }
}