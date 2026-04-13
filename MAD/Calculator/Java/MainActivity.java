package com.example.calculator;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView resultText;
    Button btnAdd, btnSub, btnMul, btnDiv, btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultText = findViewById(R.id.Result);

        btnAdd = findViewById(R.id.add);
        btnSub = findViewById(R.id.sub);
        btnMul = findViewById(R.id.multi);
        btnDiv = findViewById(R.id.div);
        btnProfile = findViewById(R.id.profile);

        // Addition
        btnAdd.setOnClickListener(v -> calculate("add"));

        // Subtraction
        btnSub.setOnClickListener(v -> calculate("sub"));

        // Multiplication
        btnMul.setOnClickListener(v -> calculate("mul"));

        // Division
        btnDiv.setOnClickListener(v -> calculate("div"));

        // Back button logic (open another project)
        btnProfile.setOnClickListener(v -> {

            Intent intent = new Intent();
            intent.setComponent(new ComponentName(
                    "com.example.grid_layout",
                    "com.example.grid_layout.MainActivity"));

            startActivity(intent);
        });
    }

    @SuppressLint("SetTextI18n")
    private void calculate(String operation) {

        if(num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()){
            Toast.makeText(this,"Enter Numbers",Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());
        double result = 0;

        switch (operation) {

            case "add":
                result = n1 + n2;
                break;

            case "sub":
                result = n1 - n2;
                break;

            case "mul":
                result = n1 * n2;
                break;

            case "div":
                if(n2 == 0){
                    Toast.makeText(this,"Cannot divide by zero",Toast.LENGTH_SHORT).show();
                    return;
                }
                result = n1 / n2;
                break;
        }

        resultText.setText("Result: " + result);
    }
}