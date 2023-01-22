package com.dpbs.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PrivacyPolicyActivity extends AppCompatActivity {
    WebView webView;
   // public String fileName = "te&co.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        getSupportActionBar().setTitle("Privacy & Policy");
        webView = (WebView) findViewById(R.id.privacy);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Html%20Files%2Fprivacy.html?alt=media&token=97c06e59-a09b-4a48-ae1e-82a5864e049a");
        // webView.loadUrl("file:///android_asset/"+fileName);

    }
}