package edu.kiet.www.mynotificationexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String channelid="mychannel";
    Notification.Builder builder;
    int notificaionid=123;
    Button simplenoty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simplenoty=findViewById(R.id.btnsimplenoty);
        simplenoty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSimpleNotification();
            }
        });
    }

    private void showSimpleNotification() {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel(channelid,"vknotice",NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("This is my notice on Oreo8.1");
            NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,channelid);
        builder.setContentTitle("Simple Notificaton");
        builder.setContentText("This is my simple notificaiton example");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setAutoCancel(true);
        Intent i = new Intent(getBaseContext(),MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(getBaseContext(),0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notificaionid,builder.build());

    }


}
