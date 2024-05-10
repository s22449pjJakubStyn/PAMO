//Author: Jakub Styn
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button main_button;
    Button calories_button;

    Button recipes_button;

    Button chart_button;

    Button shopping_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        main_button = findViewById(R.id.main_button);
        calories_button = findViewById(R.id.calories_button);
        recipes_button = findViewById(R.id.recipes_button);
        chart_button = findViewById(R.id.chart);
        shopping_button = findViewById(R.id.shopping);

        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bmiIntent = new Intent(MainActivity.this, BMICalculator.class);
                startActivity(bmiIntent);
            }
        });

        calories_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent caloriesIntent = new Intent(MainActivity.this, CaloriesCalculator.class);
                startActivity(caloriesIntent);
            }
        });

        recipes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipesIntent = new Intent(MainActivity.this, Recipes.class);
                startActivity(recipesIntent);
            }
        });

        chart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chartIntent = new Intent(MainActivity.this, BMIChart.class);
                startActivity(chartIntent);
            }
        });

        shopping_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shoppingIntent = new Intent(MainActivity.this, ShoppingList.class);
                startActivity(shoppingIntent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}