package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ButterChicken extends AppCompatActivity {

    TextView title;
    TextView ingridients;

    TextView title_ingridients;

    TextView title_making;

    TextView making;

    Button next;

    Button recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.butter_chicken);

        title = (TextView) findViewById(R.id.butter_title);

        ingridients = (TextView) findViewById(R.id.textView5);

        title_ingridients = (TextView) findViewById(R.id.textView4);

        title_making = (TextView) findViewById(R.id.textView10);

        making = (TextView) findViewById(R.id.textView11);

        next = (Button) findViewById(R.id.next_recipe);

        recipe = (Button) findViewById(R.id.recipe_page);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(ButterChicken.this, ScrambledEggs.class);
                startActivity(nextIntent);
            }
        });

        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipeIntent = new Intent(ButterChicken.this, Recipes.class);
                startActivity(recipeIntent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
