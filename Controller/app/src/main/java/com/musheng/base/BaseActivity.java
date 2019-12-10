package com.musheng.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<V extends BaseMvpView,P extends BasePresenter> extends AppCompatActivity implements BaseMvpView{

    public P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        ButterKnife.bind(this);
        mPresenter = initPresenter();//抽象方法  负责每个布局中的P层
        if (mPresenter != null){
            mPresenter.bind((V)this);
        }

        initView();
        initData();
    }

    protected abstract P initPresenter();


    protected void initData() {

    }

    protected void initView() {

    }

    protected abstract int getLayoutView();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.onDestroy();//将皮层和绑定的V层销毁
            mPresenter = null;//打断P层
        }
    }

}
