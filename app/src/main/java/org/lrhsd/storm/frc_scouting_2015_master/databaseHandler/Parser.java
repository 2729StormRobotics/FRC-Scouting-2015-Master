package org.lrhsd.storm.frc_scouting_2015_master.databaseHandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
            Log.d("arrayList"+i,teams.get(i));
            i++;
        }


        //Log.d("input","1"+input);
    }
}
