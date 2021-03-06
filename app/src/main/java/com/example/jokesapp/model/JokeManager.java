package com.example.jokesapp.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JokeManager {

    private Context mContext;
    private SharedPreferences sharedPreferences;

    public JokeManager(Context mContext) {
        this.mContext = mContext;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public void saveJoke(Joke joke){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(joke.getJokeText(),joke.isJokeLiked());
        editor.apply();

    }

    public void deleteJoke(Joke joke){

        if (sharedPreferences.contains(joke.getJokeText())){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(joke.getJokeText());
        }
    }

    public List<Joke> retrieveJokes () {

        Map<String, ?> data = sharedPreferences.getAll();
        List<Joke> jokes = new ArrayList<>();
        for (Map.Entry<String, ?> entry : data.entrySet()) {

            Joke joke = new Joke(entry.getKey(), (boolean) entry.getValue());

            if (entry.getKey().matches("variations_seed_native_stored")) {
                continue;
            }
            jokes.add(joke);
        }

      return jokes;
    }
}
