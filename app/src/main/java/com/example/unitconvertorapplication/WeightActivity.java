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

public class WeightActivity extends AppCompatActivity {
    private Spinner spinnerFrom, spinnerTo;
    private EditText editTextFrom, editTextTo;
    private Button buttonConvert;
    private static final String[] units = {"kg", "g","pound lb"};
    private static final double kg_TO_g = 1000;
    private static final double kg_TO_pound = 2.20;
    private static final double pound_TO_g = 453.59;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weight);


                spinnerFrom = findViewById(R.id.spinner5);
                spinnerTo = findViewById(R.id.spinner6);
                editTextFrom = findViewById(R.id.editTextNumber2);
                editTextTo = findViewById(R.id.editTextNumber3);
                buttonConvert = findViewById(R.id.button2);

                imageView=findViewById(R.id.imageView6);

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

                if (unitFrom.equals("kg") && unitTo.equals("g")) {
                    result = inputValue * kg_TO_g ;
                } else if (unitFrom.equals("g") && unitTo.equals("kg")) {
                    result = inputValue / kg_TO_g ;
                }
                else if (unitFrom.equals("kg") && unitTo.equals("pound lb")) {
                    result = inputValue * kg_TO_pound;
                } else if (unitFrom.equals("pound lb") && unitTo.equals("kg")) {
                    result = inputValue / kg_TO_pound;
                }
                else if (unitFrom.equals("pound lb") && unitTo.equals("g")) {
                    result = inputValue * pound_TO_g;
                } else if (unitFrom.equals("g") && unitTo.equals("pound lb")) {
                    result = inputValue /pound_TO_g;
                }
                else {
                    result = inputValue;
                }

                editTextTo.setText(String.valueOf(result));
            }
        }
