package org.lrhsd.storm.frc_scouting_2015_master.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import org.lrhsd.storm.frc_scouting_2015_master.MainActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
           // Log.d("arrayList"+i,teams.get(i));
            i++;
        }

        makeCSV(matches);

        //Log.d("input","1"+input);
    }

    public static void makeCSV(ArrayList matches){
        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File dir = new File (sdCard.getAbsolutePath() + "/storm/data");
            dir.mkdirs();
            File file = new File(dir, "match_data");
            CSVWriter writer = new CSVWriter(new FileWriter(file, true), '\n');
            writer.writeAll(matches);
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
