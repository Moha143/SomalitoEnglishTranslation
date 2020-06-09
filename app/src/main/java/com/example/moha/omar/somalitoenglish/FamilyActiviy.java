package com.example.moha.omar.somalitoenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActiviy extends AppCompatActivity {
    private MediaPlayer  mMediaPlayer;
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
final         ArrayList<word > words = new ArrayList<word> ();

        words.add(new word ("Grandfather  ", "Awoowe",R.drawable.family_grandfather ,R.raw.gfather ) );
        words.add (new word("Grandmother", "Ayeeyo",R.drawable.family_grandmother,R.raw.gmother ));
        words.add (new word("Father", "Aabe",R.drawable.family_father, R.raw.father  ));
        words.add (new word("Mother", "Hooyo",R.drawable.family_mother ,R.raw.mother ));
        words.add (new word("Brother", "walaal",R.drawable.family_older_brother ,R.raw.brother ));
        words.add (new word("Wife", "Xaas",R.drawable.family_older_sister ,R.raw.wife  ));
        words.add (new word("Doughter", "Gabadh",R.drawable.family_younger_sister,R.raw.doughter   ));
        words.add (new word("Son", "Will",R.drawable.family_younger_brother ,R.raw.son  ));
        words.add (new word("Children", "Caruur",R.drawable.children ,R.raw.children ));
        wordAdapter adapter = new wordAdapter (this, words , R.color.category_family);

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
                mMediaPlayer = MediaPlayer.create(FamilyActiviy   .this, word.getSaudioResourceId ( ));

                // Start the audio file
                mMediaPlayer.start();
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
