package com.example.cityfixmopapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReportHazardActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 100;
    private static final String TAG = "ReportHazardActivity";

    private Spinner categorySpinner;
    private EditText hazardDescriptionEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_hazard);

        // Initialize views
        ImageView cameraIcon = findViewById(R.id.cameraIcon);
        categorySpinner = findViewById(R.id.categorySpinner);
        hazardDescriptionEditText = findViewById(R.id.hazardDescriptionEditText);
        submitButton = findViewById(R.id.submitButton);

        // Set up spinner
        setupCategorySpinner();

        // Set click listeners
        cameraIcon.setOnClickListener(this::onCameraIconClick);
        submitButton.setOnClickListener(this::onSubmitButtonClick);
    }

    private void setupCategorySpinner() {
        // Add a placeholder item and actual categories
        String[] categories = {"Select Category", "Road Damage", "Water Leakage", "Electric Hazard", "Other"};

        // Create an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter to the spinner
        categorySpinner.setAdapter(adapter);

        // Set the default selection to the placeholder item
        categorySpinner.setSelection(0);
    }

    private void onCameraIconClick(View view) {
        try {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
            } else {
                Toast.makeText(this, "No camera app found", Toast.LENGTH_SHORT).show();
                Log.w(TAG, "No app found to handle ACTION_IMAGE_CAPTURE intent.");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error opening camera: " + e.getMessage(), e);
            Toast.makeText(this, "Failed to open camera", Toast.LENGTH_SHORT).show();
        }
    }

    private void onSubmitButtonClick(View view) {
        String description = hazardDescriptionEditText.getText().toString().trim();
        String category = categorySpinner.getSelectedItem().toString();

        if (description.isEmpty()) {
            Toast.makeText(this, "Please provide a description", Toast.LENGTH_SHORT).show();
        } else {
            Log.d(TAG, "Hazard Submitted: Category=" + category + ", Description=" + description);
            Toast.makeText(this, "Hazard '" + category + "' reported successfully!", Toast.LENGTH_LONG).show();
            hazardDescriptionEditText.setText(""); // Clear the description field
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this, "Image captured successfully!", Toast.LENGTH_SHORT).show();
        } else if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Image capture cancelled.", Toast.LENGTH_SHORT).show();
        } else {
            Log.d(TAG, "onActivityResult: Unknown request code or result code.");
        }
    }
}