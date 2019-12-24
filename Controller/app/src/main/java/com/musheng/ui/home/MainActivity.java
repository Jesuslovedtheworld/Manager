package com.musheng.ui.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.musheng.adapter.MainPagerAdapter;
import com.musheng.base.BaseActivity;
import com.musheng.base.BaseFragment;
import com.musheng.controller.R;
import com.musheng.mvpView.EmptyView;
import com.musheng.presenter.EmptyPresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<EmptyView,EmptyPresenter> {


    @BindView(R.id.id_main_tab)
    TabLayout mTab;
    @BindView(R.id.id_main_vp)
    ViewPager mVp;
    private ArrayList<BaseFragment> baseFragments;

    @Override
    protected EmptyPresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
            initTable();
            initFragment();
            setAdapter();
    }

    private void setAdapter() {
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), baseFragments);
        mVp.setAdapter(adapter);
        mTab.setTabsFromPagerAdapter(adapter);
    }

    private void initFragment() {
        baseFragments = new ArrayList<>();
        BooksFragment booksFragment = new BooksFragment();
        MineFragment mineFragment = new MineFragment();
        PlayFragment playFragment = new PlayFragment();
        baseFragments.add(booksFragment);
        baseFragments.add(mineFragment);
        baseFragments.add(playFragment);
    }

    private void initTable() {
            mTab.addTab(mTab.newTab().setText("我").setIcon(R.drawable.bg_eaeaea_r6));
            mTab.addTab(mTab.newTab().setText("你").setIcon(R.drawable.bg_eaeaea_r6));
            mTab.addTab(mTab.newTab().setText("他").setIcon(R.drawable.bg_eaeaea_r6));
    }
}
