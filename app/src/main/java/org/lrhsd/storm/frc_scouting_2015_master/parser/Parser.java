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
import java.util.List;

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
        input = input.substring(input.indexOf(" ") + 1);
        List<String[]> matches = new ArrayList<String[]>();
        int i = 0;
        while (input.contains(":")) {
            String temp = input.substring(0, input.indexOf(":"));
            input = input.substring(input.indexOf(":") + 1);
            String tempArray[] = temp.split(",");
            if (tempArray[2].equals("1")) {
                tempArray[2] = "Red";
            } else {
                tempArray[2] = "Blue";
            }
            if (tempArray[3].equals("1")) {
                tempArray[3] = "Yes";
            } else {
                tempArray[3] = "No";
            }
            if (tempArray[20].equals("1")) {
                tempArray[20] = "Yes";
            } else {
                tempArray[20] = "No";
            }
            matches.add(i, tempArray);
            //Log.d("arrayList" + i,matches.get(i)[0]);
            i++;
        }
        makeCSV(matches);
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        Toast.makeText((Context) activity.getApplicationContext(), (CharSequence) "Successfully Scanned QR Code", Toast.LENGTH_LONG).show();
        //Log.d("input","1"+input);
    }

    public static void makeCSV(List<String[]> matches) {
        //Log.d("arrayList", matches.get(0)[0]);
        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File dir = new File(sdCard.getAbsolutePath());
            dir.mkdirs();
            File file = new File(dir, "match_data.csv");
            CSVWriter writer;
            if (!file.exists()) {
                String[] columns = new String[21];
                columns[0] = "Team Number";
                columns[1] = "Match Number";
                columns[2] = "Alliance";
                columns[3] = "Robot in Auto Zone";
                columns[4] = "Number of Totes in Auto Zone";
                columns[5] = "Number of Containers in Auto Zone";
                columns[6] = "Number of Stack Totes in Auto Zone";
                columns[7] = "Tote Level 1";
                columns[8] = "Tote Level 2";
                columns[9] = "Tote Level 3";
                columns[10] = "Tote Level 4";
                columns[11] = "Tote Level 5";
                columns[12] = "Tote Level 6";
                columns[13] = "Can Level 1";
                columns[14] = "Can Level 2";
                columns[15] = "Can Level 3";
                columns[16] = "Can Level 4";
                columns[17] = "Can Level 5";
                columns[18] = "Can Level 6";
                columns[19] = "Number of Noodles";
                columns[20] = "Coopertition";
                matches.add(0, columns);
            }
            writer = new CSVWriter(new FileWriter(file, true), ',');
            writer.writeAll(matches);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
