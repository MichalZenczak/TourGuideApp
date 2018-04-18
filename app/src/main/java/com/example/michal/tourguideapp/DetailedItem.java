package com.example.michal.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_item);


        Intent myIntent = getIntent();
        String selectedItemText = myIntent.getStringExtra("selectedItem");
        String selectedItemDescription = myIntent.getStringExtra("selectedItemDescription");
        int selectedItemImageId = myIntent.getIntExtra("imageResourceId", 0);

        TextView detailedItemText = findViewById(R.id.detailed_item_text);
        detailedItemText.setText(String.valueOf(selectedItemText));

        ImageView detailedItemImage = findViewById(R.id.detailed_item_image);
        detailedItemImage.setImageResource(selectedItemImageId);

        TextView detailedItemDescription = findViewById(R.id.detailed_item_description);
        detailedItemDescription.setText(String.valueOf(selectedItemDescription));
    }
}
