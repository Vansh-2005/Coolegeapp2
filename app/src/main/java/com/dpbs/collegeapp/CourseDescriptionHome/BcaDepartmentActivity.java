package com.dpbs.collegeapp.CourseDescriptionHome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.dpbs.collegeapp.R;

public class BcaDepartmentActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bca_department);
        getSupportActionBar().setTitle("");

        webView = (WebView)findViewById(R.id.bcaCourse);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Html%20Files%2FBca.html?alt=media&token=9231b9f8-70fc-4174-90b0-5dbdfdc3af1a");

    }
}