package com.example.velis.musicapp;
import java.io.Serializable;

/**
 * Created by Velis on 01.04.2018.
 * * {@link Song} represents a single object.
 * Each object has 3 properties: song name, artist name, and image resource ID.
 */

public class Song implements Serializable{
    // Name of the song
    private String songName;
    // Name of the artist
    private String artistName;
    // Drawable resource ID
    private int imageRecourseId;

   /*
   * Create a new AndroidFlavor object.
   *
   * @name is the name of the song
   * @artist is the name of the artist
   * @resourceId image is drawable reference ID
   * */
    Song(String name, String artist, int resourceId) {
        songName = name;
        artistName = artist;
        imageRecourseId = resourceId;
        //find the view that shows the song
    }

    public void setName(String name){
        songName=name;
    }

     /**
     * Get the name of the song
     */
    String getSongName() {
        return songName;
    }

    /**
     * Get the name of the song
     */
    String getArtistName() {
        return artistName;
    }

    /**
     * Get the name of the song
     */
    int getImageRecourseId() {
        return imageRecourseId;
    }

    @Override
    public String toString() {
        return "Person [name=" + songName + ", age=" + artistName+ "]";
    }
}
