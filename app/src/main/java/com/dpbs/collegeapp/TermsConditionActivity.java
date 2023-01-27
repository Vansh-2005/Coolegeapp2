package com.dpbs.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class TermsConditionActivity extends AppCompatActivity {
    WebView webView;
    private ProgressBar progressBar;
   // public String fileName = "te&co.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_condition);
        getSupportActionBar().setTitle("Terms & Condition");

        progressBar =findViewById(R.id.tcProgress);
        progressBar.setMax(100);

        webView = (WebView) findViewById(R.id.terms_condition);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Html%20Files%2Fte%26co.html?alt=media&token=8502e749-6c31-4ad5-9af5-ab1d8650d0a6");
        //webView.loadUrl("file:///android_asset/"+fileName);

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }
        });
    }
}