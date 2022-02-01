package com.example.lec2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerConcertType;
    EditText editTextNumTix;
    Button btnCalcCost;
    final String TAG = "Concert Dem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Starting the concert booking...");

        btnCalcCost = findViewById(R.id.btnCalcCost);
        editTextNumTix = findViewById(R.id.editTextNumTix);
        spinnerConcertType = findViewById(R.id.spinnerConcertType);


        spinnerConcertType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //i corresponds to SelectedIndex in the spinner
                if (i == 0){
                    Toast.makeText(MainActivity.this,
                            "Clicked on Rock Band", Toast.LENGTH_SHORT).show();
                } else if (i == 1){
                    Toast.makeText(MainActivity.this, "Clicked on Jazz Band",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Clicked on Blues Band",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnCalcCost.setOnClickListener((View view) -> {
            if (editTextNumTix.getText().toString().isEmpty()){
                Log.d(TAG,"Number of Tickets is empty");
                Toast.makeText(this, "Please enter number of tickets",
                                Toast.LENGTH_SHORT).show();
            } else {
                try{
                    //here, we will add the rest of the logic
                    int numTix = Integer.parseInt(editTextNumTix.getText().toString());
                    int index = spinnerConcertType.getSelectedItemPosition();
                    double cost = 0;
                    switch (index){
                        case 0:
                            cost = numTix*79.99;
                            break;
                        case 1:
                            cost = numTix*69.99;
                            break;
                        case 2:
                            cost = numTix*59.99;
                            break;
                    }
                    //creating an intent to start the next results activity
                    Intent myResults = new Intent(MainActivity.this,ResultsActivity.class);

                    //create a bundle to bundle the data to be passed
                    Bundle bundle = new Bundle();
                    bundle.putInt("NUMTIX",numTix);
                    bundle.putString("TYPE",spinnerConcertType.getSelectedItem().toString());
                    bundle.putDouble("COST",cost);

                    myResults.putExtras(bundle);

                    startActivity(myResults);

                } catch (Exception ex){
                    Log.d(TAG,ex.getMessage());
                    Toast.makeText(this,
                            "Please enter valid number of tickets",
                            Toast.LENGTH_SHORT).show();
                    ex.printStackTrace();
                }
            }

        });
    }
}