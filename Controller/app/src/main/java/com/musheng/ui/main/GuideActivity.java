package com.musheng.ui.main;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.musheng.adapter.GuideViewAdapter;
import com.musheng.base.BaseActivity;
import com.musheng.base.Constants;
import com.musheng.controller.R;
import com.musheng.mvpView.EmptyView;
import com.musheng.presenter.EmptyPresenter;
import com.musheng.ui.home.MainActivity;
import com.musheng.util.Logger;
import com.musheng.util.SpUtil;
import com.musheng.widget.PreviewIndicator;

import java.util.ArrayList;

import butterknife.BindView;

public class GuideActivity extends BaseActivity<EmptyView, EmptyPresenter> implements ViewPager.OnPageChangeListener, View.OnClickListener {

    @BindView(R.id.guide_pr)
    PreviewIndicator pr;
    @BindView(R.id.guide_vp)
    ViewPager viewPager;
    @BindView(R.id.guide_btn)
    Button mBtn;
    private ArrayList<View> views;
    private Intent intent;

    @Override
    protected EmptyPresenter initPresenter() {
        intent = new Intent(GuideActivity.this,MainActivity.class);
        Boolean jump = (Boolean) SpUtil.getParam(Constants.isJump, false);
        if (jump){
            startActivity(intent);
            finish();
        }
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
        mBtn.setOnClickListener(this);
    }

    private void setPreView() {
        pr.setNumbers(3);
        pr.initSize(70, 10, 5);
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

    }

    @Override
    public void onPageSelected(int i) {
        pr.setSelected(i);
        if (i == 2){
            mBtn.setVisibility(View.VISIBLE);
        }else {
            mBtn.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onClick(View v) {
        SpUtil.setParam(Constants.isJump,true);
        startActivity(intent);
        finish();
    }
}
