package org.lrhsd.storm.frc_scouting_2015_master;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.lrhsd.storm.frc_scouting_2015_master.adapter.ViewPagerAdapter;
import org.lrhsd.storm.frc_scouting_2015_master.databaseHandler.*;
import org.lrhsd.storm.frc_scouting_2015_master.scanner.ScannerActivity;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    //Scouter id for qr
    final String SCOUTER_ID = "@stormscouting ";

    //Storage of the strings
    String[] tempStorage = new String[30];

    //Database for data
    public static DBHelper db;

    TextView tv;

    //Handle pop-ups
    boolean yes = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Looks for viewpager in activity_main.xml

        ViewPager viewpager = (ViewPager) this.findViewById(R.id.pager);
        viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        db = new DBHelper(this);


    }

    //When Scanner button pressed
    public void scan(View view){
        Intent intent = new Intent(this, ScannerActivity.class);
        startActivity(intent);

    }
    //Clears Database of data
    public void clearData(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Clear Database");
        builder.setMessage("Are you sure you want to do this?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.yes = true;
                MainActivity.db.clearDB();

            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.yes = false;
            }
        });
        AlertDialog action = builder.create();
        action.show();
    }

}

