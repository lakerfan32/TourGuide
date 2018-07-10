package com.example.ralph.tourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Set the content of the activity to use the activity_main.xml layout file
         */
        setContentView(R.layout.activity_main);

        /**
         * Find the ViewPager that allows the user to swipe between fragments
         */
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        /**
         * Create an adapter that knows where each fragment should be shown on each page
         */
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        /**
         * Set adapter onto the view pager
         */
        viewPager.setAdapter(adapter);

        /**
         * Find the TabLayout that shows the category tabs
         */
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        /**
         * Connect the TabLayout with the ViewPager.
         * This will update the tabs and ViewPager according to each swipe.
         */
        tabLayout.setupWithViewPager(viewPager);
    }
}
