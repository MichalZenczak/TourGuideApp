package com.example.michal.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

    public ItemAdapter(Context context, ArrayList<Item> itemList) {
        super(context, 0, itemList);
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
        itemImage.setImageResource(currentItem.getRoundImageResourceId());

        return listOfItemsView;
    }
}
