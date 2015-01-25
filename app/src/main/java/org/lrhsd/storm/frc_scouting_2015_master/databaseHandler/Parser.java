package org.lrhsd.storm.frc_scouting_2015_master.databaseHandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import org.lrhsd.storm.frc_scouting_2015_master.MainActivity;

import java.util.ArrayList;

import me.dm7.barcodescanner.zbar.Result;


public class Parser {

    public static void Parse(Result result, Activity activity) {
        String input = result.getContents();
        //Log.d("Parser input", input);
        if (!input.contains("@stormscouting")) {
            Intent i = new Intent(activity, MainActivity.class);
            activity.startActivity(i);
            Toast.makeText((Context) activity.getApplicationContext(), (CharSequence) "Scan a Valid QR Code", Toast.LENGTH_LONG).show();
            return;
        }
        input = input.substring(input.indexOf(" ")+1);
        ArrayList<String> teams = new ArrayList<String>();
        int i = 0;
        while(input.contains(":")){
            String temp;
            temp=input.substring(0,input.indexOf(":"));
            input=input.substring(input.indexOf(":")+1);
            teams.add(i,temp);
            seperateTeamData(teams.get(i));
           // Log.d("arrayList"+i,teams.get(i));
            i++;
        }


        //Log.d("input","1"+input);
    }

    public static void seperateTeamData(String team){
        int teamNumber;
        int matchnumber;
        int red;
        int robotAuto;
        int numTotesAuto;
        int numContainersAuto;
        int numStackAuto;
        int toteLevel1;
        int toteLevel2;
        int toteLevel3;
        int toteLevel4;
        int toteLevel5;
        int toteLevel6;
        int canLevel1;
        int canLevel2;
        int canLevel3;
        int canLevel4;
        int canLevel5;
        int canLevel6;
        int noodle;
        int coop;

        teamNumber = Integer.parseInt(team.substring(0, team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        matchnumber = Integer.parseInt(team.substring(0, team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        red = Integer.parseInt(team.substring(0, team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        robotAuto = Integer.parseInt(team.substring(0, team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        numTotesAuto = Integer.parseInt(team.substring(0, team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        numContainersAuto = Integer.parseInt(team.substring(0, team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        numStackAuto = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        toteLevel1 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        toteLevel2 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        toteLevel3 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        toteLevel4 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        toteLevel5 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        toteLevel6 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        canLevel1 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        canLevel2 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        canLevel3 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        canLevel4 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        canLevel5 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        canLevel6 = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        noodle = Integer.parseInt(team.substring(0,team.indexOf(",")));
        team = team.substring(team.indexOf(",") + 1);
        coop = Integer.parseInt(team);
    }

    public static void makeXMLData(
            int teamNumber,
            int matchnumber,
            int red,
            int robotAuto,
            int numTotesAuto,
            int numContainersAuto,
            int numStackAuto,
            int toteLevel1,
            int toteLevel2,
            int toteLevel3,
            int toteLevel4,
            int toteLevel5,
            int toteLevel6,
            int canLevel1,
            int canLevel2,
            int canLevel3,
            int canLevel4,
            int canLevel5,
            int canLevel6,
            int noodle,
            int coop){
        String record = "<record>";
        record += "<TeamNumber>"+teamNumber+"</TeamNumber>"+
                "<MatchNumber>"+matchnumber+"</MatchNumber>"+
                "<Alliance>"+red+"<//Alliance>"+
                "<RobotAuto>"+robotAuto+"</RobotAuto>"+
                "<ToteNumber>"+numTotesAuto+"</ToteNumber>"+
                "<ContainerNumber>"+numContainersAuto+"</ContainerNumber>"+
                "<StackNum>"+numStackAuto+"</StackNum>" +
                "<ToteLevelOne"+toteLevel1+"</ToteLevelOne>"+
                "<ToteLevelTwo>"+toteLevel2+"</ToteLevelTwo>"+
                "<ToteLevelThree>"+toteLevel3+"</ToteLevelThree>"+
                "<ToteLevelFour>"+toteLevel4+"</ToteLevelFour>"+
                "<ToteLevelFive>"+toteLevel5+"</ToteLevelFive>"+
                "<ToteLevelSix>"+toteLevel6+"</ToteLevelSix>"+
                "<ContainerLevelOne"+canLevel1+"</ContainerLevelOne>"+
                "<ContainerLevelTwo>"+canLevel2+"</ContainerLevelTwo>"+
                "<ContainerLevelThree>"+canLevel3+"</ContainerLevelThree>"+
                "<ContainerLevelFour>"+canLevel4+"</ContainerLevelFour>"+
                "<ContainerLevelFive>"+canLevel5+"</ContainerLevelFive>"+
                "<ContainerLevelSix>"+canLevel6+"</ContainerLevelSix>"+
                "<Noodle>"+noodle+"</Noodle>"+
                "<Co-Opertition>"+coop+"</Co-Opertition>"+
                "</record>";
    }



}
