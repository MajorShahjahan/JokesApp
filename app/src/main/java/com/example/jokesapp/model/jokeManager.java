package com.example.jokesapp.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class jokeManager {

    private Context mContext;
    private SharedPreferences sharedPreferences;

    public jokeManager(Context mContext) {
        this.mContext = mContext;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }
}
