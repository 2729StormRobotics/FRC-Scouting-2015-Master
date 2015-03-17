package org.lrhsd.storm.frc_scouting_2015_master;

import android.app.Activity;
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

    public void analyze(View view) {
        Intent intent = new Intent(this, SorterActivity.class);
        startActivity(intent);

    }

    public void makeDatabaseFromCSV(View view){
        final Activity a = this;
        new AlertDialog.Builder(this)
                .setTitle("Make Database")
                .setMessage("Are you sure you want to make a database from the CSV? All data will be in the database will be overwritten.")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseHandler.getInstance(getApplicationContext()).makeDatabaseFromCSV(a);
                        Toast.makeText(getApplicationContext(), "Database Created", Toast.LENGTH_SHORT).show();
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



        public void makeCSV(View view) {
            new AlertDialog.Builder(this)
                    .setTitle("Make CSV")
                    .setMessage("Are you sure you want to make a CSV File?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            DatabaseHandler.getInstance(getApplicationContext()).makeCSV();
                            Toast.makeText(getApplicationContext(), "CSV File Created", Toast.LENGTH_SHORT).show();
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


    public void clearDatabase(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Delete Data")
                .setMessage("Are you sure you want to delete all data?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseHandler.getInstance(getApplicationContext()).clearTable();
                        Toast.makeText(getApplicationContext(), "Data Deleted", Toast.LENGTH_SHORT).show();
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



