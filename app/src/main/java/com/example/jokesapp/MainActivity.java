package com.example.jokesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.jokesapp.controller.CardsDataAdapter;
import com.example.jokesapp.model.Joke;
import com.wenchao.cardstack.CardStack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardStack.CardEventListener {

    CardStack mCardStack;
    CardsDataAdapter mCardAdapter;
    private List<Joke> allJokes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("jokes",loadJSONFromAsset());
        mCardStack = findViewById(R.id.container);

        mCardStack.setContentResource(R.layout.joke_card);
        mCardStack.setStackMargin(20);

        mCardAdapter = new CardsDataAdapter(getApplicationContext(),0);
       try {

           JSONObject rootObject = new JSONObject(loadJSONFromAsset());
           JSONArray fatJokes = rootObject.getJSONArray("fat");
           addJokesTOArrayList(fatJokes,allJokes);

           JSONArray stupidJokes = rootObject.getJSONArray("stupid");
           addJokesTOArrayList(stupidJokes,allJokes);

           JSONArray uglyJokes = rootObject.getJSONArray("ugly");
           addJokesTOArrayList(uglyJokes,allJokes);

           JSONArray nastyJokes = rootObject.getJSONArray("nasty");
           addJokesTOArrayList(nastyJokes,allJokes);

           JSONArray odorJokes = rootObject.getJSONArray("odor");
           addJokesTOArrayList(odorJokes,allJokes);

           JSONArray hairyJokes = rootObject.getJSONArray("hairy");
           addJokesTOArrayList(hairyJokes,allJokes);

           JSONArray baldJokes = rootObject.getJSONArray("bald");
           addJokesTOArrayList(baldJokes,allJokes);

           JSONArray oldJokes = rootObject.getJSONArray("old");
           addJokesTOArrayList(oldJokes,allJokes);

           JSONArray poorJokes = rootObject.getJSONArray("poor");
           addJokesTOArrayList(poorJokes,allJokes);

           JSONArray shortJokes = rootObject.getJSONArray("short");
           addJokesTOArrayList(shortJokes,allJokes);

           JSONArray skinnyJokes = rootObject.getJSONArray("skinny");
           addJokesTOArrayList(skinnyJokes,allJokes);

           JSONArray tallJokes = rootObject.getJSONArray("tall");
           addJokesTOArrayList(tallJokes,allJokes);

           JSONArray gotJokes = rootObject.getJSONArray("got");
           addJokesTOArrayList(gotJokes,allJokes);

           JSONArray likeJokes = rootObject.getJSONArray("like");
           addJokesTOArrayList(likeJokes,allJokes);

           JSONArray musicJokes = rootObject.getJSONArray("music");
           addJokesTOArrayList(musicJokes,allJokes);



       }catch (JSONException e){
           e.printStackTrace();
       }

       for (Joke joke : allJokes){

           mCardAdapter.add(joke.getJokeText());
       }
        mCardStack.setAdapter(mCardAdapter);

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("jokes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void addJokesTOArrayList(JSONArray jsonArray, List<Joke> arrayList)
    {
        try {
            if (jsonArray !=null){
                for (int i = 0; i<jsonArray.length();i++){

                    arrayList.add(new Joke(jsonArray.getString(i),false));
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean swipeEnd(int section, float distance) {
        return (distance>300)? true : false;
    }

    @Override
    public boolean swipeStart(int section, float distance) {
        return true;
    }

    @Override
    public boolean swipeContinue(int section, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void discarded(int mIndex, int direction) {

    }

    @Override
    public void topCardTapped() {

    }
}