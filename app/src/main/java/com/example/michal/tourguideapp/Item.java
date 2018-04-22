package com.example.michal.tourguideapp;

public class Item {

    private String mLocationName;
    private String mLocationDescription;
    private String mGeoLocation;
    private int mRoundImageResourceId;
    private int mImageResourceId;

    public Item(String locationName, String locationDescription, int imageRoundResourceId,
                int imageResourceId, String geoLocation) {
        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mRoundImageResourceId = imageRoundResourceId;
        mImageResourceId = imageResourceId;
        mGeoLocation = geoLocation;
    }

    public String getLocationName() {
        return mLocationName;
    }
    public String getLocationDescription() {
        return mLocationDescription;
    }
    public String getGeoLocation(){return mGeoLocation;}
    public int getRoundImageResourceId() {
        return mRoundImageResourceId;
    }
    public int getImageResourceId() {
        return mImageResourceId;
    }



}
