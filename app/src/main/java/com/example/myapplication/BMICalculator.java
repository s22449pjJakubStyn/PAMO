//Author: Jakub Styn
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMICalculator extends AppCompatActivity {

    private EditText heightTextView;
    private EditText weightTextView;
    Button calculate_button;
    private TextView result;

    Button back_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.bmi_calculator);

        heightTextView = (EditText) findViewById(R.id.heightText);
        weightTextView = (EditText) findViewById(R.id.weightText);
        calculate_button = findViewById(R.id.calculateBMIButton);
        result = (TextView) findViewById(R.id.resultBMI);
        back_button = findViewById(R.id.back_button);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float height = Float.parseFloat(heightTextView.getText().toString());
                float weight = Float.parseFloat(weightTextView.getText().toString());

                float height_cm = height/100;

                Float BMI = weight / (height_cm * height_cm);

                result.setText(String.valueOf(BMI));

            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(BMICalculator.this, MainActivity.class);
                startActivity(backIntent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}