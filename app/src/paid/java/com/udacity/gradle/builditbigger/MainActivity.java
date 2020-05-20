package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.nano.androiddisplayjokelib.JokeDetailsActivity;


public class MainActivity extends AppCompatActivity implements JokeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void tellJoke(View view) {
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onJokeLoaded(String joke) {
        Intent intent = new Intent(this, JokeDetailsActivity.class);
        intent.putExtra(JokeDetailsActivity.EXTRA_JOKE, joke);
        startActivity(intent);
    }
}
