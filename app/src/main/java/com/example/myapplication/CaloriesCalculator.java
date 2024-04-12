package com.example.myapplication;

import static java.lang.Math.round;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.util.Objects;

public class CaloriesCalculator extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView title;
    TextView subTitle;

    TextView weightTitle;
    TextView heightTitle;

    TextView age;

    EditText weightValue;

    EditText heightValue;

    EditText ageValue;

    TextView result;

    String[] sexes = {"Male", "Female"};
    String selectedSex;
    Spinner spino;

    Button ppm;

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calories_calculator);

        spino = findViewById(R.id.sexSpinner);
        spino.setOnItemSelectedListener(this);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sexes);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spino.setAdapter(ad);

        title = (TextView) findViewById(R.id.calories_title);
        subTitle = (TextView) findViewById(R.id.subtitle);
        weightTitle = (TextView) findViewById(R.id.textView6);
        heightTitle = (TextView) findViewById(R.id.textView7);
        weightValue = (EditText) findViewById(R.id.BMRWeight);
        heightValue = (EditText) findViewById(R.id.BMRHeight);
        age = (TextView) findViewById(R.id.textView9);
        ageValue = (EditText) findViewById(R.id.Age);
        result = (TextView) findViewById(R.id.result);

        ppm = (Button) findViewById(R.id.calculate_ppm);
        back = (Button) findViewById(R.id.back_button);

        ppm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float height = Float.parseFloat(heightValue.getText().toString());
                float weight = Float.parseFloat(weightValue.getText().toString());
                int age = Integer.parseInt(ageValue.getText().toString());
                String sex = selectedSex;
                Log.d(selectedSex, selectedSex);

                double BMR;

                if (Objects.equals(sex, "Male")) {
                    BMR = ((13.7 * weight) + (5.0 * height) - (6.76 * age) + 66.47);
                } else {
                    BMR = ((9.567 * weight) + (1.85 * height) - (4.68 * age) + 655.1);
                }

                DecimalFormat df = new DecimalFormat("#.##");
                result.setText(df.format(BMR) + " kcal");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(CaloriesCalculator.this, MainActivity.class);
                startActivity(backIntent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedSex = sexes[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
