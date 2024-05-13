package com.example.lab1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    AppCompatButton b1, b3_1, b3_2, b4_1, b4_2, b5_1, b5_2, b9, b10, b11, b12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        b1 = findViewById(R.id.b1);
        b3_1 = findViewById(R.id.b3_1); 
        b3_2 = findViewById(R.id.b3_2);
        b4_1 = findViewById(R.id.b4_1);
        b4_2 = findViewById(R.id.b4_2);
        b5_1 = findViewById(R.id.b5_1); 
        b5_2 = findViewById(R.id.b5_2); 
        b9 = findViewById(R.id.b9); 
        b10 = findViewById(R.id.b10); 
        b11 = findViewById(R.id.b11); 
        b12 = findViewById(R.id.b12);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab1Activity.class);
                startActivity(intent);
            }
        });

        b3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab31Activity.class);
                startActivity(intent);
            }
        });

        b3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab32Activity.class);
                startActivity(intent);
            }
        });

        b4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CircleActivity.class);
                startActivity(intent);
            }
        });

        b4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab42Activity.class);
                startActivity(intent);
            }
        });

    }
}