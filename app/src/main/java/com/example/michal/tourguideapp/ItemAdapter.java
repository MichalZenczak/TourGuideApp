package com.example.michal.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by michal on 4/12/18.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    private int mColorResourceId;

    public ItemAdapter(Context context, ArrayList<Item> itemList, int colorResourceId) {
        super(context, 0, itemList);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
