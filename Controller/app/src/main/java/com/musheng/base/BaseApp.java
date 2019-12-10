package com.musheng.base;

import android.app.Application;

import com.musheng.util.ToastUtil;

public class BaseApp extends Application {

    public static BaseApp getInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        getInstance = this;
        welcomeUseMyApp();
    }

    private void welcomeUseMyApp() {
        ToastUtil.shortToast("欢迎使用");
    }

    public static BaseApp getInstance(){
        return getInstance;
    }
}
