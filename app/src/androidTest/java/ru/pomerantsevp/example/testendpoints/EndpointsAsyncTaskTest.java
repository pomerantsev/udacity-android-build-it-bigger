package ru.pomerantsevp.example.testendpoints;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by pavel on 2/23/16.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase {
    public void testDoInBackground() {
        final CountDownLatch signal = new CountDownLatch(1);

        (new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String s) {
                assert s.length() > 0;
                signal.countDown();
            }
        }).execute();
        try {
            signal.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            fail("Timed out");
        }
    }
}
