package edu.kiet.www.mywebapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView mywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebview = findViewById(R.id.mywebview);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.loadUrl("file:///android_asset/index.html");
        mywebview.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (mywebview.canGoBack()) {
            mywebview.goBack();
        } else {

            super.onBackPressed();
        }
    }
}