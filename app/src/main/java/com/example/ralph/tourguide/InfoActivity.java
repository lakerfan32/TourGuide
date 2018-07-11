package com.example.ralph.tourguide;

/**
 * Created by Ralph on 7/9/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.ralph.tourguide.CityFragment.KEY_DESCRIPTION;
import static com.example.ralph.tourguide.CityFragment.KEY_DRAWABLE;
import static com.example.ralph.tourguide.CityFragment.KEY_FACT;
import static com.example.ralph.tourguide.CityFragment.KEY_LOCATION;
import static com.example.ralph.tourguide.CityFragment.KEY_NAME;

/**
 * A {@link InfoActivity} that displays the data of an object from {@link Info}.
 * Data unique to this site is a fact and description to provide more information
 * about a particular object.
 */

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        String currentName = "";
        String currentLocation = "";
        String currentFact = "";
        String currentDescription = "";

        // Gets String extras from clicked ListView item
        Intent intent = getIntent();
        if (null != intent) {
            currentName = intent.getStringExtra(KEY_NAME);
            currentLocation = intent.getStringExtra(KEY_LOCATION);
            currentFact = intent.getStringExtra(KEY_FACT);
            currentDescription = intent.getStringExtra(KEY_DESCRIPTION);
        }

        // Gets image resource ID from clicked ListView item and stores in currentDrawable variable
        Bundle extras = getIntent().getExtras();
        int currentDrawable = extras.getInt(KEY_DRAWABLE);

        // Finds ImageView and sets the image resource ID to clicked ListView item object
        ImageView imageView = (ImageView) findViewById(R.id.current_drawable);
        imageView.setImageResource(currentDrawable);

        // Finds TextView and sets text to clicked ListView item object
        TextView currentNameText = (TextView) findViewById(R.id.current_name);
        currentNameText.setText(currentName);

        // Finds TextView and sets text to clicked ListView item object
        TextView currentLocationText = (TextView) findViewById(R.id.current_location);
        currentLocationText.setText(currentLocation);
        currentLocationText.setMovementMethod(LinkMovementMethod.getInstance());

        // Finds TextView and sets text to clicked ListView item object
        TextView currentFactText = (TextView) findViewById(R.id.current_fact);
        currentFactText.setText(currentFact);

        // Finds TextView and sets text to clicked ListView item object
        TextView currentDescriptionText = (TextView) findViewById(R.id.current_description);
        currentDescriptionText.setText(currentDescription);
    }
}
