package com.example.connectfourandcrisscross;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Instructions mAdapter;
    List<Game> noteList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        recyclerView = (RecyclerView)
                findViewById(R.id.recyclerView);
        noteList=new ArrayList<>();
        Game g1=new Game("ConnectFour",R.drawable.connectgame);
        Game g2=new Game("crissCross",R.drawable.downloadabc);
        noteList.add(g1);
        noteList.add(g2);
        mAdapter = new Instructions(this, noteList);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

// set the adapter
        recyclerView.setAdapter(mAdapter);

    }
    public void abc(){
        setContentView(R.layout.instruction_connectfour);
    }

}
