package com.example.ralph.tourguide;

/**
 * {@link Info} represents the information about sights, activities, restaurants,
 * lodging, and events. It contains the name, location, details, description and image for each item.
 */

public class Info {

    /** Name for ListView item object **/
    private String mName;

    /** Quick details for object **/
    private String mFact;

    /** More detailed description of object, displayed in {@link InfoActivity} **/
    private String mDescription;

    /** Location of object, usually a hyperlink if object has address **/
    private String mLocation;

    /** Image resource ID for the object **/
    private int mImageResourceId;

    /**
     * Create an Info object
     *
     * @param name is the title or name associated with Info object
     *
     * @param fact is a short one-line fact about the object to draw interest from the user
     *
     * @param imageResourceId is the resource ID associated with the object image
     *
     * @param description is the information about the object
     *
     * @param location is the address of the object via a hyperlink to a Maps app
     */
    public Info(String name, String fact, int imageResourceId, String description, String location) {
        mName = name;
        mFact = fact;
        mImageResourceId = imageResourceId;
        mDescription = description;
        mLocation = location;
    }

    /** Get the Name of the object **/
    public String getName() {
        return mName;
    }

    /** Get the Facts on the object **/
    public String getDetails() {
        return mFact;
    }

    /** Get the Description of the object **/
    public String getDescription() {
        return mDescription;
    }

    /** Get the Location of the object **/
    public String getLocation() {
        return mLocation;
    }

    /** Get the Image resource ID of the object **/
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
