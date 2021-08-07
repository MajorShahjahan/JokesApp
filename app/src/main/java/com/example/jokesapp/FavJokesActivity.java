package com.example.jokesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jokesapp.fragments.FavJokesFragment;

public class FavJokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_joke);

        FavJokesFragment mFavJokesFragment = new FavJokesFragment().newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.Fav_Jokes_Container,mFavJokesFragment).commit();

    }
}