package com.example.ralph.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Info} objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given position number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AboutFragment();
        } else if (position == 1) {
            return new CityFragment();
        } else if (position == 2) {
            return new ShopFragment();
        } else if (position == 3) {
            return new NatureFragment();
        } else {
            return new SocialFragment();
        }
    }

    /**
     * Return the total number of pages
     */
    @Override
    public int getCount() {
        return 5;
    }

    /**
     * Provides the titles of tabs for each fragment
     * @param position is the position number of each tab
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.fragment_about);
        } else if (position == 1) {
            return mContext.getString(R.string.fragment_city);
        } else if (position == 2) {
            return mContext.getString(R.string.fragment_shop);
        } else if (position == 3) {
            return mContext.getString(R.string.fragment_nature);
        } else {
            return mContext.getString(R.string.fragment_social);
        }
    }
}