package com.example.lab1_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class Lab9SenderActivity extends AppCompatActivity { // define the variable
    Button send_button;
    EditText send_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab9_send);
        send_button = findViewById(R.id.send_button_id);
        send_text = findViewById(R.id.send_text_id);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "Hello : " + send_text.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Lab9ReceiveActivity.class);
                intent.putExtra("message_key", str);
                startActivity(intent);
            }
        });
    }
}
