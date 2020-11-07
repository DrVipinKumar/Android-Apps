package edu.kiet.www.mybroadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(Intent.ACTION_POWER_CONNECTED.equals(intent.getAction()))
        {
            Toast.makeText(context,"Charger Connected",Toast.LENGTH_SHORT).show();
        }
        else if (Intent.ACTION_POWER_DISCONNECTED.equals(intent.getAction()))
        {
            Toast.makeText(context,"Charger Dis-connected",Toast.LENGTH_SHORT).show();
        }
        else if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
        {
            Toast.makeText(context,"Internet Connection Changed ",Toast.LENGTH_SHORT).show();
        }


    }
}
