package org.lrhsd.storm.frc_scouting_2015_master;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;

import org.lrhsd.storm.frc_scouting_2015_master.database.DatabaseHandler;
import org.lrhsd.storm.frc_scouting_2015_master.database.TeamData;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;


public class TeamReportActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_report_layout);
        String team = EventBus.getDefault().removeStickyEvent(String.class);
        DatabaseHandler.getInstance(getApplicationContext()).getOneTeamsData(team, this);
        ArrayList<Integer> teamMatches = EventBus.getDefault().removeStickyEvent(ArrayList.class);
        TeamData teamData = EventBus.getDefault().removeStickyEvent(TeamData.class);
        ArrayAdapter<Integer> ad = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item, teamMatches);
        Spinner spin = (Spinner) findViewById(R.id.spinner2);
        spin.setAdapter(ad);
        addToScrollView(teamData, team, Integer.parseInt(DatabaseHandler.matchNum));
        //Make right here call addToScrollView
        //Make the matchNum the match number selected from the spinner
        //addToScrollView(teamData,team,matchNum);
    }

    public void addToScrollView(TeamData team, String teamNum, int matchNum) {
        DatabaseHandler.getInstance(this).getOneTeamsData(teamNum, this);
        team.teamReport(teamNum, matchNum, this);
        ScrollView scroll = (ScrollView) findViewById(R.id.scrollView1);
        View view = LayoutInflater.from(this).inflate(R.layout.team_report_data_layout, null);
        scroll.addView(view);
    }
}
