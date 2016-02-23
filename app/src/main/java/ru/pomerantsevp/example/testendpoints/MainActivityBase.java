package ru.pomerantsevp.example.testendpoints;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ru.pomerantsevp.example.jokedisplay.JokeActivity;

/**
 * Created by pavel on 2/23/16.
 */
public abstract class MainActivityBase extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runAd();
    }

    abstract void runAd();

    public void tellJoke(View view){
        (new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                Intent intent = new Intent(MainActivityBase.this, JokeActivity.class);
                intent.putExtra(JokeActivity.INTENT_JOKE_KEY, result);
                MainActivityBase.this.startActivity(intent);
            }
        }).execute();
    }
}
