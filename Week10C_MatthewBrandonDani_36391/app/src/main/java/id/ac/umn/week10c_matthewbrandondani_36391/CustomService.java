package id.ac.umn.week10c_matthewbrandondani_36391;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.AsyncTask;
import android.util.Log;

public class CustomService extends Service {
    public CustomService() {
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Log.i("CUSTOMSERVICE", "onCreate: CustomService");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i("CUSTOMSERVICE", "onStartCommand: " + startId);
        AsyncTask customServiceTask = new CustomServiceTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, startId);
        return Service.START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        //TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        Log.i("CUSTOMSERVICE", "onBind: Service Bind");
        return null;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("CUSTOMSERVICE", "onDestroy: Service Destroyed");
    }
}