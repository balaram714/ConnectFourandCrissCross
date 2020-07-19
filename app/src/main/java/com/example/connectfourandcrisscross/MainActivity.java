package com.example.connectfourandcrisscross;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class MainActivity extends Activity {
 public ConnectFourGame mconnectFourGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display=getWindowManager().getDefaultDisplay();
        Point size=new Point();
        display.getSize(size);
        mconnectFourGame=new ConnectFourGame(this,size);
        setContentView(mconnectFourGame);

    }
    @Override
    protected void onResume() {
        super.onResume();
        mconnectFourGame.resume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mconnectFourGame.pause();
    }
}
