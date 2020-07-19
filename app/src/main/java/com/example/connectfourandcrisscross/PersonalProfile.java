package com.example.connectfourandcrisscross;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class PersonalProfile extends Fragment {
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.personal_profile,
                container, false);
        return v;
    }
}
