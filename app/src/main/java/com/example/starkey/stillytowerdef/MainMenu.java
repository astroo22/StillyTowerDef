package com.example.starkey.stillytowerdef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button buttonGame;
    private Button buttonLeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        buttonGame = (Button)findViewById(R.id.buttonGame);
        buttonLeader = (Button)findViewById(R.id.buttonLeader);

    }

    public void onClickGame(View v){
            Intent intent = new Intent (getApplicationContext(), MainActivity.class);
            startActivity(intent);
    }

    public void onClickLeader(View v){

    }
}
