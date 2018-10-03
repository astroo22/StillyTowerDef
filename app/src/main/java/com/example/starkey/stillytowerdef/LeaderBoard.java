package com.example.starkey.stillytowerdef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LeaderBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leader_board);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
