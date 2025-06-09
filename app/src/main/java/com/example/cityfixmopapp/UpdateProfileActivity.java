package com.example.cityfixmopapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        // Find views by their IDs
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText phoneEditText = findViewById(R.id.phoneEditText);
        Button saveButton = findViewById(R.id.save);
        ImageButton profileButton = findViewById(R.id.profileButton);
        ImageButton bellButton = findViewById(R.id.bellButton);
        ImageButton homeButton = findViewById(R.id.homeButton);
        ImageButton logoutButton = findViewById(R.id.logoutButton);

        // Save button logic
        saveButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String phone = phoneEditText.getText().toString().trim();

            // Validate input fields
            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate email format
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save the updated profile information
            Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
            // Add logic to save the updated profile information (e.g., database or shared preferences)
            finish(); // Close the activity
        });

        // Navigation logic for ImageButtons
        profileButton.setOnClickListener(v -> {

            Intent intent = new Intent(UpdateProfileActivity.this, ProfileActivity.class);
            startActivity(intent);

        });

        bellButton.setOnClickListener(v -> {
            // Handle bell button click
            Intent intent = new Intent(UpdateProfileActivity.this, NotificationsActivity.class);
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(UpdateProfileActivity.this, MainActivity.class);
            startActivity(intent);
        });

        logoutButton.setOnClickListener(v -> {
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UpdateProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Close the current activity
        });
    }
}