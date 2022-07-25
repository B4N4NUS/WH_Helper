package com.bruh.wh_helper;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


class SectionsPagerAdapter extends FragmentPagerAdapter {
    int totalTabs;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        this.totalTabs = MainActivity.tabsFragments.length;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return MainActivity.tabsFragments[position];
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}