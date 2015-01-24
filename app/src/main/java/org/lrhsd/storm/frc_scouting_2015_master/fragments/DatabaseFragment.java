package org.lrhsd.storm.frc_scouting_2015_master.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lrhsd.storm.frc_scouting_2015_master.R;


public class DatabaseFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from fragmenttab1.xml
        View view = inflater.inflate(R.layout.fragment_database, container, false);
        return view;
    }
}
