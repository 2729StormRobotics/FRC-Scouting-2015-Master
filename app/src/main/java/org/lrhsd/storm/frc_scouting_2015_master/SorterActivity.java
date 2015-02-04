package org.lrhsd.storm.frc_scouting_2015_master;

import android.app.ListActivity;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.lrhsd.storm.frc_scouting_2015_master.database.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;


public class SorterActivity extends ListActivity implements AdapterView.OnItemSelectedListener {
    String columnname = "";
    String[] fromcolumn = new String[]{};
    int[] toview = new int[]{};
    Cursor cursor;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorter);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> spin_adapt = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
        spin_adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spin_adapt);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sorter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sorter(String column){

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch ((int) parent.getItemIdAtPosition(position)) {
            case 0:
                columnname = DatabaseHandler.KEY_TEAM_NUMBER;
                break;
            case 1:
                columnname = DatabaseHandler.KEY_MATCH_NUMBER;
                break;
            case 2:
                columnname = DatabaseHandler.KEY_ALLIANCE;
                break;
            case 3:
                columnname = DatabaseHandler.KEY_ROBOT_AUTO;
                break;
            case 4:
                columnname = DatabaseHandler.KEY_NUMBER_TOTES_AUTO;
                break;
            case 5:
                columnname = DatabaseHandler.KEY_NUMBER_CONTAINERS_AUTO;
                break;
            case 6:
                columnname = DatabaseHandler.KEY_NUMBER_TOTES_STACKED_AUTO;
                break;
            case 7:
                columnname = DatabaseHandler.KEY_TOTE_LEVEL1;
                break;
            case 8:
                columnname = DatabaseHandler.KEY_TOTE_LEVEL2;
                break;
            case 9:
                columnname = DatabaseHandler.KEY_TOTE_LEVEL3;
                break;
            case 10:
                columnname = DatabaseHandler.KEY_TOTE_LEVEL3;
                break;
            case 11:
                columnname = DatabaseHandler.KEY_TOTE_LEVEL4;
                break;
            case 12:
                columnname = DatabaseHandler.KEY_TOTE_LEVEL5;
                break;
            case 13:
                columnname = DatabaseHandler.KEY_TOTE_LEVEL6;
                break;
            case 14:
                columnname = DatabaseHandler.KEY_CAN_LEVEL1;
                break;
            case 15:
                columnname = DatabaseHandler.KEY_TOTE_LEVEL2;
                break;
            case 16:
                columnname = DatabaseHandler.KEY_CAN_LEVEL3;
                break;
            case 17:
                columnname = DatabaseHandler.KEY_CAN_LEVEL4;
                break;
            case 18:
                columnname = DatabaseHandler.KEY_CAN_LEVEL5;
                break;
            case 19:
                columnname = DatabaseHandler.KEY_CAN_LEVEL6;
                break;
            case 20:
                columnname = DatabaseHandler.KEY_NOODLE;
                break;
            case 21:
                columnname = DatabaseHandler.KEY_COOP;
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
