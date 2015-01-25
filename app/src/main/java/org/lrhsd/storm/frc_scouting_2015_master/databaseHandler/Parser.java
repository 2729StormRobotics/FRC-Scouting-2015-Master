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
        ArrayList<String> matches = new ArrayList<String>();
        int i = 0;
        while(input.contains(":")){
            String temp;
            temp=input.substring(0,input.indexOf(":"));
            input=input.substring(input.indexOf(":")+1);
            matches.add(i, temp);
            seperateTeamData(matches.get(i));
           // Log.d("arrayList"+i,teams.get(i));
            i++;
        }


        //Log.d("input","1"+input);
    }

    public static void seperateTeamData(String team){
        String teamNumber;
        String matchnumber;
        String red;
        String robotAuto;
        String numTotesAuto;
        String numContainersAuto;
        String numStackAuto;
        String toteLevel1;
        String toteLevel2;
        String toteLevel3;
        String toteLevel4;
        String toteLevel5;
        String toteLevel6;
        String canLevel1;
        String canLevel2;
        String canLevel3;
        String canLevel4;
        String canLevel5;
        String canLevel6;
        String noodle;
        String coop;

        String[] dataList = team.split(",");
        teamNumber = dataList[0];
        matchnumber = dataList[1];
        red = dataList[2];
        robotAuto = dataList[3];
        numTotesAuto = dataList[4];
        numContainersAuto = dataList[5];
        numStackAuto = dataList[6];
        toteLevel1 = dataList[7];
        toteLevel2 = dataList[8];
        toteLevel3 = dataList[9];
        toteLevel4 = dataList[10];
        toteLevel5 = dataList[11];
        toteLevel6 = dataList[12];
        canLevel1 = dataList[13];
        canLevel2 = dataList[14];
        canLevel3 = dataList[15];
        canLevel4 = dataList[16];
        canLevel5 = dataList[17];
        canLevel6 = dataList[18];
        noodle = dataList[19];
        coop = dataList[20];

        makeXMLData(teamNumber, matchnumber, red, robotAuto, numTotesAuto, numContainersAuto, numStackAuto, toteLevel1, toteLevel2, toteLevel3, toteLevel4, toteLevel5, toteLevel6, canLevel1, canLevel2, canLevel3, canLevel4, canLevel5, canLevel6, noodle,coop);


    }

    public static void makeXMLData(
            String teamNumber,
            String matchnumber,
            String red,
            String robotAuto,
            String numTotesAuto,
            String numContainersAuto,
            String numStackAuto,
            String toteLevel1,
            String toteLevel2,
            String toteLevel3,
            String toteLevel4,
            String toteLevel5,
            String toteLevel6,
            String canLevel1,
            String canLevel2,
            String canLevel3,
            String canLevel4,
            String canLevel5,
            String canLevel6,
            String noodle,
            String coop){
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
