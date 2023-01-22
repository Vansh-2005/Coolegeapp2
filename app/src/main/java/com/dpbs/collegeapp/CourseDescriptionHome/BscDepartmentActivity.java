package com.dpbs.collegeapp.CourseDescriptionHome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.dpbs.collegeapp.R;

public class BscDepartmentActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsc_department);
        getSupportActionBar().setTitle("");
        webView = (WebView)findViewById(R.id.bscCourse);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("");
    }
}