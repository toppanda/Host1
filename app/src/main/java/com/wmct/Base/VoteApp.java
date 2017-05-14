package com.wmct.Base;

import android.app.Application;
import android.content.Context;

/**
 * Created by ZHYu on 2017/5/13.
 */

public class VoteApp extends Application {
    private static final String TAG = "VoteApp";
    private static Context context;

    @Override
    public void onCreate() {
        //获取Context
        context = getApplicationContext();
    }

    //返回
    public static Context getContextObject(){
        return context;
    }
}
