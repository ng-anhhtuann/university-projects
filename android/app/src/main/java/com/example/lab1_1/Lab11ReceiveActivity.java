package com.example.lab1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Lab11ReceiveActivity extends AppCompatActivity {
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab11_receive);

        calculateButton = findViewById(R.id.calculate_button_id);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                ArrayList<String> stringsArray = intent.getStringArrayListExtra("strings_key");
                int iCount = countCharacterI(stringsArray);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result_key", iCount);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    private int countCharacterI(ArrayList<String> stringsArray) {
        int count = 0;
        for (String str : stringsArray) {
            for (char c : str.toCharArray()) {
                if (c == 'i') {
                    count++;
                }
            }
        }
        return count;
    }
}
