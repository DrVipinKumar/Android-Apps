package edu.kiet.www.mybindserviceexample;

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

    Button getnumber, startservice, stopservice;
    TextView displaynumber;
    Intent i;
    boolean checkservice;
    MyService myService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startservice = findViewById(R.id.btnStartService);
        stopservice= findViewById(R.id.btnStopService);
        getnumber = findViewById(R.id.btnShowRandom);
        displaynumber=findViewById(R.id.txtRandomNumber);
        final MyServiceConnection myServiceConnection =new MyServiceConnection();
        startservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(MainActivity.this,MyService.class);
                bindService(i,myServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });
        stopservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkservice) {
                    unbindService(myServiceConnection);
                    checkservice=false;
                }
            }
        });
        getnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkservice)
                {
                    displaynumber.setText("Random Number is=>"+myService.getRandomNumber());
                }
            }
        });
    }
    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.MyBinder myBinder = (MyService.MyBinder)iBinder;
            myService =myBinder.getService();
            checkservice=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            checkservice=false;
        }
    }
}
