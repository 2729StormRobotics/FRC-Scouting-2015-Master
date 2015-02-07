package org.lrhsd.storm.frc_scouting_2015_master;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

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

    public void analyze(View view){
        DatabaseHandler db = DatabaseHandler.getInstance(this);
        db.addTeamData();
        db.getAllTeamData();
        Intent intent = new Intent(this, SorterActivity.class);
        startActivity(intent);

    }

    public void clearDatabase(View v){
        new AlertDialog.Builder(this)
                .setTitle("Clear Database")
                .setMessage("Are you sure you want to clear the database?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (DatabaseHandler.getInstance(getApplicationContext()).checkIfEmpty() == false) {
                            DatabaseHandler.getInstance(getApplicationContext()).clearTable();
                        } else {
                            Toast.makeText(getApplicationContext(), "Database is already empty", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}

