package com.example.popularmoviesstage1;

import android.content.Intent;
import android.graphics.Movie;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.net.CookieHandler;

public class MovieDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE_TITLE = "extra_movie_title";
    public static final String EXTRA_POSTER_PATH = "extra_poster_path";
    public static final String EXTRA_RELEASE_DATE = "extra_release_date";
    public static final String EXTRA_VOTE_AVERAGE = "extra_vote_average";
    public static final String EXTRA_OVERVIEW = "extra_overview";

    ImageView poster;

    TextView title, releaseDate, voteAverage, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

//        linking ImageViews and TextViews to activity_movie_details.xml

        poster = findViewById(R.id.movie_poster);

        title = findViewById(R.id.title);

        releaseDate = findViewById(R.id.release_date);

        voteAverage = findViewById(R.id.vote_average);

        overview = findViewById(R.id.overview);

//        extracting data from PopularMoviesActivity, and displaying it on activity_movie_details.xml on MovieDetailsActivity

        Intent intent = getIntent();

        String posterPath = intent.getStringExtra(EXTRA_POSTER_PATH);

        Picasso.get().load(posterPath).into(poster);

        String movieTitle = "Title: " + intent.getStringExtra(EXTRA_MOVIE_TITLE);

        title.setText(movieTitle);


        String movieReleaseDate = "Release Date: " + intent.getStringExtra(EXTRA_RELEASE_DATE);

        releaseDate.setText(movieReleaseDate);

        String movieVoteAverage = "Vote Average: " + intent.getStringExtra(EXTRA_VOTE_AVERAGE);

        voteAverage.setText(movieVoteAverage);

        String movieOverview = "Overview: \n" + intent.getStringExtra(EXTRA_OVERVIEW);

        overview.setText(movieOverview);

    }
}