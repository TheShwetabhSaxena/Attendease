package com.example.attendance_management;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.net.NetworkInterface;

public class ConnectionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(isConnected(context)){
            Toast.makeText(context, "Internet Active", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(context, "Connect to Internet Immediately", Toast.LENGTH_SHORT).show();

    }

    public boolean isConnected(Context context){
        try{
            ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=cm.getActiveNetworkInfo();
            return (networkInfo !=null && networkInfo.isConnected());

        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }



    }
}
