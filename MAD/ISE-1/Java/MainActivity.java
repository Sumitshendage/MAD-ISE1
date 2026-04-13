package com.example.grid_layout;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btn1.setOnClickListener(v ->
                openApp("com.example.constraint_layout",
                        "com.example.constraint_layout.MainActivity"));

        btn2.setOnClickListener(v ->
                openApp("com.example.vertical_layout",
                        "com.example.vertical_layout.MainActivity"));

        btn3.setOnClickListener(v ->
                openApp("com.example.linear_layout",
                        "com.example.linear_layout.MainActivity"));

        btn4.setOnClickListener(v ->
                openApp("com.example.table_layout",
                        "com.example.table_layout.MainActivity"));

        btn5.setOnClickListener(v ->
                openApp("com.example.frame_layout",
                        "com.example.frame_layout.MainActivity"));

        btn6.setOnClickListener(v ->
                openApp("com.example.login_page",
                        "com.example.login_page.LoginActivity"));

        btn7.setOnClickListener(v ->
                openApp("com.example.calculator",
                        "com.example.calculator.MainActivity"));

        btn8.setOnClickListener(v ->
                openApp("com.example.profile_page",
                        "com.example.profile_page.ProfileActivity"));

        btn9.setOnClickListener(v ->
                openApp("com.example.implicit",
                        "com.example.implicit.MainActivity"));}

    private void openApp(String packageName, String activityName) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        try {
            startActivity(intent);
        } catch (Exception e) {
            Log.e("AppError", "Error opening app", e);
        }
    }
}
