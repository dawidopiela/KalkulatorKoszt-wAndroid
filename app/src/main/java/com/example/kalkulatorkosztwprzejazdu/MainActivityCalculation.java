package com.example.kalkulatorkosztwprzejazdu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityCalculation extends AppCompatActivity {
    TextView distance, fuel, fuel_cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculation);


        distance = findViewById(R.id.Pole1);
        fuel = findViewById(R.id.Pole2);
        fuel_cost = findViewById(R.id.Pole3);


        Intent intent = getIntent();
        String dis = intent.getStringExtra("fuel_cost");
        String fue = intent.getStringExtra("cost_for_person");
        String co = intent.getStringExtra("cost_way");

        distance.setText(dis + " złoty");
        fuel.setText(fue + " złoty");
        fuel_cost.setText(co + " złoty");


    }


}