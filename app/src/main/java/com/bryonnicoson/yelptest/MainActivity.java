package com.bryonnicoson.yelptest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.SearchResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private static final String CONSUMER_KEY = "";
    private static final String CONSUMER_SECRET = "";
    private static final String TOKEN = "";
    private static final String TOKEN_SECRET = "";
    Map<String, String> params = new HashMap<>();
    SearchResponse searchResponse;

    String test;
    // these need to be gathered via GPS call - can be bounding box built around location coordinates or
    // can use location
//    private static final Double latitude = 41.881832;
//    private static final Double longitude = -87.623177;

    @BindView(R.id.test_tv) TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        new Search().execute();

    }

    public class Search extends AsyncTask<Map, Void, SearchResponse>{
        @Override
        protected com.yelp.clientlib.entities.SearchResponse doInBackground(Map... maps) {
            YelpAPIFactory apiFactory = new YelpAPIFactory(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
            YelpAPI yelpAPI = apiFactory.createAPI();

            params.put("term", "food");
            params.put("limit", "10");

            Call<SearchResponse> call = yelpAPI.search("Chicago", params);

            try {
                searchResponse = call.execute().body();
                //Response<YelpResponse> response = call.execute();
                //yelpResponse = Gson.fromJson(response., YelpResponse.class);
                //yelpResponse = YelpResponse.parseJSON(response.body().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return searchResponse;
        }
        protected void onPostExecute(SearchResponse searchReponse) {
            tv.setText(searchReponse.businesses().get(0).name());
            Log.i("YELP", searchReponse.businesses().get(0).name());
        }
    }
}

