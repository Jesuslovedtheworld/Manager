package com.musheng.util;

import android.widget.Toast;

import com.musheng.base.BaseApp;


public class ToastUtil {
    public static void shortToast(String msg){
        Toast.makeText(BaseApp.getInstance,msg,Toast.LENGTH_SHORT).show();
    }
    public static void longToast(String msg){
        Toast.makeText(BaseApp.getInstance,msg,Toast.LENGTH_LONG).show();
    }
}
