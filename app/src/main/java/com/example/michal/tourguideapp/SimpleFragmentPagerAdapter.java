package com.example.michal.tourguideapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 4;
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PopularFragment();
        } else if (position == 1) {
            return new HistoricFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else {
            return new HotelsFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.fragment_popular_title);
        } else if (position == 1) {
            return mContext.getString(R.string.fragment_historic_title);
        } else if (position == 2) {
            return mContext.getString(R.string.fragment_food_title);
        } else {
            return mContext.getString(R.string.fragment_hotels_title);
        }
    }
}
