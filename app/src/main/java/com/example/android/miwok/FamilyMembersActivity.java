package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);


        final ArrayList<Word> familyMembers = new ArrayList<Word>();
        familyMembers.add(new Word("father","әpә",R.raw.family_father,R.drawable.family_father));
        familyMembers.add(new Word("mother", "әṭa",R.raw.family_mother,R.drawable.family_mother));
        familyMembers.add(new Word("son", "angsi",R.raw.family_son,R.drawable.family_son));
        familyMembers.add(new Word("daughter", "tune",R.raw.family_daughter,R.drawable.family_daughter));
        familyMembers.add(new Word("older brother", "taachi",R.raw.family_older_brother,R.drawable.family_older_brother));
        familyMembers.add(new Word("younger brother", "chalitti",R.raw.family_younger_brother,R.drawable.family_younger_brother));
        familyMembers.add(new Word("older sister", "teṭe",R.raw.family_older_sister,R.drawable.family_older_sister));
        familyMembers.add(new Word("younger sister", "kolliti",R.raw.family_younger_sister,R.drawable.family_younger_sister));
        familyMembers.add(new Word("grandmother", "ama",R.raw.family_grandmother,R.drawable.family_grandmother));
        familyMembers.add(new Word("grandfather", "paapa",R.raw.family_grandfather,R.drawable.family_grandfather));

        WordAdapter itemsAdapter = new WordAdapter(this, familyMembers,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mMediaPlayer = new MediaPlayer();

                mMediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, familyMembers.get(i).getAudioID());
                mMediaPlayer.start();
            }
        });

    }
}
