package org.lrhsd.storm.frc_scouting_2015_master;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;

import org.lrhsd.storm.frc_scouting_2015_master.database.DatabaseHandler;
import org.lrhsd.storm.frc_scouting_2015_master.database.TeamData;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;


public class TeamReportActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    int matchNum;
    ArrayList<String> _teamMatches;
    ArrayList<String[]> _teamsData;
    TeamData teamData;
    String team;
    ScrollView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_report_layout);
        team = EventBus.getDefault().removeStickyEvent(String.class);
        _teamsData = DatabaseHandler.getInstance(getApplicationContext()).getOneTeamsData(team);
        _teamMatches = DatabaseHandler.getInstance(getApplicationContext()).getTeamMatches();
        teamData = EventBus.getDefault().removeStickyEvent(TeamData.class);
        scroll = (ScrollView) findViewById(R.id.scrollView1);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, _teamMatches);
        Spinner spin = (Spinner) findViewById(R.id.spinner2);
        spin.setAdapter(ad);
        spin.setOnItemSelectedListener(this);

        //Make right here call addToScrollView
        //Make the matchNum the match number selected from the spinner
        //addToScrollView(teamData,team,matchNum);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d("TeamMatches.get",_teamMatches.get((int)parent.getItemIdAtPosition(position)));
        matchNum = Integer.parseInt(_teamMatches.get((int)parent.getItemIdAtPosition(position)));
        Log.d("MatchNum",""+matchNum);
        Log.d("teamMatchesInOn",_teamMatches.get(0));
        scroll.removeAllViews();
        addToScrollView(teamData, team, _teamMatches.indexOf(String.valueOf(matchNum)));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        matchNum=0;
    }

    public void addToScrollView(TeamData team, String teamNum, int matchNum) {
        Log.d("team",""+team);
        Log.d("teamNum",teamNum);
        Log.d("teamsData",_teamsData+"");
        team.setMatches(_teamsData);
        View view = LayoutInflater.from(this).inflate(R.layout.team_report_data_layout, null);
        team.teamReport(teamNum, matchNum, view ,team,this);
        scroll = (ScrollView) findViewById(R.id.scrollView1);
        scroll.addView(view);
    }
}
