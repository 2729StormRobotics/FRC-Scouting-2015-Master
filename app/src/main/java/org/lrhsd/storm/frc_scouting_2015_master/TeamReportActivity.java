package org.lrhsd.storm.frc_scouting_2015_master;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;

import org.lrhsd.storm.frc_scouting_2015_master.database.DatabaseHandler;
import org.lrhsd.storm.frc_scouting_2015_master.database.TeamData;

import java.util.ArrayList;


public class TeamReportActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_report_layout);
    }

    public void addToScrollView(TeamData team,String teamNum,int matchNum){
        DatabaseHandler.getInstance(this).getOneTeamsData(teamNum,this);
        team.teamReport(teamNum,matchNum,this);
        ScrollView scroll = (ScrollView) findViewById(R.id.scrollView1);
        View view = LayoutInflater.from(this).inflate(R.layout.team_report_data_layout,null);
        scroll.addView(view);
    }
    public void addScrollview(ArrayList<String> teamMatches,TeamData team,String teamNumber){
        Log.d("this",""+this);
        Spinner spin = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamMatches);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adap);
        this.addToScrollView(team, teamNumber, 1);
    }
}
