package com.example.android.miwok;

/**
 * Created by mahmoud shaltoot on 2/19/2018.
 */

public class Word {
    private String defaultTransilation;
    private String miwokTransilation;
    private int imageID;
    private int audioID;

    public Word(String defaulttext, String miwoktext, int audioID) {
        this.defaultTransilation = defaulttext;
        this.miwokTransilation = miwoktext;
        this.audioID = audioID;
        imageID = 0;

    }

    public Word(String defaulttext, String miwoktext, int audioID, int imageID) {
        this.defaultTransilation = defaulttext;
        this.miwokTransilation = miwoktext;
        this.imageID = imageID;
        this.audioID = audioID;
    }


    public String getDefaultTransilation() {
        return defaultTransilation;
    }

    public String getMiwokTransilation() {
        return miwokTransilation;
    }

    public int getAudioID() {
        return this.audioID;
    }

    public int getImageID() {
        return imageID;
    }

    public boolean hasImage() {
        if (getImageID() != 0)
            return true;
        else
            return false;
    }


}
