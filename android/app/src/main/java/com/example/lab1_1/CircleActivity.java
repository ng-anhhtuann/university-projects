package com.example.lab1_1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class CircleActivity extends AppCompatActivity {

    private boolean iconsVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        ImageView middleImageView = findViewById(R.id.middle);

        final LinearLayout[] surroundingLayouts = {
                findViewById(R.id.r1),
                findViewById(R.id.r2),
                findViewById(R.id.r3),
                findViewById(R.id.r4)
        };

        Runnable hide = new Runnable() {
            @Override
            public void run() {
                for (LinearLayout layout : surroundingLayouts) {
                    layout.setVisibility(View.VISIBLE);
                }
            }
        };

        middleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (LinearLayout layout : surroundingLayouts) {
                    layout.setVisibility(View.GONE);
                }
                for (LinearLayout layout : surroundingLayouts) {
                    layout.postDelayed(hide, 3000);
                }
            }
        });
    }
}
