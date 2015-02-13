package org.lrhsd.storm.frc_scouting_2015_master;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import org.lrhsd.storm.frc_scouting_2015_master.database.DatabaseHandler;



public class SorterActivity extends Activity implements AdapterView.OnItemSelectedListener {
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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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
        //sort(view);

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
   /* public void sort(View v){
        Log.d("ColumnName",columnName);

        Log.d("ColumnName2",columnName);
       CustomCursorAdapter adapt = new CustomCursorAdapter(this,DatabaseHandler.getInstance(this).getSortedTeamData(columnName),0,columnName,R.layout.database_list_layout);
        
        //view.setAdapter(adapt);
        GridView listView = (GridView)findViewById(R.id.list);

        listView.setAdapter(adapt);

    }*/
}
