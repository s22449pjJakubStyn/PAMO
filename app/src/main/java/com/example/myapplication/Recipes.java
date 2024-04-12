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

public class Recipes extends AppCompatActivity {
    TextView title;
    Button chicken;
    TextView dinner1;

    TextView dinner2;

    Button eggs;

    Button main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recipes);

        title = (TextView) findViewById(R.id.recipes_title);

        chicken = (Button) findViewById(R.id.chicken);

        dinner1 = (TextView) findViewById(R.id.textView8);

        dinner2 = (TextView) findViewById(R.id.textView12);

        eggs = (Button) findViewById(R.id.eggs);

        main = (Button) findViewById(R.id.back_to_main);


        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chickenIntent = new Intent(Recipes.this, ButterChicken.class);
                startActivity(chickenIntent);
            }
        });

        eggs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chickenIntent = new Intent(Recipes.this, ScrambledEggs.class);
                startActivity(chickenIntent);
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chickenIntent = new Intent(Recipes.this,MainActivity.class);
                startActivity(chickenIntent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
