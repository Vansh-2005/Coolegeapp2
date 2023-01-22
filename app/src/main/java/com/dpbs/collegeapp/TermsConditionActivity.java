package com.dpbs.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class TermsConditionActivity extends AppCompatActivity {
    WebView webView;
   // public String fileName = "te&co.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_condition);
        getSupportActionBar().setTitle("Terms & Condition");
        webView = (WebView) findViewById(R.id.terms_condition);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Html%20Files%2Fte%26co.html?alt=media&token=8502e749-6c31-4ad5-9af5-ab1d8650d0a6");
        //webView.loadUrl("file:///android_asset/"+fileName);
    }
}