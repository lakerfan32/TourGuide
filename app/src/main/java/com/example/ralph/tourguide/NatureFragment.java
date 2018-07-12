package com.example.ralph.tourguide;

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
 * A simple {@link Fragment} subclass that displays an ArrayList of nature sites within Miami.
 */
public class NatureFragment extends Fragment {

    // Creates keys for ListView item data
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_LOCATION = "KEY_LOCATION";
    public static final String KEY_FACT = "KEY_FACT";
    public static final String KEY_DRAWABLE = "KEY_DRAWABLE";
    public static final String KEY_DESCRIPTION = "KEY_DESCRIPTION";

    public NatureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        /**
         * Creates a list of nature sites
         * Beaches photo courtesy of http://meetusinmiami.blogspot.com/2011/10/student-life-in-miami.html
         * Everglades National Park photo courtesy of https://cbairboatrides.com/gallery
         * Venetian Pool photo courtesy of Shutterstock/Marco Borghini https://www.timeout.com/
         *      miami/things-to-do/venetian-pool-miami-fl
         * Key West photo courtesy of https://www.travellingdany.com/
         *      epic-road-trip-from-miami-to-key-west/
         */
        final ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(getContext().getString(R.string.beaches_name),
                getContext().getString(R.string.beaches_fact), R.drawable.beaches,
                getContext().getString(R.string.beaches_description),
                getContext().getString(R.string.beaches_location)));
        info.add(new Info(getContext().getString(R.string.everglades_name),
                getContext().getString(R.string.everglades_fact), R.drawable.everglades,
                getContext().getString(R.string.everglades_description),
                getContext().getString(R.string.everglades_location)));
        info.add(new Info(getContext().getString(R.string.venetian_pool_name),
                getContext().getString(R.string.venetian_pool_fact), R.drawable.venetian_pool,
                getContext().getString(R.string.venetian_pool_description),
                getContext().getString(R.string.venetian_pool_location)));
        info.add(new Info(getContext().getString(R.string.key_west_name),
                getContext().getString(R.string.key_west_fact), R.drawable.key_west,
                getContext().getString(R.string.key_west_description),
                getContext().getString(R.string.key_west_location)));

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
