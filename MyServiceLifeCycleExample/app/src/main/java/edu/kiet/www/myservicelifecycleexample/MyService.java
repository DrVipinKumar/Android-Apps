package edu.kiet.www.myservicelifecycleexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {
    Random random =new Random();
    MyBinder myBinder = new MyBinder();
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return myBinder;
    }
    class MyBinder extends Binder {
        public MyService getService()
        {
            return MyService.this;
        }
    }

    public int getRandomNumber()
    {
        return random.nextInt(100);
    }
}
