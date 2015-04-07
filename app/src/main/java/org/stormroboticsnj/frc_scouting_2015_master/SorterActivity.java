package org.stormroboticsnj.frc_scouting_2015_master;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

import org.stormroboticsnj.frc_scouting_2015_master.adapters.CustomArrayAdapter;
import org.stormroboticsnj.frc_scouting_2015_master.adapters.CustomCursorAdapter;
import org.stormroboticsnj.frc_scouting_2015_master.database.DatabaseHandler;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;


public class SorterActivity extends Activity implements AdapterView.OnItemSelectedListener{
    String columnName = "";
    int rowIndex;
    //String array for SimpleCursorAdapter parameters.  Used to obtain the columns of the database to get the data to populate with
    String[] fromColumn = new String[]{DatabaseHandler.KEY_TEAM_NUMBER, DatabaseHandler.KEY_MATCH_NUMBER, DatabaseHandler.KEY_ALLIANCE,
            DatabaseHandler.KEY_ROBOT_AUTO, DatabaseHandler.KEY_NUMBER_TOTES_AUTO, DatabaseHandler.KEY_NUMBER_CONTAINERS_AUTO, DatabaseHandler.KEY_NUMBER_TOTES_STACKED_AUTO,
            DatabaseHandler.KEY_CONTAINERS_CENTER_AUTO, DatabaseHandler.KEY_TOTE_LEVEL1, DatabaseHandler.KEY_TOTE_LEVEL2, DatabaseHandler.KEY_TOTE_LEVEL3, DatabaseHandler.KEY_TOTE_LEVEL4,
            DatabaseHandler.KEY_TOTE_LEVEL5, DatabaseHandler.KEY_TOTE_LEVEL6, DatabaseHandler.KEY_CAN_LEVEL1, DatabaseHandler.KEY_CAN_LEVEL2, DatabaseHandler.KEY_CAN_LEVEL3,
            DatabaseHandler.KEY_CAN_LEVEL4, DatabaseHandler.KEY_CAN_LEVEL5, DatabaseHandler.KEY_CAN_LEVEL6, DatabaseHandler.KEY_NOODLE, DatabaseHandler.KEY_COOPLEVEL1,DatabaseHandler.KEY_COOPLEVEL2,DatabaseHandler.KEY_COOPLEVEL3,DatabaseHandler.KEY_COOPLEVEL4};
    ArrayList<String> columnNames = new ArrayList<String>();

    public void setColumnNames(ArrayList<String> columnNames) {
        this.columnNames = columnNames;
    }

    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        columnNames.add("Team Number");
        columnNames.add("Match Number");
        columnNames.add("Alliance");
        columnNames.add("Robot in Auto");
        columnNames.add("Totes in Auto");
        columnNames.add("Container Totes in Auto");
        columnNames.add("Stacked Totes");
        columnNames.add("Containers in center");
        columnNames.add("Tote Level 1");
        columnNames.add("Tote Level 2");
        columnNames.add("Tote Level 3");
        columnNames.add("Tote Level 4");
        columnNames.add("Tote Level 5");
        columnNames.add("Tote Level 6");
        columnNames.add("Container Level 1");
        columnNames.add("Container Level 2");
        columnNames.add("Container Level 3");
        columnNames.add("Container Level 4");
        columnNames.add("Container Level 5");
        columnNames.add("Container Level 6");
        columnNames.add("Noodle");
        columnNames.add("Coop Level 1");
        columnNames.add("Coop Level 2");
        columnNames.add("Coop Level 3");
        columnNames.add("Coop Level 4");

        setContentView(R.layout.activity_sorter);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        CustomArrayAdapter<CharSequence> spin_adapt = new CustomArrayAdapter (getApplicationContext(), columnNames);
        spinner.setAdapter(spin_adapt);
        spinner.setOnItemSelectedListener(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        search = (EditText) findViewById(R.id.search);

    }

    public void enter(View v){
        String team = search.getText().toString();
        if (DatabaseHandler.getInstance(getApplicationContext()).checkIfTeamIsInDatabase(team)) {
            EventBus.getDefault().postSticky(team);
            Intent intent = new Intent(getApplicationContext(), TeamReportActivity.class);
            startActivity(intent);
        }
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        columnName = fromColumn[(int) parent.getItemIdAtPosition(position)];
        rowIndex = (int) parent.getItemIdAtPosition(position);
        sort(view);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void sort(View v) {
        GridView listView = (GridView) findViewById(R.id.list);
        CustomCursorAdapter adapt = new CustomCursorAdapter(this, DatabaseHandler.getInstance(this).getSortedTeamData(columnName), 0, columnName, R.layout.database_list_layout);

        listView.setAdapter(adapt);

    }
}
