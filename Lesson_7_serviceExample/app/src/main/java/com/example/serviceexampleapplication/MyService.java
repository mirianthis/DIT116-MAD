package com.example.serviceexampleapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {
    public MyService() {
    }

    public class LocalBinder extends Binder {
        public MyService getService(){
            return  MyService.this;
        };
    }

    @Override
    public IBinder onBind(Intent intent) {
        LocalBinder binder = new LocalBinder();
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        stopSelf();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //client methods
    public int getRandomInt(){
        return (new Random().nextInt(100));
    }
}