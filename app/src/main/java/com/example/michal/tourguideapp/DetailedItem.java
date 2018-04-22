package com.example.michal.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailedItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_item);


        Intent myIntent = getIntent();
        String selectedItemText = myIntent.getStringExtra("selectedItem");
        String selectedItemDescription = myIntent.getStringExtra("selectedItemDescription");
        final String selectedItemLocation = myIntent.getStringExtra("geoLocation");
        int selectedItemImageId = myIntent.getIntExtra("imageResourceId", 0);

        TextView detailedItemText = findViewById(R.id.detailed_item_text);
        detailedItemText.setText(String.valueOf(selectedItemText));

        ImageView detailedItemImage = findViewById(R.id.detailed_item_image);
        detailedItemImage.setImageResource(selectedItemImageId);

        TextView detailedItemDescription = findViewById(R.id.detailed_item_description);
        detailedItemDescription.setText(String.valueOf(selectedItemDescription));

        Button locationButton =findViewById(R.id.detailed_item_location_button);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, createGeoLocationFormat(selectedItemLocation));
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }

    private Uri createGeoLocationFormat(String geoLocation){
        return Uri.parse("geo:" + geoLocation + "?z=14" + "&q=" + geoLocation);
    }
}
