package com.example.android.myapp.sync;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.android.myapp.database.AppDB;
import com.example.android.myapp.remote.DishCSClass;

import java.util.List;

public class foodSyncIntentSevice extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public static final String EXTRA_DATA_ID_Obj="ljjhjhqqsqqqw";
    public static final String EXTRA_DATA_ID="ljjhjhqq";
   // private AppDB mDb;
    public foodSyncIntentSevice(String name) {
        super("foodSyncIntentService");
}

    public foodSyncIntentSevice() {
        super("foodSyncIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String todohere="";//="syncdish";
        AppDB mdb= AppDB.getInstance(this);

        if (intent != null && intent.hasExtra(EXTRA_DATA_ID)) {
        todohere = intent.getStringExtra(EXTRA_DATA_ID);
        }
        if(todohere.equals("syncdish")){
              FoodSyncTask.syncWeather(this,mdb);
            todohere="";
        }else if(todohere.equals("full")){
            List<DishCSClass> a= (List<DishCSClass>) intent.getSerializableExtra(EXTRA_DATA_ID_Obj);
            FoodSyncTask.syncWeatherfullv2(mdb,a);
            todohere="";
        }else if(todohere.equals("clean")){
        FoodSyncTask.clean(mdb);
        todohere="";
    }

}}
