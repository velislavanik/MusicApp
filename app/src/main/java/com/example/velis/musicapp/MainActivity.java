package com.example.velis.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of Song objects
        final ArrayList<Song> androidSongs = new ArrayList<>();
        androidSongs.add(new Song("Bohemian Rhapsody", "Queen", R.drawable.guitar1));
        androidSongs.add(new Song("Stairway to Heaven", " Led Zeppelin", R.drawable.guitar2));
        androidSongs.add(new Song("Imagine", "John Lennon", R.drawable.guitar3));
        androidSongs.add(new Song("Smells Like Teen Spirit", "Nirvana", R.drawable.guitar4));
        androidSongs.add(new Song("Hotel California", "Eagles", R.drawable.guitar5));
        androidSongs.add(new Song("Sweet Child O'Mine", "Guns N' Roses", R.drawable.guitar8));
        androidSongs.add(new Song("Hey Jude", "The Beatles", R.drawable.guitar9));
        androidSongs.add(new Song("Like a Rolling Stone", "Bob Dylan", R.drawable.guitar10));

        // Create an {@link SongAdapter}, whose data source is a list of
        // {@link Song}s. The adapter knows how to create list item views for each item
        // in the list.
        SongAdapter songsAdapter = new SongAdapter(this, androidSongs);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(songsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // 1. create an intent pass class name or intent action name
                Intent intent = new Intent(MainActivity.this, SongDetailsActivity.class);

                // 2. create person object
                if (i >= 0) {
                    Song person2 = androidSongs.get(i);

                    // 3. put person in intent data
                    intent.putExtra("person", person2);

                    // 4. start the activity
                    startActivity(intent);
                }
            }


        });
    }
}
