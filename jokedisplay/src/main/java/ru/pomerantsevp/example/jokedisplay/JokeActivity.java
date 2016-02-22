package ru.pomerantsevp.example.jokedisplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static final String INTENT_JOKE_KEY = "joke";
    private static final String BUNDLE_JOKE_KEY = "bundled_joke";

    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        if (savedInstanceState == null) {
            mJoke = getIntent().getStringExtra(INTENT_JOKE_KEY);
        } else {
            mJoke = savedInstanceState.getString(BUNDLE_JOKE_KEY);
        }
        TextView jokeTextView = (TextView) findViewById(R.id.joke_text);
        jokeTextView.setText(mJoke);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BUNDLE_JOKE_KEY, mJoke);
    }
}
