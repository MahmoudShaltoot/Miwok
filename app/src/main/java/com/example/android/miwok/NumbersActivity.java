package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;
    MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        final ArrayList<Word> numbers = new ArrayList<Word>();
        numbers.add(new Word("one","lutti",R.raw.number_one,R.drawable.number_one));
        numbers.add(new Word("two", "otiiko",R.raw.number_two,R.drawable.number_two));
        numbers.add(new Word("three", "tolookosu",R.raw.number_three,R.drawable.number_three));
        numbers.add(new Word("four", "oyyisa",R.raw.number_four,R.drawable.number_four));
        numbers.add(new Word("five", "massokka",R.raw.number_five,R.drawable.number_five));
        numbers.add(new Word("six", "temmokka",R.raw.number_six,R.drawable.number_six));
        numbers.add(new Word("seven", "kenekaku",R.raw.number_seven,R.drawable.number_seven));
        numbers.add(new Word("eight", "kawinta",R.raw.number_eight,R.drawable.number_eight));
        numbers.add(new Word("nine", "wo’e",R.raw.number_nine,R.drawable.number_nine));
        numbers.add(new Word("ten", "na’aacha",R.raw.number_ten,R.drawable.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, numbers,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        //ListView is filled with Word Objects



        //Listener on ListItems To Play the appropriate sound
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, numbers.get(i).getAudioID());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
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
