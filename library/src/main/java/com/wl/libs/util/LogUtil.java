package com.wl.libs.util;

import android.util.Log;

/**
 * Created by wanglei on 16/7/1.
 */
public class LogUtil {

    public static boolean debug = true;
    public static String TAG = "LogUtil";

    public static void v(String msg) {
        if (debug) {
            Log.v(TAG, "v: " + msg);
        }
    }

    public static void d(String msg) {
        if (debug) {
            Log.d(TAG, "d: " + msg);
        }
    }

    public static void w(String msg) {
        if (debug) {
            Log.w(TAG, "w: " + msg);
        }
    }

    public static void i(String msg) {
        if (debug) {
            Log.i(TAG, "i: " + msg);
        }
    }

    public static void e(String msg) {
        if (debug) {
            Log.e(TAG, "e: " + msg);
        }
    }

}
