package com.example.cityfixmopapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Find TextViews by their IDs
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);
        Button editProfileButton = findViewById(R.id.updateProfileButton);


        // Example user data (replace with actual data from intent or database)
        String userName = "Mohammed Shabaneh";
        String userEmail = "shabaneh@example.com";
        String userPhone = "+970598363203";

        // Set user data to TextViews
        nameTextView.setText(userName);
        emailTextView.setText(userEmail);
        phoneTextView.setText(userPhone);

        // Find buttons by their IDs
        ImageButton profileButton = findViewById(R.id.profileButton);
        ImageButton bellButton = findViewById(R.id.bellButton);
        ImageButton homeButton = findViewById(R.id.homeButton);
        ImageButton logoutButton = findViewById(R.id.logoutButton);


        // Set click listeners for each button

        profileButton.setOnClickListener(v -> {
            Toast.makeText(this, "Already on Profile Page", Toast.LENGTH_SHORT).show();
        });

        bellButton.setOnClickListener(v -> {
            Toast.makeText(this, "Notifications clicked", Toast.LENGTH_SHORT).show();
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        });
        logoutButton.setOnClickListener(v -> {
            // Handle logout action
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Close the current activity
        });

        editProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, UpdateProfileActivity.class);
            startActivity(intent);
        });
    }
}