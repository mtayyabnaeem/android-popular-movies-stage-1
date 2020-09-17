package com.example.popularmoviesstage1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
// API calls are made here for Popular and Top Rated movies.

    @GET("movie/popular?api_key=56e13caa83283369bdc35dba762d6723")
    Call<MovieResponse> getPopular();

    @GET("movie/top_rated?api_key=56e13caa83283369bdc35dba762d6723")
    Call<MovieResponse> getTopRated();
}
