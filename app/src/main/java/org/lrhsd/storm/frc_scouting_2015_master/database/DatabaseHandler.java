package org.lrhsd.storm.frc_scouting_2015_master.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import org.lrhsd.storm.frc_scouting_2015_master.TeamReportActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
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

    public void addTeamData() {
        SQLiteDatabase db = this.getWritableDatabase();
        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File(sdCard.getAbsolutePath());
        dir.mkdirs();
        File file = new File(dir, "match_data.csv");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);
            db.beginTransaction();
            String line = "";
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
            String str2 = ");";
            while ((line = buffer.readLine()) != null) {
                StringBuilder sb = new StringBuilder(str1);
                String[] str = line.split(",");
                sb.append(str[0] + ",");
                sb.append(str[1] + ",");
                sb.append(str[2] + ",");
                sb.append(str[3] + ",");
                sb.append(str[4] + ",");
                sb.append(str[5] + ",");
                sb.append(str[6] + ",");
                sb.append(str[7] + ",");
                sb.append(str[8] + ",");
                sb.append(str[9] + ",");
                sb.append(str[10] + ",");
                sb.append(str[11] + ",");
                sb.append(str[12] + ",");
                sb.append(str[13] + ",");
                sb.append(str[14] + ",");
                sb.append(str[15] + ",");
                sb.append(str[16] + ",");
                sb.append(str[17] + ",");
                sb.append(str[18] + ",");
                sb.append(str[19] + ",");
                sb.append(str[20] + ",");
                Log.d("str20",str[20]);
                sb.append(str[21] + ",");
                sb.append(str[22]);
                sb.append(str2);
                Log.d("sb", sb.toString());
                db.execSQL(sb.toString());
            }
            db.setTransactionSuccessful();
            db.endTransaction();

            // Inserting Row
        /*db.insert(TABLE_TEAM, null, values);*/
            db.close(); // Closing database connection
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void clearTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEAM, null, null);
    }

    public List<ArrayList> getAllTeamData() {
        List<ArrayList> teamDataList = new ArrayList<ArrayList>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TEAM;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ArrayList teamData = new ArrayList();

                teamData.add(0, ((cursor.getString(0))));
                teamData.add(1, ((cursor.getString(1))));
                teamData.add(2, ((cursor.getString(2))));
                teamData.add(3, ((cursor.getString(3))));
                teamData.add(4, ((cursor.getString(4))));
                teamData.add(5, ((cursor.getString(5))));
                teamData.add(6, ((cursor.getString(6))));
                teamData.add(7, ((cursor.getString(7))));
                teamData.add(8, ((cursor.getString(8))));
                teamData.add(9, ((cursor.getString(9))));
                teamData.add(10, ((cursor.getString(10))));
                teamData.add(11, ((cursor.getString(11))));
                teamData.add(12, ((cursor.getString(12))));
                teamData.add(13, ((cursor.getString(13))));
                teamData.add(14, ((cursor.getString(14))));
                teamData.add(15, ((cursor.getString(15))));
                teamData.add(16, ((cursor.getString(16))));
                teamData.add(17, ((cursor.getString(17))));
                teamData.add(18, ((cursor.getString(18))));
                teamData.add(19, ((cursor.getString(19))));
                teamData.add(20, ((cursor.getString(20))));
                teamData.add(21, ((cursor.getString(21))));
                teamData.add(22, ((cursor.getString(22))));

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
        if (columnName.equals(KEY_COOP) || columnName.equals(KEY_ALLIANCE)) {
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
    public String[] getOneTeamsDataSummary(String teamNumber){
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
        for(int i=0; i<teamsDataSum.size(); i++){
            for(int t=4; t<22; t++){
                dataInt[t-4]=dataInt[t-4]+teamsDataSum.get(i)[t];
            }
        }
        String[] dataString = new String[21];
        for(int i=0;i<18;i++){
            dataString[i] = String.valueOf(dataInt[i]);
        }
        int numNo = 0;
        int numYes = 0;
        if (c.moveToFirst()) {
            do {
               if(c.getString(21).equals("No")){
                   numNo++;
               }else{
                   numYes++;
               }
            } while (c.moveToNext());
        }
        dataString[18]=String.valueOf(numNo);
        dataString[19]=String.valueOf(numYes);
        String notes = "";
        if (c.moveToFirst()) {
            do {
                notes=notes+c.getString(22)+"\n";
            } while (c.moveToNext());
        }
        dataString[20]=notes;
        return dataString;
    }
    public ArrayList<String> getTeamMatches(){
        ArrayList<String> teamMatches = new ArrayList<String>();
        for (int i = 0; i < teamsData.size(); i++) {
            teamMatches.add(i,"Match: "+teamsData.get(i)[1]);
        }
        teamMatches.add(teamMatches.size(),"Summary");
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


