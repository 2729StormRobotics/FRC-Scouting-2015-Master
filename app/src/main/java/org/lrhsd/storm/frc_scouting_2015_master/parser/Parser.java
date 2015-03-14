package org.lrhsd.storm.frc_scouting_2015_master.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.lrhsd.storm.frc_scouting_2015_master.MainActivity;
import org.lrhsd.storm.frc_scouting_2015_master.database.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zbar.Result;


public class Parser {

    //this class parses the data from the qr code string and saves it to a csv file

    static Activity act;

    public static void Parse(Result result, Activity activity) {
        act = activity;
        String input = result.getContents();
        //Log.d("Parser input", input);
        if (!input.contains("@stormscouting")) {
            Intent i = new Intent(activity, MainActivity.class);
            activity.startActivity(i);
            Toast.makeText((Context) activity.getApplicationContext(), (CharSequence) "Scan a Valid QR Code", Toast.LENGTH_LONG).show();
            return;
        }
        input = input.substring(input.indexOf(" ") + 1);
        List<String[]> matches = new ArrayList<String[]>();
        int i = 0;
        while (input.contains(":")) {
            String temp = input.substring(0, input.indexOf(":"));
            input = input.substring(input.indexOf(":") + 1);
            String tempArray[] = temp.split(",");
          /*  if (tempArray[2].equals("1")) {
                tempArray[2] = "Red";
            } else {
                tempArray[2] = "Blue";
            }
            if (tempArray[3].equals("1")) {
                tempArray[3] = "Yes";
            } else {
                tempArray[3] = "No";
            }
            if (tempArray[21].equals("1")) {
                tempArray[21] = "Yes";
            } else {
                tempArray[21] = "No";
            }*/
           /* if (tempArray[22].equals("")){
                tempArray[22] = "No Notes";
            }*/
            matches.add(i, tempArray);
            //Log.d("arrayList" + i,matches.get(i)[0]);
            i++;
        }
        makeDatabase(matches);
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        Toast.makeText((Context) activity.getApplicationContext(), (CharSequence) "Successfully Scanned QR Code", Toast.LENGTH_LONG).show();
        //Log.d("input","1"+input);
    }

    public static void makeDatabase(List<String[]> matches) {
        DatabaseHandler.getInstance(act.getApplicationContext()).addTeamData(matches);
    }

}
