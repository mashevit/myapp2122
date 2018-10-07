package com.example.android.myapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.android.myapp.database.AppDB;




public class LocalServiceMain extends Service {
    // Binder given to clients
    private final IBinder mBinder = new LocalBinderMain();
    // Random number generator
//    private final Random mGenerator = new Random();

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinderMain extends Binder {
        public LocalServiceMain getService() {
            // Return this instance of LocalService so clients can call public methods
            return LocalServiceMain.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }




    public static void cleanAll(AppDB mDb){

        mDb.clearAllTables();


    }

}