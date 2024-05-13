package com.example.lab1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Lab42Activity extends AppCompatActivity {

    AppCompatButton join2, join1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quizapp);

        join2 = findViewById(R.id.join2);
        join1 = findViewById(R.id.join1);
        join1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab42Activity.this, Lab42SubActivity.class);
                startActivity(intent);
            }
        });
        join2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab42Activity.this, Lab42SubActivity.class);
                startActivity(intent);
            }
        });
    }
}
