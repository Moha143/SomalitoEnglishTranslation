package com.example.moha.omar.somalitoenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class numbersActivity extends AppCompatActivity {
private  MediaPlayer mMediaPlayer ;
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
     final    ArrayList<word > words = new ArrayList<word> ();

        words.add(new word ("One  ", "Kow",R.drawable.number_one, R.raw.number_one ) );
        words.add (new word("Two", "Labo ",R.drawable.number_two , R.raw.number_two ));
        words.add (new word("Three", "Saddex",R.drawable.number_three , R.raw.number_three ));
        words.add (new word("Four", "afar",R.drawable.number_four, R.raw.number_four  ));
        words.add (new word("Five", "Shan",R.drawable.number_five , R.raw.number_five ));

        words.add (new word("Six", "Lix",R.drawable.number_six ,  R.raw.number_six ));
        words.add (new word("Seven", "Todobo",R.drawable.number_seven, R.raw.number_seven  ));
        words.add (new word("Eight", "Sideed",R.drawable.number_eight , R.raw.number_eight ));
        words.add (new word("Nine", "Sagaal",R.drawable.number_nine,  R.raw.number_nine  ));
        words.add (new word("Ten", "Toban",R.drawable.number_ten , R.raw.number_ten ));
        wordAdapter adapter = new wordAdapter (this, words ,R.color.category_numbers);

        ListView listView = findViewById (R.id.lists );
        listView.setAdapter (adapter );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                word  word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(numbersActivity .this, word.getSaudioResourceId ( ));

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
