package com.example.popularmoviesstage1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {


    @SerializedName("page")
    public int page;

    @SerializedName("results")
    public List<Post> resultsList;

}
