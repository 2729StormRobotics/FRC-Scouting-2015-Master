package org.lrhsd.storm.frc_scouting_2015_master.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.lrhsd.storm.frc_scouting_2015_master.R;


public class DownloadFragment extends Fragment {

    public static View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_download, container, false);
        return view;
    }
}