package com.example.ralph.tourguide;

import android.app.Activity;
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
 * A simple {@link Fragment} subclass that displays an ArrayList of sites in the city within Miami.
 */
public class CityFragment extends Fragment {

    // Creates keys for ListView item data
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_LOCATION = "KEY_LOCATION";
    public static final String KEY_FACT = "KEY_FACT";
    public static final String KEY_DRAWABLE = "KEY_DRAWABLE";
    public static final String KEY_DESCRIPTION = "KEY_DESCRIPTION";

    public CityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        /**
         * Creates a list of sites in the city of Miami
         * South Beach photo courtesy of http://www.miamiandbeaches.com/places-to-see/
         *      south-beach-art-deco-district
         * Vizcaya Museum and Gardens photo courtesy of http://www.miamiandbeaches.com/arts/
         *      vizcaya-museum-and-gardens/100789
         * Calle Ocho photo courtesy of https://www.mebymelia.com/destination-guide/little-havana/
         */
        final ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(getContext().getString(R.string.south_beach_name),
                getContext().getString(R.string.south_beach_fact), R.drawable.south_beach,
                getContext().getString(R.string.south_beach_description),
                getContext().getString(R.string.south_beach_location)));
        info.add(new Info(getContext().getString(R.string.vizcaya_name),
                getContext().getString(R.string.vizcaya_fact), R.drawable.vizcaya,
                getContext().getString(R.string.vizcaya_description),
                getContext().getString(R.string.vizcaya_location)));
        info.add(new Info(getContext().getString(R.string.calle_ocho_name),
                getContext().getString(R.string.calle_ocho_fact), R.drawable.calle_ocho,
                getContext().getString(R.string.calle_ocho_description),
                getContext().getString(R.string.calle_ocho_location)));

        /**
         * Create an {@link InfoAdapter} and populates with data sourced from {@link Info}.
         */
        InfoAdapter adapter = new InfoAdapter(getActivity(), info);

        /**
         * Finds the {@link ListView} object in the view hierarchy of the {@link Activity}.
         * There is a view ID called list in the list_view.xml file.
        */
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        /**
         * Sets the {@link ListView} to use the {@link InfoAdapter} to display list items for each
         * {@link Info} object.
         */
        listView.setAdapter(adapter);

        /**
         * Sets an onItemClickListener(), gets the position of clicked item, and calls an explicit intent.
         * Extras sent to the {@link InfoActivity} include all {@link Info} object data, except for distance.
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Info item = info.get(position);
                Intent details = new Intent(getContext(), InfoActivity.class);
                details.putExtra(KEY_NAME, item.getName());
                details.putExtra(KEY_LOCATION, item.getLocation());
                details.putExtra(KEY_FACT, item.getDetails());
                details.putExtra(KEY_DESCRIPTION, item.getDescription());
                details.putExtra(KEY_DRAWABLE, item.getImageResourceId());
                startActivity(details);
            }
        });

        return rootView;
    }
}