package com.example.michal.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_items, container, false);

        final ArrayList<Item> hotelList = new ArrayList<>();
        String[] hotelNames = getResources().getStringArray(R.array.hotel_names);
        String[] hotelDescription = getResources().getStringArray(R.array.hotel_description);
        String[] hotelLocations = getResources().getStringArray(R.array.hotel_locations);
        int[] hotelRoundImagesResourceIds = {R.mipmap.ic_w_barcelona_round, R.mipmap.ic_mandarin_oriental_round,
                R.mipmap.ic_hotel_espana_round, R.mipmap.ic_serras_hotel_round};
        int[] hotelImagesResourceIds = {R.mipmap.ic_w_barcelona_foreground, R.mipmap.ic_mandarin_oriental_foreground,
                R.mipmap.ic_hotel_espana_foreground, R.mipmap.ic_serras_hotel_foreground};

        for (int i = 0; i < hotelNames.length; i++) {
            hotelList.add(new Item(hotelNames[i], hotelDescription[i],
                    hotelRoundImagesResourceIds[i], hotelImagesResourceIds[i], hotelLocations[i]));
        }
        final ItemAdapter hotelAdapter = new ItemAdapter(getActivity(), hotelList);
        ListView listView = rootView.findViewById(R.id.list_of_items);
        listView.setAdapter(hotelAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item selectedItem = hotelList.get(position);
                Intent myIntent = new Intent(getContext(), DetailedItem.class);
                myIntent.putExtra("selectedItem", selectedItem.getLocationName());
                myIntent.putExtra("selectedItemDescription", selectedItem.getLocationDescription());
                myIntent.putExtra("imageResourceId", selectedItem.getImageResourceId());
                myIntent.putExtra("geoLocation",selectedItem.getGeoLocation());
                startActivity(myIntent);
            }
        });
        return rootView;
    }
}