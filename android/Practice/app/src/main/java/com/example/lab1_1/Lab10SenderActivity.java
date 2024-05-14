package com.example.lab1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Lab10SenderActivity extends AppCompatActivity {
    Button sendButton;
    EditText inputNumber;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab10_send);

        sendButton = findViewById(R.id.send_button_id);
        inputNumber = findViewById(R.id.input_number_id);
        resultTextView = findViewById(R.id.result_text_view_id);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(inputNumber.getText().toString());
                Intent intent = new Intent(Lab10SenderActivity.this, Lab10ReceiveActivity.class);
                intent.putExtra("number_key", number);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            long factorialResult = data.getLongExtra("result_key", -1);
            resultTextView.setText(factorialResult + "!");
        }
    }
}
