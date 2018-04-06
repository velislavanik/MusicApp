package com.example.velis.musicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Velis on 01.04.2018.
 * {@link SongAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link Song} objects.
 */

 public class SongAdapter extends ArrayAdapter<Song> {

    // private static final String LOG_TAG =SongAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param songs   a List of Song objects to display in a list
     */
     SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    public android.view.View getView(int position, View convertView, @NonNull android.view.ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the song_name
        TextView songNameTextView = listItemView.findViewById(R.id.song_name);
        // Get the song name from the current Song object and
        // set this text on the name TextView
        if (currentSong != null) {
            songNameTextView.setText( currentSong.getSongName());
        }

        // Find the TextView in the list_item.xml layout with the artist name
        TextView artistNameTextView = listItemView.findViewById(R.id.artist_name);
        // Get the artist name from the current Song object and
        // set this text on the number TextView

        if (currentSong != null) {
            artistNameTextView.setText(currentSong.getArtistName());
        }

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current Song object and
        // set the image to iconView
        if(currentSong != null){
            iconView.setImageResource(currentSong.getImageRecourseId());
        }
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
