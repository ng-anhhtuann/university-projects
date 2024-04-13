package com.example.listviewform;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private TextView firstName;
    private TextView lastName;
    private TextView email;
    private Button pickDateBtn;
    private TextView selectedDateTV;
    private TextView password;
    private CheckBox agree;
    private RadioGroup radioGroup;
    private String selectedGender;

    private void openDetailsActivity() {
        Intent intent = new Intent(MainActivity.this, RegisterData.class);
        intent.putExtra("ID", "1");
        intent.putExtra("FIRST_NAME", firstName.getText().toString());
        intent.putExtra("LAST_NAME", lastName.getText().toString());
        intent.putExtra("EMAIL", email.getText().toString());
        intent.putExtra("GENDER", selectedGender);
        intent.putExtra("DOB", selectedDateTV.getText().toString());
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");

        String formattedDate = formatter.format(date);
        intent.putExtra("REGISTER_DATE", formattedDate);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedDateTV = findViewById(R.id.idTVSelectedDate);
        firstName = findViewById(R.id.first_name);
        password = findViewById(R.id.password);
        radioGroup = findViewById(R.id.radio);
        agree = findViewById(R.id.privacy_policy);
        radioGroup.setOnCheckedChangeListener(this);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        pickDateBtn = findViewById(R.id.idBtnPickDate);
        Button btnRegister = findViewById(R.id.register_button);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailsActivity();
            }
        });
        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                selectedDateTV.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        selectedGender = "Male";
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId != -1) {
            RadioButton selectedButton = findViewById(checkedRadioButtonId);
            selectedGender = selectedButton.getText().toString();
        }
    }
}