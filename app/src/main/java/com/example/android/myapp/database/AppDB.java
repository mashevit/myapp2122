package com.example.android.myapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

@Database(entities = {Dish.class, Mitzrahnames.class, ingredients.class}, version = 2, exportSchema = false)

public abstract  class AppDB extends RoomDatabase {


    private static final String LOG_TAG = AppDB.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "dishlist";
    private static AppDB sInstance;

    public static AppDB getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDB.class, AppDB.DATABASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    public abstract DishDao dishDao();
    public abstract ingredientsDao ingredientsDao();
    public abstract MitzrahnamesDao mitzrahnamesDao();
}
