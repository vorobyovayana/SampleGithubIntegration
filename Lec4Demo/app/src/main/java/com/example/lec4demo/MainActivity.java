package com.example.lec4demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewSites;
    List<String> ChicagoSiteNames = new ArrayList<>(
            Arrays.asList("Magnificient Mile","Navy Pier","Art Institute"));
    List<Integer> ChicagoSitePics = new ArrayList<>(Arrays.asList(
            R.drawable.magmile, R.drawable.pier,R.drawable.artinst));
    List<SiteAttraction> sitesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewSites = findViewById(R.id.listViewSites);
        ArrayAdapter<String> sitesArrAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,ChicagoSiteNames);
        listViewSites.setAdapter(sitesArrAdapter);

        SitesAdapter sitesAdapter2 = new SitesAdapter(ChicagoSiteNames, ChicagoSitePics);
        listViewSites.setAdapter(sitesAdapter2);

        listViewSites.setOnItemClickListener(
                (AdapterView<?> adapterView, View view, int i, long l) -> {
                switch(i){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.themagnificentmile.com")));
                        break;

                    case 1:
                        startActivity(new Intent(MainActivity.this, NavyPierActivity.class));
                        break;

                    case 2:
                        startActivity(new Intent(MainActivity.this, ArInstituteActivity.class));
                        break;
                }


        });
    }


}