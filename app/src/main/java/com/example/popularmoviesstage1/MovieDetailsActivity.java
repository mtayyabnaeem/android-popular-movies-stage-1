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
    public static final String EXTRA_POSITION = "extra_position";

Post post;
ImageView poster;

TextView title, releaseDate, voteAverage, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        poster = findViewById(R.id.movie_poster);

        title = findViewById(R.id.title);

        releaseDate = findViewById(R.id.release_date);

        voteAverage = findViewById(R.id.vote_average);

        overview = findViewById(R.id.overview);


//        String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
//        ImageView ivBasicImage = (ImageView) findViewById(R.id.ivBasicImage);
//        Picasso.get().load(imageUri).into(ivBasicImage);


    }
}