package com.example.michal.tourguideapp;

public class Item {

    private String mLocationName;
    private int mImageResourceId;

    public Item(String locationName, int imageResourceId) {
        mLocationName = locationName;
        mImageResourceId = imageResourceId;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

}
