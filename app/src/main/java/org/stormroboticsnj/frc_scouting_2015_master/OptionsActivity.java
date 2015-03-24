package org.stormroboticsnj.frc_scouting_2015_master;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import org.stormroboticsnj.frc_scouting_2015_master.database.DatabaseHandler;

public class OptionsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(org.stormroboticsnj.frc_scouting_2015_master.R.layout.activity_options);
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
