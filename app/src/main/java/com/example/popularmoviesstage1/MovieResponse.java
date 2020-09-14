package com.example.popularmoviesstage1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {



    @SerializedName("results")
    public List<Post> resultsList;

    @SerializedName("results/genre_ids")
    public List<Post> genre_ids_list;



}
