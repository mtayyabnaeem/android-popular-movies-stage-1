package com.example.popularmoviesstage1;


import com.google.gson.annotations.SerializedName;

public class Post {

  @SerializedName("poster_path")
    private String posterPath;

  @SerializedName("title")
    private String title;

    public String getMovieTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }


    public Post(String title) {
        this.title = title;

    }




}
