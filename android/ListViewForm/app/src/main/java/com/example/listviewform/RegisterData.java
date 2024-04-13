package com.example.listviewform;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RegisterData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_data);

        RecyclerView recyclerView = findViewById(R.id.recipeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecipeAdapter adapter = new RecipeAdapter();
        recyclerView.setAdapter(adapter);

        // Initialize TextViews
        TextView tvDetailId = findViewById(R.id.tvId);
        TextView tvDetailFirstName = findViewById(R.id.tvFirstName); 
        TextView tvDetailLastName = findViewById(R.id.tvLastName); 
        TextView tvDetailGender = findViewById(R.id.tvGender); 
        TextView tvDetailEmail = findViewById(R.id.tvEmail);
        TextView tvDetailDOB = findViewById(R.id.tvDOB);
        TextView tvRegisterDate = findViewById(R.id.tvRegistrationDate);

        // Get the data from the intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String id = extras.getString("ID");
            String firstName = extras.getString("FIRST_NAME");
            String lastName = extras.getString("LAST_NAME");
            String gender = extras.getString("GENDER");
            String email = extras.getString("EMAIL");
            String dob = extras.getString("DOB");
            String registerDate = extras.getString("REGISTER_DATE");

            // Set the data to TextViews
            tvDetailId.setText("Id: " + id);
            tvDetailFirstName.setText("First name: " + firstName);
            tvDetailLastName.setText("Last name: " + lastName);
            tvDetailGender.setText("Gender: " + gender);
            tvDetailEmail.setText("Email: " + email);
            tvDetailDOB.setText("DOB: " + dob);
            tvRegisterDate.setText("Registration Date & Time: " + registerDate);
        }
    }
}
