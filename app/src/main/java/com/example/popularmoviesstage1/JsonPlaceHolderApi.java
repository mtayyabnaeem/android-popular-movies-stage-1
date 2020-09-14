package com.example.popularmoviesstage1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("movie/popular?api_key=56e13caa83283369bdc35dba762d6723")
    Call<MovieResponse> getPosts();
}
