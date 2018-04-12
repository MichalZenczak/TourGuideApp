package com.example.michal.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ItemAdapter extends ArrayAdapter<Item> {

    private int mColorResourceId;

    public ItemAdapter(Context context, ArrayList<Item> itemList, int colorResourceId) {
        super(context, 0, itemList);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listOfItemsView = convertView;
        if (listOfItemsView == null) {
            listOfItemsView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        Item currentItem = getItem(position);

        TextView itemText = listOfItemsView.findViewById(R.id.item_text);
        itemText.setText(currentItem.getLocationName());

        ImageView itemImage = listOfItemsView.findViewById(R.id.item_image);
        itemImage.setImageResource(currentItem.getImageResourceId());


        // Set the theme color for the list item
        View textContainer = listOfItemsView.findViewById(R.id.item_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        return listOfItemsView;
    }
}
