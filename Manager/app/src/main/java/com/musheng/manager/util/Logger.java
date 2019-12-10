package com.musheng.manager.util;

import android.util.Log;

import com.musheng.manager.bean.Constants;

public class Logger {

    public static void ErrorLogger(String msg){
        if (Constants.isDebug){
            Log.e(Constants.ErrorTAG,msg);
        }
    }
    public static void DebugLogger(String msg){
        if (Constants.isDebug){
            Log.e(Constants.DebugTAG,msg);
        }
    }
}
