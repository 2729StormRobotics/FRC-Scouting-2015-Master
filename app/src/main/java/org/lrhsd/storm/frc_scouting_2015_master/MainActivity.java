package org.lrhsd.storm.frc_scouting_2015_master;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import org.lrhsd.storm.frc_scouting_2015_master.database.DatabaseHandler;
import org.lrhsd.storm.frc_scouting_2015_master.scanner.ScannerActivity;

public class MainActivity extends FragmentActivity {


    //Handle pop-ups
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    }

    //When Scanner button pressed
    public void scan(View view) {
        Intent intent = new Intent(this, ScannerActivity.class);
        startActivity(intent);

    }

    public void analyze(View view) {
        clearDatabase();
        DatabaseHandler db = DatabaseHandler.getInstance(this);
        db.addTeamData();
        db.getAllTeamData();
        Intent intent = new Intent(this, SorterActivity.class);
        startActivity(intent);

    }

    public void clearDatabase() {
        DatabaseHandler.getInstance(getApplicationContext()).clearTable();
    }

}

