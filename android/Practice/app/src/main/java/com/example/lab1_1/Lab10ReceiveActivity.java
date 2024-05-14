package com.example.lab1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Lab10ReceiveActivity extends AppCompatActivity {
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab10_receive);

        calculateButton = findViewById(R.id.calculate_button_id);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                int number = intent.getIntExtra("number_key", -1);
                long factorial = calculateFactorial(number);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result_key", factorial);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    private long calculateFactorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
