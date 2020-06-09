package com.example.moha.omar.somalitoenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
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

        words.add(new word ("Hold up a minute. i want to check someting  ", "daqiiqad sug. waxaan rabaa inaan hubiyo wax", R.raw.phrase1 ) );
        words.add (new word("I can't find my keys , so i'll look around", "ma heli karo furayadayda, sidaa darteed waan raadin doonaa",R.raw.phrase2));
        words.add (new word("I hope to bring about successfull conclusion:  ", "Waxaan rajeynayaa inaan keeno natiijo guul leh",R.raw.phrase3));
        words.add (new word("The new computers make for much great productivity", "kombiyuutarada cusub ayaa sameeya wax soo saar badan.",R.raw.phrase4));
        words.add (new word("Don't try to come after me", "Ha isku dayin inaad i soo raacdid",R.raw.phrase5));

        words.add (new word("Give me back my book", "buuggayga dib iigu celi",R.raw.phrase6));
        words.add (new word("He tried to keep away from danger", "wuxuu isku dayay inuu ka fogaado khatarta",R.raw.phrase11));
        words.add (new word("I looked at the possibility of buying a new car", "Waxaan eegay suurtagalnimada iibsashada gaari cusub",R.raw.phrase7));
        words.add (new word("I put in an extra hour in work today","Waxaan geliyay saacad dheeraad ah shaqada maanta",R.raw.phrase8));
        words.add (new word("please come in and look around", "fadlan soo gal oo hareeraha fiiri",R.raw.phrase9));
        words.add (new word("That flight just come in.", "duulimaadkaas ayaa imanaya.",R.raw.phrase10));
        wordAdapter adapter = new wordAdapter (this, words ,R.color.category_phrases );

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
                mMediaPlayer = MediaPlayer.create(PhrasesActivity   .this, word.getSaudioResourceId ( ));

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
