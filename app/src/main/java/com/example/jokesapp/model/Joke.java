package com.example.jokesapp.model;

public class Joke {

    private String jokeText;
    private boolean jokeLiked;

    public Joke(String jokeText, boolean jokeLiked) {
        this.jokeText = jokeText;
        this.jokeLiked = jokeLiked;
    }

    public String getJokeText() {
        return jokeText;
    }

    public void setJokeText(String jokeText) {
        this.jokeText = jokeText;
    }

    public boolean isJokeLiked() {
        return jokeLiked;
    }

    public void setJokeLiked(boolean jokeLiked) {
        this.jokeLiked = jokeLiked;
    }
}
