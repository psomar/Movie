package com.somar.moview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;

import java.util.List;

public class FavouriteMovieActivity extends AppCompatActivity {

    private final static String TAG = "FavouriteMovieActivity";

    private static final String EXTRA_FAVOURITE = "favourite";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_movie);
        RecyclerView recyclerViewFavouriteMovie = findViewById(R.id.recyclerViewFavouriteMovie);
        MoviesAdapter moviesAdapter = new MoviesAdapter();
        recyclerViewFavouriteMovie.setAdapter(moviesAdapter);
        moviesAdapter.setOnMovieClickListener(new MoviesAdapter.onMovieClickListener() {
            @Override
            public void onMovieClick(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(
                        FavouriteMovieActivity.this,
                        movie
                );
                startActivity(intent);
            }
        });

        recyclerViewFavouriteMovie.setLayoutManager(new GridLayoutManager(this,
                2));

        FavouriteMovieViewModel viewModel = new ViewModelProvider(this).get(
                FavouriteMovieViewModel.class);

        viewModel.getGetFavouriteMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                moviesAdapter.setMovies(movies);
            }
        });
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, FavouriteMovieActivity.class);
    }
}