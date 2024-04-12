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

public class ScrambledEggs extends AppCompatActivity {

    TextView title;

    TextView ingr;

    TextView ingrValue;

    TextView mkg;

    TextView mkgValue;

    Button next;

    Button main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.scrambled_eggs);

        title = (TextView) findViewById(R.id.scrambled_title);

        ingr = (TextView) findViewById(R.id.textView14);

        ingrValue = (TextView) findViewById(R.id.textView15);

        mkg = (TextView) findViewById(R.id.textView16);

        mkgValue = (TextView) findViewById(R.id.textView17);

        next = (Button) findViewById(R.id.egg_next);

        main = (Button) findViewById(R.id.main_recipe);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(ScrambledEggs.this, ButterChicken.class);
                startActivity(nextIntent);
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(ScrambledEggs.this, Recipes.class);
                startActivity(nextIntent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
