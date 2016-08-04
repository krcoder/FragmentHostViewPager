package com.intelliabb.hnabbasi.fragmenthostviewpager.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.intelliabb.hnabbasi.fragmenthostviewpager.Fragments.MyFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    String[] tabs;

    public ViewPagerAdapter(FragmentManager fm, String[] tabs) {
        super(fm);
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int i) {




        return MyFragment.newInstance(String.valueOf(i));
        //return MyFragment.newInstance(String.format("%s Fragmentt", tabs[i]));
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
