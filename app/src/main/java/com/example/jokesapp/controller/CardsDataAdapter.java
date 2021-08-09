package com.example.jokesapp.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jokesapp.R;
import com.example.jokesapp.model.Joke;
import com.example.jokesapp.model.JokeManager;

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
        TextView vr = (TextView)(contentView.findViewById(R.id.content));
        vr.setText(getItem(position));

        ImageButton likeButton = contentView.findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isClicked){

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

        ImageButton shareImageButton = contentView.findViewById(R.id.shareButton);
        shareImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                String shareBody =vr.getText().toString();
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Mama Joke!");
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                vr.getContext().startActivity(Intent.createChooser(intent,"Share"));
            }
        });



        return contentView;
    }

}
