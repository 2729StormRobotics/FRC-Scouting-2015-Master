package org.lrhsd.storm.frc_scouting_2015_master;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;

import org.lrhsd.storm.frc_scouting_2015_master.adapters.CustomArrayAdapter;
import org.lrhsd.storm.frc_scouting_2015_master.database.DatabaseHandler;
import org.lrhsd.storm.frc_scouting_2015_master.database.TeamData;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;


public class TeamReportActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    String matchNum;
    ArrayList<String> _teamMatches;
    ArrayList<String[]> _teamsData;
    TeamData teamData;
    String _team;
    ScrollView scroll;
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_team_report_layout);
        search = (EditText) findViewById(R.id.searchReport);
        _team = EventBus.getDefault().removeStickyEvent(String.class);
        _teamsData = DatabaseHandler.getInstance(getApplicationContext()).getOneTeamsData(_team);
        _teamMatches = DatabaseHandler.getInstance(getApplicationContext()).getTeamMatches();
        teamData = EventBus.getDefault().removeStickyEvent(TeamData.class);
        scroll = (ScrollView) findViewById(R.id.scrollView1);
        CustomArrayAdapter<String> ad = new CustomArrayAdapter<String>(getApplicationContext(), _teamMatches);
        Spinner spin = (Spinner) findViewById(R.id.spinner2);
        spin.setAdapter(ad);
        spin.setOnItemSelectedListener(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Log.d("TeamMatches.get",_teamMatches.get((int)parent.getItemIdAtPosition(position)));
        matchNum = _teamMatches.get((int) parent.getItemIdAtPosition(position));
        if(matchNum.equals("Summary")) {
            scroll.removeAllViews();
            addToScrollView(teamData, _team, -1);
        }else if(matchNum.equals("Average")){

            scroll.removeAllViews();
            addToScrollView(teamData, _team, -2);

        }else{
            scroll.removeAllViews();
            addToScrollView(teamData, _team, _teamMatches.indexOf(matchNum));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        matchNum="0";
    }

    public void addToScrollView(TeamData team, String teamNum, int matchNum) {
        Log.d("team",""+team);
        Log.d("teamNum",teamNum);

        View view = LayoutInflater.from(this).inflate(R.layout.team_report_data_layout, null);
        if(matchNum==-1){
            String[] teamDataSum;
            teamDataSum = DatabaseHandler.getInstance(getApplicationContext()).getOneTeamsDataSummary(teamNum);
            team.teamReportSum(teamNum, view, this, teamDataSum);
        }else if(matchNum==-2) {
            String[] teamDataSum;
            team.setMatches(_teamsData);
            teamDataSum = DatabaseHandler.getInstance(getApplicationContext()).getOneTeamsDataAverage(teamNum);
            team.teamReportSum(teamNum, view, this, teamDataSum);
        }else{
            team.setMatches(_teamsData);
            team.teamReport(teamNum, matchNum, view ,team,this);
        }
        scroll = (ScrollView) findViewById(R.id.scrollView1);
        scroll.addView(view);
    }

    public void enter(View v){
        String team = search.getText().toString();
        if (DatabaseHandler.getInstance(getApplicationContext()).checkIfTeamIsInDatabase(team)) {
            _team=team;
            _teamsData = DatabaseHandler.getInstance(getApplicationContext()).getOneTeamsData(_team);
            _teamMatches = DatabaseHandler.getInstance(getApplicationContext()).getTeamMatches();
            teamData = EventBus.getDefault().removeStickyEvent(TeamData.class);
            scroll = (ScrollView) findViewById(R.id.scrollView1);
            CustomArrayAdapter<String> ad = new CustomArrayAdapter<String>(getApplicationContext(), _teamMatches);
            Spinner spin = (Spinner) findViewById(R.id.spinner2);
            spin.setAdapter(ad);
        }
    }
}
