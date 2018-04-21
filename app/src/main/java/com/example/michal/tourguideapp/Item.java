package com.example.michal.tourguideapp;

public class Item {

    private String mLocationName;
    private String mLocationDescription;
    private int mRoundImageResourceId;
    private int mImageResourceId;


    public Item(String locationName, String locationDescription, int imageRoundResourceId, int imageResourceId) {
        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mRoundImageResourceId = imageRoundResourceId;
        mImageResourceId = imageResourceId;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public String getLocationDescription() {
        return mLocationDescription;
    }

    public int getRoundImageResourceId() {
        return mRoundImageResourceId;
    }
    public int getImageResourceId() {
        return mImageResourceId;
    }


}
