package com.example.moha.omar.somalitoenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
  private MediaPlayer    mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.word_list );
        //  creating Array of word from word class
        final ArrayList<word > words = new ArrayList<word> ();

        words.add (new word("Blue", "Buluug",R.drawable.blue, R.raw.blue ));
        words.add (new word("Black", "Madoow",R.drawable.color_black, R.raw.black));
        words.add (new word("Brown", "Kafee",R.drawable.color_brown,R.raw.brown ));
        words.add (new word("Yellow", "Jaale/Huruud",R.drawable.color_mustard_yellow,R.raw.yellow));
        words.add (new word("White", "Cadaan",R.drawable.color_white,R.raw.white));
        words.add (new word("Pink", "Basali",R.drawable.pink,R.raw.pink));
        words.add (new word("Green", "Cagaar",R.drawable.color_green,R.raw.green));
        words.add (new word("Orange", "Oranjo",R.drawable.orange ,R.raw.orange));

        words.add (new word("Red", "Casaan/Guduud",R.drawable.color_red ,R.raw.red));

        wordAdapter adapter = new wordAdapter (this, words,R.color.category_colors  );

        ListView listView = findViewById (R.id.lists );
        listView.setAdapter (adapter );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int position,long l) {
                releaseMediaPlayer();
                // Get the {@link Word} object at the given position the user clicked on
                word  word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(ColorsActivity  .this, word.getSaudioResourceId ( ));

                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
