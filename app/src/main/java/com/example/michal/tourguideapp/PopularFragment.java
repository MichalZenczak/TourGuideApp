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
public class PopularFragment extends Fragment {

    public PopularFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_of_items, container, false);

        final ArrayList<Item> popularPlacesList = new ArrayList<>();
        String[] popularPlacesNames = getResources().getStringArray(R.array.popular_places_names);
        String[] popularPalacesDescription = getResources().getStringArray(R.array.popular_places_description);
        String[] popularPlacesLocations = getResources().getStringArray(R.array.popular_places_locations);
        int[] popularRoundImagesResourceIds = {R.mipmap.ic_sagrada_familia_round,R.mipmap.ic_park_guel_round,
                R.mipmap.ic_la_rambla_round, R.mipmap.ic_camp_nou_round, R.mipmap.ic_tibidabo_round};
        int[] popularImagesResourceIds = {R.mipmap.ic_sagrada_familia_foreground,R.mipmap.ic_park_guel_foreground,
                R.mipmap.ic_la_rambla_foreground, R.mipmap.ic_camp_nou_foreground, R.mipmap.ic_tibidabo_foreground};

        for (int i = 0; i < popularPlacesNames.length; i++) {
            popularPlacesList.add(new Item(popularPlacesNames[i], popularPalacesDescription[i],
                    popularRoundImagesResourceIds[i], popularImagesResourceIds[i], popularPlacesLocations[i]));
        }
        final ItemAdapter popularPlacesAdapter = new ItemAdapter(getActivity(), popularPlacesList);
        ListView listView = rootView.findViewById(R.id.list_of_items);
        listView.setAdapter(popularPlacesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item selectedItem = popularPlacesList.get(position);
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