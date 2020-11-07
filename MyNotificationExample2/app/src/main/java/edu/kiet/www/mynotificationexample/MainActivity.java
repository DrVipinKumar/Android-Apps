package edu.kiet.www.mynotificationexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button shownotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shownotification = findViewById(R.id.btnShowNotification);
        shownotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fireNotification();
            }
        });
    }
    public void fireNotification()
    {
        int notificationid=123;
        String channelid="mychannel";
        Notification.Builder builder;
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            builder= new Notification.Builder(MainActivity.this,channelid);
            NotificationChannel notificationChannel = new NotificationChannel(channelid,"myname",NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("this is my notificaton channel");
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }else
        {
            builder= new Notification.Builder(MainActivity.this);
        }

        builder.setContentTitle("My Notice");
        builder.setContentText("This is my notification for android appp");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setAutoCancel(true);
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        PendingIntent pendingIntent =PendingIntent.getActivity(this,notificationid,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationid,builder.build());
    }
}
