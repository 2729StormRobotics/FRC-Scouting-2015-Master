package org.lrhsd.storm.frc_scouting_2015_master;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.lrhsd.storm.frc_scouting_2015_master.database.DatabaseHandler;

public class CustomCursorAdapter extends CursorAdapter {
    private LayoutInflater cursorInflater;
    private String columnName;

    public CustomCursorAdapter(Context context, Cursor cursor, int flags, String column_Name) {
        super(context,cursor, flags);
        cursorInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        columnName = column_Name;
    }

    public void bindView(View view, Context context, Cursor cursor){
        String teamNum = cursor.getString( cursor.getColumnIndex(DatabaseHandler.KEY_TEAM_NUMBER) );
        String sortColumn = cursor.getString(cursor.getColumnIndex(columnName));
        TextView textTeamNum = (TextView) view.findViewById(R.id.TeamNum);
        TextView textSortColumn = (TextView) view.findViewById(R.id.SortColumn);
        textTeamNum.setText(teamNum);
        textSortColumn.setText(String.valueOf(sortColumn));
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.databas_list_layout, parent, false);
    }
}
