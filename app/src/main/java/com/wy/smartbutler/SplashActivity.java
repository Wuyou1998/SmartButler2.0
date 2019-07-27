package com.wy.smartbutler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.fullScreen);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
