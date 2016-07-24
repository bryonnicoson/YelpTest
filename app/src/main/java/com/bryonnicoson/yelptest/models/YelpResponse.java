package com.bryonnicoson.yelptest.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bryon on 7/22/16.
 */
public class YelpResponse {

    public Region region;
    public Integer total;
    public List<Business> businesses;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public YelpResponse(){
        businesses = new ArrayList<Business>();
    }

    public static YelpResponse parseJSON(String response){
        // Type collectionType = new TypeToken<List<Business>>(){}; use to
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
        // gsonBuilder.registerTypeAdapter();  use to convert date ?
        Gson gson = new GsonBuilder().create();

        YelpResponse yelpResponse = gson.fromJson(response, YelpResponse.class);
        return yelpResponse;
    }
}
