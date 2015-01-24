package org.lrhsd.storm.frc_scouting_2015_master;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import android.widget.Toast;

import org.lrhsd.storm.frc_scouting_2015_master.databaseHandler.*;
import org.lrhsd.storm.frc_scouting_2015_master.scanner.ScannerActivity;

public class MainActivity extends FragmentActivity {



    //Handle pop-ups
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    //When Scanner button pressed
    public void scan(View view){
        Intent intent = new Intent(this, ScannerActivity.class);
        startActivity(intent);

    }
    

}

