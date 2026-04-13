package com.example.login_page;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnBack = findViewById(R.id.btnBack);

        btnLogin.setOnClickListener(v -> {

            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
            else if (email.equals("arya@gmail.com") && password.equals("1234")) {

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

                try {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(
                            "com.example.profile_page",
                            "com.example.profile_page.ProfileActivity"));
                    startActivity(intent);

                } catch (Exception e) {
                    Toast.makeText(this, "Profile App Not Installed!", Toast.LENGTH_SHORT).show();
                }

            }
            else {
                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
            }
        });

        // Back button
        btnBack.setOnClickListener(v -> {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(
                        "com.example.grid_layout",
                        "com.example.grid_layout.MainActivity"));
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Grid App Not Installed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}