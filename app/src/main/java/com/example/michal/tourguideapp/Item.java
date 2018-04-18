package com.example.michal.tourguideapp;

public class Item {

    private String mLocationName;
    private String mLocationDescription;
    private int mImageResourceId;


    public Item(String locationName, String locationDescription, int imageResourceId) {
        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mImageResourceId = imageResourceId;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public String getLocationDescription() {
        return mLocationDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

}
