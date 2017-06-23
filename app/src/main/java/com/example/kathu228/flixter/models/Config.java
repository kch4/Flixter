package com.example.kathu228.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kathu228 on 6/22/17.
 */

public class Config {

    // the bic url for loading images
    String imageBaseUrl;
    // the poster size to use when fetching
    String posterSize;
    // the backdrop size to use when fetching images
    String backdropSize;

    public static final String youtube_api_key = "AIzaSyAv0BphiZiYUylpOQa4UJNAdHNGKUqVrbs";

    public Config(JSONObject object) throws JSONException {
        // parse images
        JSONObject images = object.getJSONObject("images");
        // get image base url
        imageBaseUrl =  images.getString("secure_base_url");
        // get poster size array
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        // get poster size at index 3
        posterSize = posterSizeOptions.optString(3, "w342");
        // parse the backdrop sizes and use the option at index 1 or w780 as fallback
        JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
        backdropSize = backdropSizeOptions.optString(1, "w780");

    }

    // helper method for creating urls
    public String getImageURL(String size, String path){
        return String.format("%s%s%s", imageBaseUrl,size,path); //concatenate all three
    }
    public String getImageBaseUrl() {
        return imageBaseUrl;
    }
    public String getPosterSize() {
        return posterSize;
    }
    public String getBackdropSize() {
        return backdropSize;
    }
}
