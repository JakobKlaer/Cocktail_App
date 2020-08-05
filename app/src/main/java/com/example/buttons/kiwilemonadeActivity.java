package com.example.buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class kiwilemonadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiwilemonade);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}