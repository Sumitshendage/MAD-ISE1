package com.example.profile_page;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ✅ Correct layout file name
        setContentView(R.layout.activity_main);

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            Toast.makeText(this, "Back Button Clicked", Toast.LENGTH_SHORT).show();
            finish(); // closes current activity
        });
    }
}