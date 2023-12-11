package com.example.attendance_management;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.attendance_management.Student.StudentMain;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isConnected = NetworkUtils.isConnectedToNetwork(this);
        if (isConnected) {
            // Get network name
            String networkName = NetworkUtils.getNetworkName(this);

            // Get network IP address
            String networkIPAddress = NetworkUtils.getNetworkIPAddress(this);

            Toast.makeText(this, "Connected to network: " + networkName + "\nIP Address: " + networkIPAddress, Toast.LENGTH_LONG).show();
        }
        broadcastReceiver=new ConnectionReceiver();
        registerNetworkBroadcast();
        Intent i=new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
        finish();

    }
    protected void registerNetworkBroadcast(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }
    protected void unregistorNetwork(){
        try {
            unregisterReceiver(broadcastReceiver);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregistorNetwork();
    }
}