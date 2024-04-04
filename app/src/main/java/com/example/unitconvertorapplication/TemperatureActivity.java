package com.example.unitconvertorapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
public class TemperatureActivity extends AppCompatActivity {
    private Spinner spinnerFrom, spinnerTo;
    private EditText editTextFrom, editTextTo;
    private Button buttonConvert;
    ImageView imageView;
    private static final String[] units = {"Celsius C", "Fahrenheit F","Kelvin K"};
    private static final double C_TO_F = 33.8;
    private static final double F_TO_K = 255.92;

    private static final double C_TO_K = 274.15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_temperature);

        spinnerFrom = findViewById(R.id.spinner5);
        spinnerTo = findViewById(R.id.spinner4);
        editTextFrom = findViewById(R.id.editTextNumber2);
        editTextTo = findViewById(R.id.editTextNumber3);
        buttonConvert = findViewById(R.id.button2);
        imageView=findViewById(R.id.imageView4);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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

                if (unitFrom.equals("Celsius C") && unitTo.equals("Fahrenheit F")) {
                    result = inputValue * C_TO_F;
                } else if (unitFrom.equals("Fahrenheit F") && unitTo.equals("Celsius C")) {
                    result = inputValue / C_TO_F;
                }
                else if (unitFrom.equals("Fahrenheit F") && unitTo.equals("Kelvin K")) {
                    result = inputValue * F_TO_K;
                } else if (unitFrom.equals("Kelvin K") && unitTo.equals("Fahrenheit F")) {
                    result = inputValue / F_TO_K;
                }
                else if (unitFrom.equals("Celsius C") && unitTo.equals("Kelvin K")) {
                    result = inputValue * C_TO_K;
                } else if (unitFrom.equals("Kelvin K") && unitTo.equals("Celsius C")) {
                    result = inputValue / C_TO_K;
                }

                else {
                    result = inputValue;
                }

                editTextTo.setText(String.valueOf(result));
            }
        }
