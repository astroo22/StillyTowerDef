package com.example.starkey.stillytowerdef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LeaderBoard extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference dref;
    DatabaseReference rootRef;
    private Firebase mRef;
    private ListView mListView;
    private ArrayList<String> mUsernames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leader_board);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = (ListView)findViewById(R.id.listView1);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mUsernames);
        mListView.setAdapter(arrayAdapter);

        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://stillytower.firebaseio.com/Users");


        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> names = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String username = ds.child("Username").getValue(String.class);
                    String hiscore = ds.child("HighScore").getValue(String.class);
                    int counter = 0;

                    mUsernames.add((counter+1 + " ") + username + ": " +  hiscore);
                    arrayAdapter.notifyDataSetChanged();



                    //String password = ds.child("Password").getValue(String.class);
                    //mUsernames.add(hiscore);
                    //arrayAdapter.notifyDataSetChanged();
                    Log.d("TAG", username + "/" + "/" + hiscore);
                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });
    }
}



        /*mRef = new Firebase("https://stillytower.firebaseio.com/Users");

        mListView = (ListView)findViewById(R.id.list1);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mUsernames);

        mListView.setAdapter(arrayAdapter);

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                mUsernames.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/
