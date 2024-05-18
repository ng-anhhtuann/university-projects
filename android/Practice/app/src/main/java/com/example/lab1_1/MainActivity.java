package com.example.lab1_1;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab1_1.model.DatabaseExec;

public class MainActivity extends AppCompatActivity {
    private EditText fullNameEditText, emailEditText, phoneEditText, addressEditText, quantityEditText, instructionsEditText;
    private Spinner sizeSpinner, colorSpinner;
    private CheckBox termsCheckBox;
    private Button submitButton;
    private DatabaseExec databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_8);

        databaseHelper = new DatabaseExec(this);

        fullNameEditText = findViewById(R.id.fullName);
        emailEditText = findViewById(R.id.email);
        phoneEditText = findViewById(R.id.phone);
        addressEditText = findViewById(R.id.address);
        sizeSpinner = findViewById(R.id.size);
        colorSpinner = findViewById(R.id.color);
        quantityEditText = findViewById(R.id.quantity);
        instructionsEditText = findViewById(R.id.instruc);
        termsCheckBox = findViewById(R.id.termsCheckBox);
        submitButton = findViewById(R.id.submitOrderButton);

        ArrayAdapter<CharSequence> sizeAdapter = ArrayAdapter.createFromResource(this,
                R.array.shirt_sizes, android.R.layout.simple_spinner_item);
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(sizeAdapter);

        ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(this,
                R.array.shirt_colors, android.R.layout.simple_spinner_item);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(colorAdapter);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!termsCheckBox.isChecked()) {
                    Toast.makeText(MainActivity.this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                    return;
                }

                String fullName = fullNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String shirtSize = sizeSpinner.getSelectedItem().toString();
                String shirtColor = colorSpinner.getSelectedItem().toString();
                int quantity = Integer.parseInt(quantityEditText.getText().toString());
                String instructions = instructionsEditText.getText().toString();

                boolean isInserted = databaseHelper.insertOrder(fullName, email, phone, address, shirtSize, shirtColor, quantity, instructions);
                if (isInserted) {
                    Toast.makeText(MainActivity.this, "Order Submitted Successfully", Toast.LENGTH_SHORT).show();
                    clearForm();
                } else {
                    Toast.makeText(MainActivity.this, "Order Submission Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        populateFormIfOrderExists();
    }

    @SuppressLint("Range")
    private void populateFormIfOrderExists() {
        Cursor cursor = databaseHelper.getFirstOrder();
        if (cursor.moveToFirst()) {
            fullNameEditText.setText(cursor.getString(cursor.getColumnIndex("full_name")));
            emailEditText.setText(cursor.getString(cursor.getColumnIndex("email")));
            phoneEditText.setText(cursor.getString(cursor.getColumnIndex("phone")));
            addressEditText.setText(cursor.getString(cursor.getColumnIndex("address")));
            String size = cursor.getString(cursor.getColumnIndex("size"));
            String color = cursor.getString(cursor.getColumnIndex("color"));
            quantityEditText.setText(cursor.getString(cursor.getColumnIndex("quantity")));
            instructionsEditText.setText(cursor.getString(cursor.getColumnIndex("instructions")));

            ArrayAdapter<CharSequence> sizeAdapter = (ArrayAdapter<CharSequence>) sizeSpinner.getAdapter();
            sizeSpinner.setSelection(sizeAdapter.getPosition(size));

            ArrayAdapter<CharSequence> colorAdapter = (ArrayAdapter<CharSequence>) colorSpinner.getAdapter();
            colorSpinner.setSelection(colorAdapter.getPosition(color));
        }
        cursor.close();
    }

    private void clearForm() {
        fullNameEditText.setText("");
        emailEditText.setText("");
        phoneEditText.setText("");
        addressEditText.setText("");
        quantityEditText.setText("");
        instructionsEditText.setText("");
        sizeSpinner.setSelection(0);
        colorSpinner.setSelection(0);
        termsCheckBox.setChecked(false);
    }
}
