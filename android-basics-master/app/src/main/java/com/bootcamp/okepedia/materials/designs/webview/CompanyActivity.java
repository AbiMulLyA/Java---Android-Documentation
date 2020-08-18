package com.bootcamp.okepedia.materials.designs.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.bootcamp.okepedia.R;

public class CompanyActivity extends AppCompatActivity {

    WebView wbCompany;
    ProgressBar pbLoading;

    private static final String urLCompany = "http://multidaya.id/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        pbLoading = findViewById(R.id.pbLoading);

        wbCompany = findViewById(R.id.wbCompany);
        wbCompany.getSettings().setLoadsImagesAutomatically(true);
        wbCompany.getSettings().setJavaScriptEnabled(true);
        wbCompany.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wbCompany.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                wbCompany.setVisibility(View.VISIBLE);
                pbLoading.setVisibility(View.GONE);

                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle("Multidaya Dinamika");
            }
        });
        wbCompany.loadUrl(urLCompany);
    }
}