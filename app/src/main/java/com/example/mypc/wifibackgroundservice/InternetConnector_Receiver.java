package com.example.mypc.wifibackgroundservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class InternetConnector_Receiver extends BroadcastReceiver
{
    public InternetConnector_Receiver()
    {

    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        try
        {
            boolean isVisible = MyApplication.isActivityVisible();

            Log.i("Activity is Visible ", "Is activity visible : " + isVisible);

            if (isVisible == false)
            {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected())
                {
                    //new MainActivity().changeTextStatus(true);
                    Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();

                }
                else
                {
                   // new MainActivity().changeTextStatus(false);
                    Toast.makeText(context, "Not Connected", Toast.LENGTH_SHORT).show();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
