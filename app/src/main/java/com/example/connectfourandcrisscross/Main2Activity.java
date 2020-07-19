package com.example.connectfourandcrisscross;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements Animation.AnimationListener {
Animation animZoomin;
TextView textStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loadAnimations();
        loadUI();
        working();
    }
    public void loadAnimations(){
       animZoomin= AnimationUtils.loadAnimation(
               this, R.anim.zoom_in);
    }
public void loadUI(){
    textStatus = (TextView) findViewById(R.id.textView);
}
public void working(){
    animZoomin.setDuration(5000);
    animZoomin.setAnimationListener(this);
    textStatus.startAnimation(animZoomin);
}

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent=new Intent(this,Main3Activity.class);
        startActivity(intent);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
