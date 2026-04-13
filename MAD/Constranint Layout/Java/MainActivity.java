package com.example.constraint_layout;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backBtn = findViewById(R.id.backBtn);

        // Back to Grid Project
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(
                    "com.example.grid_layout",
                    "com.example.grid_layout.MainActivity"));
            startActivity(intent);
        });
    }
}