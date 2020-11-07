package edu.kiet.www.myservicelifecycleexample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startservice, stopservie,getrandom;
    Intent i;
    boolean checkrunning;
    TextView number;
    MyService myService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startservice =findViewById(R.id.btnStartService);
        stopservie =findViewById(R.id.btnStopService);
        getrandom =findViewById(R.id.btnGetRandomNumber);
        number = findViewById(R.id.txtRandom);
       final MyServiceConnection conn =new MyServiceConnection();
        startservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(getApplicationContext(),MyService.class);
                bindService(i,conn,Context.BIND_AUTO_CREATE);
            }
        });
        stopservie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(conn);
                checkrunning=false;
            }
        });
        getrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkrunning)
                {
                    number.setText(""+myService.getRandomNumber());
                }
            }
        });
    }

    class MyServiceConnection implements  ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.MyBinder myBinder = (MyService.MyBinder) iBinder;
            myService =myBinder.getService();
            checkrunning=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
                checkrunning=false;
        }
    }
}
