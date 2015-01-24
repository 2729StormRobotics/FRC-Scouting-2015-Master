package org.lrhsd.storm.frc_scouting_2015_master;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.lrhsd.storm.frc_scouting_2015_master.adapter.ViewPagerAdapter;
import org.lrhsd.storm.frc_scouting_2015_master.databaseHandler.*;
import org.lrhsd.storm.frc_scouting_2015_master.scanner.ScannerActivity;

import net.sourceforge.zbar.Symbol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class MainActivity extends FragmentActivity {
    //Scouter id for qr
    final String SCOUTER_ID = "@stormscouting ";

    //Storage of the strings
    String[] tempStorage = new String[30];

    //Database for data
    public static DBHelper db;

    TextView tv;

    //Handle pop-ups
    boolean yes = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Looks for viewpager in activity_main.xml

        ViewPager viewpager = (ViewPager) this.findViewById(R.id.pager);
        viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        db = new DBHelper(this);

       // tv = (TextView) DownloadFragment.view.findViewById(R.id.tv_down_direct);
       // tv.setText("These files will be downloaded to: " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ " Look for files called Cascade_Auto.xml and Cascade_Tele.xml");
    }


    //When Scanner button pressed
    public void scan(View view){
        Intent intent = new Intent(this, ScannerActivity.class);
        startActivity(intent);

    }

    //Changes look of temp data
    public void DisplayTemp(){
       //Function to define the display of the temp storage
        TextView tv_temp_one = (TextView)this.findViewById(R.id.tv_temp_one),
                tv_temp_two = (TextView)this.findViewById(R.id.tv_temp_two),
                tv_temp_three = (TextView)this.findViewById(R.id.tv_temp_three),
                tv_temp_four = (TextView)this.findViewById(R.id.tv_temp_four),
                tv_temp_five = (TextView)this.findViewById(R.id.tv_temp_five),
                tv_temp_six = (TextView)this.findViewById(R.id.tv_temp_six),
                tv_temp_seven = (TextView)this.findViewById(R.id.tv_temp_seven),
                tv_temp_eight = (TextView)this.findViewById(R.id.tv_temp_eight),
                tv_temp_nine = (TextView)this.findViewById(R.id.tv_temp_nine),
                tv_temp_ten = (TextView)this.findViewById(R.id.tv_temp_ten),
                tv_temp_eleven = (TextView)this.findViewById(R.id.tv_temp_eleven),
                tv_temp_twelve = (TextView)this.findViewById(R.id.tv_temp_twelve),
                tv_temp_thirteen = (TextView)this.findViewById(R.id.tv_temp_thirteen),
                tv_temp_fourteen = (TextView)this.findViewById(R.id.tv_temp_fourteen),
                tv_temp_fifteen = (TextView)this.findViewById(R.id.tv_temp_fifteen),
                tv_temp_sixteen = (TextView)this.findViewById(R.id.tv_temp_sixteen),
                tv_temp_seventeen = (TextView)this.findViewById(R.id.tv_temp_seventeen),
                tv_temp_eightteen = (TextView)this.findViewById(R.id.tv_temp_eightteen),
                tv_temp_nineteen = (TextView)this.findViewById(R.id.tv_temp_nineteen),
                tv_temp_twenty = (TextView)this.findViewById(R.id.tv_temp_twenty),
                tv_temp_twenty_one = (TextView)this.findViewById(R.id.tv_temp_twenty_one),
                tv_temp_twenty_two = (TextView)this.findViewById(R.id.tv_temp_twenty_two),
                tv_temp_twenty_three = (TextView)this.findViewById(R.id.tv_temp_twenty_three),
                tv_temp_twenty_four = (TextView)this.findViewById(R.id.tv_temp_twenty_four),
                tv_temp_twenty_five = (TextView)this.findViewById(R.id.tv_temp_twenty_five),
                tv_temp_twenty_six = (TextView)this.findViewById(R.id.tv_temp_twenty_six),
                tv_temp_twenty_seven = (TextView)this.findViewById(R.id.tv_temp_twenty_seven),
                tv_temp_twenty_eight = (TextView)this.findViewById(R.id.tv_temp_twenty_eight),
                tv_temp_twenty_nine = (TextView)this.findViewById(R.id.tv_temp_twenty_nine),
                tv_temp_thirty = (TextView)this.findViewById(R.id.tv_temp_thirty);
        if(tempStorage[0].indexOf(",")>=0){tv_temp_one.setText(tempStorage[0].substring(0, tempStorage[0].indexOf(",")));}
        else{tv_temp_one.setText("");}
        if(tempStorage[1].indexOf(",")>=0){tv_temp_two.setText(tempStorage[1].substring(0, tempStorage[1].indexOf(",")));}
        else{tv_temp_two.setText("");}
        if(tempStorage[2].indexOf(",")>=0){tv_temp_three.setText(tempStorage[2].substring(0, tempStorage[2].indexOf(",")));}
        else{tv_temp_three.setText("");}
        if(tempStorage[3].indexOf(",")>=0){tv_temp_four.setText(tempStorage[3].substring(0, tempStorage[3].indexOf(",")));}
        else{tv_temp_four.setText("");}
        if(tempStorage[4].indexOf(",")>=0){tv_temp_five.setText(tempStorage[4].substring(0, tempStorage[4].indexOf(",")));}
        else{tv_temp_five.setText("");}
        if(tempStorage[5].indexOf(",")>=0){tv_temp_six.setText(tempStorage[5].substring(0, tempStorage[5].indexOf(",")));}
        else{tv_temp_six.setText("");}
        if(tempStorage[6].indexOf(",")>=0){tv_temp_seven.setText(tempStorage[6].substring(0, tempStorage[6].indexOf(",")));}
        else{tv_temp_seven.setText("");}
        if(tempStorage[7].indexOf(",")>=0){tv_temp_eight.setText(tempStorage[7].substring(0, tempStorage[7].indexOf(",")));}
        else{tv_temp_eight.setText("");}
        if(tempStorage[8].indexOf(",")>=0){tv_temp_nine.setText(tempStorage[8].substring(0, tempStorage[8].indexOf(",")));}
        else{tv_temp_nine.setText("");}
        if(tempStorage[9].indexOf(",")>=0){tv_temp_ten.setText(tempStorage[9].substring(0, tempStorage[9].indexOf(",")));}
        else{tv_temp_ten.setText("");}
        if(tempStorage[10].indexOf(",")>=0){tv_temp_eleven.setText(tempStorage[10].substring(0, tempStorage[10].indexOf(",")));}
        else{tv_temp_eleven.setText("");}
        if(tempStorage[11].indexOf(",")>=0){tv_temp_twelve.setText(tempStorage[11].substring(0, tempStorage[11].indexOf(",")));}
        else{tv_temp_twelve.setText("");}
        if(tempStorage[12].indexOf(",")>=0){tv_temp_thirteen.setText(tempStorage[12].substring(0, tempStorage[12].indexOf(",")));}
        else{tv_temp_thirteen.setText("");}
        if(tempStorage[13].indexOf(",")>=0){tv_temp_fourteen.setText(tempStorage[13].substring(0, tempStorage[13].indexOf(",")));}
        else{tv_temp_fourteen.setText("");}
        if(tempStorage[14].indexOf(",")>=0){tv_temp_fifteen.setText(tempStorage[14].substring(0, tempStorage[14].indexOf(",")));}
        else{tv_temp_fifteen.setText("");}
        if(tempStorage[15].indexOf(",")>=0){tv_temp_sixteen.setText(tempStorage[15].substring(0, tempStorage[15].indexOf(",")));}
        else{tv_temp_sixteen.setText("");}
        if(tempStorage[16].indexOf(",")>=0){tv_temp_seventeen.setText(tempStorage[16].substring(0, tempStorage[16].indexOf(",")));}
        else{tv_temp_seventeen.setText("");}
        if(tempStorage[17].indexOf(",")>=0){tv_temp_eightteen.setText(tempStorage[17].substring(0, tempStorage[17].indexOf(",")));}
        else{tv_temp_eightteen.setText("");}
        if(tempStorage[18].indexOf(",")>=0){tv_temp_nineteen.setText(tempStorage[18].substring(0, tempStorage[18].indexOf(",")));}
        else{tv_temp_nineteen.setText("");}
        if(tempStorage[19].indexOf(",")>=0){tv_temp_twenty.setText(tempStorage[19].substring(0, tempStorage[19].indexOf(",")));}
        else{tv_temp_twenty.setText("");}
        if(tempStorage[20].indexOf(",")>=0){tv_temp_twenty_one.setText(tempStorage[20].substring(0, tempStorage[20].indexOf(",")));}
        else{tv_temp_twenty_one.setText("");}
        if(tempStorage[21].indexOf(",")>=0){tv_temp_twenty_two.setText(tempStorage[21].substring(0, tempStorage[21].indexOf(",")));}
        else{tv_temp_two.setText("");}
        if(tempStorage[22].indexOf(",")>=0){tv_temp_three.setText(tempStorage[22].substring(0, tempStorage[22].indexOf(",")));}
        else{tv_temp_twenty_three.setText("");}
        if(tempStorage[23].indexOf(",")>=0){tv_temp_twenty_four.setText(tempStorage[23].substring(0, tempStorage[23].indexOf(",")));}
        else{tv_temp_twenty_four.setText("");}
        if(tempStorage[24].indexOf(",")>=0){tv_temp_twenty_five.setText(tempStorage[24].substring(0, tempStorage[24].indexOf(",")));}
        else{tv_temp_twenty_five.setText("");}
        if(tempStorage[25].indexOf(",")>=0){tv_temp_twenty_six.setText(tempStorage[25].substring(0, tempStorage[25].indexOf(",")));}
        else{tv_temp_twenty_six.setText("");}
        if(tempStorage[26].indexOf(",")>=0){tv_temp_twenty_seven.setText(tempStorage[26].substring(0, tempStorage[26].indexOf(",")));}
        else{tv_temp_twenty_seven.setText("");}
        if(tempStorage[27].indexOf(",")>=0){tv_temp_twenty_eight.setText(tempStorage[27].substring(0, tempStorage[27].indexOf(",")));}
        else{tv_temp_twenty_eight.setText("");}
        if(tempStorage[28].indexOf(",")>=0){tv_temp_twenty_nine.setText(tempStorage[28].substring(0, tempStorage[28].indexOf(",")));}
        else{tv_temp_twenty_nine.setText("");}
        if(tempStorage[29].indexOf(",")>=0){tv_temp_thirty.setText(tempStorage[29].substring(0, tempStorage[29].indexOf(",")));}
        else{tv_temp_thirty.setText("");}






    }
    //Method to move from temp to db
    public void temptoDB(){
       for(int i = 0; i < tempStorage.length; ++i){
           if(tempStorage[i].contains(",")){
               addDatatoDb(tempStorage[i]);
               tempStorage[i] = "";
           }

       }
        DisplayTemp();
    }
    //A form of moving temp to db using RecycleRush class
    public void addDatatoDb(RecycleRush input){
        try{
            db.addData(input);
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT);
        }
    }
    //A form of moving temptoDb  using string input
    public void addDatatoDb(String input){
        try{
            RecycleRush rr = new RecycleRush(input);
            db.addData(rr);
        }catch(Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT);
        }
    }
    //Adds data to db when clicked
    public void addData(View view){
        temptoDB();
    }

    public void update(View view){
        ArrayList<RecycleRush> list = db.getAllData();
        String record ="";
        for(RecycleRush rr:list){

                   record += rr.getTextData();
        }
        TextView update = (TextView)this.findViewById(R.id.tv_database);
        update.setText(record);
    }
    //Clears Database of data
    public void clearData(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Clear Database");
        builder.setMessage("Are you sure you want to do this?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.yes = true;
                MainActivity.db.clearDB();

            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.yes = false;
            }
        });
        AlertDialog action = builder.create();
        action.show();
    }
    //Obtains Auto data to xml
    public void downloadAutoXML(View view){
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "RecycleRush_Auto.xml");

            BufferedWriter buffer = new BufferedWriter(new FileWriter(file));

            //writing into the files
            buffer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<Auto xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
            buffer.write(db.getAllAutoXML());

            buffer.write("</Auto>");

            buffer.close();
            Toast.makeText(this, "RecycleRush_Auto has been downloaded to your /DOWNLOADS directory", Toast.LENGTH_SHORT);
        }catch (IOException e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT);
        }

    }
    public void downloadTeleXML(View view){
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "RecycleRush_Tele.xml");

            BufferedWriter buffer = new BufferedWriter(new FileWriter(file));

            //writing into the files
            buffer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<Tele xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
            buffer.write(db.getAllTeleXML());

            buffer.write("</Tele>");

            buffer.close();
            Toast.makeText(this, "RecycleRush_Tele has been downloaded to your /DOWNLOADS directory", Toast.LENGTH_SHORT);
        }catch (IOException e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT);
        }

    }
   /* ///////////////////////////////// For checking storage permissions ///////////////////////////////////
	*//* Checks if external storage is available for read and write *//*
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    *//* Checks if external storage is available to at least read *//*
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }*/

    public void DecodeTempStorage(String input, String temp) {

                temp = input.substring(0, input.indexOf(":"));
                input = input.substring(input.indexOf(":") + 1, input.length());
            }

}

