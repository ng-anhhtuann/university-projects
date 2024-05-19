package com.example.lab1_1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Lab51Activity extends AppCompatActivity {
    int[] image = {R.mipmap.uk, R.mipmap.sun, R.mipmap.rocket, R.mipmap.ptr, R.mipmap.noti, R.mipmap.moun, R.mipmap.ld, R.mipmap.grw};

    String[] version = {"Android United Kingdom", " Android Sun", "Android Rocket", "Android Ptr", "Android Notification", "Android Mountain", "Android LD", "Android GRW"};

    String[] numVersion = {"1.0", "1.1", "1.2", "2.0", "2.1", "3.0", "3.1", "3.2"};

    ListView listView;

    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview5_1);
        listView = findViewById(R.id.androidList);

        listAdapter = new List51Adapter(Lab51Activity.this, version, numVersion, image);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Lab51Activity.this, version[i] + " " + numVersion[i], Toast.LENGTH_SHORT ).show();
            }
        });
    }

}
