package com.bryonnicoson.yelptest.models;

import com.yelp.clientlib.entities.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bryon on 7/22/16.
 */
public class Location {

    public String city;
    public List<String> displayAddress = new ArrayList<String>();
    public Double geoAccuracy;
    public List<String> neighborhood = new ArrayList<String>();
    public String postalCode;
    public String countryCode;
    public List<String> address = new ArrayList<String>();
    public Coordinate coordinate;
    public String stateCode;
}
