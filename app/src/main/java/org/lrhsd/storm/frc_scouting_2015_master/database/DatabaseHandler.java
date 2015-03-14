package org.lrhsd.storm.frc_scouting_2015_master.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;

public class DatabaseHandler extends SQLiteOpenHelper implements AdapterView.OnItemSelectedListener {

    // Contacts Table Columns names
    // private static final String KEY_ID = "id";
    //main
    public static final String KEY_TEAM_NUMBER = "_id";
    public static final String KEY_MATCH_NUMBER = "match_number";
    public static final String KEY_ALLIANCE = "alliance";
    //auto
    public static final String KEY_ROBOT_AUTO = "robot_auto";
    // public static final String KEY_TOTE_AUTO = "tote_auto";
    public static final String KEY_NUMBER_TOTES_AUTO = "number_totes_auto";
    //  public static final String KEY_CONTAINER_AUTO = "container_auto";
    public static final String KEY_NUMBER_CONTAINERS_AUTO = "number_containers_auto";
    //   public static final String KEY_ASSISTED_TOTES_AUTO = "assisted_totes_auto";
    public static final String KEY_NUMBER_TOTES_STACKED_AUTO = "number_totes_stacked_auto";
    public static final String KEY_CONTAINERS_CENTER_AUTO = "containers_center_auto";
    public static final String KEY_TOTE_LEVEL1 = "tote_level1";
    //telop
    public static final String KEY_TOTE_LEVEL2 = "tote_level2";
    public static final String KEY_TOTE_LEVEL3 = "tote_level3";
    public static final String KEY_TOTE_LEVEL4 = "tote_level4";
    public static final String KEY_TOTE_LEVEL5 = "tote_level5";
    public static final String KEY_TOTE_LEVEL6 = "tote_level6";
    public static final String KEY_CAN_LEVEL1 = "can_level1";
    public static final String KEY_CAN_LEVEL2 = "can_level2";
    public static final String KEY_CAN_LEVEL3 = "can_level3";
    public static final String KEY_CAN_LEVEL4 = "can_level4";
    public static final String KEY_CAN_LEVEL5 = "can_level5";
    public static final String KEY_CAN_LEVEL6 = "can_level6";
    public static final String KEY_NOODLE = "noodle";
    public static final String KEY_COOP = "coop";
    public static final String KEY_NOTES = "notes";
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Team_Manager";
    // Contacts table name
    private static final String TABLE_TEAM = "Team_Data";
    // All Static variables
    private static DatabaseHandler sInstance = null;
    private Context mCtx;
    private String matchNum;
    private ArrayList<String[]> teamsData;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mCtx = context;
    }


    public static DatabaseHandler getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHandler(context.getApplicationContext());
        }
        return sInstance;
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //creates table
        String CREATE_TEAM = "CREATE TABLE " + TABLE_TEAM + "("
                + KEY_TEAM_NUMBER + " INTEGER,"
                + KEY_MATCH_NUMBER + " INTEGER,"
                + KEY_ALLIANCE + " INTEGER,"
                + KEY_ROBOT_AUTO + " INTEGER,"
                + KEY_NUMBER_TOTES_AUTO + " INTEGER,"
                + KEY_NUMBER_CONTAINERS_AUTO + " INTEGER,"
                + KEY_NUMBER_TOTES_STACKED_AUTO + " INTEGER,"
                + KEY_CONTAINERS_CENTER_AUTO + " INTEGER,"
                + KEY_TOTE_LEVEL1 + " INTEGER,"
                + KEY_TOTE_LEVEL2 + " INTEGER,"
                + KEY_TOTE_LEVEL3 + " INTEGER,"
                + KEY_TOTE_LEVEL4 + " INTEGER,"
                + KEY_TOTE_LEVEL5 + " INTEGER,"
                + KEY_TOTE_LEVEL6 + " INTEGER,"
                + KEY_CAN_LEVEL1 + " INTEGER,"
                + KEY_CAN_LEVEL2 + " INTEGER,"
                + KEY_CAN_LEVEL3 + " INTEGER,"
                + KEY_CAN_LEVEL4 + " INTEGER,"
                + KEY_CAN_LEVEL5 + " INTEGER,"
                + KEY_CAN_LEVEL6 + " INTEGER,"
                + KEY_NOODLE + " INTEGER,"
                + KEY_COOP + " INTEGER,"
                + KEY_NOTES + " TEXT"
                + ")";
        db.execSQL(CREATE_TEAM);
       // Log.d("Number of Rows",getNumRows()+"");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEAM);

        // Create tables again
        onCreate(db);
    }

    public void addTeamData(List<String[]> matches) {
        Log.d("bitch got called", matches.get(0)[0]);
            SQLiteDatabase db = this.getWritableDatabase();

            String str1 = "INSERT INTO " + TABLE_TEAM + " (" +
                    KEY_TEAM_NUMBER + ", "
                    + KEY_MATCH_NUMBER + ", "
                    + KEY_ALLIANCE + ", "
                    + KEY_ROBOT_AUTO + ", "
                    + KEY_NUMBER_TOTES_AUTO + ", "
                    + KEY_NUMBER_CONTAINERS_AUTO + ", "
                    + KEY_NUMBER_TOTES_STACKED_AUTO + ", "
                    + KEY_CONTAINERS_CENTER_AUTO + ", "
                    + KEY_TOTE_LEVEL1 + ", "
                    + KEY_TOTE_LEVEL2 + ", "
                    + KEY_TOTE_LEVEL3 + ", "
                    + KEY_TOTE_LEVEL4 + ", "
                    + KEY_TOTE_LEVEL5 + ", "
                    + KEY_TOTE_LEVEL6 + ", "
                    + KEY_CAN_LEVEL1 + ", "
                    + KEY_CAN_LEVEL2 + ", "
                    + KEY_CAN_LEVEL3 + ", "
                    + KEY_CAN_LEVEL4 + ", "
                    + KEY_CAN_LEVEL5 + ", "
                    + KEY_CAN_LEVEL6 + ", "
                    + KEY_NOODLE + ", "
                    + KEY_COOP +   ", "
                    + KEY_NOTES +
                    ") values(";
            String str2 = " );";

            for(int i = 0; i < matches.size();i++){
                StringBuilder sb = new StringBuilder(str1);
                sb.append(matches.get(i)[0] + ",");
                sb.append(matches.get(i)[1] + ",");
                sb.append(matches.get(i)[2] + ",");
                sb.append(matches.get(i)[3] + ",");
                sb.append(matches.get(i)[4] + ",");
                sb.append(matches.get(i)[5] + ",");
                sb.append(matches.get(i)[6] + ",");
                sb.append(matches.get(i)[7] + ",");
                sb.append(matches.get(i)[8] + ",");
                sb.append(matches.get(i)[9] + ",");
                sb.append(matches.get(i)[10] + ",");
                sb.append(matches.get(i)[11] + ",");
                sb.append(matches.get(i)[12] + ",");
                sb.append(matches.get(i)[13] + ",");
                sb.append(matches.get(i)[14] + ",");
                sb.append(matches.get(i)[15] + ",");
                sb.append(matches.get(i)[16] + ",");
                sb.append(matches.get(i)[17] + ",");
                sb.append(matches.get(i)[18] + ",");
                sb.append(matches.get(i)[19] + ",");
                sb.append(matches.get(i)[20] + ",");
                sb.append(matches.get(i)[21] + ",");
                sb.append("'"+matches.get(i)[22]+"'");
                sb.append(str2);
                //Log.d("SQL",sb.toString());
                db.execSQL(sb.toString());
            }

    }

    public void clearTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEAM, null, null);
    }

        public List<TeamData> getAllTeamData () {
            List<TeamData> teamDataList = new ArrayList<TeamData>();
            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_TEAM;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    TeamData teamData = new TeamData();
                    //main
                    teamData.setTeamNumber(cursor.getInt(0));
                    teamData.setMatchNumber(cursor.getInt(1));
                    teamData.setAlliance(cursor.getInt(2) > 0);
                    //Auto
                    teamData.setRobotAuto(cursor.getInt(3) > 0);
                    teamData.setNumberTotesAuto(cursor.getInt(4));
                    teamData.setNumberContainersAuto(cursor.getInt(5));
                    teamData.setNumberStackedTotesAuto(cursor.getInt(6));
                    teamData.setContainers_center(cursor.getInt(7));

                    //Tele-op

                    teamData.setToteLevel1(cursor.getInt(8));
                    teamData.setToteLevel2(cursor.getInt(9));
                    teamData.setToteLevel3(cursor.getInt(10));
                    teamData.setToteLevel4(cursor.getInt(11));
                    teamData.setToteLevel5(cursor.getInt(12));
                    teamData.setToteLevel6(cursor.getInt(13));
                    teamData.setCanLevel1(cursor.getInt(14));
                    teamData.setCanLevel2(cursor.getInt(15));
                    teamData.setCanLevel3(cursor.getInt(16));
                    teamData.setCanLevel4(cursor.getInt(17));
                    teamData.setCanLevel5(cursor.getInt(18));
                    teamData.setCanLevel6(cursor.getInt(19));

                    teamData.setNoodle(cursor.getInt(20));
                    teamData.setCoop(cursor.getInt(21));
                    teamData.setNotes(cursor.getString(22));


                    // Adding contact to list
                    teamDataList.add(teamData);
                } while (cursor.moveToNext());
            }

            // return contact list
            return teamDataList;
        }

    public boolean checkIfEmpty() {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(*) FROM " + TABLE_TEAM;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if (icount > 0) {
            return false;
        }
        return true;
    }

    public Cursor getSortedTeamData(String columnName) {
        //gets sorted data by a column name
        List<ArrayList> teamDataList = new ArrayList<ArrayList>();
        String selectQuery;
        if (columnName.equals(KEY_ALLIANCE)||columnName.equals(KEY_ROBOT_AUTO)||columnName.equals(KEY_COOP)||columnName.equals(KEY_ROBOT_AUTO)) {
            selectQuery = "SELECT  * FROM " + TABLE_TEAM + " ORDER BY " + columnName + " ASC";
        } else {
            selectQuery = "SELECT  * FROM " + TABLE_TEAM + " ORDER BY " + columnName + " DESC";
        }

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    public HashMap<String, Integer> getRankedColumn(String column) {
        //returns a hashmap with a rank of the team and their rank of that column
        Cursor cursor = getSortedTeamData(column);
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < cursor.getCount(); i++) {
            String teamNumber = cursor.getString(0);
            hashMap.put(teamNumber, i + 1);
        }
        return hashMap;
    }

    public boolean checkIfTeamIsInDatabase(String team) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_TEAM;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                if (c.getString(0).equals(team)) {
                    return true;
                }

            } while (c.moveToNext());
        }
        return false;
    }

    public ArrayList<String[]> getOneTeamsData(String teamNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_TEAM + " WHERE " + KEY_TEAM_NUMBER + " = " + teamNumber;
        Cursor c = db.rawQuery(selectQuery, null);
        teamsData = new ArrayList<>();
        TeamData team = new TeamData();
        if (c.moveToFirst()) {
            do {
                String[] teamData = new String[23];
                for (int i = 0; i < 23; i++) {
                    teamData[i] = c.getString(i);

                }
                Log.d("teamData21",teamData[21]);
                Log.d("teamData22",teamData[22]);
                teamsData.add(teamData);

            } while (c.moveToNext());
        }

        EventBus.getDefault().postSticky(team);
        //Log.d("teamsdata From DataBaseHand2",""+teamsData);
        EventBus.getDefault().postSticky(teamsData);
        return teamsData;
    }
    public String[] getOneTeamsDataSummary(String teamNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_TEAM + " WHERE " + KEY_TEAM_NUMBER + " = " + teamNumber;
        Cursor c = db.rawQuery(selectQuery, null);
        //Log.d("Cursor",c+"");
        int[] dataInt = new int[19];
        ArrayList<Integer[]> teamsDataSum = new ArrayList<Integer[]>();
        if (c.moveToFirst()) {
            do {
                Integer[] teamData = new Integer[23];
                for (int i = 0; i < 23; i++) {
                    teamData[i] = c.getInt(i);

                }
                teamsDataSum.add(teamData);
            } while (c.moveToNext());
        }
        for (int i = 0; i < teamsDataSum.size(); i++) {
            for (int t = 5; t < 22; t++) {
                dataInt[t - 4] = dataInt[t - 4] + teamsDataSum.get(i)[t];
            }
        }
        String[] dataString = new String[22];
        for (int i = 2; i < 19; i++) {
            dataString[i] = String.valueOf(dataInt[i]);
        }
        int numNo = 0;
        int numYes = 0;
        int robotNumYes = 0;
        int robotNumNo = 0;
        if (c.moveToFirst()) {
            do {
                if (c.getString(3).equals("No")) {
                    robotNumNo++;
                } else {
                    robotNumYes++;
                }
            } while (c.moveToNext());
            if (c.moveToFirst()) {
                do {
                    if (c.getString(21).equals("No")) {
                        numNo++;
                    } else {
                        numYes++;
                    }
                } while (c.moveToNext());
            }
            dataString[0] = String.valueOf(robotNumYes);
            dataString[1] = String.valueOf(robotNumNo);
            dataString[19] = String.valueOf(numYes);
            dataString[20] = String.valueOf(numNo);
            String notes = "";
            if (c.moveToFirst()) {
                do {
                    notes = notes + c.getString(22) + "\n";
                } while (c.moveToNext());
            }
            dataString[21] = notes;

        }

        return dataString;
    }

    public String[] getOneTeamsDataAverage(String teamNumber, TeamData teamData) {

      String[] dataString = getOneTeamsDataSummary(teamNumber);

        double[] dataDouble = new double[22];

        for(int i = 0; i < dataString.length-1; i ++){
            dataDouble[i] = Integer.parseInt(dataString[i]) / (double)teamData.getMatches().size();
            dataString[i] = String.format("%.3f",dataDouble[i]);
        }
       return  dataString;
    }

        public ArrayList<String> getTeamMatches(){
        ArrayList<String> teamMatches = new ArrayList<String>();
        for (int i = 0; i < teamsData.size(); i++) {
            teamMatches.add(i,"Match: "+teamsData.get(i)[1]);
        }
        teamMatches.add(teamMatches.size(),"Summary");
        teamMatches.add(teamMatches.size(),"Average");
        return teamMatches;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        matchNum = Long.toString(parent.getItemIdAtPosition(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public int getNumRows() {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT COUNT(*) FROM " + TABLE_TEAM;
        Cursor cursor = db.rawQuery(count, null);
        return cursor.getCount();
    }
}


