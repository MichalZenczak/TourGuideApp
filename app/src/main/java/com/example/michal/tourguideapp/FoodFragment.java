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
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_items, container, false);

        final ArrayList<Item> foodPlacesList = new ArrayList<>();
        String[] foodPlacesNames = getResources().getStringArray(R.array.food_names);
        String[] foodPalacesDescription = getResources().getStringArray(R.array.food_description);
        String[] foodPlacesLocations = getResources().getStringArray(R.array.food_locations);
        int[] foodRoundImagesResourceIds = {R.mipmap.ic_bar_canete_round,R.mipmap.ic_cova_fumada_round,
                R.mipmap.ic_martinez_round, R.mipmap.ic_lomo_alto_round, R.mipmap.ic_disfrutar_round};
        int[] foodImagesResourceIds = {R.mipmap.ic_bar_canete_foreground,R.mipmap.ic_cova_fumada_foreground,
                R.mipmap.ic_martinez_foreground, R.mipmap.ic_lomo_alto_foreground, R.mipmap.ic_disfrutar_foreground};

        for (int i = 0; i < foodPlacesNames.length; i++) {
            foodPlacesList.add(new Item(foodPlacesNames[i], foodPalacesDescription[i],
                    foodRoundImagesResourceIds[i], foodImagesResourceIds[i], foodPlacesLocations[i]));
        }
        final ItemAdapter foodPlacesAdapter = new ItemAdapter(getActivity(), foodPlacesList);
        ListView listView = rootView.findViewById(R.id.list_of_items);
        listView.setAdapter(foodPlacesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item selectedItem = foodPlacesList.get(position);
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