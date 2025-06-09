package com.example.cityfixmopapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class ContactUsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        // Navigate to MainActivity
        findViewById(R.id.homeButton).setOnClickListener(v -> {
            Intent intent = new Intent(ContactUsActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}