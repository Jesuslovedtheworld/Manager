package com.musheng.ui.main;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.musheng.adapter.GuideViewAdapter;
import com.musheng.base.BaseActivity;
import com.musheng.controller.R;
import com.musheng.mvpView.EmptyView;
import com.musheng.presenter.EmptyPresenter;
import com.musheng.util.Logger;
import com.musheng.widget.PreviewIndicator;

import java.util.ArrayList;

import butterknife.BindView;

public class GuideActivity extends BaseActivity<EmptyView,EmptyPresenter> implements ViewPager.OnPageChangeListener {

    @BindView(R.id.guide_pr)
    PreviewIndicator pr;
    @BindView(R.id.guide_vp)
    ViewPager viewPager;
    private ArrayList<View> views;

    @Override
    protected EmptyPresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        initPage();
        setPreView();
    }

    private void setPreView() {
        pr.setNumbers(3);
        pr.initSize(70,10,5);
    }

    private void initPage() {
        views = new ArrayList<>();
        View guideOne = getLayoutInflater().inflate(R.layout.guide_one, null);
        View guideTwo = getLayoutInflater().inflate(R.layout.guide_two, null);
        View guideThree = getLayoutInflater().inflate(R.layout.guide_three, null);
        views.add(guideOne);
        views.add(guideTwo);
        views.add(guideThree);
        GuideViewAdapter adapter = new GuideViewAdapter(views);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        pr.setSelected(i);
    }

    @Override
    public void onPageSelected(int i) {
        Logger.DebugLogger("第三个"+i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
