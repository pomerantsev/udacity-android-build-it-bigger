package ru.pomerantsevp.example.testendpoints;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import ru.pomerantsevp.example.jokedisplay.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
                mAdView.loadAd(adRequest);
    }

    public void tellJoke(View view){
        (new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                Intent intent = new Intent(MainActivity.this, JokeActivity.class);
                intent.putExtra(JokeActivity.INTENT_JOKE_KEY, result);
                MainActivity.this.startActivity(intent);
            }
        }).execute();
    }
}

