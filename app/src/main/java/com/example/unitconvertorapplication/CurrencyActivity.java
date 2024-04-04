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

public class CurrencyActivity extends AppCompatActivity {
    private Spinner spinnerFrom, spinnerTo;
    private EditText editTextFrom, editTextTo;
    private Button buttonConvert;
  ImageView imageView;
    private static final String[] units = {"INR", "USD","EUR"};
    private static final double USD_TO_INR = 82.92;
    private static final double EUR_TO_INR = 89.92;

    private static final double EUR_TO_USD = 1.08;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_currency);


                spinnerFrom = findViewById(R.id.spinner5);
                spinnerTo = findViewById(R.id.spinner4);
                editTextFrom = findViewById(R.id.editTextNumber2);
                editTextTo = findViewById(R.id.editTextNumber3);
                buttonConvert = findViewById(R.id.button2);
                imageView=findViewById(R.id.imageView3);
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

                if (unitFrom.equals("USD") && unitTo.equals("INR")) {
                    result = inputValue * USD_TO_INR;
                } else if (unitFrom.equals("INR") && unitTo.equals("USD")) {
                    result = inputValue / USD_TO_INR;
                }
                else if (unitFrom.equals("EUR") && unitTo.equals("INR")) {
                    result = inputValue * EUR_TO_INR;
                } else if (unitFrom.equals("INR") && unitTo.equals("EUR")) {
                    result = inputValue / EUR_TO_INR;
                }
                else if (unitFrom.equals("EUR") && unitTo.equals("USD")) {
                    result = inputValue * EUR_TO_USD;
                } else if (unitFrom.equals("USD") && unitTo.equals("EUR")) {
                    result = inputValue / EUR_TO_USD;
                }

                else {
                    result = inputValue;
                }

                editTextTo.setText(String.valueOf(result));
            }
        }
