package com.example.unitconvertorapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import com.example.unitconvertorapplication.databinding.ActivityUnitConvertorBinding;
public class UnitConvertorActivity extends AppCompatActivity {
    ActivityUnitConvertorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_unit_convertor);

                binding = ActivityUnitConvertorBinding.inflate(getLayoutInflater());
                setContentView(binding.getRoot());

                binding.cardView4.setOnClickListener(view -> {
                    Intent intent = new Intent(UnitConvertorActivity.this,CurrencyActivity.class);
                    startActivity(intent);
                });

                binding.cardView6.setOnClickListener(view -> {
                    Intent intent = new Intent(UnitConvertorActivity.this,WeightActivity.class);
                    startActivity(intent);
                });
                binding.profile.setOnClickListener(view -> {
                    Intent intent = new Intent(UnitConvertorActivity.this,TimeActivity.class);
                    startActivity(intent);
                });
                binding.createUser.setOnClickListener(view -> {
                    Intent intent = new Intent(UnitConvertorActivity.this,LengthActivity.class);
                    startActivity(intent);
                });
                binding.outForDeliveryButton.setOnClickListener(view -> {
                    Intent intent = new Intent(UnitConvertorActivity.this,AreaActivity.class);
                    startActivity(intent);
                });
                binding.cardView5.setOnClickListener(view -> {
                    Intent intent = new Intent(UnitConvertorActivity.this,TemperatureActivity.class);
                    startActivity(intent);
                });


            }
        }