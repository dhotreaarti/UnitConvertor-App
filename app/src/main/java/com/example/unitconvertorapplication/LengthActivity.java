package com.example.unitconvertorapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class LengthActivity extends AppCompatActivity {
    private Spinner spinnerFrom, spinnerTo;
    private EditText editTextFrom, editTextTo;

    private static final String[] units = {"m", "cm","mm"};
    private static final double m_TO_cm = 100;
    private static final double cm_TO_mm = 10;
    ImageView imageView;
    private static final double m_TO_mm = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_length);

                spinnerFrom = findViewById(R.id.spinner3);
                spinnerTo = findViewById(R.id.spinner4);
                editTextFrom = findViewById(R.id.editTextNumber2);
                editTextTo = findViewById(R.id.editTextNumber3);
                Button buttonConvert = findViewById(R.id.button2);
                imageView=findViewById(R.id.imageView2);

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

                if (unitFrom.equals("m") && unitTo.equals("cm")) {
                    result = inputValue * m_TO_cm;
                } else if (unitFrom.equals("cm") && unitTo.equals("m")) {
                    result = inputValue / m_TO_cm;
                }
                else if (unitFrom.equals("cm") && unitTo.equals("mm")) {
                    result = inputValue * cm_TO_mm;
                } else if (unitFrom.equals("mm") && unitTo.equals("cm")) {
                    result = inputValue / cm_TO_mm;
                }
                else if (unitFrom.equals("m") && unitTo.equals("mm")) {
                    result = inputValue * m_TO_mm;
                } else if (unitFrom.equals("mm") && unitTo.equals("m")) {
                    result = inputValue / m_TO_mm;
                }

                else {
                    result = inputValue;
                }

                editTextTo.setText(String.valueOf(result));
            }
        }



