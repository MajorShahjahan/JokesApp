package com.example.jokesapp.controller;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jokesapp.R;
import com.example.jokesapp.model.Joke;

import androidx.annotation.NonNull;

public class CardsDataAdapter extends ArrayAdapter<String> {

    Context mContext;
    private boolean isClicked = true;
    private JokeLikeListener jokeLikeListener;
    private Joke mJoke;

    public CardsDataAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        mContext = context;

        jokeLikeListener = (JokeLikeListener) context;
    }

    @Override
    public View getView(int position, final View contentView, ViewGroup parent){
        //supply the layout for your card
        TextView v = (TextView)(contentView.findViewById(R.id.content));
        v.setText(getItem(position));

        ImageButton likeButton = contentView.findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext,"Like Button is Tapped",Toast.LENGTH_SHORT).show();

                if (isClicked){

                    likeButton.setImageResource(R.drawable.like_filled);
                    isClicked = false;

                    mJoke = new Joke(getItem(position),true);
                    jokeLikeListener.jokeIsLiked(mJoke);


                }else {

                    likeButton.setImageResource(R.drawable.like_empty);
                    isClicked = true;

                    mJoke = new Joke(getItem(position),false);
                    jokeLikeListener.jokeIsLiked(mJoke);
                }

            }
        });


        return contentView;
    }

}
