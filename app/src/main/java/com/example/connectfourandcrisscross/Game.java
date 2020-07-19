package com.example.connectfourandcrisscross;

import android.widget.ImageView;

public class Game {
    public String text;
    public int img;
    public Game(String text,int img) {
        this.text = text;

    }

    public String getText() {
        return text;
    }

    public int getImg() {
        return img;
    }
}
