package com.org.iii.will13;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private Timer timer;
    private int i;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        Log.v("will", "onCreate()");
        timer = new Timer();
        timer.schedule(new MyTimer(), 1000, 1000);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.v("will", "onStartCommand()");
        boolean isStart = intent.getBooleanExtra("isStart", false);
        if (isStart) {
            i = intent.getIntExtra("value", -100);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.purge();
            timer.cancel();
            timer = null;

        }
//        Log.v("will", "onDestroy()");
    }

    private class MyTimer extends TimerTask {
        @Override
        public void run() {
            Log.v("will", "i = " + i++);
        }
    }
}
