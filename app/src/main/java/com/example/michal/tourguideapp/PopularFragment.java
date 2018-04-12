package com.example.michal.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_of_items, container, false);

        final ArrayList<Item> popularPlacesList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            popularPlacesList.add(new Item("Location " + i, R.drawable.ic_satellite_black_24dp));
        }
        ItemAdapter popularPlacesAdapter = new ItemAdapter(getActivity(), popularPlacesList, R.color.colorPopularPlaces);
        ListView listView = rootView.findViewById(R.id.list_of_items);
        listView.setAdapter(popularPlacesAdapter);


        return rootView;
    }

}
