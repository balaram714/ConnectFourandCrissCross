package com.example.connectfourandcrisscross;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class HowtoPlay extends Fragment {
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.how_to_play,
                container, false);
        return v;
    }
}
