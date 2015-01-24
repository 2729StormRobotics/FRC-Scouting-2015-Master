package org.lrhsd.storm.frc_scouting_2015_master.adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.lrhsd.storm.frc_scouting_2015_master.fragments.ScannerFragment;
import org.lrhsd.storm.frc_scouting_2015_master.fragments.DatabaseFragment;
import org.lrhsd.storm.frc_scouting_2015_master.fragments.DownloadFragment;
/**
 * Created by Tommy on 1/15/2015.
 */
public class ViewPagerAdapter  extends  FragmentPagerAdapter{

    final int TAB_COUNT = 3;

    String tab_names[] = new String[]{"Scan", "Database", "Download"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                ScannerFragment scan = new ScannerFragment();
                return scan;

            case 1:
                DatabaseFragment db = new DatabaseFragment();
                return db;
            case 2:
                DownloadFragment download = new DownloadFragment();
                return download;

        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab_names[position];
    }
}