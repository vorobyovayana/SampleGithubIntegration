package com.example.lec3demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView txtViewResults;
    EditText editTextInputWt;
    Button btnConvertWt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher_wt_round);

        actionBar.setTitle(R.string.txtTitle);

        radioGroup = findViewById(R.id.radGroupConvType);
        editTextInputWt = findViewById(R.id.editTextInputWt);
        btnConvertWt = findViewById(R.id.btnConvertWt);
        txtViewResults = findViewById(R.id.txtViewResults);

        btnConvertWt.setOnClickListener((View view) -> {
            if (radioGroup.getCheckedRadioButtonId() == -1){
                Toast.makeText(MainActivity.this,
                        "Please select conversion type",
                                    Toast.LENGTH_SHORT).show();
            } else if (editTextInputWt.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,
                        "Please enter baggage weight",
                            Toast.LENGTH_SHORT).show();
            } else {
                double inputWt, outputWt = 0;
                try {
                    inputWt = Double.parseDouble(
                            editTextInputWt.getText().toString());
                    if (inputWt < 0){
                        Toast.makeText(MainActivity.this,
                                "Baggage weight cannot be negative",
                                Toast.LENGTH_SHORT).show();
                    } else if (radioGroup.getCheckedRadioButtonId()
                                        == R.id.radBtnKgsToLbs){
                        if (inputWt > 500) {
                            Toast.makeText(MainActivity.this,
                                    "Input baggage wt cannot be greater than 500 Kilos",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            outputWt = inputWt*2.2;
                            txtViewResults.setText(String.format("Converted Wt: %.2f Lbs",outputWt));
                        }
                    } else if (radioGroup.getCheckedRadioButtonId() == R.id.radBtnLbsToKgs){
                        if (inputWt > 1000) {
                            Toast.makeText(MainActivity.this,
                                    "Input baggage wt cannot be greater than 1000Lbs",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            outputWt = inputWt / 2.2;
                            txtViewResults.setText(String.format("Converted Wt: %.2f Kgs",outputWt));
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

    }
}