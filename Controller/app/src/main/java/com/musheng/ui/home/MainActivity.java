package com.musheng.ui.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.musheng.base.BaseActivity;
import com.musheng.controller.R;
import com.musheng.mvpView.EmptyView;
import com.musheng.presenter.EmptyPresenter;

import butterknife.BindView;

public class MainActivity extends BaseActivity<EmptyView,EmptyPresenter> {


    @BindView(R.id.id_main_tab)
    TabLayout mTab;
    @BindView(R.id.id_main_vp)
    ViewPager mVp;
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
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
        mTab.setupWithViewPager(mVp);

    }
}
