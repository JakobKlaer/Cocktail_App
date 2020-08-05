package com.example.buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SazeracActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sazerac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}