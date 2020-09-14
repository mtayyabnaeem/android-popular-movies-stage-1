package com.example.popularmoviesstage1;


import com.google.gson.annotations.SerializedName;

public class Post {

  @SerializedName("poster_path")
    private String posterPath;



    public String getPosterPath() {
        return posterPath;
    }
}
