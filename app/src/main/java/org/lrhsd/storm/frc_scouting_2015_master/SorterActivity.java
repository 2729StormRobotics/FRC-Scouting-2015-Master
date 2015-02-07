package org.lrhsd.storm.frc_scouting_2015_master;

import android.app.ListActivity;
import android.database.Cursor;
import android.media.session.PlaybackState;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import java.util.ArrayList;

import org.lrhsd.storm.frc_scouting_2015_master.database.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;


public class SorterActivity extends ListActivity implements AdapterView.OnItemSelectedListener {
    String columnName = "";
    //String array for SimpleCursorAdapter parameters.  Used to obtain the columns of the database to get the data to populate with
    String[] fromColumn = new String[]{DatabaseHandler.KEY_TEAM_NUMBER, DatabaseHandler.KEY_MATCH_NUMBER, DatabaseHandler.KEY_ALLIANCE,
                                       DatabaseHandler.KEY_ROBOT_AUTO, DatabaseHandler.KEY_NUMBER_TOTES_AUTO, DatabaseHandler.KEY_NUMBER_CONTAINERS_AUTO, DatabaseHandler.KEY_NUMBER_TOTES_STACKED_AUTO,
                                       DatabaseHandler.KEY_TOTE_LEVEL1, DatabaseHandler.KEY_TOTE_LEVEL2, DatabaseHandler.KEY_TOTE_LEVEL3, DatabaseHandler.KEY_TOTE_LEVEL4,
                                       DatabaseHandler.KEY_TOTE_LEVEL5, DatabaseHandler.KEY_TOTE_LEVEL6, DatabaseHandler.KEY_CAN_LEVEL1, DatabaseHandler.KEY_CAN_LEVEL2, DatabaseHandler.KEY_CAN_LEVEL3,
                                       DatabaseHandler.KEY_CAN_LEVEL4, DatabaseHandler.KEY_CAN_LEVEL5, DatabaseHandler.KEY_CAN_LEVEL6, DatabaseHandler.KEY_NOODLE, DatabaseHandler.KEY_COOP};
    //Integer array for SimpleCursorAdapter parameters.  Used to direct what views get what data
    int[] toview = new int[]{R.id.team, R.id.match, R.id.alliance, R.id.robot_auto, R.id.totes_auto, R.id.container_auto, R.id.stack_auto, R.id.tote_one, R.id.tote_two, R.id.tote_three, R.id.tote_four, R.id.tote_five,
                             R.id.tote_six, R.id.cont_one, R.id.cont_two, R.id.cont_three, R.id.cont_four, R.id.cont_five, R.id.cont_six, R.id.noodle, R.id.coop};
    //Cursor to hold database query results
    Cursor cursor;
    //To sort the listviews properly
    Spinner spinner;
    //Listview to populate
    ListView view;
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
        columnName= fromColumn[(int)parent.getItemIdAtPosition(position)];

        /*switch ((int) parent.getItemIdAtPosition(position)) {
            case 0:
                columnName = DatabaseHandler.KEY_TEAM_NUMBER;
                 
                break;
            case 1:
                columnName = DatabaseHandler.KEY_MATCH_NUMBER;
                 
                break;
            case 2:
                columnName = DatabaseHandler.KEY_ALLIANCE;
                 
                break;
            case 3:
                columnName = DatabaseHandler.KEY_ROBOT_AUTO;
                 
                break;
            case 4:
                columnName = DatabaseHandler.KEY_NUMBER_TOTES_AUTO;
                 
                break;
            case 5:
                columnName = DatabaseHandler.KEY_NUMBER_CONTAINERS_AUTO;
                 
                break;
            case 6:
                columnName = DatabaseHandler.KEY_NUMBER_TOTES_STACKED_AUTO;
                 
                break;
            case 7:
                columnName = DatabaseHandler.KEY_TOTE_LEVEL1;
                 
                break;
            case 8:
                columnName = DatabaseHandler.KEY_TOTE_LEVEL2;
                 
                break;
            case 9:
                columnName = DatabaseHandler.KEY_TOTE_LEVEL3;
                 
                break;
            case 10:
                columnName = DatabaseHandler.KEY_TOTE_LEVEL3;
                 
                break;
            case 11:
                columnName = DatabaseHandler.KEY_TOTE_LEVEL4;
                 
                break;
            case 12:
                columnName = DatabaseHandler.KEY_TOTE_LEVEL5;
                 
                break;
            case 13:
                columnName = DatabaseHandler.KEY_TOTE_LEVEL6;
                 
                break;
            case 14:
                columnName = DatabaseHandler.KEY_CAN_LEVEL1;
                 
                break;
            case 15:
                columnName = DatabaseHandler.KEY_TOTE_LEVEL2;
                 
                break;
            case 16:
                columnName = DatabaseHandler.KEY_CAN_LEVEL3;
                 
                break;
            case 17:
                columnName = DatabaseHandler.KEY_CAN_LEVEL4;
                 
                break;
            case 18:
                columnName = DatabaseHandler.KEY_CAN_LEVEL5;
                 
                break;
            case 19:
                columnName = DatabaseHandler.KEY_CAN_LEVEL6;
                 
                break;
            case 20:
                columnName = DatabaseHandler.KEY_NOODLE;
                 
                break;
            case 21:
                columnName = DatabaseHandler.KEY_COOP;
   
                break;
        }*/

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void sort(View v){
        Log.d("ColumnName",columnName);

        Log.d("ColumnName2",columnName);
       ArrayAdapter adapt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, DatabaseHandler.getInstance(this).getSortedTeamData(columnName));

        //view.setAdapter(adapt);
        ListView listView = (ListView)findViewById(R.id.list_item);
        listView.setAdapter(adapt);

    }
}
