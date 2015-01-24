package org.lrhsd.storm.frc_scouting_2015_master.databaseHandler;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tommy on 1/17/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String ROW_ID = "ROWID", DATABASE_NAME = "Recycle_Rush", TABLE_NAME = "Recycle_Table";
    private static final int DATABASE_VERSION = 2;

    private static final String[] columnNames= {"team_num", //Team number
            "match_num", //match number
            "is_red",  //Alliance
            "robot_auto", //If robot does autonomous
            "totes_num_auto", //Number of totes stacked in auto
            "container_num_auto", //Number of containers in auto
            "stack_num", //Number of stacks
            "tote_level_one", //Tote levels
            "tote_level_two",
            "tote_level_three",
            "tote_level_four",
            "tote_level_five",
            "tote_level_six",
            "container_level_one", //Container level
            "container_level_two",
            "container_level_three",
            "container_level_four",
            "container_level_five",
            "container_level_six",
            "noodle", //Noodle variable
            "coopertition"// If teams do coopertition

                                               };
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     String COMMAND = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
             //Creates Table
             "(" +
             columnNames[0] +  " INTEGER,"+
             columnNames[1] +  " INTEGER,"+
             columnNames[2] +  " INTEGER,"+
             columnNames[3] +  " INTEGER,"+
             columnNames[4] +  " INTEGER,"+
             columnNames[5] +  " INTEGER"+
             columnNames[6] +  " INTEGER,"+
             columnNames[7] +  " INTEGER,"+
             columnNames[8] +  " INTEGER,"+
             columnNames[9] +  " INTEGER,"+
             columnNames[10] +  " INTEGER,"+
             columnNames[11] +  " INTEGER,"+
             columnNames[12] +  " INTEGER,"+
             columnNames[13] +  " INTEGER,"+
             columnNames[14] +  " INTEGER,"+
             columnNames[15] +  " INTEGER,"+
             columnNames[16] +  " INTEGER,"+
             columnNames[17] +  " INTEGER,"+
             columnNames[18] +  " INTEGER,"+
             columnNames[19] +  " INTEGER,"+
             columnNames[20] +  " INTEGER)";

             db.execSQL(COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          //Drops table if it already exists
          db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

          //Creates table again
          onCreate(db);
    }
    public void addData(RecycleRush rr){ //Adds data to database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(columnNames[0], rr.getTeam_num());
        content.put(columnNames[1], rr.getMatch_num());
        content.put(columnNames[2], rr.getIs_red());
        content.put(columnNames[3], rr.getRobot_auto());
        content.put(columnNames[4], rr.getTotes_num_auto());
        content.put(columnNames[5], rr.getContainer_num_auto());
        content.put(columnNames[6], rr.getStack_num());
        content.put(columnNames[7], rr.getTote_level_one());
        content.put(columnNames[8], rr.getTote_level_two());
        content.put(columnNames[9], rr.getTote_level_three());
        content.put(columnNames[10], rr.getTote_level_four());
        content.put(columnNames[11], rr.getTote_level_five());
        content.put(columnNames[12], rr.getTote_level_six());
        content.put(columnNames[13], rr.getContainer_level_one());
        content.put(columnNames[14], rr.getContainer_level_two());
        content.put(columnNames[15], rr.getContainer_level_three());
        content.put(columnNames[16], rr.getContainer_level_four());
        content.put(columnNames[17], rr.getContainer_level_five());
        content.put(columnNames[18], rr.getContainer_level_six());
        content.put(columnNames[19], rr.getNoodle());
        content.put(columnNames[20], rr.getCoopertition());

        //adds data to next row
        db.insert(TABLE_NAME, null, content);

        //closes db connection
        db.close();

    }
    public ArrayList<RecycleRush> getAllData(){
        String command = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(command, null);
        ArrayList<RecycleRush> recycle = new ArrayList<RecycleRush>();
        if(cursor.moveToFirst()){
            do{
                  RecycleRush rr = new RecycleRush(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3),
                                                       cursor.getInt(4), cursor.getInt(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8),
                                                       cursor.getInt(9),cursor.getInt(10),cursor.getInt(11),cursor.getInt(12),cursor.getInt(13),
                                                       cursor.getInt(14),cursor.getInt(15),cursor.getInt(16),cursor.getInt(17),cursor.getInt(18),
                                                       cursor.getInt(19),cursor.getInt(20));
                recycle.add(rr);
            }while(cursor.moveToNext());
        }
        //returns data
        return recycle;
    }
    public String getAllAutoXML(){
        String result = "";
        ArrayList<RecycleRush> recycle = getAllData();
        for(RecycleRush rr: recycle){
            result += rr.getAutoXMLData();
        }
        return result;
    }
    public String getAllTeleXML(){
        String result = "";
        ArrayList<RecycleRush> recycle = getAllData();
        for(RecycleRush rr: recycle){
            result += rr.getTeleXmlData();
        }
        return result;
    }
    public void clearDB(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null,null);
    }
}
