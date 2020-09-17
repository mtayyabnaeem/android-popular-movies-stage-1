package com.example.popularmoviesstage1;


import com.google.gson.annotations.SerializedName;



//TODO rename to Movie
public class Movie {

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("title")
    private String title;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("overview")
    private String overview;

    public String getOverview() {
        return overview;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getMovieTitle() {

        return title;
    }

    public String getPosterPath() {

        return posterPath;
    }
}
