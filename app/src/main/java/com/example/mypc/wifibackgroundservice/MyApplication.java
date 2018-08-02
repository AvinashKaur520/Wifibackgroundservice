package com.example.mypc.wifibackgroundservice;

/**
 * Created by MY PC on 03-08-2018.
 */

import android.app.Application;
public class MyApplication extends Application
{
    public static boolean activityVisible;

    public static boolean isActivityVisible()
    {
        return activityVisible;
    }

    public static void activityResumed()
    {
        activityVisible = true;
    }

    public static void activityPaused()
    {
        activityVisible = false;
    }
}