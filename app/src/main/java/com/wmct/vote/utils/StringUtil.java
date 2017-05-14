package com.wmct.vote.utils;

import android.util.Log;

import com.wmct.R;

/**
 * Created by ZHYu on 2017/5/13.
 */

public class StringUtil {
    private static final String TAG = "StringUtil";
    public static int ENChangeToCH(String msg) {
        Log.i(TAG, "msg:------------------>" + msg);
        int resourceId = 0;
        switch (msg) {
            case "WrongRoomnumError":
                resourceId = R.string.WrongRoomnumError;
                break;
            case "WrongPasswordError":
                resourceId = R.string.WrongPasswordError;
                break;
            case "RoomHasOpenedError":
                resourceId = R.string.RoomHasOpenedError;
                break;
            case "RoomHasClosedError":
                resourceId = R.string.RoomHasClosedError;
                break;
        }
        return resourceId;
    }
}
