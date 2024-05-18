package com.example.lab1_1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ExamReceiveActivity extends AppCompatActivity {

    private TextView textViewResult;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam0_receive);

        textViewResult = findViewById(R.id.textViewResult);
        buttonBack = findViewById(R.id.buttonBack);

        Intent intent = getIntent();
        int sum = intent.getIntExtra("sum", 0);
        textViewResult.setText(String.valueOf(sum));

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("sum", sum);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}

