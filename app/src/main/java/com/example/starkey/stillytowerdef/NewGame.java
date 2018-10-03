package com.example.starkey.stillytowerdef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
