package com.example.popularmoviesstage1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PopularMoviesActivity extends AppCompatActivity implements PopularMoviesAdapter.ItemClickListener {

    PopularMoviesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(PopularMoviesActivity.this, numberOfColumns));
        adapter = new PopularMoviesAdapter(PopularMoviesActivity.this);
        adapter.setClickListener(PopularMoviesActivity.this);
        recyclerView.setAdapter(adapter);

        LoadPopularMovies();

    }


    public void LoadPopularMovies(){
        // using retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<MovieResponse> call = jsonPlaceHolderApi.getPopular();
        call.enqueue(new Callback<MovieResponse>() {

            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.i("Pakistan", "" + response.body().resultsList + response.body().genre_ids_list);

                adapter.setData(response.body().resultsList);


            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }


    public void LoadTopRatedMovies(){
        // using retrofit
        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi2 = retrofit2.create(JsonPlaceHolderApi.class);
        Call<MovieResponse> call2 = jsonPlaceHolderApi2.getTopRated();
        call2.enqueue(new Callback<MovieResponse>() {

            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.i("Pakistan", "" + response.body().resultsList);
                adapter.setData(response.body().resultsList);


            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){


            case R.id.Popular:
               LoadPopularMovies();
                Toast.makeText(this, "Displaying Popular Movies", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Top_Rated:
                LoadTopRatedMovies();
                Toast.makeText(this, "Displaying Top Rated Movies", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onItemClick(View view, int position) {
        Context context = getApplicationContext();
        CharSequence text = "You clicked number " +  position;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
//        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);

        launchMovieDetailsActivity(position);




    }

    private void launchMovieDetailsActivity(int position) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra(MovieDetailsActivity.EXTRA_POSITION, position);
        startActivity(intent);
    }

}