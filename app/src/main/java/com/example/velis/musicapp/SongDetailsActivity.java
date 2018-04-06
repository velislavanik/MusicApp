package com.example.velis.musicapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;

public class SongDetailsActivity extends AppCompatActivity {

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        TextView userName = findViewById(R.id.s_name);
        TextView artistName = findViewById(R.id.a_name);
        ImageView img = findViewById(R.id.img);
        Intent i = getIntent();

        Song sng = (Song) i.getSerializableExtra("person");
        userName.setText(sng.getSongName());
        artistName.setText(sng.getArtistName());
        img.setImageResource(sng.getImageRecourseId());

        final Button button = findViewById(R.id.play);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String url = "http://programmerguru.com/android-tutorial/wp-content/uploads/2013/04/hosannatelugu.mp3";
                if (player == null) {
                    player = new MediaPlayer();
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {
                        player.setDataSource(url);
                        player.prepare(); // might take long! (for buffering, etc)
                        player.start();
                    } catch (IOException e) {
                        Log.v("AUDIOHTTPPLAYER", e.getMessage());
                    }
                }
            }
        });

        final Button button1 = findViewById(R.id.stop);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Auto-generated method stub
                if (player != null && player.isPlaying()) {
                    player.stop();
                    player.release();
                    player = null;
                }
            }
        });
    }
}
