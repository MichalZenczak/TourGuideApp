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
public class HistoricFragment extends Fragment {

    public HistoricFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_items, container, false);

        final ArrayList<Item> historicalPlacesList = new ArrayList<>();
        String[] historicalPlacesNames = getResources().getStringArray(R.array.historical_places_names);
        String[] historicalPalacesDescription = getResources().getStringArray(R.array.historical_places_description);
        String[] historicalPlacesLocations = getResources().getStringArray(R.array.historical_places_locations);
        int[] historicalRoundImagesResourceIds = {R.mipmap.ic_arc_de_triomf_round,R.mipmap.ic_casa_batllo_round,
                R.mipmap.ic_hosp_de_sant_pau_round, R.mipmap.ic_santa_maria_del_pi_round, R.mipmap.ic_columbus_monument_round};
        int[] historicalImagesResourceIds = {R.mipmap.ic_arc_de_triomf_foreground,R.mipmap.ic_casa_batllo_foreground,
                R.mipmap.ic_hosp_de_sant_pau_foreground, R.mipmap.ic_santa_maria_del_pi_foreground, R.mipmap.ic_columbus_monument_foreground};

        for (int i = 0; i < historicalPlacesNames.length; i++) {
            historicalPlacesList.add(new Item(historicalPlacesNames[i], historicalPalacesDescription[i],
                    historicalRoundImagesResourceIds[i], historicalImagesResourceIds[i], historicalPlacesLocations[i]));
        }
        final ItemAdapter historicalPlacesAdapter = new ItemAdapter(getActivity(), historicalPlacesList);
        ListView listView = rootView.findViewById(R.id.list_of_items);
        listView.setAdapter(historicalPlacesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item selectedItem = historicalPlacesList.get(position);
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