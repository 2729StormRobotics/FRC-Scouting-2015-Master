package org.stormroboticsnj.frc_scouting_2015_master.adapters;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.stormroboticsnj.frc_scouting_2015_master.R;
import org.stormroboticsnj.frc_scouting_2015_master.database.DatabaseHandler;

import java.util.HashMap;

public class CustomCursorAdapter extends CursorAdapter {
    private LayoutInflater cursorInflater;
    private String _columnName;
    private int _layout;
    private HashMap map;

    public CustomCursorAdapter(Context context, Cursor cursor, int flags, String column_Name, int layout) {
        super(context, cursor, flags);
        cursorInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        _columnName = column_Name;
        _layout = layout;

    }

    public void bindView(View view, Context context, Cursor cursor) {
        String teamNum = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_TEAM_NUMBER));
        String sortColumn;
        /*if(cursor.getColumnIndex(_columnName)<7&&cursor.getColumnIndex(_columnName)>5){
            sortColumn = (String) map.get(cursor.getString(cursor.getColumnIndex(_columnName)));
        }else{*/
            sortColumn = cursor.getString(cursor.getColumnIndex(_columnName));
        //}

        TextView textTeamNum = (TextView) view.findViewById(R.id.TeamNum);
        TextView textSortColumn = (TextView) view.findViewById(R.id.SortColumn);

        textTeamNum.setText(teamNum);
        if (textTeamNum.length() < 4) {
            int diff = 4 - textTeamNum.length();
            if (diff == 1) {
                textSortColumn.setText(" " + String.valueOf(sortColumn));
            }
            if (diff == 2) {
                textSortColumn.setText("  " + String.valueOf(sortColumn));
            }
            if (diff == 3) {
                textSortColumn.setText("   " + String.valueOf(sortColumn));
            }

        } else {
            textSortColumn.setText(String.valueOf(sortColumn));
        }

    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(_layout, parent, false);
    }
}
