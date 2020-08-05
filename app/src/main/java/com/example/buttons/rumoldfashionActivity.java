package com.example.buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class rumoldfashionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumoldfashion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}