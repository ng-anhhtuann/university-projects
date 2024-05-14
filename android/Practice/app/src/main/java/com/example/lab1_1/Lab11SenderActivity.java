package com.example.lab1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Lab11SenderActivity extends AppCompatActivity {
    Button addButton, sendButton;
    EditText inputString;
    TextView resultTextView, enteredStringsTextView;
    ArrayList<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab11_send);

        addButton = findViewById(R.id.add_button_id);
        sendButton = findViewById(R.id.send_button_id);
        inputString = findViewById(R.id.input_strings_id);
        resultTextView = findViewById(R.id.result_text_view_id);
        enteredStringsTextView = findViewById(R.id.entered_strings_id);
        stringList = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputString.getText().toString().trim();
                if (!input.isEmpty()) {
                    stringList.add(input);
                    inputString.setText("");
                    updateEnteredStringsTextView();
                    enteredStringsTextView.setVisibility(View.VISIBLE);
                    Toast.makeText(Lab11SenderActivity.this, "String added: " + input, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Lab11SenderActivity.this, "Please enter a string", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab11SenderActivity.this, Lab11ReceiveActivity.class);
                intent.putStringArrayListExtra("strings_key", stringList);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void updateEnteredStringsTextView() {
        StringBuilder sb = new StringBuilder("Entered strings:\n");
        for (String s : stringList) {
            sb.append(s).append("\n");
        }
        enteredStringsTextView.setText(sb.toString().trim());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            int iCount = data.getIntExtra("result_key", -1);
            resultTextView.setText("Count of 'i': " + iCount);
        }
    }
}
