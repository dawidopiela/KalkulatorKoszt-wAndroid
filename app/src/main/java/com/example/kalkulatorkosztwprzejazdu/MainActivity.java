package com.example.kalkulatorkosztwprzejazdu;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText distance;
    EditText fuel;
    EditText people;
    EditText cost;
    Button calculate;
    Button reset;
    Double fuel_cost;
    Double cost_for_person;
    Double cost_way;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        distance = (EditText) findViewById(R.id.input_kilomiters);
        fuel = (EditText) findViewById(R.id.input_usage);
        people = (EditText) findViewById(R.id.input_people);
        cost = (EditText) findViewById(R.id.input_cost);
        calculate = (Button) findViewById(R.id.button);
        reset = (Button) findViewById(R.id.button_reset);



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                distance.getText().clear();
                fuel.getText().clear();
                people.getText().clear();
                cost.getText().clear();


            }
        });


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                Double a = Double.parseDouble(zeroIfEmpty(distance.getText().toString()));
                Double b = Double.parseDouble(zeroIfEmpty(fuel.getText().toString()));

                Double c;
                if(allNotNull()){
                    Toast.makeText(MainActivity.this, "Proszę wypełnij pola", Toast.LENGTH_SHORT).show();

                }
                else {
                    c = Double.parseDouble(people.getText().toString());


                    Double d = Double.parseDouble(zeroIfEmpty(cost.getText().toString()));



                    fuel_cost = (a / 100) * b * d;   //
                    cost_for_person = (fuel_cost / c);
                    cost_way = fuel_cost / (a / 100);

                    String r = String.format("%.2f", fuel_cost);
                    String t = String.format("%.2f", cost_for_person);
                    String u = String.format("%.2f", cost_way);


                    Intent intent = new Intent(MainActivity.this, MainActivityCalculation.class);
                    intent.putExtra("fuel_cost", r);
                    intent.putExtra("cost_for_person", t);
                    intent.putExtra("cost_way", u);
                    startActivity(intent);

                }

            }

        });

    }

    private boolean allNotNull(){

        return notNull(distance) || notNull(fuel) || notNull(people) || notNull((cost));


    }
    private boolean notNull(EditText et){
        return et.getText().toString().isEmpty();
    }


    private String zeroIfEmpty(String num) {
        if (num.isEmpty()){
            return "0";
        }
        return num;
    }
}





