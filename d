[33mcommit 5cc1a3c02efc91f9a8753a09702fc92c29d86bc1[m
Author: Matthew Rassmann <matt.rassmann@me.com>
Date:   Mon Feb 16 09:10:45 2015 -0500

    Started the Formatting

[1mdiff --git a/app/src/main/java/org/lrhsd/storm/frc_scouting_2015_master/database/TeamData.java b/app/src/main/java/org/lrhsd/storm/frc_scouting_2015_master/database/TeamData.java[m
[1mindex f884641..5d858ba 100644[m
[1m--- a/app/src/main/java/org/lrhsd/storm/frc_scouting_2015_master/database/TeamData.java[m
[1m+++ b/app/src/main/java/org/lrhsd/storm/frc_scouting_2015_master/database/TeamData.java[m
[36m@@ -302,26 +302,26 @@[m [mpublic class TeamData {[m
         TextView noodle = (TextView) act.findViewById(R.id.column_noodle);[m
         TextView coop = (TextView) act.findViewById(R.id.column_coop);[m
         teamNum.setText(team);[m
[31m-        Log.d("getMatchesinTeamReport",teamData.getMatches().get(0)[3]);[m
[31m-        Log.d("MatchNum",""+matchNum);[m
[31m-        robotAuto.setText(teamData.getMatches().get(matchNum)[3]);[m
[31m-        numTotesAuto.setText(teamData.getMatches().get(matchNum)[4]);[m
[31m-        numContainAuto.setText(teamData.getMatches().get(matchNum)[5]);[m
[31m-        numStackedTotesAuto.setText(teamData.getMatches().get(matchNum)[6]);[m
[31m-        toteLevel1.setText(teamData.getMatches().get(matchNum)[7]);[m
[31m-        toteLevel2.setText(teamData.getMatches().get(matchNum)[8]);[m
[31m-        toteLevel3.setText(teamData.getMatches().get(matchNum)[9]);[m
[31m-        toteLevel4.setText(teamData.getMatches().get(matchNum)[10]);[m
[31m-        toteLevel5.setText(teamData.getMatches().get(matchNum)[11]);[m
[31m-        toteLevel6.setText(teamData.getMatches().get(matchNum)[12]);[m
[31m-        canLevel1.setText(teamData.getMatches().get(matchNum)[13]);[m
[31m-        canLevel2.setText(teamData.getMatches().get(matchNum)[14]);[m
[31m-        canLevel3.setText(teamData.getMatches().get(matchNum)[15]);[m
[31m-        canLevel4.setText(teamData.getMatches().get(matchNum)[16]);[m
[31m-        canLevel5.setText(teamData.getMatches().get(matchNum)[17]);[m
[31m-        canLevel6.setText(teamData.getMatches().get(matchNum)[18]);[m
[31m-        noodle.setText(teamData.getMatches().get(matchNum)[19]);[m
[31m-        coop.setText(teamData.getMatches().get(matchNum)[20]);[m
[32m+[m[32m        //Log.d("getMatchesinTeamReport",teamData.getMatches().get(0)[3]);[m
[32m+[m[32m       // Log.d("MatchNum",""+matchNum);[m
[32m+[m[32m        robotAuto.setText("Robot Auto"+"\n"+teamData.getMatches().get(matchNum)[3]);[m
[32m+[m[32m        numTotesAuto.setText("Number of Totes Auto"+"\n"+teamData.getMatches().get(matchNum)[4]);[m
[32m+[m[32m        numContainAuto.setText("Number of Container Auto"+"\n"+teamData.getMatches().get(matchNum)[5]);[m
[32m+[m[32m        numStackedTotesAuto.setText("Number of Stacked Totes in Auto"+"\n"+teamData.getMatches().get(matchNum)[6]);[m
[32m+[m[32m        toteLevel1.setText("Tote Level 1"+"\n"+teamData.getMatches().get(matchNum)[7]);[m
[32m+[m[32m        toteLevel2.setText("Tote Level 2"+"\n"+teamData.getMatches().get(matchNum)[8]);[m
[32m+[m[32m        toteLevel3.setText("Tote Level 3"+"\n"+teamData.getMatches().get(matchNum)[9]);[m
[32m+[m[32m        toteLevel4.setText("Tote Level 4"+"\n"+teamData.getMatches().get(matchNum)[10]);[m
[32m+[m[32m        toteLevel5.setText("Tote Level 5"+"\n"+teamData.getMatches().get(matchNum)[11]);[m
[32m+[m[32m        toteLevel6.setText("Tote Level 6"+"\n"+teamData.getMatches().get(matchNum)[12]);[m
[32m+[m[32m        canLevel1.setText("Can Level 1"+"\n"+teamData.getMatches().get(matchNum)[13]);[m
[32m+[m[32m        canLevel2.setText("Can Level 2"+"\n"+teamData.getMatches().get(matchNum)[14]);[m
[32m+[m[32m        canLevel3.setText("Can Level 3"+"\n"+teamData.getMatches().get(matchNum)[15]);[m
[32m+[m[32m        canLevel4.setText("Can Level 4"+"\n"+teamData.getMatches().get(matchNum)[16]);[m
[32m+[m[32m        canLevel5.setText("Can Level 5"+"\n"+teamData.getMatches().get(matchNum)[17]);[m
[32m+[m[32m        canLevel6.setText("Can Level 6"+"\n"+teamData.getMatches().get(matchNum)[18]);[m
[32m+[m[32m        noodle.setText("Noodle"+"\n"+teamData.getMatches().get(matchNum)[19]);[m
[32m+[m[32m        coop.setText("Coop"+"\n"+teamData.getMatches().get(matchNum)[20]);[m
     }[m
 [m
     public ArrayList<String[]> getMatches() {[m
[1mdiff --git a/app/src/main/res/layout/activity_sorter.xml b/app/src/main/res/layout/activity_sorter.xml[m
[1mindex 439b775..22e2700 100644[m
[1m--- a/app/src/main/res/layout/activity_sorter.xml[m
[1m+++ b/app/src/main/res/layout/activity_sorter.xml[m
[36m@@ -26,12 +26,12 @@[m
         android:id="@+id/search"[m
         android:layout_width="wrap_content"[m
         android:layout_height="wrap_content"[m
[31m-        android:layout_alignBottom="@+id/spinner"[m
[31m-        android:layout_alignParentEnd="true"[m
[31m-        android:layout_alignParentRight="true"[m
         android:ems="10"[m
         android:hint="Search Team #"[m
[31m-        android:inputType="textPersonName" />[m
[32m+[m[32m        android:inputType="textPersonName"[m
[32m+[m[32m        android:layout_alignTop="@+id/list"[m
[32m+[m[32m        android:layout_alignParentRight="true"[m
[32m+[m[32m        android:layout_alignParentEnd="true" />[m
 [m
 [m
 </RelativeLayout>[m
[1mdiff --git a/app/src/main/res/layout/activity_team_report_layout.xml b/app/src/main/res/layout/activity_team_report_layout.xml[m
[1mindex 9a455a9..bd413b0 100644[m
[1m--- a/app/src/main/res/layout/activity_team_report_layout.xml[m
[1m+++ b/app/src/main/res/layout/activity_team_report_layout.xml[m
[36m@@ -7,24 +7,24 @@[m
         android:id="@+id/team_report_team_number"[m
         android:layout_width="wrap_content"[m
         android:layout_height="wrap_content"[m
[31m-        android:layout_below="@+id/scrollView1"[m
[31m-        android:layout_centerHorizontal="true"[m
         android:text="Large Text"[m
[31m-        android:textAppearance="?android:attr/textAppearanceLarge" />[m
[31m-[m
[31m-    <ScrollView[m
[31m-        android:id="@+id/scrollView1"[m
[31m-        android:layout_width="wrap_content"[m
[31m-        android:layout_height="wrap_content"[m
[31m-        android:layout_alignEnd="@+id/team_report_team_number"[m
[31m-        android:layout_alignRight="@+id/team_report_team_number" />[m
[32m+[m[32m        android:textAppearance="?android:attr/textAppearanceLarge"[m
[32m+[m[32m        android:layout_centerHorizontal="true" />[m
 [m
     <Spinner[m
         android:id="@+id/spinner2"[m
         android:layout_width="wrap_content"[m
         android:layout_height="wrap_content"[m
[32m+[m[32m        android:layout_below="@+id/team_report_team_number"[m
         android:layout_alignParentLeft="true"[m
[31m-        android:layout_alignParentStart="true"[m
[31m-        android:layout_below="@+id/team_report_team_number" />[m
[32m+[m[32m        android:layout_alignParentStart="false" />[m
[32m+[m
[32m+[m[32m    <ScrollView[m
[32m+[m[32m        android:layout_width="wrap_content"[m
[32m+[m[32m        android:layout_height="wrap_content"[m
[32m+[m[32m        android:id="@+id/scrollView1"[m
[32m+[m[32m        android:layout_alignParentBottom="true"[m
[32m+[m[32m        android:layout_centerHorizontal="true"[m
[32m+[m[32m        android:layout_marginBottom="367dp" />[m
 [m
 </RelativeLayout>[m
