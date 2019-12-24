package com.musheng.ui.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.musheng.base.BaseFragment;
import com.musheng.controller.R;
import com.musheng.mvpView.EmptyView;
import com.musheng.presenter.EmptyPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends BaseFragment<EmptyView,EmptyPresenter>{

    @Override
    protected EmptyPresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_play;
    }
}
