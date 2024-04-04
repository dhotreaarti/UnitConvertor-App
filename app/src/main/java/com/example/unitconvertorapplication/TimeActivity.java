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
import android.widget.Spinner;

public class TimeActivity extends AppCompatActivity {
    private Spinner spinnerFrom, spinnerTo;
    private EditText editTextFrom, editTextTo;
    private Button buttonConvert;
    private static final String[] units = {"min", "s","hour"};
    private static final double min_TO_s = 60;
    private static final double hour_TO_min = 60;

    private static final double hour_TO_s = 3600;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_time);



                spinnerFrom = findViewById(R.id.spinner3);
                spinnerTo = findViewById(R.id.spinner4);
                editTextFrom = findViewById(R.id.editTextNumber2);
                editTextTo = findViewById(R.id.editTextNumber3);
                buttonConvert = findViewById(R.id.button2);

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

                if (unitFrom.equals("min") && unitTo.equals("s")) {
                    result = inputValue * min_TO_s;
                } else if (unitFrom.equals("s") && unitTo.equals("min")) {
                    result = inputValue / min_TO_s;
                }
                else if (unitFrom.equals("hour") && unitTo.equals("min")) {
                    result = inputValue * hour_TO_min;
                } else if (unitFrom.equals("min") && unitTo.equals("hour")) {
                    result = inputValue / hour_TO_min;
                }
                else if (unitFrom.equals("hour") && unitTo.equals("s")) {
                    result = inputValue * hour_TO_s;
                } else if (unitFrom.equals("s") && unitTo.equals("hour")) {
                    result = inputValue / hour_TO_s;
                }
                else {
                    result = inputValue;
                }

                editTextTo.setText(String.valueOf(result));
            }
        }
