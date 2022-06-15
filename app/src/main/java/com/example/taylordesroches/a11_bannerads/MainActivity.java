package com.example.taylordesroches.a11_bannerads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize MobileAds onCreate
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        // Setup the Banner Ad
        adView = findViewById(R.id.adView);
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        adRequestBuilder.addKeyword("fitness");
        adRequestBuilder.addKeyword("workout");
        adView.loadAd(adRequestBuilder.build());
    }

    @Override
    protected void onPause() {
        if (adView != null)
            adView.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adView != null)
            adView.resume();
    }

    @Override
    protected void onDestroy() {
        if (adView != null)
            adView.destroy();
        super.onDestroy();
    }
}