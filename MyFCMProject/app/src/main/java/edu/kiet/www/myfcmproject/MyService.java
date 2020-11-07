package edu.kiet.www.myfcmproject;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyService extends FirebaseMessagingService {
    public MyService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
       // Log.d(TAG, "From: " + remoteMessage.getFrom());
        String title=null;
        String body=null;
        String Channel_Name="FCMChannel";
        String Channel_Desc="This is my FCM Channel";
        String channel_id="1";
        NotificationCompat.Builder builder;
        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
       //     Log.d(TAG, "Message data payload: " + remoteMessage.getData());



        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d("MyFCM", "Message Notification Body: " + remoteMessage.getNotification().getBody());
            title=remoteMessage.getNotification().getTitle();
            body=remoteMessage.getNotification().getBody();
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
            {

                NotificationChannel notificationChannel = new NotificationChannel(channel_id,Channel_Name,NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel.setDescription(Channel_Desc);
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            builder= new NotificationCompat.Builder(getApplicationContext(),channel_id);
            builder.setContentText(body);
            builder.setContentTitle(title);
            builder.setAutoCancel(true);
            builder.setSmallIcon(R.mipmap.ic_launcher);
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(1,builder.build());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
    @Override
    public void onNewToken(String token) {
        Log.d("MyFCMToken", "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        //sendRegistrationToServer(token);
    }
}
