package com.example.starkey.stillytowerdef;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class spinner extends Activity implements OnItemSelectedListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Choose an option:");
        categories.add("Start Game");
        categories.add("LeaderBoard");
        categories.add("Exit");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //MainActivity ma = MainActivity.instance;

        //SurfaceHolder surfaceHolder = ;
        if (requestCode == 1) {
            if(resultCode == SpawnManager.RESULT_OK){

                System.out.println("got here??????");
                Toast.makeText(this, "User Finished Game", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_popup_score);


            }
            if (resultCode == SpawnManager.RESULT_CANCELED) {

                Toast.makeText(this, "User Left Mid-Game", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        //String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item

        //Taha: instead add an intent to the activity that you want to send the user to
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        final Intent intent;

        switch(position) {
            case 1:
                Intent i = new Intent (getApplicationContext(), MainActivity.class);
                startActivityForResult(i,1);
                break;
            case 2:
                intent = new Intent(spinner.this, LeaderBoard.class);
                startActivity(intent);
                break;
            case 3:

                System.exit(0);
        }



    }






    //Intent l = new Intent(this,MainActivity.class);














    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}