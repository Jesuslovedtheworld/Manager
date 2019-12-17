package com.musheng.widget;

import android.support.v4.app.Fragment;

import com.musheng.ui.home.BooksFragment;
import com.musheng.ui.home.MineFragment;
import com.musheng.ui.home.PlayFragment;

public class FragmentFactory {
    public static Fragment getFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MineFragment();
                break;
            case 1:
                fragment = new BooksFragment();
                break;
            case 2:
                fragment = new PlayFragment();
                break;
        }
        return fragment;
    }
}