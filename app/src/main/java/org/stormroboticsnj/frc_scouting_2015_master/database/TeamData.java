package org.stormroboticsnj.frc_scouting_2015_master.database;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.stormroboticsnj.frc_scouting_2015_master.R;
import org.stormroboticsnj.frc_scouting_2015_master.TeamReportActivity;

import java.util.ArrayList;

public class TeamData {

    //private variables
//    int _id;
    int team_number = 0;
    int match_number = 0;
    boolean alliance_red = false;
    boolean robot_auto = false;
    //boolean tote_auto = false;
    int number_totes_auto = 0;
    // boolean container_auto = false;
    int number_containers_auto = 0;
    //  boolean assisted_totes_auto = false;
    int number_totes_stacked_auto = 0;
    int containers_center = 0;


    int toteLevel1 = 0;
    int toteLevel2 = 0;
    int toteLevel3 = 0;
    int toteLevel4 = 0;
    int toteLevel5 = 0;
    int toteLevel6 = 0;

    int canLevel1 = 0;
    int canLevel2 = 0;
    int canLevel3 = 0;
    int canLevel4 = 0;
    int canLevel5 = 0;
    int canLevel6 = 0;

    int coopLevel1 = 0;
    int coopLevel2 = 0;
    int coopLevel3 = 0;
    int coopLevel4 = 0;

    int noodle = 0;
    String notes = "";


    ArrayList<String[]> matches = new ArrayList<String[]>();

    TextView[] textViews = new TextView[21];
    String[] text = new String[21];


    public TeamData(int team_number, int match_number, boolean alliance_red) {
        this.team_number = team_number;
        this.match_number = match_number;
        this.alliance_red = alliance_red;
    }

    public TeamData() {

    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getContainers_center() {
        return containers_center;
    }

    public void setContainers_center(int containers_center) {
        this.containers_center = containers_center;
    }

    public TeamData(int team_number, int match_number, boolean alliance_red, boolean robot_auto,
                    int number_totes_auto, int number_containers_auto,
                    int number_totes_stacked_auto, int containers_center, int tote_level1, int tote_level2, int tote_level3,
                    int tote_level4, int tote_level5, int tote_level6, int can_level1, int can_level2,
                    int can_level3, int can_level4, int can_level5, int can_level6, int noodle, int coopLevel1, int coopLevel2, int coopLevel3, int coopLevel4, String notes
    ) {
        this.team_number = team_number;
        this.match_number = match_number;
        this.alliance_red = alliance_red;
        this.robot_auto = robot_auto;
        //this.tote_auto = tote_auto;
        this.number_totes_auto = number_totes_auto;
        // this.container_auto = container_auto;
        this.number_containers_auto = number_containers_auto;
        // this.assisted_totes_auto = assisted_totes_auto;
        this.number_totes_stacked_auto = number_totes_stacked_auto;
        this.containers_center = containers_center;


        this.toteLevel1 = tote_level1;
        this.toteLevel2 = tote_level2;
        this.toteLevel3 = tote_level3;
        this.toteLevel4 = tote_level4;
        this.toteLevel5 = tote_level5;
        this.toteLevel6 = tote_level6;

        this.canLevel1 = can_level1;
        this.canLevel2 = can_level2;
        this.canLevel3 = can_level3;
        this.canLevel4 = can_level4;
        this.canLevel5 = can_level5;
        this.canLevel6 = can_level6;

        this.noodle = noodle;
        this.coopLevel1 = coopLevel1;
        this.coopLevel2 = coopLevel2;
        this.coopLevel3 = coopLevel3;
        this.coopLevel4 = coopLevel4;
        this.notes = notes;


    }

    // getting team number
    public int getTeamNumber() {
        return this.team_number;
    }

    // setting team number
    public void setTeamNumber(int number) {
        this.team_number = number;
    }

    // getting match numberS
    public int getMatchNumber() {
        return this.match_number;
    }

    // setting match number
    public void setMatchNumber(int match_number) {
        this.match_number = match_number;
    }

    // getting alliance
    public boolean getAlliance() {
        return this.alliance_red;
    }

    // setting alliance
    public void setAlliance(boolean alliance) {
        this.alliance_red = alliance;
    }


    public boolean getRobotAuto() {
        return this.robot_auto;
    }


    public void setRobotAuto(boolean robot_auto) {
        this.robot_auto = robot_auto;
    }


    public int getNumberTotesAuto() {
        return this.number_totes_auto;
    }


    public void setNumberTotesAuto(int number_totes_auto) {
        this.number_totes_auto = number_totes_auto;
    }

    public int getNumberContainersAuto() {
        return this.number_containers_auto;
    }


    public void setNumberContainersAuto(int number_containers_auto) {
        this.number_containers_auto = number_containers_auto;
    }

    public int getNumberStackedTotesAuto() {
        return this.number_totes_stacked_auto;
    }


    public void setNumberStackedTotesAuto(int number_totes_stacked_auto) {
        this.number_totes_stacked_auto = number_totes_stacked_auto;
    }


    public int getToteLevel1() {
        return toteLevel1;
    }

    public void setToteLevel1(int toteLevel1) {
        this.toteLevel1 = toteLevel1;
    }

    public int getToteLevel2() {
        return toteLevel2;
    }

    public void setToteLevel2(int toteLevel2) {
        this.toteLevel2 = toteLevel2;
    }

    public int getToteLevel3() {
        return toteLevel3;
    }

    public void setToteLevel3(int toteLevel3) {
        this.toteLevel3 = toteLevel3;
    }

    public int getToteLevel4() {
        return toteLevel4;
    }

    public void setToteLevel4(int toteLevel4) {
        this.toteLevel4 = toteLevel4;
    }

    public int getToteLevel5() {
        return toteLevel5;
    }

    public void setToteLevel5(int toteLevel5) {
        this.toteLevel5 = toteLevel5;
    }

    public int getToteLevel6() {
        return toteLevel6;
    }

    public void setToteLevel6(int toteLevel6) {
        this.toteLevel6 = toteLevel6;
    }

    public int getCanLevel1() {
        return canLevel1;
    }

    public void setCanLevel1(int canLevel1) {
        this.canLevel1 = canLevel1;
    }

    public int getCanLevel2() {
        return canLevel2;
    }

    public void setCanLevel2(int canLevel2) {
        this.canLevel2 = canLevel2;
    }

    public int getCanLevel3() {
        return canLevel3;
    }

    public void setCanLevel3(int canLevel3) {
        this.canLevel3 = canLevel3;
    }

    public int getCanLevel4() {
        return canLevel4;
    }

    public void setCanLevel4(int canLevel4) {
        this.canLevel4 = canLevel4;
    }

    public int getCanLevel5() {
        return canLevel5;
    }

    public void setCanLevel5(int canLevel5) {
        this.canLevel5 = canLevel5;
    }

    public int getCanLevel6() {
        return canLevel6;
    }

    public void setCanLevel6(int canLevel6) {
        this.canLevel6 = canLevel6;
    }

    public int getNoodle() {
        return noodle;
    }

    public void setNoodle(int noodle) {
        this.noodle = noodle;
    }

    public int getCoopLevel1() {return coopLevel1;}

    public void setCoopLevel1(int coop) {
        this.coopLevel1 = coop;
    }

    public int getCoopLevel2() {return coopLevel2;}

    public void setCoopLevel2(int coop) {
        this.coopLevel2 = coop;
    }

    public int getCoopLevel3() {return coopLevel3;}

    public void setCoopLevel3(int coop) {this.coopLevel3 = coop;}

    public int getCoopLevel4() {return coopLevel4;}

    public void setCoopLevel4(int coop) {
        this.coopLevel4 = coop;
    }

    public void teamReport(String team, int matchNum, View act,TeamData teamData,TeamReportActivity act1) {

        TextView teamNum = (TextView) act1.findViewById(R.id.team_report_team_number);
        TextView robotAuto = (TextView) act.findViewById(R.id.column_robot_auto);
        TextView numTotesAuto = (TextView) act.findViewById(R.id.column_number_totes_auto);
        TextView numContainAuto = (TextView) act.findViewById(R.id.column_number_containers_auto);
        TextView numStackedTotesAuto = (TextView) act.findViewById(R.id.column_number_totes_stacked_auto);
        TextView containersCenterAuto = (TextView) act.findViewById(R.id.column_Containers_Center);
        TextView toteLevel1 = (TextView) act.findViewById(R.id.column_tote_level_1);
        TextView toteLevel2 = (TextView) act.findViewById(R.id.column_tote_level_2);
        TextView toteLevel3 = (TextView) act.findViewById(R.id.column_tote_level_3);
        TextView toteLevel4 = (TextView) act.findViewById(R.id.column_tote_level_4);
        TextView toteLevel5 = (TextView) act.findViewById(R.id.column_tote_level_5);
        TextView toteLevel6 = (TextView) act.findViewById(R.id.column_tote_level_6);
        TextView canLevel1 = (TextView) act.findViewById(R.id.column_can_level_1);
        TextView canLevel2 = (TextView) act.findViewById(R.id.column_can_level_2);
        TextView canLevel3 = (TextView) act.findViewById(R.id.column_can_level_3);
        TextView canLevel4 = (TextView) act.findViewById(R.id.column_can_level_4);
        TextView canLevel5 = (TextView) act.findViewById(R.id.column_can_level_5);
        TextView canLevel6 = (TextView) act.findViewById(R.id.column_can_level_6);
        TextView noodle = (TextView) act.findViewById(R.id.column_noodle);
        TextView coop1 = (TextView) act.findViewById(R.id.coop1);
        TextView coop2 = (TextView) act.findViewById(R.id.coop1);
        TextView coop3 = (TextView) act.findViewById(R.id.coop1);
        TextView coop4 = (TextView) act.findViewById(R.id.coop1);
        TextView robotInfo = (TextView) act.findViewById(R.id.RobotInfo);


        teamNum.setText(team);
        robotAuto.setText("Robot Auto:"+"\n"+teamData.getMatches().get(matchNum)[3]);
        numTotesAuto.setText("Number of Totes Auto:"+"\n"+teamData.getMatches().get(matchNum)[4]);
        numContainAuto.setText("Number of Container Auto:"+"\n"+teamData.getMatches().get(matchNum)[5]);
        numStackedTotesAuto.setText("Number of Stacked Totes in Auto:"+"\n"+teamData.getMatches().get(matchNum)[6]);
        containersCenterAuto.setText("Number of Center Containers Taken:"+"\n"+teamData.getMatches().get(matchNum)[7]);
        toteLevel1.setText("Tote Level 1:"+"\n"+teamData.getMatches().get(matchNum)[8]);
        toteLevel2.setText("Tote Level 2:"+"\n"+teamData.getMatches().get(matchNum)[9]);
        toteLevel3.setText("Tote Level 3:"+"\n"+teamData.getMatches().get(matchNum)[10]);
        toteLevel4.setText("Tote Level 4:"+"\n"+teamData.getMatches().get(matchNum)[11]);
        toteLevel5.setText("Tote Level 5:"+"\n"+teamData.getMatches().get(matchNum)[12]);
        toteLevel6.setText("Tote Level 6"+"\n"+teamData.getMatches().get(matchNum)[13]);
        canLevel1.setText("Can Level 1:"+"\n"+teamData.getMatches().get(matchNum)[14]);
        canLevel2.setText("Can Level 2:"+"\n"+teamData.getMatches().get(matchNum)[15]);
        canLevel3.setText("Can Level 3:"+"\n"+teamData.getMatches().get(matchNum)[16]);
        canLevel4.setText("Can Level 4:"+"\n"+teamData.getMatches().get(matchNum)[17]);
        canLevel5.setText("Can Level 5:"+"\n"+teamData.getMatches().get(matchNum)[18]);
        canLevel6.setText("Can Level 6:"+"\n"+teamData.getMatches().get(matchNum)[19]);
        noodle.setText("Noodles in Cans:"+"\n"+teamData.getMatches().get(matchNum)[20]);
        coop1.setText("Coop Level 1:"+"\n"+teamData.getMatches().get(matchNum)[21]);
        coop2.setText("Coop Level 1:"+"\n"+teamData.getMatches().get(matchNum)[22]);
        coop3.setText("Coop Level 1:"+"\n"+teamData.getMatches().get(matchNum)[23]);
        coop4.setText("Coop Level 1:"+"\n"+teamData.getMatches().get(matchNum)[24]);
        robotInfo.setText("Robot Info:"+"\n"+teamData.getMatches().get(matchNum)[25]);
    }

    public void teamReportSum(String team, View act,TeamReportActivity act1,String[] data, int numMatches) {
        Log.d("teamReportAct",act+"");
        TextView teamNum = (TextView) act1.findViewById(R.id.team_report_team_number);
        TextView robotAuto = (TextView) act.findViewById(R.id.column_robot_auto);
        TextView numTotesAuto = (TextView) act.findViewById(R.id.column_number_totes_auto);
        TextView numContainAuto = (TextView) act.findViewById(R.id.column_number_containers_auto);
        TextView numStackedTotesAuto = (TextView) act.findViewById(R.id.column_number_totes_stacked_auto);
        TextView containersCenterAuto = (TextView) act.findViewById(R.id.column_Containers_Center);
        TextView toteLevel1 = (TextView) act.findViewById(R.id.column_tote_level_1);
        TextView toteLevel2 = (TextView) act.findViewById(R.id.column_tote_level_2);
        TextView toteLevel3 = (TextView) act.findViewById(R.id.column_tote_level_3);
        TextView toteLevel4 = (TextView) act.findViewById(R.id.column_tote_level_4);
        TextView toteLevel5 = (TextView) act.findViewById(R.id.column_tote_level_5);
        TextView toteLevel6 = (TextView) act.findViewById(R.id.column_tote_level_6);
        TextView canLevel1 = (TextView) act.findViewById(R.id.column_can_level_1);
        TextView canLevel2 = (TextView) act.findViewById(R.id.column_can_level_2);
        TextView canLevel3 = (TextView) act.findViewById(R.id.column_can_level_3);
        TextView canLevel4 = (TextView) act.findViewById(R.id.column_can_level_4);
        TextView canLevel5 = (TextView) act.findViewById(R.id.column_can_level_5);
        TextView canLevel6 = (TextView) act.findViewById(R.id.column_can_level_6);
        TextView noodle = (TextView) act.findViewById(R.id.column_noodle);
        TextView coop1 = (TextView) act.findViewById(R.id.coop1);
        TextView coop2 = (TextView) act.findViewById(R.id.coop2);
        TextView coop3 = (TextView) act.findViewById(R.id.coop3);
        TextView coop4 = (TextView) act.findViewById(R.id.coop4);
        TextView robotInfo = (TextView) act.findViewById(R.id.RobotInfo);

        teamNum.setText(team);

        robotAuto.setText("Robot Auto:"+"\n"+"No: "+ (numMatches - Double.parseDouble(data[0])) + " Yes: "+data[0]);
        numTotesAuto.setText("Number of Totes Auto:"+"\n"+data[1]);
        numContainAuto.setText("Number of Container Auto:"+"\n"+data[2]);
        numStackedTotesAuto.setText("Number of Stacked Totes in Auto:"+"\n"+data[3]);
        containersCenterAuto.setText("Number of Containers from Center:"+"\n"+data[4]);

        toteLevel1.setText("Tote Level 1:"+"\n"+data[5]);
        toteLevel2.setText("Tote Level 2:"+"\n"+data[6]);
        toteLevel3.setText("Tote Level 3:"+"\n"+data[7]);
        toteLevel4.setText("Tote Level 4:"+"\n"+data[8]);
        toteLevel5.setText("Tote Level 5:"+"\n"+data[9]);
        toteLevel6.setText("Tote Level 6"+"\n"+data[10]);

        canLevel1.setText("Can Level 1:"+"\n"+data[11]);
        canLevel2.setText("Can Level 2:"+"\n"+data[12]);
        canLevel3.setText("Can Level 3:"+"\n"+data[13]);
        canLevel4.setText("Can Level 4:"+"\n"+data[14]);
        canLevel5.setText("Can Level 5:"+"\n"+data[15]);
        canLevel6.setText("Can Level 6:"+"\n"+data[16]);

        noodle.setText("Noodle:"+"\n"+data[17]);
        coop1.setText("Coop Level 1:"+"\n"+"No: "+ data[18]);
        coop2.setText("Coop Level 2:"+"\n"+"No: "+ data[19]);
        coop3.setText("Coop Level 3:"+"\n"+"No: "+ data[20]);
        coop4.setText("Coop Level 4:"+"\n"+"No: "+ data[21]);
        robotInfo.setText("Robot Info:"+"\n"+data[22]);
    }

    public ArrayList<String[]> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<String[]> data) {
        matches = data;
    }

}