package com.example.starkey.stillytowerdef;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PopupScore extends Activity {
    private EditText editUsername;


    public void onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.activity_popup_score, null);

        builder.setView(v)
                .setTitle("You Lost")
                .setNegativeButton("Rage Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        editUsername = v.findViewById(R.id.enter_username);

        //return builder.create();


        final AlertDialog dialog = builder.create();
        dialog.show();


    }

        /*@Override
    protected void onCreate(View v) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_score);

        public void popUpScore(View v){

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
            View mView = getLayoutInflater().inflate(R.layout.activity_popup_score, null);
            final EditText enterUsername = (EditText) mView.findViewById(R.id.enter_username);
            Button submit = (Button) mView.findViewById(R.id.btn_submit);
            Button cancel = (Button) mView.findViewById(R.id.btn_cancel);


            mBuilder.setPositiveButton("submit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            mBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            mBuilder.setView(mView);
            final AlertDialog dialog = mBuilder.create();
            dialog.show();

            /*mLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()){
                        Toast.makeText(MainActivity.this,
                                R.string.success_login_msg,
                                Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }else{
                        Toast.makeText(MainActivity.this,
                                R.string.error_login_msg,
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }*/




}
