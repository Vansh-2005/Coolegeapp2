package com.dpbs.collegeapp.CourseDescriptionHome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.dpbs.collegeapp.R;

public class BcomDepartmentActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcom_department);
        getSupportActionBar().setTitle("");
        webView = (WebView)findViewById(R.id.bcomCourse);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("");
    }
}