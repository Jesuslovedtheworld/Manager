package com.musheng.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.musheng.base.BaseFragment;

import java.util.ArrayList;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<BaseFragment> fragments;
    private ArrayList<String> strings;

    public MainPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments, ArrayList<String> strings) {
        super(fm);
        this.fragments = fragments;
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
