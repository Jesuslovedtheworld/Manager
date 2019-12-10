package com.musheng.util;

import android.util.Log;

import com.musheng.base.Constants;

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
