package org.lrhsd.storm.frc_scouting_2015_master.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 6;
    // Database Name
    private static final String DATABASE_NAME = "Team_Manager";
    // Contacts table name
    private static final String TABLE_TEAM = "Team_Data";
    // Contacts Table Columns names
    // private static final String KEY_ID = "id";
    //main
    private static final String KEY_TEAM_NUMBER = "team_number";
    private static final String KEY_MATCH_NUMBER = "match_number";
    private static final String KEY_ALLIANCE = "alliance";
    //auto
    private static final String KEY_ROBOT_AUTO = "robot_auto";
    // private static final String KEY_TOTE_AUTO = "tote_auto";
    private static final String KEY_NUMBER_TOTES_AUTO = "number_totes_auto";
    //  private static final String KEY_CONTAINER_AUTO = "container_auto";
    private static final String KEY_NUMBER_CONTAINERS_AUTO = "number_containers_auto";
    //   private static final String KEY_ASSISTED_TOTES_AUTO = "assisted_totes_auto";
    private static final String KEY_NUMBER_TOTES_STACKED_AUTO = "number_totes_stacked_auto";
    private static final String KEY_TOTE_LEVEL1 = "tote_level1";
    //telop
    private static final String KEY_TOTE_LEVEL2 = "tote_level2";
    private static final String KEY_TOTE_LEVEL3 = "tote_level3";
    private static final String KEY_TOTE_LEVEL4 = "tote_level4";
    private static final String KEY_TOTE_LEVEL5 = "tote_level5";
    private static final String KEY_TOTE_LEVEL6 = "tote_level6";
    private static final String KEY_CAN_LEVEL1 = "can_level1";
    private static final String KEY_CAN_LEVEL2 = "can_level2";
    private static final String KEY_CAN_LEVEL3 = "can_level3";
    private static final String KEY_CAN_LEVEL4 = "can_level4";
    private static final String KEY_CAN_LEVEL5 = "can_level5";
    private static final String KEY_CAN_LEVEL6 = "can_level6";
    private static final String KEY_NOODLE = "noodle";
    private static final String KEY_COOP = "coop";
    // All Static variables
    private static DatabaseHandler sInstance = null;
    private Context mCtx;

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
        String CREATE_TEAM = "CREATE TABLE " + TABLE_TEAM + "("
                + KEY_TEAM_NUMBER + " INTEGER,"
                + KEY_MATCH_NUMBER + " INTEGER,"
                + KEY_ALLIANCE + " INTEGER,"
                + KEY_ROBOT_AUTO + " INTEGER,"
                + KEY_NUMBER_TOTES_AUTO + " INTEGER,"
                + KEY_NUMBER_CONTAINERS_AUTO + " INTEGER,"
                + KEY_NUMBER_TOTES_STACKED_AUTO + " INTEGER,"
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
                + KEY_COOP + " INTEGER"
                + ")";
        db.execSQL(CREATE_TEAM);
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
                    KEY_TEAM_NUMBER + ","
                    + KEY_MATCH_NUMBER + ","
                    + KEY_ALLIANCE + ","
                    + KEY_ROBOT_AUTO + ","
                    + KEY_NUMBER_TOTES_AUTO + ","
                    + KEY_NUMBER_CONTAINERS_AUTO + ","
                    + KEY_NUMBER_TOTES_STACKED_AUTO + ","
                    + KEY_TOTE_LEVEL1 + ","
                    + KEY_TOTE_LEVEL2 + ","
                    + KEY_TOTE_LEVEL3 + ","
                    + KEY_TOTE_LEVEL4 + ","
                    + KEY_TOTE_LEVEL5 + ","
                    + KEY_TOTE_LEVEL6 + ","
                    + KEY_CAN_LEVEL1 + ","
                    + KEY_CAN_LEVEL2 + ","
                    + KEY_CAN_LEVEL3 + ","
                    + KEY_CAN_LEVEL4 + ","
                    + KEY_CAN_LEVEL5 + ","
                    + KEY_CAN_LEVEL6 + ","
                    + KEY_NOODLE + ","
                    + KEY_COOP +
                    ") values(";
            String str2 = ");";
            while ((line = buffer.readLine()) != null) {
                StringBuilder sb = new StringBuilder(str1);
                String[] str = line.split(",");
                sb.append("'" + str[0] + "',");
                sb.append(str[1] + "',");
                sb.append(str[2] + "',");
                sb.append(str[3] + "'");
                sb.append(str[4] + "'");
                sb.append(str[5] + "'");
                sb.append(str[6] + "'");
                sb.append(str[7] + "'");
                sb.append(str[8] + "'");
                sb.append(str[9] + "'");
                sb.append(str[10] + "'");
                sb.append(str[11] + "'");
                sb.append(str[12] + "'");
                sb.append(str[13] + "'");
                sb.append(str[14] + "'");
                sb.append(str[15] + "'");
                sb.append(str[16] + "'");
                sb.append(str[17] + "'");
                sb.append(str[18] + "'");
                sb.append(str[19] + "'");
                sb.append(str[20] + "'");
                sb.append(str2);
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
                ArrayList teamData = new ArrayList(  );

                teamData.add(0,String.valueOf((cursor.getInt(0))));
                teamData.add(1,String.valueOf((cursor.getInt(1))));
                teamData.add(2,String.valueOf((cursor.getInt(2))));
                teamData.add(3,String.valueOf((cursor.getInt(3))));
                teamData.add(4,String.valueOf((cursor.getInt(4))));
                teamData.add(5,String.valueOf((cursor.getInt(5))));
                teamData.add(6,String.valueOf((cursor.getInt(6))));
                teamData.add(7,String.valueOf((cursor.getInt(7))));
                teamData.add(8,String.valueOf((cursor.getInt(8))));
                teamData.add(9,String.valueOf((cursor.getInt(9))));
                teamData.add(10,String.valueOf((cursor.getInt(10))));
                teamData.add(11,String.valueOf((cursor.getInt(11))));
                teamData.add(12,String.valueOf((cursor.getInt(12))));
                teamData.add(13,String.valueOf((cursor.getInt(13))));
                teamData.add(14,String.valueOf((cursor.getInt(14))));
                teamData.add(15,String.valueOf((cursor.getInt(15))));
                teamData.add(16,String.valueOf((cursor.getInt(16))));
                teamData.add(17,String.valueOf((cursor.getInt(17))));
                teamData.add(18,String.valueOf((cursor.getInt(18))));
                teamData.add(19,String.valueOf((cursor.getInt(19))));
                teamData.add(20,String.valueOf((cursor.getInt(20))));
                Log.d("Database", teamData.get(0).toString());

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

    public int getNumRows() {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT COUNT(*) FROM " + TABLE_TEAM;
        Cursor cursor = db.rawQuery(count, null);
        return cursor.getCount();
    }


}