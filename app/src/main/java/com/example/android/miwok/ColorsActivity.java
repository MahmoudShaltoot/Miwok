package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        final ArrayList<Word> colors = new ArrayList<Word>();
        colors.add(new Word("red", "weṭeṭṭi",R.raw.color_red,R.drawable.color_red));
        colors.add(new Word("green", "chokokki",R.raw.color_green,R.drawable.color_green));
        colors.add(new Word("brown", "ṭakaakki",R.raw.color_brown,R.drawable.color_brown));
        colors.add(new Word("gray", "ṭopoppi",R.raw.color_gray,R.drawable.color_gray));
        colors.add(new Word("black", "kululli",R.raw.color_black,R.drawable.color_black));
        colors.add(new Word("white", "kelelli",R.raw.color_white,R.drawable.color_white));
        colors.add(new Word("dusty yellow", "ṭopiisә",R.raw.color_dusty_yellow,R.drawable.color_dusty_yellow));
        colors.add(new Word("mustard yellow", "chiwiiṭә",R.raw.color_mustard_yellow,R.drawable.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this, colors,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mMediaPlayer = new MediaPlayer();

                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, colors.get(i).getAudioID());
                mMediaPlayer.start();
            }
        });

    }

}
