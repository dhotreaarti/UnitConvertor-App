package com.example.unitconvertorapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
public class AreaActivity extends AppCompatActivity {
    private Spinner spinnerFrom, spinnerTo;
    private EditText editTextFrom, editTextTo;
    ImageView imageView;
    private static final String[] units = {"Sq.kilometer", "Sq.foot", "Sq.meter"};
    private static final double kilometer_TO_foot = 10763910.4;
    private static final double meter_TO_foot = 10.7639104;

    private static final double Kilometer_TO_meter = 1000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area);

        imageView=findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        spinnerFrom = findViewById(R.id.spinner3);
        spinnerTo = findViewById(R.id.spinner4);
        editTextFrom = findViewById(R.id.editTextNumber2);
        editTextTo = findViewById(R.id.editTextNumber3);
        Button buttonConvert = findViewById(R.id.button2);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }


            private void convert() {
                double inputValue = Double.parseDouble(editTextFrom.getText().toString());
                String unitFrom = spinnerFrom.getSelectedItem().toString();
                String unitTo = spinnerTo.getSelectedItem().toString();
                double result;

                if (unitFrom.equals("Sq.kilometer") && unitTo.equals("Sq.foot")) {
                    result = inputValue * kilometer_TO_foot;
                } else if (unitFrom.equals("Sq.foot") && unitTo.equals("Sq.kilometer")) {
                    result = inputValue / kilometer_TO_foot;
                }
                else if (unitFrom.equals("Sq.meter") && unitTo.equals("Sq.foot")) {
                    result = inputValue * meter_TO_foot;
                } else if (unitFrom.equals("Sq.foot") && unitTo.equals("Sq.meter")) {
                    result = inputValue / meter_TO_foot;
                }
                else if (unitFrom.equals("Sq.kilometer") && unitTo.equals("Sq.meter")) {
                    result = inputValue * Kilometer_TO_meter;
                } else if (unitFrom.equals("Sq.meter") && unitTo.equals("Sq.kilometer")) {
                    result = inputValue / Kilometer_TO_meter;
                }

                else {
                    result = inputValue;
                }

                editTextTo.setText(String.valueOf(result));
            }
        }



