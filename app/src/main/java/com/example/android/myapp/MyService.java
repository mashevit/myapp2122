package com.example.android.myapp;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.android.myapp.database.AppDB;
import com.example.android.myapp.database.Dish;

public class MyService extends IntentService {
    public static final String EXTRA_DATA_ID1 ="ssdsdds" ;
    public static final String EXTRA_DATA_ID="ljjhjh";
    private AppDB mDb;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param //name Used to name the worker thread, important only for debugging.
     */
    public MyService() {
        super("MyService");

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mDb = AppDB.getInstance(getApplicationContext());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null && intent.hasExtra(EXTRA_DATA_ID)&& intent.hasExtra(EXTRA_DATA_ID1)) {
            boolean bool= intent.getBooleanExtra(EXTRA_DATA_ID1,false);
            String id = intent.getStringExtra(EXTRA_DATA_ID);

        Dish dish=mDb.dishDao().loadDishByIdw(id);
        dish.setChecked(bool);

        mDb.dishDao().updateDish(dish);
     //   final String id=mDish.get(position).getId();
       // holder.mCheckBox.setChecked(dish.isChecked());
    }
}

}
