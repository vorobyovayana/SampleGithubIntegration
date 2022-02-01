package com.example.lec2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultsActivity extends AppCompatActivity {
    final String TAG = "Concert Dem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        int numTix = 0;
        try {
            Bundle bundle = getIntent().getExtras(); //you may get the bundle
            double cost = getIntent().getExtras().getDouble("COST",0);
            numTix = getIntent().getExtras().getInt("NUMTIX",0);
            String concertType = getIntent().getExtras().getString("TYPE","error");
            DecimalFormat df = new DecimalFormat("$#.##");

            String outputStr = "Concert Type: " + concertType + "\n" +
                                "Num Tix: " + numTix + "\n" +
                                    "Total Cost: " + df.format(cost);
            TextView txtViewResults = findViewById(R.id.txtViewResults);
            txtViewResults.setText(outputStr);

            //another way to set gravity of txt view at run time in java
            txtViewResults.setGravity(Gravity.CENTER);
            txtViewResults.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL); //this gives top center alignment

        } catch (Exception ex){
            ex.printStackTrace();
            Log.e(TAG,numTix + "");
        }
    }
}