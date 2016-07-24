package com.bryonnicoson.yelptest.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryon on 7/22/16.
 */

public class Business {

    public String id;
    public String name;
    public String phone;
    public String displayPhone;
    public String url;
    public String imageUrl;
    public String mobileUrl;
    public String snippetImageUrl;
    public String snippetText;
    public Location location;
    public Boolean isClosed;
    public Double distance;

    public List<List<String>> categories = new ArrayList<List<String>>();

    public Double rating;
    public String ratingImgUrl;
    public String ratingImgUrlSmall;
    public String ratingImgUrlLarge;
    public Integer reviewCount;

    public Boolean isClaimed;


}
