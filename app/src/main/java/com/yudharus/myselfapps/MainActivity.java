package com.yudharus.myselfapps;

// Tanggal pengerjaan   : 4/6/2021
// NIM                  : 10118040
// NAMA                 :Moch Yudha Rusdian

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();

        //FontsOverride.setDefaultFont(this, "MONOSPACE", "rakkas_regular.otf");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Walkthrough.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}